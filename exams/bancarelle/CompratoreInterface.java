import java.util.*;

public interface CompratoreInterface{

    Acquisto compra(final int num, final Giocattolo giocattolo);

    Set<Bancarella> getBancarelleByDisponibilita(Giocattolo g);

}