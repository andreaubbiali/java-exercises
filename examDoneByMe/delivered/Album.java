import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Un album è immutabile e la sua rappresentazione è costituita da una lista ordinata di Brani. 
 * La durataComplessiva rappresenta in secondi la durata complessiva di tutto l'album.
 * Il titolo rappresenta il titolo dell'album. 
 */
public class Album{

    /**
     * Un brano è immutabile ed è rappresentato da una durata in secondi e da un titolo che lo identifica.
     */
    public class Brano {

        private final String titolo;
        private final Durata durata;

        /**
         * Il titolo non può essere null.
         * La durata deve essere positiva e maggiore di zero.
         */

        /**
         * Costruttore di un brano.
         * 
         * @param durata la durata del brano.
         * @param titolo il titolo del brano.
         * @throws IllegalArgumentException se la durata è minore o uguale a zero.
         */
        public Brano(int durata, String titolo) {
            Objects.requireNonNull(titolo);
            if (durata <= 0) {
                throw new IllegalArgumentException("la durata di un brano deve essere positiva e maggiore di zero");
            }

            this.titolo = titolo;
            this.durata = new Durata(durata);
        }

        /**
         * Ritorna l'album al quale è associato.
         * @return l'album al quale è associato.
         */
        public Album getAlbum() {
            return Album.this;
        }

        /**
         * Ritorna il titolo del brano.
         * @return il titolo del brano.
         */
        public String getTitolo() {
            return this.titolo;
        }

        /**
         * Ritorna la durata del brano.
         * @return la durata del brano.
         */
        public int getDurata() {
            return this.durata.durata;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Brano))
                return false;

            final Brano tmp = (Brano) o;
            return tmp.durata == durata && tmp.titolo.equals(titolo);
        }
    }
    
    private final List<Brano> brani;
    private Durata durataComplessiva;
    private String titolo;

    /**
     * I brani sono una lista ordinata (secondo l'ordine di costruzione), non vuota
     * e senza ripetizioni(condizione verificata dal costruttore tramite l'utilizzo di una mappa). 
     * Il titolo non può essere null. La durata deve essere positiva e maggiore di zero.
     */
    
    /**
     * Costruttore di un album.
     * 
     * @param titolo il titolo dell'album.
     * @param titolo2durata una mappa che rappresenta il titolo e la sua durata.
     */
    public Album(String titolo, Map<String, Integer> titolo2durata) {
        Objects.requireNonNull(titolo2durata);

        this.brani = new ArrayList<>();
        this.durataComplessiva = new Durata(0);

        for (Map.Entry<String, Integer> v : titolo2durata.entrySet()) {
            this.brani.add(new Brano(v.getValue(), v.getKey()));
            this.durataComplessiva.add(v.getValue());
        }
        
        this.titolo = titolo;
    }

    /**
     * Ritorna un brano in base al suo titolo.
     * 
     * @param titolo il titolo del brano.
     * @throws AlbumException se il titolo non è presente nell'album.
     * @return il brano con il titolo richiesto.
     */
    public Brano getBranoByTitolo(String titolo) {
        Objects.requireNonNull(titolo);

        Iterator<Brano> it = this.brani.iterator();

        while (it.hasNext()) {
            Brano tmp = (Brano) it.next();
            if (tmp.titolo == titolo) {
                return tmp;
            }
        }
        
        throw new AlbumException("Il titolo non esiste nell'album");
    }

    /**
     * Ritorna un brano in base alla posizione nell'album.
     * 
     * @param position la posizione nell'album.
     * @throws IllegalArgumentException se position è un numero negativo o superiore la grandezza della lista.
     * @return il brano nella posizione position.
     */
    public Brano getBranoByPositionInAlbum(int position) {
        if (position < 0 || position >= this.brani.size()){
            throw new IllegalArgumentException("La posizione non può essere negativa e non può eccedere la grandezza della lista");
        }
        return this.brani.get(position);
    }

    /**
     * Ritorna la posizione del brano nell'album.
     * 
     * @param brano il brano da ricercare.
     * @throws AlbumException se il brano non esiste nell'album.
     * @return la posizione del brano nell'album.
     */
    public int getPosizioneByBrano(Brano brano) {
        Objects.requireNonNull(brano);

        for (int i = 0; i < this.brani.size(); i++) {
            Brano tmp = this.brani.get(i);
            
            if (tmp.equals(brano)) {
                return i;
            }
        }

        throw new AlbumException("Il brano non è presente nell'album");
    }
    
    /**
     * @return il titolo dell'album
     */
    public String getTitolo() {
        return this.titolo;
    }

    /**
     * @return la durata complessiva dell'album.
     */
    public int getDurata() {
        return this.durataComplessiva.durata;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Album))
            return false;

        final Album tmp = (Album) o;
        return tmp.durataComplessiva == durataComplessiva 
                && tmp.titolo.equals(titolo)
                && tmp.brani.equals(brani);
    }
}