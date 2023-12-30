/**
 * Cette classe abstraite représente une ligne.
 */
public abstract class Segment {
    protected PositionPixel depart;
    protected PositionPixel arrive;

    /**
     * Construit un segment.
     * @param depart est le point de départ du segment
     * @param arrive est le point d'arrivée du segment
     */
    public Segment( PositionPixel depart, PositionPixel arrive ) {
        this.depart = depart;
        this.arrive = arrive;
    }

    /**
     * Constructeur retournant le segment approprié (vertical ou horizontal).
     * @param depart est le point de départ du segment
     * @param arrive est le point d'arrivée du segment
     * @return le segment construit
     */
    public static Segment construire( PositionPixel depart, PositionPixel arrive ) {
        return ( depart.y() == arrive.y() )
                ? new SegmentHorizontal( depart, arrive )
                : new SegmentVertical( depart, arrive );
    }

    /**
     * Retourne la longueur du segment.
     * @return la longueur
     */
    public abstract int longueur();

    /**
     * Donne une position sur le segment.
     * @param t la distance du point de départ de la position souhaitée
     * @return la position en pixels du point demandé
     */
    public abstract PositionPixel tween( double t );
}
