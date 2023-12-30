/**
 * Cette classe représente une ligne verticale.
 */
public class SegmentVertical extends Segment {
    /**
     * Construit un segment vertical.
     * @param depart est le point de départ du segment
     * @param arrive est le point d'arrivée du segment
     */
    public SegmentVertical( PositionPixel depart, PositionPixel arrive ) {
        super( depart, arrive );
    }

    /**
     * Retourne la longueur du segment vertical.
     * @return la longueur
     */
    @Override
    public int longueur() {
        return Math.abs( arrive.y() - depart.y() );
    }

    /**
     * Donne une position sur le segment vertical.
     * @param t la distance du point de départ de la position souhaitée
     * @return la position en pixels du point demandé
     */
    @Override
    public PositionPixel tween( double t ) {
        return ( depart.y() < arrive.y() )
                ? new PositionPixel( depart.x(), depart.y() + (int)t )
                : new PositionPixel( depart.x(), depart.y() - (int)t );
    }
}
