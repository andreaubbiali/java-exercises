
public interface BancarellaInterface{

    void vendita(Giocattolo g, int numero);

    boolean isDisponibile(Giocattolo g);

    float getPrezzo(Giocattolo g, int numero);
}