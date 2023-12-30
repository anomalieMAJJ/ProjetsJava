/**
 * Cette classe génère des ennemis.
 */
public class Generateur {
    private int heure;
    private int nbTicInitiale;
    private int nbTicSpawn;
    private int nbEnnemi;
    private Ennemi ennemi;
    private Jeu parent;
    private boolean phaseInitiale = true;

    /**
     * Constructeur de générateur.
     * @param nbTicInitiale le tic de départ de génération
     * @param nbTicSpawn le délai entre les apparitions
     * @param ennemi l'ennemi à générer
     * @param nbEnnemi le nombre d'ennemis à générer
     */
    public Generateur(int nbTicInitiale, int nbTicSpawn, Ennemi ennemi, int nbEnnemi ) {
        this.heure = 0;
        this.nbTicInitiale = nbTicInitiale;
        this.nbTicSpawn = nbTicSpawn;
        this.ennemi = ennemi;
        this.nbEnnemi = nbEnnemi;
    }

    /**
     * Associe le générateur au jeu.
     * @param parent le jeu dans lequel se trouve le générateur
     */
    public void setParent(Jeu parent) {
        this.parent = parent;
    }

    /**
     * Indique s'il reste des ennemis à générer
     * @return True si oui, sinon False.
     */
    public boolean estVivant() {
        return 0 < nbEnnemi;
    }

    /**
     * Avance le temps et génère un ennemi si le délai est respecté.
     */
    public void avance() {
        if( ! phaseInitiale ) {
            if( heure == nbTicSpawn && 0 < nbEnnemi ) {
                heure -= nbTicSpawn;
                parent.ennemis.add( new Ennemi( ennemi ) );
                -- nbEnnemi;
            }
        } else {
            if( heure == nbTicInitiale ) {
                heure -= nbTicInitiale;
                phaseInitiale = false;
                parent.ennemis.add( new Ennemi( ennemi ) );
                -- nbEnnemi;
            }
        }
        ++ heure;
    }
}
