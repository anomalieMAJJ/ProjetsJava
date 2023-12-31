import javax.swing.*;
/**
 * Cette classe permet de jouer à une jeu de type ‘tower defence’.
 */
public class Principal {
    public static void main( String [] argv ) {

        SwingUtilities.invokeLater( PleineEcran::new );
    }
}
