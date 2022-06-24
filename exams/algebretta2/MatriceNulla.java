public class MatriceNulla extends MatriceIntera{

    /**
     * RI: matrice nulla è una specificazione di matriceIntera la quale ha tutti i componenti pari a 0.
     */

    /**
     * Costruttore.
     * @param numCol numero di colonne
     * @param numRighe numero di righe
     */
    public MatriceNulla(final int numCol, final int numRighe){
        super(createMatriceNulla(numCol, numRighe));
    }

    /**
     * creazione di una struttura arrray di array con tutti i componenti a 0
     * @param numCol numero di colonne
     * @param numRighe numero di righe
     * @return la struttura array di array con tutte le posizioni a 0
     */
    private static int[][] createMatriceNulla(final int numCol, final int numRighe){
        int [][] matrice = new int[numRighe][numCol];
        return matrice;
    }
}