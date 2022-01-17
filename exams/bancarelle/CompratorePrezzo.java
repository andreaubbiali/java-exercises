import java.util.*;

public class CompratorePrezzo extends CompratoreAbs{

    public CompratorePrezzo(Set<Bancarella> bancarelle){
        super(bancarelle);
    }

    /**
    * 
    */
    @Override
    public Acquisto compra(int num, final Giocattolo giocattolo){
        
        Acquisto acquisto = new Acquisto(giocattolo, num);
        boolean fine = false;

        Set<Bancarella> bDisp = getBancarelleByDisponibilita(giocattolo);

        while(fine == false){
            Bancarella selected = getBancarellaMinPrezzo(giocattolo, bDisp);
            if (selected == null){
                throw new CompratoreException("errore nel selezionare bancarella");
            }

            int disp = selected.getDisponibilita(giocattolo);

            if (num-disp <= 0){
                fine = true;

                acquisto.setBancarella(selected, num);
                acquisto.addCosto(selected.getPrezzo(giocattolo, num));

                selected.vendita(giocattolo, num);
            } else {
                int v = num-disp;

                acquisto.setBancarella(selected, v);
                acquisto.addCosto(selected.getPrezzo(giocattolo, v));

                selected.vendita(giocattolo, v);
                
                // rimuovi la bancarella utilizzata
                bDisp.remove(selected);
                num = num-disp;
            }
                        
        }
        
        return acquisto;
    }

    /**
    * @param g il giocattolo.
    * @param bancDisp le bancarelle disponibili.
    */
    public Bancarella getBancarellaMinPrezzo(Giocattolo g, Set<Bancarella> bancDisp){
        Bancarella[] array = bancDisp.toArray(new Bancarella[0]);

        float minPrezzo = 0;
        Bancarella b = null;
        for (int i = 0; i < array.length; i++){
            if (array[i].getPrezzo(g, 0) < minPrezzo){
                minPrezzo = array[i].getPrezzo(g, 0);
                b = array[i];
            }
        }

        return b;
    }

}