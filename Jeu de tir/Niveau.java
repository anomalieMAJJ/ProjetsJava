import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;

/**
 * Cette interface décrit comment intéragir avec un niveau.
 */
public interface Niveau {
    /**
     * Dessine l'environnement du niveau.
     * @param g2 est la fenêtre
     * @param affineTransform la transformation à appliquer
     */
    void dessiner(Graphics2D g2, AffineTransform affineTransform );
    int argentDepart();
    PositionTuile [] positionTours();
    List< Generateur > generateurs();
    PositionTuile positionPV();
}
