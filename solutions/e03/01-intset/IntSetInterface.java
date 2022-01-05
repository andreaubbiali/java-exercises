public interface IntSetInterface {
    
    // return a random int from the set
    // EmptyException if empty set
    int choose() throws EmptyException;

    // return the legth of the set
    int size();

    // return true if x is in the set false otherwise
    boolean contains(int x);
}