import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Cette classe gère les clics de souris dans le jeu.
 */
public class GestionSouris implements MouseListener {
    /**
     * Ce record représente les événements à écouter.
     * @param position la position de la souris à l'écran
     * @param action le bouton sélectionné
     */
    private record Evenement ( PositionTuile position, BiConsumer< Jeu, PositionTuile > action ) {
        @Override
        public boolean equals( Object obj ) {
            boolean resultat = false;

            if( obj != null && obj instanceof Evenement e ) {
                resultat = position.equals( e.position );
            }

            return resultat;
        }
    }

    private List< Evenement > evenements;
    private Jeu parent;

    /**
     * Constructeur du listener.
     * @param parent est le jeu écouté
     */
    public GestionSouris( Jeu parent ) {
        this.parent = parent;
        this.evenements = new ArrayList<>();
    }

    /**
     * Ajoute un événement à écouter.
     * @param position la position de la souris à l'écran
     * @param action le bouton sélectionné
     */
    public void inscrireEvenement( PositionTuile position, BiConsumer< Jeu, PositionTuile > action ) {
        evenements.add( new Evenement( position, action ) );
    }

    /**
     * Modifie un événement à écouter.
     * @param pos la position d'une tuile
     * @param action le bouton sélectionné
     */
    public void modifierEvenement( PositionTuile pos, BiConsumer< Jeu, PositionTuile > action ) {
        evenements.set( evenements.indexOf( new Evenement( pos, null ) ), new Evenement( pos, action ) );
    }

    /**
     * Exécute l'action associée à la position de la souris lors du clic.
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked( MouseEvent e ) {
        int x = ( e.getX() - parent.margeX ) / ( parent.r * Constantes.TAILLE_TUILE );
        int y = ( e.getY() - parent.margeY ) / ( parent.r * Constantes.TAILLE_TUILE );

        PositionTuile cible = new PositionTuile( x, y );

        int i = 0;
        while( i < evenements.size() && ! evenements.get( i ).position().equals( cible ) ) {
            ++ i;
        }

        if( i < evenements.size() ) {
            evenements.get( i ).action().accept( parent, cible );
        }
    }

    @Override
    public void mousePressed( MouseEvent e ) {
        // rien
    }

    @Override
    public void mouseReleased( MouseEvent e ) {
        // rien
    }

    @Override
    public void mouseEntered( MouseEvent e ) {
        // rien
    }

    @Override
    public void mouseExited( MouseEvent e ) {
        // rien
    }
}
