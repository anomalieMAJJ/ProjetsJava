import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe est le parcours des ennemis.
 */
public class Chemin {
    private List< Segment > segments;
    private int longueur;

    /**
     * Constructeur du chemin.
     * @param extremites sont les extrémités du chemin
     */
    public Chemin( PositionTuile ... extremites ) {
        longueur = 0;
        segments = new ArrayList<>();
        for( int i = 1; i < extremites.length; ++ i ) {
            Segment s = Segment.construire( extremites[ i - 1 ].positionPixel(), extremites[ i ].positionPixel() );
            segments.add( s );
            longueur += s.longueur();
        }
    }

    /**
     * Prend le nombre de segments (lignes droites du trajet).
     * @return le nombre de segments
     */
    public int nombreSegment() {
        return segments.size();
    }

    /**
     * Rend le segment à l'index demandé.
     * @param pos est la position dans la liste de segments (index)
     * @return le segment
     */
    public Segment getSegment( int pos ) {
        return segments.get( pos );
    }

    /**
     * Calcule la position d'un point sur un segment du chemin.
     * @param noSegment est un segment du chemin
     * @param t est une distance à partir du début du segment
     * @return une position en pixels
     */
    public PositionPixel calculerPosition( int noSegment, double t ) {
        return segments.get( noSegment ).tween( t );
    }

    /**
     * Prend la longueur du chemin.
     * @return la longueur du chemin
     */
    public int getLongueur() {
        return longueur;
    }
}
