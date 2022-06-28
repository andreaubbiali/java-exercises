import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Album {
    
    // !ATTENZIONE farlo private perchè se no si può modificare
    // elenco ordinato non vuoto e senza ripetizioni
    private final Brano[] brani;
    // titolo dell'album immutabile e non vuoto
    public final String titolo;
    // durata complessiva dell'album
    public final Durata durataComplessiva;

    /**
     * Album è una rappresentazione immutabile di un album caratterizzato da un elenco di brani, un titolo ed una durata complessiva.
     * L'elenco di brani non può essere vuoto ed è ordinato (secondo l'ordine di immissione). Il titolo non può essere vuoto. 
     * La durata non può essere uguale a 0 ed è calcolata dalla somma di tutte le durate dei singoli brani che compongono this.
     */

    public class Brano{
        // titolo del brano immutabile e non vuoto
        public final String titolo;
        // durata del brano, deve essere sempre positiva
        public final Durata durata;

        /**
         * Brano è la rappresentazione immutabile di un brano tramite un titolo ed una durata che lo caratterizzano.
         * Il titolo non può essere vuoto e la durata deve essere sempre positiva
         */

        /**
        * Costruttore di un brano
        * @param titolo il titolo del brano
        * @param durata la durata del brano
        * @throws NullPointerException se titolo è nullo
        * @throws IllegalArgumentException se la durata <= 0 oppure se il titolo è vuoto
        */
        private Brano(final String titolo, final int durata){
            Objects.requireNonNull(titolo);
            if (titolo == ""){
                throw new IllegalArgumentException();
            }
            if (durata <= 0){
                throw new IllegalArgumentException();
            }
            this.titolo = titolo;
            this.durata = new Durata(durata);
        }

    }

    /**
     * Costruttore che si occupa di creare un album partendo da un titolo e due liste indicanti titoli e durate.
     * @param titoloAlbum titolo dell'album
     * @param titoli lista dei titoli
     * @param durate lista delle durate
     * @throws NullPointerException se il titolo dell'album, la lista di titoli o la lista di durate sono nulli
     * @throws IllegalArgumentException se le liste delle durate e dei titoli sono di lunghezza diversa
     */
    public Album(final String titoloAlbum, final List<String> titoli, final List<Integer> durate){
        Objects.requireNonNull(titoloAlbum);
        Objects.requireNonNull(titoli);
        Objects.requireNonNull(durate);
        if (titoli.size() != durate.size()){
            throw new IllegalArgumentException("array di titoli e di durate con lunghezze diverse");
        }

        // eliminazione ripetizioni
        for (int i = 0; i < titoli.size(); i++) {
            
            int l = titoli.size();
            int k = 0;
            while(k<l){
                if (titoli.get(i).equals(titoli.get(k))){
                    titoli.remove(k);
                    l -= 1;
                }
                k++;
            }
        }

        brani = new Brano[titoli.size()];
        this.titolo = titoloAlbum;
        
        int durCompl = 0;

        for (int i = 0; i < titoli.size(); i++){
            brani[i] = new Brano(titoli.get(i), durate.get(i));
            durCompl += durate.get(i);
        }

        this.durataComplessiva = new Durata(durCompl);
    }

    /**
     * ritorna un brano dato il suo titolo
     * @param titolo il titolo del brano da ricercare
     * @return il brano con il titolo ricercato
     * @throws NoSuchElementException se il titolo non viene trovato
     */
    public Brano getBranoByTitolo(final String titolo) throws NoSuchElementException{
        Objects.requireNonNull(titolo);

        Iterator<Brano> i = this.iterator();
        while(i.hasNext()){
            Brano b = i.next();
            if (b.titolo.equals(titolo)){
                return b;
            }
        }
        
        throw new NoSuchElementException();
    }

    /**
     * Ritorna un brano data la sua posizione
     * @param pos la posizione del brano
     * @return il brano alla posizione richiesta
     * @throws IndexOutOfBoundsException
     * @throws IllegalArgumentException se la posizione richiesta è negativa
     */
    public Brano getBranoByPosition(final int pos) throws IndexOutOfBoundsException{
        if (pos < 0){
            throw new IllegalArgumentException();
        }
        return this.brani[pos];
    }

    /**
     * Ritorna la posizione del brano
     * @param brano il brano da ricercare
     * @return la posizione del brano se esiste, -1 altrimenti
     * @throws NullPointerException se il parametro è null
     */
    public int getPosizioneByBrano(final Brano brano){
        Objects.requireNonNull(brano);
        int ind = 0;

        Iterator<Brano> i = this.iterator();
        while(i.hasNext()){
            Brano b = i.next();
            if (b.equals(brano)){
                return ind;
            }
            ind++;
        }

        return -1;
    }

    public Iterator<Album.Brano> iterator(){
        return new Iterator<Album.Brano>() {
            private int index = 0;

            @Override
            public boolean hasNext(){
                return index < brani.length;
            }
            
            @Override
            public Album.Brano next(){
                Brano data = brani[index];
                index++;
                return data;
            }
            
            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

}
