public class MatriceIdentita extends MatriceIntera{

    /**
     * RI: matrice identita è una specificazione di matriceIntera la quale ha tutti i componenti sulla diagonale principale a 1, gli altri a 0.
     */

    /**
     * Costruttore.
     * @param numCol numero di colonne
     * @param numRighe numero di righe
     */
    public MatriceIdentita(final int numCol, final int numRighe){
        super(createMatriceIdentita(numCol, numRighe));
    }

    /**
     * creazione di una struttura arrray di array con tutti i componenti della diagonale principale a 1, gli altri a 0
     * @param numCol numero di colonne
     * @param numRighe numero di righe
     * @return la struttura array di array con tutte le posizioni della diagonale principale a 1, le altre a 0
     */
    private static int[][] createMatriceIdentita(final int numCol, final int numRighe){
        int [][] matrice = new int[numRighe][numCol];

        for (int i = 0; i < numRighe; i++){
            for (int j = 0; j < numCol; j++){
                if (i == j){
                    matrice[i][j] = 1;
                }
            }
        }

        return matrice;
    }
}