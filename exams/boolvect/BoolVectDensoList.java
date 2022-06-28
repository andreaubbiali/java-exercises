import java.util.ArrayList;
import java.util.List;

public class BoolVectDensoList extends BoolVect{
    
    private final List<Boolean> lst = new ArrayList<Boolean>();

    public BoolVectDensoList(final int len){
        super(len, "VFFV");
    }

    @Override
    public int dimensione(){
        return lst.lastIndexOf(true)+1;
    }
    
    @Override
    public void modificaValore(final int pos, final boolean valore) throws IndexOutOfBoundsException{
        if (pos > taglia){
            throw new IndexOutOfBoundsException();
        }
        lst.set(pos, valore);
    }

    @Override
    public boolean getValore(final int pos)throws IndexOutOfBoundsException{
        if (pos > taglia){
            throw new IndexOutOfBoundsException();
        }
        return lst.get(pos);
    }

}
