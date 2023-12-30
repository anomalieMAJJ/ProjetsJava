/**
 * Cette classe représente une ligne horizontale.
 */
public class SegmentHorizontal extends Segment {
    /**
     * Construit un segment horizontal.
     * @param depart est le point de départ du segment
     * @param arrive est le point d'arrivée du segment
     */
    public SegmentHorizontal( PositionPixel depart, PositionPixel arrive ) {
        super( depart, arrive );
    }

    /**
     * Retourne la longueur du segment horizontal.
     * @return la longueur
     */
    @Override
    public int longueur() {
        return Math.abs( arrive.x() - depart.x() );
    }

    /**
     * Donne une position sur le segment horizontal.
     * @param t la distance du point de départ de la position souhaitée
     * @return la position en pixels du point demandé
     */
    @Override
    public PositionPixel tween( double t ) {
        return ( depart.x() < arrive.x() )
                ? new PositionPixel( depart.x() + (int)t, depart.y() )
                : new PositionPixel( depart.x() - (int)t, depart.y() );
    }
}
