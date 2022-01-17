import java.util.Objects;

public class Bancarella implements BancarellaInterface{

    public String proprietario;
    private Inventario inventario;
    private ListinoAbs listino;

    /**
    * Costruttore.
    * @param proprietario il proprietario della bancarella.
    * @param inventario l'inventario della bancarella.
    * @param listino il listino della bancarella.
    */
    public Bancarella(String proprietario, Inventario inventario, ListinoAbs listino){
        if (inventario == null || listino == null){
            throw new IllegalArgumentException("Inventario e listino non possono essere nulli");
        }

        this.proprietario = proprietario;
        
        this.inventario = inventario;
        this.listino = listino;
        assert repOK();
    }

    /**
    * Vendita di un certo numero di giocattoli.
    * @param g il giocattolo da vendere.
    * @param numero il numero di giocattoli.
    * @throws BancarellaException se il giocattolo non esiste nella bancarella o non ci sono abbastanza giocattoli.
    */
    public void vendita(Giocattolo g, int numero){
        if (Objects.isNull(g)){
            throw new IllegalArgumentException("g is null");
        }

        int num = inventario.getGiocattolo(g);
        if (num == 0 || num < numero){
            throw new BancarellaException("Il giocattolo non esiste o non ci sono abbastanza giocattoli nell'inventario.");
        }

        inventario.rimuoviGiocattoli(g, numero);        
    }

    /**
    * check esistenza del giocattolo nell'inventario
    * @param g il giocattolo
    * @return true se c'è il giocattolo richiesto false altrimenti
    * @throws IllegalArgumentException se g è nullo.
    */
    public boolean isDisponibile(Giocattolo g){
        if (Objects.isNull(g)){
            throw new IllegalArgumentException("g is null");
        }

        return (inventario.getGiocattolo(g) == 0) ? false : true;
    }

    /**
    * ritorna il numero di giocattoli nell'inventario
    * @param g il giocattolo
    * @return il numero di giocattoli
    * @throws IllegalArgumentException se g è nullo.
    */
    public int getDisponibilita(Giocattolo g){
        if (Objects.isNull(g)){
            throw new IllegalArgumentException("g is null");
        }

        return inventario.getGiocattolo(g);
    }

    /**
    * Ritorna il prezzo del giocattolo.
    * @throws IllegalArgumentException se g è nullo.
    * @throws numero numero dei giocattoli richiesti.
    */
    public float getPrezzo(Giocattolo g, int numero){
        if (Objects.isNull(g)){
            throw new IllegalArgumentException("g is null");
        }

        return listino.costo(g, numero);
    }

    public boolean repOK(){
        // TODO
        // check che inventario e listino corrispondano (stessi giocattoli)
        return true;
    }

}