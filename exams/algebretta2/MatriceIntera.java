import java.util.Objects;

public class MatriceIntera implements MatriceInterface<Integer>{

    // matrice è rappresentata da righe e colonne. La posizione del primo array indica la riga, il secondo array indica la riga.
    public final int[][] matrice;

    /**
     * RI: MatriceIntera rappresenta una matrice di int. 
     *      matrice non può essere nullo.
     */

    /**
     * Costruttore
     * @param matrice gli array che rappresentano le righe e colonne della matrice
     * @throws IllegalMatriceException
     */
    public MatriceIntera(int[][] matrice) throws IllegalMatriceException{
        Objects.requireNonNull(matrice);
        if (!isMatrice(matrice)){
            throw new IllegalMatriceException("la struttura non rappresenta una matrice");
        }
        this.matrice = matrice;
    }

    /**
     * Ritorna la dimensione delle righe della matrice
     * @return la dimensione della matrice
     */
    public int numeroRighe(){
        return this.matrice.length;
    }

    /**
     * Ritorna la dimensione delle colonne della matrice
     * @return la dimensione della matrice
     */
    public int numeroColonne(){
        return this.matrice[0].length;
    }

    //!use of lambda functions
    /**
     * loop attraverso this matrix e do the function specificata da f
     * @param scalare lo scalare da utilizzare nella funzione
     * @param f la funzione da applicare
     * @return la matrice risultata dal applicare f a tutte le posizioni della matrice
     */
    public MatriceIntera loopAndDo(int scalare, matrixFunction f){
        MatriceIntera res = new MatriceNulla(this.numeroColonne(), this.numeroRighe());

        for (int i = 0; i < this.numeroRighe(); i++){
            for (int j = 0; j < this.numeroColonne(); j++){
                res.matrice[i][j] = f.function(this.matrice[i][j], scalare);
            }
        }

        return res;
    }

    /**
     * loop attraverso this matrix e do the function specificata da f
     * @param m la matrice da utilizzare nella funzione f
     * @param f la funzione da applicare
     * @return la matrice risultata dal applicare f a tutte le posizioni della matrice
     */
    public MatriceIntera loopAndDo(final MatriceInterface<Integer> m, matrixFunction f){
        MatriceIntera res = new MatriceNulla(this.numeroColonne(), this.numeroRighe());

        for (int i = 0; i < this.numeroRighe(); i++){
            for (int j = 0; j < this.numeroColonne(); j++){
                res.matrice[i][j] = f.function(this.matrice[i][j], m.getPositionValue(i,j));
            }
        }

        return res;
    }

    /**
     * Ritorna il valore alla posizione richiesta
     * @param col indice della colonna
     * @param riga indice della riga
     * @return il valore della posizione richiesta
     * @throws IndexOutOfBoundException se col > numeroColonne e riga > numeroRiga
     */
    public Integer getPositionValue(int col, int riga){

        return this.matrice[riga][col];
    }

    /**
     * prodotto this per uno scalare
     * @param scalare scalare da moltiplicare
     * @return this*scalare
     */
    public MatriceIntera prodottoPerScalare(final Integer scalare){

        return loopAndDo(scalare, (v1, v2) -> (v1*v2));
    }

    /**
     * somma this con un'altra matrice
     * @param m matrice da sommare a this
     * @return this+m
     * @throws IllegalMatriceException se m non è della stessa dimensione di this
     */
    public MatriceIntera sommaMatriciale(final MatriceInterface<Integer> m) throws IllegalMatriceException{
        if (!stessaDimensione(m)) throw new IllegalMatriceException("le matrici non hanno la stessa dimensione");

        return loopAndDo(m, (v1, v2) -> (v1+v2));
    }

    /**
     * prodotto this con un'altra matrice
     * @param m matrice da moltiplicare a this
     * @return this*m
     * @throws IllegalMatriceException se m non è della stessa dimensione di this
     */
    public MatriceIntera prodottoMatriciale(final MatriceInterface<Integer> m) throws IllegalMatriceException{
        if (!stessaDimensione(m)) throw new IllegalMatriceException("le matrici non hanno la stessa dimensione");

        return loopAndDo(m, (v1, v2) -> (v1*v2));
    }

    /**
     * controllo se this ha la stessa dimensione di m
     * @param m matrice
     * @return true se hanno uguale dimensione, false altrimenti
     */
    private boolean stessaDimensione(final MatriceInterface<Integer> m) {
        return this.matrice[0].length == m.numeroColonne();
    }

    /**
     * controlla se la struttura array di array può rappresentare una matrice
     * @param matrice la struttura array di array
     * @return true se è una struttura valida per creare una matrice, false altrimenti
     */
    private boolean isMatrice(final int[][] matrice){
        Objects.requireNonNull(matrice);

        if (matrice.length == 0) {
            return false;
        }
        int len = matrice[0].length;
        for (int[] m : matrice) {
            if (m.length != len){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String res;

        res = "[";

        for (int i = 0; i < this.matrice.length; i++) {
            int[] riga = this.matrice[i];
            for (int r : riga) {
                res += r;
            }
            res += ";";
        }

        res += "]";
        return res;
    }

}