public interface VettoreInterface<T>{

    /**
     * Restituisce dimensione del vettoe, il numero delle sue componenti
     * @return numero delle sue componenti
     */
    int dim();

    /**
     * Restituisce il valore della posizione nel vettore richiesta
     * @param i indice della posizione richiesta
     * @return valore nel vettore nella posizione richiesta
     */
    T val(final int i);

    /**
     * Prodotto tra vettore this e scalare alpha
     * @param alpha scalare da moltiplicare
     * @return il prodotto tra this e alpha
     */
    VettoreInterface<T> per(final T alpha);

    /**
     * Somma tra vettore this e alpha
     * @param alpha vettore da sommare
     * @return la somma tra this e alpha
     * @throws IllegalVectorException se this e alpha non hanno la stessa dimensione
     */
    VettoreInterface<T> più(final VettoreInterface<T> alpha);
}