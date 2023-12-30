/**
 * Ce record représente une position en tuile.
 * @param x
 * @param y
 */
public record PositionTuile( int x, int y ) {
    /**
     * Converti la position d'une tuile en position sous forme de pixels.
     * @return une position en pixel
     */
    public PositionPixel positionPixel() {
        return new PositionPixel( x * Constantes.TAILLE_TUILE, y * Constantes.TAILLE_TUILE );
    }
}
