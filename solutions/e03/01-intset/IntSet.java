import java.util.Set;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;

public class IntSet implements IntSetInterface{

    private Set<Integer> set;

    public IntSet(){
        this.set = new HashSet<>();
    }

    // add an element into the set
    public void addElement(int el){
        this.set.add(el);
    }

    // return a random int from the set
    // EmptyException if empty set
    public int choose() throws EmptyException{
        int size = size();
        
        if (size == 0 ){
            throw new EmptyException();
        }
        
        Random r = new Random();
        
        int index = r.nextInt(size -1);
        Object[] arr = set.toArray();

        return (int)arr[index];
    }

    // return the legth of the set
    public int size(){
        return this.set.size();
    }

    // return true if x is in the set false otherwise
    public boolean contains(int x){
        return this.set.contains(x);
    }

    @Override
    public String toString(){
        Iterator<Integer> it = set.iterator();
        String str = "";

        while (it.hasNext()){
            str += "-" + (int)it.next();
        }

        return str;
    }
}