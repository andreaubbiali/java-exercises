
public interface InventarioInterface{

    int getGiocattolo(Giocattolo g);

    void aggiungi(int numero, Giocattolo g);

    void rimuoviGiocattoli(Giocattolo g, int numero);
}