import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Cette classe implémente le niveau 1.
 */
public class NiveauTD_1 implements Niveau {
    public static final int ARGENT_DEPART = 100;
    public static final Color VERT_PALE = new Color( 50, 200, 0 );
    public static final Color VERT = new Color( 40, 160, 0 );
    public static final Color BLEU = new Color( 30, 160, 200 );

    public static final Tuile[] NIVEAU_1_TUILES =
            {
                    null,
                    new Tuile( VERT_PALE, VERT, BitMap.TUILE_BUISSON ),
                    new Tuile( VERT_PALE, VERT, BitMap.TUILE_ARBRE ),
                    new Tuile( Color.lightGray, BitMap.TUILE_CRENEAU_NS ),
                    new Tuile( Color.lightGray, BitMap.TUILE_TOUR_DESSUS ),
                    new Tuile( Color.lightGray, BitMap.TUILE_MUR ),
                    new Tuile( Color.lightGray, BitMap.TUILE_CRENEAU_OE ),
                    new Tuile( Color.lightGray, BitMap.TUILE_PORTE ),
                    new Tuile( VERT_PALE, BitMap.TUILE_CARRE ),
                    new Tuile( BLEU, BitMap.TUILE_CARRE ),
                    new Tuile( BLEU, Color.lightGray, BitMap.TUILE_H_LARGE ),
                    new Tuile( VERT_PALE, Color.orange, BitMap.TUILE_CARRE ),
                    new Tuile( VERT_PALE, Color.orange, BitMap.TUILE_COIN_NE ),
                    new Tuile( Color.orange, VERT_PALE, BitMap.TUILE_COIN_NE_INT ),
                    new Tuile( VERT_PALE, Color.orange, BitMap.TUILE_COIN_SE ),
                    new Tuile( Color.orange, VERT_PALE, BitMap.TUILE_COIN_SE_INT ),
                    new Tuile( VERT_PALE, Color.orange, BitMap.TUILE_COIN_SO ),
                    new Tuile( Color.orange, VERT_PALE, BitMap.TUILE_COIN_SO_INT ),
            };

    public static final char [][] NIVEAU_1_MAP =
            {
                    {2, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 9, 9, 9, 9, 9, 4, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 6, 6, 6, 6, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 5, 5, 5, 5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 8, 8, 8, 8, 8, 3, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 8, 8, 8, 8, 8, 3, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 8, 8, 4, 8, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 5, 6, 6, 5, 6, 6, 5, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 5, 5, 5, 7, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9,10, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                   {11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,12, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,13,11, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,11,17, 8, 8, 8, 8, 8, 8, 8, 8,15,11, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,16,11,11,11,11,11,11,11,11,11,11,14, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 2, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 2, 8, 1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
                    {8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, },
            };

    public static final PositionTuile [] POSITION_TOURS = {
            new PositionTuile( 10, 11 ),
            new PositionTuile( 15, 14 ),
            new PositionTuile( 19, 16 ),
            new PositionTuile( 21, 17 ),
            new PositionTuile( 26, 11 ),
    };

    public static final Chemin CHEMIN = new Chemin(
            new PositionTuile( 0, 12 ),
            new PositionTuile( 17, 12 ),
            new PositionTuile( 17, 18 ),
            new PositionTuile( 28, 18 ),
            new PositionTuile( 28, 7 )
    );

    public static final Ennemi LAPIN = new Ennemi( NiveauTD_1.CHEMIN, 0.8, 10, 10, Constantes.E_LAPIN );
    public static final Ennemi TORTUE = new Ennemi( NiveauTD_1.CHEMIN, 1.5, 4, 5, Constantes.E_TORTUE );
    public static final Ennemi BOSS = new Ennemi( NiveauTD_1.CHEMIN, 0.5, 100, 100, Constantes.E_BOSS );

    public static final List< Generateur > GENERATEURS = new ArrayList<>( Arrays.asList(
            new Generateur( 0, 25, LAPIN, 8 ),
            new Generateur( 200, 0, TORTUE, 1 ),
            new Generateur( 400, 25, LAPIN, 8 ),
            new Generateur( 600, 0, TORTUE, 1 ),
            new Generateur( 700, 0, BOSS, 1 ),
            new Generateur( 800, 25, LAPIN, 8 )
    ) );

    public static final PositionTuile positionChateau = new PositionTuile( 28, 4 );

    /**
     * Donne la position du château.
     * @return la position du château
     */
    @Override
    public PositionTuile positionPV() {
        return positionChateau;
    }

    /**
     * Dessine l'environnement du niveau.
     * @param g2 est la fenêtre
     * @param affineTransform est la transformation à appliquer
     */
    @Override
    public void dessiner(Graphics2D g2, AffineTransform affineTransform) {
        for( int y = 0; y < NIVEAU_1_MAP.length; ++ y ) {
            AffineTransform pCurseur = (AffineTransform) affineTransform.clone();
            pCurseur.translate( - Constantes.TAILLE_TUILE, y * Constantes.TAILLE_TUILE );
            for( int x = 0; x < NIVEAU_1_MAP[y].length; ++ x ) {
                pCurseur.translate( Constantes.TAILLE_TUILE, 0 );
                int noTuile = NIVEAU_1_MAP[y][x];
                if( 0 != noTuile ) {
                    g2.drawImage( NIVEAU_1_TUILES[ noTuile ], pCurseur, null );
                }
            }
        }
    }

    /**
     * Donne le montant d'argent de départ.
     * @return le montant d'argent de départ
     */
    @Override
    public int argentDepart() {
        return ARGENT_DEPART;
    }

    /**
     * Donne la position des tours.
     * @return la position des tours
     */
    @Override
    public PositionTuile [] positionTours() {
        return POSITION_TOURS;
    }

    /**
     * Donne la liste de générateur associée au niveau.
     * @return la liste de générateur associée au niveau
     */
    @Override
    public List< Generateur > generateurs() {
        return GENERATEURS;
    }
}
