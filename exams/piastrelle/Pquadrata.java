
/**
* Implementazione della piastrella quadrata immutabile.
*/

public class Pquadrata extends Piastrella{

    private int lato;
    
    /**
    * RI: lato deve essere una grandezza > 0.
    */

    /**
    * Costruttore.
    * @param lato lato della piastrella.
    * @param costo costo di una piastrella.
    * @throws IllegalArgumentException se il lato è <= 0.
    */
    public Pquadrata(int lato, int costo){
        super(costo);

        if (lato <= 0){
            throw new IllegalArgumentException("Il lato deve essere >= 0");
        }

        this.lato = lato;
    }

    /**
    * Calcolo della superficie della piastrella quadrata
    * @return la superficie calcolata.
    */
    public int calcSuperficie(){
        return lato*lato;
    }
}