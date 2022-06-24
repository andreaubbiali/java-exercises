import java.util.Objects;

public class MatriceDiagonale extends MatriceIntera{

    /**
     * RI: matrice diagonale è una specificazione di matriceIntera la quale ha tutti i componenti a 0 tranne quelli sulla diagonale.
     */

    /**
     * Costruttore.
     * @param diagonale array che rappresenta gli elementi della diagonale
     */
    public MatriceDiagonale(final int[] diagonale){
        super(createMatriceDiagonale(diagonale));
    }

    /**
     * creazione di una struttura arrray di array con tutti i componenti della diagonale principale pari all'array diagonale, gli altri a 0
     * @param diagonale array che rappresenta gli elementi della diagonale
     * @return la struttura array di array con tutte le posizioni della diagonale principale pari all'array diagonale, gli altri a 0
     */
    private static int[][] createMatriceDiagonale(final int[] diagonale){
        Objects.requireNonNull(diagonale);
        int len = diagonale.length;
        int [][] matrice = new int[len][len];

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if (i == j){
                    matrice[i][j] = diagonale[i];
                }
            }
        }

        return matrice;
    }

}