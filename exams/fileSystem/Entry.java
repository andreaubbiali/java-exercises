import java.util.Objects;

/**
 * Classe astratta rappresentante una entry
 */
public abstract class Entry {
    
    // il path di una entry
    public final Path path;

    // il nome di una entry
    public final String nome;

    /**
     * - path non è null.
     * - nome è una stringa non null e non può essere vuoto.
     */

    /**
     * Costruttore di una entry.
     * @param path il path.
     * @param nome il nome.
     * @throws NullPointerException se il path è null.
     */
    public Entry(final Path path){
        Objects.requireNonNull(path, "Il path non può essere nullo");

        this.path = path;
        this.nome = path.nomeEntry;
    }

}
