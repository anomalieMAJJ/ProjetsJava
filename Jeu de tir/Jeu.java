import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Cette classe contrôle l'état du jeu.
 */
public class Jeu extends JPanel {

    public static final Tuile EMPLACEMENT_TOUR = new Tuile( Color.gray, Color.white, BitMap.TUILE_EMPLACEMENT );
    protected Dimension dimension;
    protected AffineTransform ratio;
    protected int margeX;
    protected int margeY;
    protected int r;

    protected Niveau niveauCourant;
    protected int argent;
    protected int vieChateau;
    protected AffineTransform [] emplacementTours;
    protected List< Tour > toursConstruites;
    protected Tour tourChoisie;
    protected List< Ennemi > ennemis;
    protected GestionSouris gestionSouris;
    protected Timer animateur;
    protected List< Generateur > generateurs;
    protected boolean action = false;
    /**
     * Fonction lambda pour permettre d’augmenter le dommage que cause une flèche pour
     * tous les archers d’une tour
     */
    BiConsumer<Jeu, PositionTuile> augmenterDommageFct = (jeu, position) ->
    {
        if (null != jeu.tourChoisie && jeu.tourChoisie.augmenterDommagePossible()) {
            // Code ici pour augmenter dommage.
            System.err.println("clique sur 'augmenter dommage'.");
        }
    };
    /**
     * Fonction lambda pour permettre d’augmenter le nombre d’archers dans la tour.
     */
    BiConsumer<Jeu, PositionTuile> augmenterArcherFct = (jeu, position) ->
    {
        if (null != jeu.tourChoisie && jeu.tourChoisie.augmenterArcherPossible()) {
            // Code ici pour augmenter nombre de fleche.
            System.err.println("clique sur 'augmenter nombre fleche'.");
        }
    };
    /**
     * Fonction lambda pour permettre d’augmenter la distance de tir des archers de la tour.
     */
    BiConsumer<Jeu, PositionTuile> augmenterDistanceFct = (jeu, position) ->
    {
        if (null != jeu.tourChoisie && jeu.tourChoisie.augmenterDistancePossible()) {
            // Code ici pour augmenter distance de tir.
            System.err.println("clique sur 'augmenter distance de tir'.");
        }
    };

    /**
     * Ce constructeur initialise la classe jeu.
     * @param dimension de la fenêtre du jeu.
     */
    public Jeu( Dimension dimension ) {
        super( true );

        this.dimension = dimension;

        setSize( dimension );

        int rx = dimension.width / Constantes.DIM_LARGEUR;
        int ry = dimension.height / Constantes.DIM_HAUTEUR;

        r = Math.min( rx, ry );

        margeX = ( dimension.width - r * Constantes.DIM_LARGEUR ) / 2;
        margeY = ( dimension.height - r * Constantes.DIM_HAUTEUR ) / 2;

        ratio = AffineTransform.getTranslateInstance( margeX, margeY );
        ratio.scale( r, r );

        gestionSouris = new GestionSouris( this );

        niveauCourant = new NiveauTD_1();
        argent = niveauCourant.argentDepart();
        emplacementTours = new AffineTransform[ niveauCourant.positionTours().length ];
        toursConstruites = new ArrayList<>();

        vieChateau = Constantes.VIE_CHATEAU;
        for( int i = 0; i < niveauCourant.positionTours().length; ++ i ) {
            gestionSouris.inscrireEvenement( niveauCourant.positionTours()[ i ], ( jeu, position ) ->
            {
                if( Constantes.PRIX_TOUR <= jeu.argent &&
                        ! toursConstruites.stream().anyMatch( ( t ) -> t.getPositionTuile().equals( position ) ) ) {
                    jeu.argent -= Constantes.PRIX_TOUR;
                    Tour nouvelleTour = new Tour( position );
                    toursConstruites.add( nouvelleTour );
                    jeu.repaint();
                    jeu.gestionSouris.modifierEvenement( position, ( j, p ) -> {
                        j.tourChoisie = nouvelleTour;
                        repaint();
                    } );
                }
            }
            );
            PositionPixel p = niveauCourant.positionTours()[ i ].positionPixel();
            emplacementTours[ i ] = (AffineTransform)ratio.clone();
            emplacementTours[ i ].translate( p.x(), p.y() );
        }
        gestionSouris.inscrireEvenement( new PositionTuile( 34, 21 ), ( jeu, position ) ->
                {
                    if( 0 < vieChateau ) {
                        animateur.start();
                        action = true;
                    }
                }
                );
        gestionSouris.inscrireEvenement( new PositionTuile( 37, 21 ), ( jeu, position ) ->
                {
                    animateur.stop();
                    action = false;
                    repaint();
                }
        );
        gestionSouris.inscrireEvenement( new PositionTuile( 39, 0 ), ( jeu, position ) -> System.exit( 0 ) );
        gestionSouris.inscrireEvenement( Constantes.POSITION_DOMMAGE_AUG, augmenterDommageFct );
        gestionSouris.inscrireEvenement( Constantes.POSITION_NOMBRE_FLECHE_AUG, augmenterArcherFct );
        gestionSouris.inscrireEvenement( Constantes.POSITION_DISTANCE_AUG, augmenterDistanceFct );

        this.addMouseListener( gestionSouris );

        animateur = new Timer( Constantes.TEMPS_TIC_MS, ( e ) -> {
            animerEnnemis();
            if( vieChateau <= 0 ) {
                animateur.stop();
                action = false;
            }
            for( int i = 0; i < generateurs.size(); ++ i ) {
                generateurs.get( i ).avance();
                if( ! generateurs.get( i ).estVivant() ) {
                    generateurs.remove( i );
                    -- i;
                }
            }
            if( generateurs.size() <= 0 && ennemis.size() <= 0 ) {
                animateur.stop();
                action = false;
            }
            tirer();
            repaint();
        } );

        ennemis = new ArrayList<>();
        generateurs = niveauCourant.generateurs();

        generateurs.stream().forEach( ( e ) -> e.setParent( this ) );
        tourChoisie = null;
    }

    private class ProcheChateau implements Comparator<Ennemi>{

        @Override
        public int compare(Ennemi o1, Ennemi o2) {
            return o1.distanceChateau() - o2.distanceChateau();
        }
    }

    /**
     * Tirer sur les ennemis avec les tours qui sont sur le terrain.
     */
    private void tirer() {
        // votre code ici.


        for (Tour tourCourante: toursConstruites) {
            tourCourante.recharger();
            if (tourCourante.isReady()) {
                ArrayList<Ennemi> ciblesPossibles = new ArrayList<>();

                for (Ennemi cible: this.ennemis) {
                    int distance = tourCourante.getPositionPixel().distance(cible.getPositionPixel());
                    if (tourCourante.getDistanceMaxTir_pixel() >= distance){
                        ciblesPossibles.add(cible);
                    }
                }
                ciblesPossibles.sort(new ProcheChateau());
                if (!ciblesPossibles.isEmpty()) {
                    Ennemi cibleChoisie = ciblesPossibles.get(0);
                    cibleChoisie.endommage(tourCourante.getDommage_pv());
                    tourCourante.tirer();
                    if (cibleChoisie.isDead()){
                        int recompense = cibleChoisie.getValeurArgent();
                        this.argent += recompense;
                        ennemis.remove(cibleChoisie);
                    }
                }
            }
        }

        /*
        Les tours qui sont sur le terrain sont dans la variable nommée toursConstruites
        de la classe Jeu. Cette variable est de type List< Tour >.

        Les instances de la classe Tour décrivent chaque tour qui est sur le terrain.

        La variable nommée ennemis contient une liste des ennemis en vie sur le terrain.

        À chaque tic du jeu (chaque appel à la méthode tirer), les archers dans les tours
        rechargent leur arc. La variable d’instance periodeRecharge_tic, indique
        combien de tics entre chaque tir de flèche. Un archer peut recharger son arc même s’il
        n’y a pas d’ennemi, ainsi, il peut tirer lorsqu’un ennemi est en distance de tir.
        Lorsque l’arc est rechargé, alors il reste à déterminer sur qui tirer.

            - Les tours ont une variable d’instance nommée distanceMaxTir_pixel.
            Cette variable indique la distance de tir maximum pour les archers de la tour.
            Cette distance est en pixel. Les classes Ennemi et Tour contiennent une
            méthode getPositionPixel qui donne la position en pixel de l’instance. Il
            ne reste qu’a calculer la distance entre les deux positions, si elle est plus petite
            ou égale que la distance de tir de la tour, alors il est possible de tirer sur
            l’ennemi.

            - Les tours ont aussi un nombre d’archers. Cette valeur est dans la variable
            d’instance nommée nombreProjectileParTir. Lorsqu’une tour tir, elle
            doit donc choisir un nombre d’ennemis parmi ceux en distance de tir égale au
            nombre d’archers de la tour. Il faut choisir les ennemis les plus près du château.
            La classe Ennemi contient une méthode qui donne la distance entre l’ennemi
            et le château. S’il n’y a pas assez d’ennemis pour tous les archers, alors les
            autres archers tirent dans le vide : tous les archers devront recharger leur arc en
            même temps.

            - Lorsqu’un archer tire sur un ennemi, il lui fait du dommage égal à la valeur dans
            la variable d’instance dommage_pv de la classe Tour. Ce dommage est
            soustrait de la variable d’instance pointVie de la classe Ennemi. Si un
            ennemi arrive à zéro pointVie ou moins, alors il est enlevé de la liste
            d’ennemis. Dans ce cas, le montant d’argent que possède le joueur est
            augmenté. La classe Ennemi contient cette valeur dans une variable
            d’instance. Le nombre d’argents qu’a un joueur est dans la variable d’instance
            argent de la classe Jeu.

        Un joueur peut augmenter les caractéristiques de ses tours. Pour cela, il doit dépenser de
        l’argent. La classe Jeu contient trois (3) fonctions lambda de type BiConsumer. Chacune de ces
        fonctions correspond à l’augmentation d’une caractéristique des tours.

            - augmenterDommageFct : cette variable contient la fonction lambda pour permettre
            d’augmenter le dommage que cause une flèche pour tous les archers d’une tour. Vous
            devez compléter le code dans cette fonction lambda. Il faut vérifier qu’il y a assez
            d’argent pour augmenter la capacité. Au maximum, nous pouvons augmenter cette
            caractéristique 5 fois. Chaque augmentation ajoute 1 au dommage causé par la tour.
            Chaque augmentation coute 5 fois le nouveau dommage de la tour. Par exemple, pour
            aller de 2 à 3 de dommage, cela coute 15 $. S’il n’y a pas assez d’argent pour
            l’augmentation, alors la méthode ne fait rien.

            - augmenterArcherFct : cette variable contient la fonction lambda pour permettre
            d’augmenter le nombre d’archers dans la tour. Au maximum, nous pouvons augmenter
            cette caractéristique 2 fois. Chaque augmentation ajoute 1 archer. Le deuxième archer
            coute 50 $ et le troisième archer coute 100 $.

            - augmenterDistanceFct : cette variable contient la fonction lambda pour
            permettre d’augmenter la distance de tir des archers de la tour. Cette augmentation n’a
            lieu qu’une seule fois. Elle coute 70 $ et ajoute 12 à la distance de tir de la tour.

        Vous allez devoir écrire le code pour les méthodes qui tests si le nombre d’augmentations
        maximum a été atteint (dans la classe Tour). C’est méthode existe déjà et sont utiliser à
        quelques endroits dans le code : augmenterDommagePossible,
        augmenterArcherPossible, augmenterDistancePossible.
        */
    }

    /**
     * Déplacer les ennemis jusqu'au château à moins qu'il ne soit éliminé avant.
     * Si l'ennemi atteint le château, ce dernier perd de la vie.
     */
    private void animerEnnemis() {
        for( int i = 0; i < ennemis.size(); ++ i ) {
            if( ! ennemis.get( i ).aAtteintChateau() ) {
                ennemis.get( i ).avancer();
            } else {
                -- vieChateau;
                ennemis.remove( i );
                -- i;
            }
        }
    }

    /**
     * Affiche un nombre à une position spécifique dans la fenêtre.
     * @param g2 est la fenêtre
     * @param position est l'emplacement du nombre à afficher
     * @param n est le nombre à afficher
     */
    private void afficherNombre( Graphics2D g2, PositionTuile position, int n ) {
        AffineTransform pCurseur = (AffineTransform) ratio.clone();
        PositionPixel p = position.positionPixel();
        pCurseur.translate( p.x(), p.y() );
        if( 0 == n ) {
            g2.drawImage( Constantes.NIVEAU_CHIFFRES[ 0 ], pCurseur, null );
        } else {
            while( 0 != n ) {
                int chiffre = n % 10;
                n = n / 10;
                g2.drawImage( Constantes.NIVEAU_CHIFFRES[ chiffre ], pCurseur, null );
                pCurseur.translate( -Constantes.TAILLE_TUILE, 0 );
            }
        }
    }

    /**
     * Affiche les emplacements des tours que l'on veut bâtir.
     * @param g2 est la fenêtre
     */
    private void afficherEmplacementTours( Graphics2D g2 ) {
        for( int i = 0; i < emplacementTours.length; ++ i ) {
            g2.drawImage( EMPLACEMENT_TOUR, emplacementTours[ i ], null );
        }
    }

    /**
     * Affiche les tours qui sont construites.
     * @param g2 est la fenêtre
     */
    private void afficherTours( Graphics2D g2 ) {
        for( int i = 0; i < toursConstruites.size(); ++ i ) {
            AffineTransform pCurseur = (AffineTransform) ratio.clone();
            PositionPixel pos = toursConstruites.get( i ).getPositionTuile().positionPixel();
            pCurseur.translate( pos.x(), pos.y() );

            g2.drawImage( Constantes.TOUR_BAS, pCurseur, null );
            pCurseur.translate( 0, - Constantes.TAILLE_TUILE );
            g2.drawImage( Constantes.TOUR_HAUT, pCurseur, null );
        }
    }

    /**
     * Affiche les ennemis qui sont sur le terrain.
     * @param g2 est la fenêtre
     */
    private void afficherEnnemi( Graphics2D g2 ) {
        for( int i = 0; i < ennemis.size(); ++ i ) {
            ennemis.get( i ).afficher( g2, ratio );
        }
    }

    /**
     * Affiche les boutons PLAY, STOP, ainsi que les boutons pour l'amélioration des tours.
     * @param g2 est la fenêtre
     */
    private void afficherControl( Graphics2D g2 ) {
        AffineTransform pCu = (AffineTransform) ratio.clone();
        pCu.translate( 39 * Constantes.TAILLE_TUILE, 0 * Constantes.TAILLE_TUILE );
        g2.drawImage( Constantes.BOUTON_FERMER, pCu, null );
        AffineTransform pCurseur = (AffineTransform) ratio.clone();
        pCurseur.translate( 34 * Constantes.TAILLE_TUILE, 21 * Constantes.TAILLE_TUILE );
        if( action ) {
            g2.drawImage( Constantes.BOUTON_PLAY_ON, pCurseur, null );
        } else {
            g2.drawImage( Constantes.BOUTON_PLAY_OFF, pCurseur, null );
        }
        pCurseur.translate( 3 * Constantes.TAILLE_TUILE, 0 );
        if( action ) {
            g2.drawImage( Constantes.BOUTON_STOP_OFF, pCurseur, null );
        } else {
            g2.drawImage( Constantes.BOUTON_STOP_ON, pCurseur, null );
        }
        if( null != tourChoisie ) {
            AffineTransform pC = (AffineTransform) ratio.clone();
            pC.translate( 39 * Constantes.TAILLE_TUILE, 10 * Constantes.TAILLE_TUILE );
            afficherMessage( g2, "dom", new PositionTuile( 33, 10 ) );
            afficherNombre( g2, Constantes.POSITION_DOMMAGE_INT, tourChoisie.getDommage_pv() );
            if( tourChoisie.augmenterDommagePossible() ) {
                g2.drawImage( Constantes.BOUTON_AUGMENTER, pC, null );
            }
            afficherMessage( g2, "nbr", new PositionTuile( 33, 11 ) );
            afficherNombre( g2, Constantes.POSITION_NOMBRE_FLECHE_INT, tourChoisie.getNombreProjectileParTir() );
            pC.translate( 0, Constantes.TAILLE_TUILE );
            if( tourChoisie.augmenterArcherPossible() ) {
                g2.drawImage( Constantes.BOUTON_AUGMENTER, pC, null );
            }
            afficherMessage( g2, "dis", new PositionTuile( 33, 12 ) );
            afficherNombre( g2, Constantes.POSITION_DISTANCE_INT, tourChoisie.getDistanceMaxTir_pixel() );
            pC.translate( 0, Constantes.TAILLE_TUILE );
            if( tourChoisie.augmenterDistancePossible() ) {
                g2.drawImage( Constantes.BOUTON_AUGMENTER, pC, null );
            }
        }
    }

    /**
     * Affiche un message à l'écran.
     * @param g2 est la fenêtre
     * @param mssg est le message à afficher
     * @param pos est l'emplacement du début du message
     */
    public void afficherMessage( Graphics2D g2, String mssg, PositionTuile pos ) {
        AffineTransform pC = (AffineTransform) ratio.clone();
        PositionPixel p = pos.positionPixel();
        pC.translate( p.x(), p.y() );
        for( char c : mssg.toCharArray() ) {
            if( ' ' != c ) {
                g2.drawImage(Constantes.LETTRES_MIN[c - 'a'], pC, null);
            }
            pC.translate( 8, 0 );
        }
    }

    /**
     * Remplis la fenêtre des différents éléments graphiques.
     * @param g est la fenêtre
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g.setColor( Color.darkGray );
        g.fillRect( margeX, margeY, Constantes.DIM_LARGEUR * r, Constantes.DIM_HAUTEUR * r );

        niveauCourant.dessiner( g2, ratio );
        afficherNombre( g2, Constantes.POSITION_ARGENT, argent );
        AffineTransform pC = (AffineTransform) ratio.clone();
        PositionPixel p = Constantes.POSITION_DOLLAR.positionPixel();
        pC.translate( p.x(), p.y() );
        g2.drawImage(Constantes.DOLLAR, pC, null);
        afficherNombre( g2, niveauCourant.positionPV(), vieChateau );
        afficherEmplacementTours( g2 );
        afficherTours( g2 );
        afficherEnnemi( g2 );
        afficherControl( g2 );
        if( vieChateau <= 0 ) {
            afficherMessage( g2, "vous avez perdu", new PositionTuile( 12, 12 ) );
        }
        if( generateurs.size() <= 0 && ennemis.size() <= 0 ) {
            afficherMessage( g2, "vous avez gagne", new PositionTuile( 12, 12 ) );
        }
    }
}
