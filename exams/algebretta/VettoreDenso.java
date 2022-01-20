

public class VettoreDenso implements VettoreInterface{

    private final int[] elements;

    /**
    * Constructor of dense vector.
    * @param size the size of the array to be created.
    * @throws IllegalArgumentException if size is <= 0
    */
    public VettoreDenso(int size) throws IllegalArgumentException{
        if (size <= 0){
            throw new IllegalArgumentException();
        }

        this.elements = int[size];
    }

    /**
    * Constructor of the class.
    * @param elements the array.
    * @throws IllegalArgumentException if elements is null
    */
    public VettoreDenso(int[] elements) throws IllegalArgumentException{
        if (elements == null){
            throw new IllegalArgumentException();
        }

        int size = elements.length;

        this.elements = int[size];
        for (int it = 0; i < size; i++){
            this.elements[i] = elements[i];
        }

    }

    /**
    * Return the dimension of the array.
    */
    public int dim(){
        return this.elements.lentgh;
    }

    /**
    * Return the value of i's element.
    */
    public int val(final int i){
        return this.elements[i];
    }

    /**
    * Vectorial multiplication alpha*this.
    * @param alpha a scalar.
    */
    public VettoreDenso per(final int alpha){
        int resDim = (dim > alpha.dim) ? dim : alpha.dim;
        VettoreDenso res = new VettoreDenso(resDim);

        //TODO continua da qui
    }

    /**
    * Vectorial sum.
    * @param v a vector to be summed.
    * @throws IllegalArgumentException if vectors dimensions are different.
    */
    public VettoreDenso più(final Vector v) throws IllegalArgumentException{
        if (dim != v.dim ){
            throw new IllegalArgumentException();
        }
        
        VettoreDenso res = new VettoreDenso(dim);
        
        for (int i = 0; i < dim; i++){
            
            res[i] = elements[i] + v.elements[i];

        }

        return res;
    }

    @Override
    public String toString(){

    }

}