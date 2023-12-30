/**
 * Cette classe représente une tour.
 */
public class Tour {
    private PositionTuile position;
    private int dommage_pv;
    private int periodeRecharge_tic;
    private int nombreProjectileParTir;
    private int distanceMaxTir_pixel;
    private int tempsRechargeRestant;

    /**
     * Constructeur d'une tour.
     * @param position est l'emplacement de la tour.
     */
    public Tour( PositionTuile position ) {
        this.position = position;
        this.dommage_pv = Constantes.DOMMAGE_PV_INITIALE;
        this.periodeRecharge_tic = Constantes.PERIODE_RECHARGE_TIC;
        this.nombreProjectileParTir = Constantes.NOMBRE_PROJECTILE_PAR_TIR_INITIALE;
        this.distanceMaxTir_pixel = Constantes.DISTANCE_MAX_TIR_PIXEL_INITIALE;
        this.tempsRechargeRestant = 0;
    }

    /**
     * Prend la position de la Tuile où situer la tour.
     * @return la position de la Tuile
     */
    public PositionTuile getPositionTuile() {
        return position;
    }

    /**
     * Prend le nombre de dommage que fait une flèche.
     * @return les dommages faits
     */
    public int getDommage_pv() {
        return dommage_pv;
    }

    /**
     * Vérifie s'il est possible d'améliorer les dommages que fait une flèche.
     * @return True si possible, sinon False
     */
    public boolean augmenterDommagePossible(){
        return true;
    }

    /**
     * Prend le nombre de flèches par tir.
     * @return
     */
    public int getNombreProjectileParTir() {
        return nombreProjectileParTir;
    }

    /**
     * Vérifie s'il est possible d'augmenter le nombre d'archers.
     * @return True si possible, sinon False
     */
    public boolean augmenterArcherPossible(){
        return true;
    }

    /**
     * Prend la distance maximum des tirs en pixel.
     * @return la distance maximum des tirs en pixel
     */
    public int getDistanceMaxTir_pixel() {
        return distanceMaxTir_pixel;
    }

    /**
     * Vérifie s'il est possible d'augmenter la portée des flèches.
     * @return True si possible, sinon False
     */
    public boolean augmenterDistancePossible() {
        return true;
    }

    /**
     * Prend la position de la tour.
     * @return la position de la tour
     */
    public PositionPixel getPositionPixel() {
        return position.positionPixel();
    }

    public void recharger() {
        if (!isReady()){
            tempsRechargeRestant--;
        }
    }

    public void tirer(){
        tempsRechargeRestant = Constantes.PERIODE_RECHARGE_TIC;
    }

    public boolean isReady() {
        return this.tempsRechargeRestant == 0;
    }


}
