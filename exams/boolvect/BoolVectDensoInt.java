public class BoolVectDensoInt extends BoolVect{

    final static private int len = 32;
    private boolean[] arr;

    /**
     * RI: classe mutabile che implementa la classe astratta boolVect.
     *      arr è rappresentato da un array
     */

    public BoolVectDensoInt(){
        super(len);
        this.arr = new boolean[len];
    }

    @Override
    public int dimensione(){
        int dim = 0;
        for(int i = 0; i < this.taglia; i++){
            if (arr[i] == true){
                dim = i;
            }
        }
        return dim+1;
    }
    
    @Override
    public void modificaValore(final int pos, final boolean valore) throws IndexOutOfBoundsException{
        if (pos > taglia){
            throw new IndexOutOfBoundsException();
        }
        arr[pos] = valore;
    }

    @Override
    public boolean getValore(final int pos)throws IndexOutOfBoundsException{
        if (pos > taglia){
            throw new IndexOutOfBoundsException();
        }
        return arr[pos];
    }

}
