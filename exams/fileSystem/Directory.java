import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta una directory.
 */
public class Directory extends Entry{

    /**
     * Classe interna che rappresenta un file immutabile.
     * Gli oggetti di questa classe sono istanziati esclusivamente dal metodo mkFile. 
     */
    public class File extends Entry {
        
        // dimensione di un file.
        public final int dimensione;

        /**
         * Un file è caratterizzato (attributi di entry e) da:
         * - una dimensione intera e positiva (valore controllato dal costruttore e immodificabile)
         */

        /**
         * Costruttore di un file dato un path ed una dimensione.
         * @param path il path.
         * @param dimensione la dimensione.
         * @throws NullPointerException se il path è null.
         * @throws IllegalArgumentException se la dimensione è una quantità negativa.
         */
        private File(final int dimensione, final Path path){
            super(path);
            
            if (dimensione < 0){
                throw new IllegalArgumentException("La dimensione non può essere negativa");
            }
            
            this.dimensione = dimensione;
        }

    }

    // dimensione della directory.
    private int dimensione = 0;
    // lista di entry contenute nella directory.
    private final List<Entry> entryLst;

    /**
     * - dimensione è una quantità intera maggiore o uguale a zero composta dalla somma delle
     * entry che la directory contiene.
     * - entry è una lista non null e contiene entry che non sono contenute in altre directory. 
     * Condizione mantenuta dal fatto che il costruttore sia protetto e solo la classe FileSystem(creando una sua nuova entry)
     * oppure una classe directory (che crei una sua nuova entry) possono chiamare il metodo aggiungiDirectory.
     */

    /**
      * Costruttore di una directory.
      * @param path il path.
      * @throws NullPointerException se il path sono null.
      */
    protected Directory(final Path path){
        super(path);

        this.entryLst = new ArrayList<>();
    }

    /**
     * Crea e aggiunge una nuova directory a this.
     * @param path il path.
     * @throws NullPointerException se il path sono null.
     * @return la directory creata.
     */
    public Directory aggiungiDirectory(final Path path){
        Directory d = new Directory(path);
        entryLst.add(d);
        return d;
    }

    /**
     * aggiungi un nuovo file alla directory
     * @param dimensione la dimensione.
     * @param path il path.
     * @throws NullPointerException se il path è null.
     * @throws IllegalArgumentException se la dimensione è una quantità negativa.
     * @return il file creato
     */
    public File aggiungiFile(final int dimensione, final Path path){
        File f = new File(dimensione, path);
        entryLst.add(f);
        return f;
    }

    public int getDimensione(){
        return this.dimensione;
    }
}