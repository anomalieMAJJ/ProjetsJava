import javax.swing.*;
import java.awt.*;

/**
 * Cette classe affiche le jeu à l'écran.
 */
public class PleineEcran extends JFrame {
    /**
     * Affiche le jeu en pleine écran si cela est supporté sinon ferme le jeu.
     * @throws HeadlessException
     */
    public PleineEcran() throws HeadlessException {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        GraphicsDevice gDevice = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if( gDevice.isFullScreenSupported() ) {
            gDevice.setFullScreenWindow( this );
        } else {
            System.err.println( "Mode plein écran non supporte." );
            System.exit( -1 );
        }
        // setUndecorated( true );
        add( new Jeu( getSize() ) );
    }
}
