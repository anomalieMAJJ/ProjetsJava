import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Cette classe
 */
public class Tuile extends BufferedImage {
    /**
     * Ce constructeur génère une tuile du jeu.
     * @param dimension est la taille de la tuile
     * @param couleur est la couleur de la tuile
     * @param pixels sont les pixels de la tuile
     */
    Tuile(Dimension dimension, Color couleur, int [] pixels ) {
        super( dimension.width, dimension.height, TYPE_INT_ARGB );
        for( int i = 0; i < pixels.length; ++ i ) {
            int k = pixels[ i ];
            for( int j = dimension.width - 1; 0 <= j; -- j ) {
                if ( 1 == ( k & 0x0001) ) {
                    setRGB(j, i, couleur.getRGB());
                }
                k = k >> 1;
            }
        }
    }

    /**
     * Ce constructeur génère une tuile du jeu.
     * @param couleur est la couleur de la tuile
     * @param pixels sont les pixels de la tuile
     */
    Tuile( Color couleur, BitMap pixels ) {
        super( pixels.largeur, pixels.hauteur, TYPE_INT_ARGB );
        for( int i = 0; i < pixels.datas.length; ++ i ) {
            int k = pixels.datas[ i ];
            for( int j = pixels.largeur - 1; 0 <= j; -- j ) {
                if ( 1 == ( k & 0x0001) ) {
                    setRGB(j, i, couleur.getRGB());
                }
                k = k >> 1;
            }
        }
    }

    /**
     * Ce constructeur génère une tuile du jeu.
     * @param bgCouleur est la couleur du fond
     * @param fgCouleur est la couleur d'avant-plan
     * @param pixels sont les pixels de la tuile
     */
    Tuile( Color bgCouleur, Color fgCouleur, BitMap pixels ) {
        super( pixels.largeur, pixels.hauteur, TYPE_INT_ARGB );
        for( int i = 0; i < pixels.datas.length; ++ i ) {
            int k = pixels.datas[ i ];
            for( int j = pixels.largeur - 1; 0 <= j; -- j ) {
                if ( 1 == ( k & 0x0001) ) {
                    setRGB(j, i, fgCouleur.getRGB());
                } else {
                    setRGB(j, i, bgCouleur.getRGB());
                }
                k = k >> 1;
            }
        }
    }
}
