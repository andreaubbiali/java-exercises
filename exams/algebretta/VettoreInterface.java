
public interface VettoreInterface{
    
    // return the dimension od the vector
    int dim();

    // return the val of i's element 
    int val(final int i);

    // vectorial prod
    VettoreDenso per(final int alpha);

    // vectorial sum
    VettoreDenso più(final Vector v);
}