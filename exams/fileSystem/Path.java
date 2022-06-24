import java.util.Objects;

/**
 * Classe che rappresenta un path
 */
public class Path {
    
    // il nome della entry
    public final String nomeEntry;
    // il path
    public final String path;
    // indicazione se il path è assoluto
    public final boolean isAssoluto;

    /**
     * - nomeEntry non può essere null o stringa vuota.
     * - pathAssoluto non può essere null o stringa vuota.
     * - isAssoluto non può essere null. 
     */

    /**
     * Costruttore di un path.
     * @param path il path.
     * @throws IllegalArgumentException se il path è stringa vuota.
     * @throws NullPointerException se il path è null.
     */
    public Path(final String path){
        if (Objects.requireNonNull(path, "Il path non può essere nullo").isEmpty()){
            throw new IllegalArgumentException("Il path non può essere vuoto");
        }
        String[] splitted = path.split(":");

        this.nomeEntry = splitted[splitted.length-1];
        if ( path.startsWith(":")){
            this.isAssoluto = true;
            this.path = path;
        } else {
            this.isAssoluto = false;
            this.path = path;
        }
        
    }

    @Override
    public String toString(){
        return this.path;
    }
}


// TODO trasforma in record