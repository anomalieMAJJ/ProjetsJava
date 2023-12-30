import java.awt.*;

/**
 * Cette classe contient les constantes nécessaires au fonctionnement du jeu.
 */
public class Constantes {
    public static final int TAILLE_TUILE = 8;
    public static final int PRIX_TOUR = 40;
    public static final int DOMMAGE_PV_INITIALE = 2;
    public static final int PERIODE_RECHARGE_TIC = 15;
    public static final int NOMBRE_PROJECTILE_PAR_TIR_INITIALE = 1;
    public static final int DISTANCE_MAX_TIR_PIXEL_INITIALE = 24;
    private static final Color COULEUR_CARACTERES = Color.yellow;
    private static final Color COULEUR_PV = Color.red;


    public static final int DIM_LARGEUR_TUILLE = 40;
    public static final int DIM_HAUTEUR_TUILLE = 25;
    public static final int DIM_LARGEUR = DIM_LARGEUR_TUILLE * TAILLE_TUILE;
    public static final int DIM_HAUTEUR = DIM_HAUTEUR_TUILLE * TAILLE_TUILE;
    public static final Tuile[] NIVEAU_CHIFFRES =
            {
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_0 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_1 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_2 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_3 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_4 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_5 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_6 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_7 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_8 ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_9 ),
            };
    public static final Tuile[] LETTRES_MIN =
            {
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_a ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_b ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_c ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_d ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_e ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_f ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_g ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_h ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_i ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_j ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_k ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_l ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_m ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_n ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_o ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_p ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_q ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_r ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_s ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_t ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_u ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_v ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_w ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_x ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_y ),
                    new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_z ),
            };

    public static final Tuile[] PV_ENNEMI =
            {
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_0_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_1_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_2_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_3_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_4_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_5_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_6_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_7_8),
                    new Tuile(Color.darkGray, COULEUR_PV, BitMap.TUILE_PV_8_8),
            };

    public static final int FACTEUR_PV = PV_ENNEMI.length - 1;

    public static final Tuile DOLLAR = new Tuile( Color.darkGray, COULEUR_CARACTERES, BitMap.TUILE_DOLLAR );
    public static final Tuile TOUR_BAS = new Tuile( Color.darkGray, Color.lightGray, BitMap.TUILE_MUR );
    public static final Tuile TOUR_HAUT = new Tuile( Color.darkGray, Color.lightGray, BitMap.TUILE_TOUR_DESSUS );
    public static final Tuile E_LAPIN = new Tuile( new Color( 200, 105, 10 ), BitMap.TUILE_LAPIN );
    public static final Tuile E_TORTUE = new Tuile( new Color( 100, 130, 32 ), BitMap.TUILE_TORTUE );
    public static final Tuile E_BOSS = new Tuile( new Color( 150, 105, 10 ), BitMap.TUILE_BOSS );
    public static final Tuile BOUTON_FERMER = new Tuile( Color.lightGray, BitMap.TUILE_FERMER );
    public static final Tuile BOUTON_PLAY_OFF = new Tuile( Color.red, BitMap.TUILE_PLAY );
    public static final Tuile BOUTON_PLAY_ON = new Tuile( Color.green, BitMap.TUILE_PLAY );
    public static final Tuile BOUTON_STOP_OFF = new Tuile( Color.red, BitMap.TUILE_STOP );
    public static final Tuile BOUTON_STOP_ON = new Tuile( Color.green, BitMap.TUILE_STOP );
    public static final Tuile BOUTON_AUGMENTER = new Tuile( Color.green, BitMap.TUILE_AUGMENTER );
    public static final int TEMPS_TIC_MS = 1000 / 25;
    public static final int VIE_CHATEAU = 10;
    public static final PositionTuile POSITION_ARGENT = new PositionTuile( DIM_LARGEUR_TUILLE - 2, 3 );
    public static final PositionTuile POSITION_DOLLAR = new PositionTuile( DIM_LARGEUR_TUILLE - 1, 3 );
    public static final PositionTuile POSITION_DOMMAGE_INT = new PositionTuile( DIM_LARGEUR_TUILLE - 2, 10 );
    public static final PositionTuile POSITION_DOMMAGE_AUG = new PositionTuile( DIM_LARGEUR_TUILLE - 1, 10 );
    public static final PositionTuile POSITION_NOMBRE_FLECHE_INT = new PositionTuile( DIM_LARGEUR_TUILLE - 2, 11 );
    public static final PositionTuile POSITION_NOMBRE_FLECHE_AUG = new PositionTuile( DIM_LARGEUR_TUILLE - 1, 11 );
    public static final PositionTuile POSITION_DISTANCE_INT = new PositionTuile( DIM_LARGEUR_TUILLE - 2, 12 );
    public static final PositionTuile POSITION_DISTANCE_AUG = new PositionTuile( DIM_LARGEUR_TUILLE - 1, 12 );
}
