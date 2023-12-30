import javax.swing.*;
/**
 *  * @authors Jessica Majeur et Jessica Portillo
 *  * Codes permanents : MAJJ 2651 9105 et PORJ 1656 8802
 *  * Courriel : ge991970@ens.uqam.ca et portillo.jessica@courrier.uqam.ca
 *  * Cours : INF2120-20
 *  * @version 2023-08-04
 *
 * Cette classe permet de jouer à une jeu de type ‘tower defence’.
 */
public class Principal {
    public static void main( String [] argv ) {

        SwingUtilities.invokeLater( PleineEcran::new );
    }
}
