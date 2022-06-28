import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Playlist {
    
    // !ATTENZIONE porli tutti a private perchè è mutabile
    // lista ordinata di brani mutabile
    public final List<Album.Brano> brani;
    // nome della playlist mutabile
    public String nome;
    // durata complessiva della playlist mutabile
    public Durata durataComplessiva;

    /**
     * Elenco ordinato (secondo l'ordine di immissione) di brani caratterizzata da un nome ed una durata complessiva.
     * Il nome della playlist non può essere vuoto
     * La durata complessiva pari a zero indica una playlist vuota
     */

    /**
     * Costruttore di una playlist
     * @param nome della playlist
     * @throws NullPointerException se il nome è nullo
     * @throws IllegalArgumentException se il nome è vuoto
     */
    public Playlist(final String nome){
        Objects.requireNonNull(nome);
        if (nome == ""){
            throw new IllegalArgumentException();
        }
        this.nome = nome;
        this.durataComplessiva = new Durata(0);
        this.brani = new ArrayList<Album.Brano>();
    }

    /**
     * fonde due playlist in un unica. Il nome della nuova playlist è dato dal parametro nome, 
     * i brani sono composti in ordine da quelli di p1 + quelli di p2 omettendo le ripetizioni
     * @param nome della playlist fusa
     * @param p1 playlist 1 da fondere
     * @param p2 playlist da fondere
     * @return la nuova playlist composta dalla fusione delle due playlist
     * @throws NullPointerException se nome, p1 o p2 sono nulli
     */
    public Playlist fondi(final String nome, final Playlist p1, final Playlist p2){
        Objects.requireNonNull(nome);
        Objects.requireNonNull(p1);
        Objects.requireNonNull(p2);
        
        Playlist res = new Playlist(nome);

        for (Album.Brano b : p1.brani) {
            res.aggiungiBrano(b);
        }

        for (Album.Brano b : p2.brani) {
            if (!res.existBrano(b)){
                res.aggiungiBrano(b);
            }
        }

        return res;
    }

    /**
     * aggiungi un brano alla playlist
     * @param brano il brano da aggiungere
     * @throws NullPointerException se brano è null
     * @throws IllegalArgumentException se il brano esiste già nella playlist
     */
    public void aggiungiBrano(Album.Brano brano){
        Objects.requireNonNull(brano);

        if (existBrano(brano)){
            throw new IllegalArgumentException();
        }

        this.brani.add(brano);
        this.durataComplessiva = this.durataComplessiva.addDurata(brano.durata);
    }

    /**
     * rimuovi un brano alla playlist
     * @param brano il brano da rimuovere
     * @throws NullPointerException se brano è null
     */
    public void rimuoviBrano(Album.Brano brano){
        Objects.requireNonNull(brano);
        try{
            int pos = posizioneBrano(brano);
            this.brani.remove(pos);
            this.durataComplessiva = this.durataComplessiva.removeDurata(brano.durata);
        }catch(NoSuchElementException e){
            System.out.println("brano non esistente nella playlist");
        }
    }

    /**
     * controlla se il brano è presente nella playlist
     * @param brano il brano da ricercare
     * @return true se il brano esiste, false altrimenti
     * @throws NullPointerException se brano è null
     */
    public boolean existBrano(Album.Brano brano){
        Objects.requireNonNull(brano);

        Iterator<Album.Brano> i = this.iterator();
        while(i.hasNext()){
            if (i.next() == brano){
                return true;
            }
        }
        return false;
    }

    /**
     * ritorna la posizione del brano nella playlist
     * @param brano il brano da ricercare
     * @return la posizione se il brano esiste
     * @throws NullPointerException se brano è null
     * @throws NoSuchElementException se il brano non esiste nella playlist
     */
    public int posizioneBrano(Album.Brano brano){
        Objects.requireNonNull(brano);
        int index = 0;
        Iterator<Album.Brano> i = this.iterator();
        while(i.hasNext()){
            if (i.next() == brano){
                return index;
            }
            index++;
        }
        throw new NoSuchElementException();
    }

    public Iterator<Album.Brano> iterator(){
        return new Iterator<Album.Brano>() {
            int index = 0;

            @Override
            public boolean hasNext(){
                return index < brani.size();
            }
  
            @Override
            public Album.Brano next(){
                Album.Brano b = brani.get(index);
                index++;
                return b;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // Per rendere più complete le funzionalità della playlist è possibile renderla in grado di enumerare:

    // tutti i suoi brani (con l’indicazione dell’album da cui provengono),

    // i suoi brani che appartengono a un dato album,

    // gli album dei suoi brani (senza ripetizione).



}
