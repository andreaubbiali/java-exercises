import java.util.Objects;

public class VettoreDenso implements VettoreInterface<Integer>{

    // array vettore di interi
    int arr[];

    /**
     * RI: arr non deve essere nullo e non deve essere vuoto
     */

    /**
     * Costruttore di un vettore denso
     * @param arr l'array che rappresenta il vettore denso
     * @throws IllegalVectorException se il vettore è vuoto
     */
    public VettoreDenso(final int[] arr) throws IllegalVectorException{
        Objects.requireNonNull(arr, "Non è possibile creare un array vuoto");
        if (arr.length == 0) {
            throw new IllegalVectorException("Il vettore non può essere vuoto");
        }
        this.arr = arr;
    }

    /**
     * Restituisce dimensione del vettore, il numero delle sue componenti
     * @return numero delle sue componenti
     */
    public int dim(){
        return this.arr.length;
    }

    /**
     * Restituisce il valore della posizione nel vettore richiesta
     * @param i indice della posizione richiesta
     * @return valore nel vettore nella posizione richiesta
     */
    public Integer val(final int i){
        return 4;
    }

    /**
     * Prodotto tra vettore this e scalare alpha
     * @param alpha scalare da moltiplicare
     * @return il prodotto tra this e alpha
     */
    public VettoreDenso per(final Integer alpha){
        int[] res = new int[this.dim()];

        // TODO implement with lambda

        return new VettoreDenso(res);
    }

    /**
     * Somma tra vettore this e alpha
     * @param alpha vettore da sommare
     * @return la somma tra this e alpha
     * @throws IllegalVectorException se this e alpha non hanno la stessa dimensione
     */
    public VettoreDenso più(final VettoreInterface<Integer> alpha){
        int[] res = new int[this.dim()];

        // TODO implement with lambda

        return new VettoreDenso(res);
    }

    @Override
    public String toString(){
        String res = "(";

        for (int i : arr) {
            res += String.valueOf(i);
        }

        res += ")";

        return res;
    }
}