import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
* Classe mutabile che rappresenta una pavimentazione.
*/

public class Pavimentazione {

    private Map<Piastrella, Integer> piastrella2numero;

    /**
    * RI: superficie deve essere un numero > 0. 
    *       costoTotale deve essere un numero > 0.
    *       piastrella non deve essere nullo.
    */

    /**
    * Costruttore pavimentazione con numero piastrelle.
    * @param p la piastrella non nulla.
    * @param numero il numero di piastrelle.
    * @throws IllegalArgumentException se numero <= 0
    */
    public Pavimentazione(Piastrella p, int numero){
        Objects.requireNonNull(p);
        
        if (numero <= 0 ){
            throw new IllegalArgumentException("impossibile creare una pavimentazione con un numero negativo o uguale a zero di piastrelle.");
        }

        piastrella2numero = new HashMap<>();
        piastrella2numero.put(p, numero);
    }

    /**
    * Aggiungi un certo numero di piastrelle alla pavimentazione.
    * @param p la piastrella non nulla.
    * @param numero il numero di piastrelle.
    * @throws IllegalArgumentException se numero <= 0
    */
    public void addPiastrella(Piastrella p, int numero){
        Objects.requireNonNull(p);
        
        if (numero <= 0 ){
            throw new IllegalArgumentException("impossibile aggiungere alla pav un numero negativo o uguale a zero di piastrelle.");
        }

        piastrella2numero.put(p, numero);
    }

    // /**
    // * Costruttore pavimentazione con numero piastrelle.
    // * @param p la piastrella non nulla.
    // * @param numero il numero di piastrelle che costituiscono la pavimentazione.
    // * @throws IllegalArgumentException se numero <= 0
    // */
    // public Pavimentazione(Piastrella p, int numero){
    //     this.piastrella = Objects.requireNonNull(p);
        
    //     if (numero <= 0 ){
    //         throw new IllegalArgumentException("impossibile creare una pavimentazione con un numero negativo o uguale a zero di piastrelle.");
    //     }

    //     this.superficie = p.getSuperficieTot(numero);
    //     this.costoTotale = numero * p.getCosto();
    // }

    /**
    * calcolo della superficie totale
    * @return il valore di superficie
    */
    public int getSuperficie(){
        int superficie = 0;

        for(Map.Entry<Piastrella, Integer> v : piastrella2numero.entrySet()){
            int numero = v.getValue();
            Piastrella p = v.getKey();

            superficie += p.getSuperficieTot(numero);
        }

        assert superficie>0 : "Qualcosa è andato storto";

        return superficie;
    }

    /**
    * calcolo del costo totale
    * @return costo totale
    */
    public int getCosto(){
        int costo = 0;

        for(Map.Entry<Piastrella, Integer> v : piastrella2numero.entrySet()){
            int numero = v.getValue();
            Piastrella p = v.getKey();

            costo += p.getCosto() * numero;
        }

        assert costo>0 : "Qualcosa è andato storto";

        return costo;
    }

}