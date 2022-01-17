import java.util.*;

public class CompratoreRandom extends CompratoreAbs{
    
    public CompratoreRandom(Set<Bancarella> bancarelle){
        super(bancarelle);
    }

    @Override
    public Acquisto compra(int num, final Giocattolo giocattolo){
        // TODO
        Acquisto acquisto = new Acquisto(giocattolo, num);
        
        return acquisto;
    }
}