
public interface MatriceInterface<T>{

    interface matrixFunction{
        int function(final int val1, final int val2);
    }

    MatriceInterface<T> loopAndDo(int scalare, matrixFunction function);

    MatriceInterface<T> loopAndDo(final MatriceInterface<T> m, matrixFunction function);

    T getPositionValue(int col, int riga);

    int numeroRighe();

    int numeroColonne();

    MatriceInterface<T> prodottoPerScalare(final T scalare);

    MatriceInterface<T> sommaMatriciale(final MatriceInterface<T> m) throws IllegalMatriceException;

    MatriceInterface<T> prodottoMatriciale(final MatriceInterface<T> m) throws IllegalMatriceException;
}