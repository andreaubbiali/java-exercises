import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe che rappresenta il filesystem il quale è un'estensione di directory.
 */
public class FileSystem extends Directory{

    // entry del filesystem.
    public final List<Entry> nodes = new ArrayList<>();

    /**
     * - nodes non possono essere null.
     */

    public FileSystem(){
        super(new Path(":"));
    }

    /**
     * Ritorna una entry dato il suo path assoluto.
     * @param path il path assoluto
     * @throws NullPointerException se il path è null.
     * @throws IllegalArgumentException se il path non è assoluto.
     * @return la entry con il dato path se esiste, altrimenti null.
     */
    public Entry getEntryByPath(final Path path){
        Objects.requireNonNull(path, "Il path non può essere null");
        if (!path.isAssoluto){
            throw new IllegalArgumentException("Il path non è assoluto.");
        }
        
        for (Entry e : nodes){
            if (path.equals(e.path)){
                return e;
            }
        }

        return null;
    }

    /**
     * Crea una directory tramite il path assoluto.
     * @param path il path assoluto.
     * @throws NullPointerException se il path è null.
     * @throws IllegalArgumentException se il path non è assoluto, se non esiste alcune entry con tale path oppure se la entry è un file.
     */
    public void creaDirectoryByPath(final Path path){
        Objects.requireNonNull(path, "Il path non può essere null");
        if (!path.isAssoluto){
            throw new IllegalArgumentException("Il path non è assoluto.");
        }

        Entry e = getEntryByPath(path);
        if (e == null){
            throw new IllegalArgumentException("Non esiste alcuna entry a tale path");
        }
        if (e instanceof File){
            throw new IllegalArgumentException("Non è possibile creare una entry in un file");
        }

        Directory dir  = (Directory)e;
        nodes.add(dir.aggiungiDirectory(path));        
    }

    /**
     * Crea un file dato il path assoluto e la dimensione.
     * @param dimensione la dimensione.
     * @param path il path assoluto.
     * @throws NullPointerException se il path è null.
     * @throws IllegalArgumentException se il path non è assoluto.
     * 
     */
    public void creaFile(final int dimensione, final Path path){
        Objects.requireNonNull(path, "Il path non può essere null");
        if (!path.isAssoluto){
            throw new IllegalArgumentException("Il path non è assoluto.");
        }

        Entry e = getEntryByPath(path);
        if (e == null){
            throw new IllegalArgumentException("Non esiste alcuna entry a tale path");
        }
        if (e instanceof File){
            throw new IllegalArgumentException("Non è possibile creare una entry in un file");
        }

        Directory dir = (Directory) e;
        nodes.add(dir.aggiungiFile(dimensione, path));
    }

    /**
     * Elenca contenuto della directory dato il suo path assoluto.
     * iteratore
     */
    public Iterator<Entry> elencaContenuto(final Path path){
        
    }
    // TODO

    // ottenere la dimensione di una entry dato il suo path assoluto.
    /**
     * Ritorna la dimensione della entry dato il path assoluto.
     * @param path il path
     * @throws NullPointerException se il path è null.
     * @throws IllegalArgumentException se il path non è assoluto.
     * @return la dimensione della entry
     */
    public int dimensione(final Path path){
        Objects.requireNonNull(path, "Il path non può essere null");
        if (!path.isAssoluto){
            throw new IllegalArgumentException("Il path non è assoluto.");
        }

        for (Entry e : nodes){
            if (path.equals(e.path)){
                if (e instanceof File){
                    File f = (File)e;
                    return f.dimensione;
                }
                Directory d = (Directory)e;
                return d.getDimensione();
            }
        }

        return 0;
    }


 
}
