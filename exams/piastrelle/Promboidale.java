
/**
* Implementazione della piastrella romboidale immutabile.
*/

public class Promboidale extends Piastrella{

    private int d1;
    private int d2;
    
    /**
    * RI: d1 e d2 devono essere quantità numeriche > 0.
    */

    /**
    * Costruttore.
    * @param d1 diagonale primaria.
    * @param d2 diagonale secondaria.
    * @param costo costo di una piastrella.
    * @throws IllegalArgumentException se una delle diagonali è <= 0.
    */
    public Promboidale(int d1, int d2, int costo){
        super(costo);

        if (d1 <= 0 || d2 <= 0){
            throw new IllegalArgumentException("Le diagonali devono essere >= 0");
        }

        this.d1 = d1;
        this.d2 = d2;
    }

    /**
    * Calcolo della superficie della piastrella.
    * @return la superficie calcolata.
    */
    public int calcSuperficie(){
        return (d1*d2)/2;
    }
}