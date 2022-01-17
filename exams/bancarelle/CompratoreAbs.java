
import java.util.*;

public abstract class CompratoreAbs implements CompratoreInterface{

    private Set<Bancarella> bancarelle;

    /**
    * Costruttore.
    * @throws IllegalArgumentException se bancarelle è nullo.
    */
    public CompratoreAbs(Set<Bancarella> bancarelle){
        if (Objects.isNull(bancarelle)){
            throw new IllegalArgumentException("bancarelle null.");
        }
        this.bancarelle = new HashSet<>();
        this.bancarelle = bancarelle;
    }

    /**
    * Ritorna le bancarelle che hanno il giocattolo richiesto.
    * @param g il giocattolo.
    */
    public Set<Bancarella> getBancarelleByDisponibilita(Giocattolo g){
        Set<Bancarella> bancDisponibili = new HashSet<>();

        Iterator<Bancarella> it = bancarelle.iterator();
        
        while(it.hasNext()){
            Bancarella b = it.next();

            if(b.isDisponibile(g)){
                bancDisponibili.add(b);
            }
        }

        return bancDisponibili;
    }
}