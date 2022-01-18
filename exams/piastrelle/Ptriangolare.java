
/**
* Implementazione della piastrella traingolare immutabile.
*/

public class Ptriangolare extends Piastrella{

    private int base;
    private int altezza;
    
    /**
    * RI: base e altezza devono essere quantità numeriche > 0.
    */

    /**
    * Costruttore.
    * @param b base del triangolo.
    * @param a altezza del triangolo.
    * @param costo costo di una piastrella.
    * @throws IllegalArgumentException se una base o altezza è <= 0.
    */
    public Ptriangolare(int b, int a, int costo){
        super(costo);

        if (b <= 0 || a <= 0){
            throw new IllegalArgumentException("Base e altezza devono essere >= 0");
        }

        this.base = b;
        this.altezza = a;
    }

    /**
    * Calcolo della superficie della piastrella.
    * @return la superficie calcolata.
    */
    public int calcSuperficie(){
        return (base*altezza)/2;
    }
}