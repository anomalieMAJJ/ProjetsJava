/**
 * Ce record représente une position en pixel.
 * @param x
 * @param y
 */
public record PositionPixel( int x, int y ) {
    /**
     * Mesure la distance entre deux positions.
     * @param p2 est une autre position que l'on veut comparer.
     * @return la distance en nombre de pixels.
     */
    public int distance( PositionPixel p2 ) {
        int deltaX = x - p2.x;
        int deltaY = y - p2.y;
        double d = Math.sqrt( deltaX * deltaX + deltaY * deltaY );
        return (int) d;
    }
}
