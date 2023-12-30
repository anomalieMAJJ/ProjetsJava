import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Cette classe représente un ennemi.
 */
public class Ennemi {
    private Chemin chemin;
    private int noSegment;
    private double distance;

    private double vitesse;
    private int pointVie;
    private int pointVieMax;

    private Tuile image;
    private int valeurArgent;

    /**
     * Constructeur d'un ennemi.
     * @param chemin est le Chemin jusqu'au château
     * @param vitesse est la vitesse de déplacement par tic
     * @param pointVie est le nombre de points de vie de l'ennemi
     * @param valeurArgent le montant remis lorsque l'ennemi est tué
     * @param image est la Tuile représentant l'ennemi
     */
    public Ennemi( Chemin chemin, double vitesse, int pointVie, int valeurArgent, Tuile image ) {
        this.chemin = chemin;
        this.vitesse = vitesse;
        this.pointVie = pointVie;
        this.pointVieMax = pointVie;
        this.valeurArgent = valeurArgent;
        this.image = image;
        this.distance = 0.0;
        this.noSegment = 0;
    }

    /**
     * Constructeur d'un ennemi.
     * @param original est l'ennemi à copier
     */
    public Ennemi( Ennemi original ) {
        chemin = original.chemin;
        noSegment = original.noSegment;
        distance = original.distance;
        vitesse = original.vitesse;
        pointVie = original.pointVie;
        pointVieMax = original.pointVieMax;
        image = original.image;
        valeurArgent = original.valeurArgent;
    }

    /**
     * Indique si l'ennemi a atteint le château.
     * @return True si le château est atteint, sinon False
     */
    public boolean aAtteintChateau() {
        return chemin.nombreSegment() <= noSegment;
    }

    /**
     * Avance l'ennemi en direction du château.
     */
    public void avancer() {
        if( noSegment < chemin.nombreSegment() ) {
            distance += vitesse;
            int longueur = chemin.getSegment( noSegment ).longueur();
            if( longueur < distance ) {
                distance -= longueur;
                ++ noSegment;
            }
        }
    }

    /**
     * Calcul la distance entre un ennemi et le château.
     * @return la distance
     */
    public int distanceChateau() {
        return chemin.getLongueur() - ( (int)distance );
    }

    /**
     * Donne la position en pixel d'un ennemi.
     * @return la position
     */
    public PositionPixel getPositionPixel() {
        return chemin.calculerPosition( noSegment >= chemin.nombreSegment() ? noSegment - 1:noSegment, distance );
    }

    /**
     * Déplace l'ennemi dans le jeu.
     * @param g2 est la fenêtre
     * @param affineTransform
     */
    public void afficher( Graphics2D g2, AffineTransform affineTransform ) {
        if( noSegment < chemin.nombreSegment() ) {
            AffineTransform pCurseur = (AffineTransform) affineTransform.clone();
            PositionPixel position = getPositionPixel();
            pCurseur.translate( position.x(), position.y() );
            g2.drawImage( image, pCurseur, null );
            pCurseur.translate( 0, - 2 );
            int rPV = ( pointVie * Constantes.FACTEUR_PV ) / pointVieMax;
            g2.drawImage( Constantes.PV_ENNEMI[ rPV ], pCurseur, null );
        }
    }

    /**
     * Prend la valeur en argent de l'ennemi.
     * @return le montant d'argent
     */
    public int getValeurArgent() {
        return valeurArgent;
    }

    public void endommage(int dommage){
        this.pointVie -= dommage;
    }
    public boolean isDead(){
        return this.pointVie <= 0;
    }
}
