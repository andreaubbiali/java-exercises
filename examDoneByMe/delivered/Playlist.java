import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


/**
 * Una playlist è mutabile ed è rappresentata da un nome che la identifica. Essa è composta da una lista ordinata
 * (secondo l'ordine di inserimento nella lista) di brani. La sua durata è data dalla somma della durata di ogni brano che la compone.
 */

public class Playlist implements PlaylistInterface{
    
    private String nome;
    private Durata durataComplessiva;
    private List<Album.Brano> brani;

    /**
     * Il nome non può essere null.
     * La durata complessiva deve essere maggiore o uguale a zero.
     * La lista di brani non può essere null ma può essere vuota. 
     */

    /**
     * Costruttore di una playlist vuota.
     * @param nome il nome della playlist.
     */
    public Playlist(String nome) {
        Objects.requireNonNull(nome);

        this.brani = new ArrayList<>();
        this.nome = nome;
        this.durataComplessiva = new Durata(0);
        assert repOK() : "Qualcosa è andato storto";
    }

    /**
     * Costruttore di una nuova playlist con i brani di p1 e p2 non ripetuti.
     * 
     * @param nome il nome della nuova playlist.
     * @param p1 la playlist1
     * @param p2 la playlist2
     */
    public Playlist(String nome, Playlist p1, Playlist p2) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(p1);
        Objects.requireNonNull(p2);

        this.brani = new ArrayList<>();
        this.nome = nome;
        this.durataComplessiva = new Durata(0);

        for (int i = 0; i < p1.brani.size(); i++) {
            Album.Brano tmp = p1.brani.get(i);

            try {
                aggiungiBrano(tmp);
                this.durataComplessiva.add(tmp.getDurata());
            } catch (PlaylistException pe) {
                System.out.println("doppione" + tmp);
            }
        }
        
        for (int i = 0; i < p2.brani.size(); i++) {
            Album.Brano tmp = p2.brani.get(i);

            try {
                aggiungiBrano(tmp);
                this.durataComplessiva.add(tmp.getDurata());
            } catch (PlaylistException pe) {
                System.out.println("doppione" + tmp);
            }
        }

        assert repOK() : "Qualcosa è andato storto";
    }

    /**
     * Aggiunge il brano all'interno della playlist se non esiste già.
     * 
     * @param b il brano da aggiungere.
     * @throws PlaylistException se il brano esiste già nella playlist.
     */
    public void aggiungiBrano(Album.Brano b) {
        Objects.requireNonNull(b);

        // controllo che non esista già e aggiungo il brano alla lista
        if (isPresent(b)) {
            throw new PlaylistException("Il brano è già presente nella playlist.");
        }
        this.brani.add(b);

        // aggiorno la durata della playlist
        this.durataComplessiva.add(b.getDurata());

        assert repOK() : "Qualcosa è andato storto";
    }
    
    /**
     * Rimozione del brano dalla playlist.
     * 
     * @param b il brano da rimuovere.
     * @throws PlaylistException se il brano non esiste nella playlist.
     */
    public void rimuoviBrano(Album.Brano b) {
        Objects.requireNonNull(b);

        // controllo che il brano esista nella playlist e lo rimuovo
        int pos = getPosition(b);
        this.brani.remove(pos);

        // aggiorno la durata della playlist
        this.durataComplessiva.sub(b.getDurata());

        assert repOK() : "Qualcosa è andato storto";
    }

    /**
     * Ricerca dell'esistenza del brano all'interno della playlist.
     * 
     * @param b il brano da ricercare nella playlist.
     * @return true se il brano è presente nella playlist false altrimenti.
     */
    public boolean isPresent(Album.Brano b) {
        Objects.requireNonNull(b);

        try{
            getPosition(b);
            return true;
        } catch (PlaylistException e) {
            return false;
        }
    }

    /**
     * Ricerca la posizione del brano nella playlist.
     * 
     * @param p il brano da ricercare.
     * @return la posizione del brano.
     * @throws PlaylistException se il brano non esiste nella playlist.
     */
    public int getPosition(Album.Brano b) {
        Objects.requireNonNull(b);

        for (int i = 0; i < this.brani.size(); i++) {
            Album.Brano tmp = this.brani.get(i);

            if (tmp.equals(b)) {
                return i;
            }
        }

        throw new PlaylistException("Il brano non è presente nella playlist");
    }
    
    /**
     * ritorna tutti i brani presenti nella playlist di un album a.
     * 
     * @param a l'album.
     * @return una lista dei brani di un album presenti nella playlist. Lista vuota se non ci sono brani del dato album.
     */
    public List<Album.Brano> getBraniByAlbum(Album a) {
        Objects.requireNonNull(a);
        List<Album.Brano> res = new ArrayList<>();

        for (int i = 0; i < this.brani.size(); i++) {
            Album.Brano tmp = this.brani.get(i);

            if (tmp.getAlbum().equals(a)) {
                res.add(tmp);
            }
        }

        return res;
    }

    /**
     * Ritorna tutti i diversi album presenti nella playlist.
     * 
     * @return gli album nella playlist. Lista vuota se non ci sono album.
     */
    public Set<Album> getAllAlbums() {
        Set<Album> res = new HashSet<>();

        for (int i = 0; i < this.brani.size(); i++) {
            Album.Brano tmp = this.brani.get(i);

            res.add(tmp.getAlbum());
        }

        return res;
    }

    public boolean repOK() {
        return durataComplessiva.durata >= 0 && this.brani != null && this.nome != null;
    }
    
    @Override
    public String toString() {
        String res = "Nome playlist: " + this.nome + "\n";

        for (int i = 0; i < this.brani.size(); i++) {
            Album.Brano tmp = this.brani.get(i);

            res += (i + 1) + " - \"" + tmp.getTitolo() + "\" " + tmp.getDurata() + ", (da \"" + tmp.getAlbum().getTitolo() +"\")\n";

        }

        res += "Durata totale " + this.durataComplessiva;
        return res;
    }
}
