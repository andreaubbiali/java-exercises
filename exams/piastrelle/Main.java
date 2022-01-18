import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

// TODO fixare secondo le vere richieste (così è sbagliato)

public class Main{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Map<Integer, Piastrella> piastrelle = new HashMap<>();
        List<Pavimentazione> pavimentazione = new ArrayList<>();
        int num1;
        int num2;
        int num3;
        Piastrella p;
        int index = 0;

        while(scan.hasNext()){
            String letter = scan.next();
            num1 = scan.nextInt();
            num2 = scan.nextInt();

            switch(letter){
                case "Q":

                    // crea piastrella quadrata lato=num1 costo=num2
                    p = new Pquadrata(num1, num2);
                    piastrelle.put(index, p);

                    break;
                case "R":
                    num3 = scan.nextInt();

                    // crea piastrella romboidale di diagonali e costo assegnate
                    p = new Promboidale(num1, num2, num3);
                    piastrelle.put(index, p);

                    break;
                case "T":
                    num3 = scan.nextInt();

                    //crea una piastrella triangolare di base, altezza e costo assegnati
                    p = new Ptriangolare(num1, num2, num3);
                    piastrelle.put(index, p);

                    break;
                case "P":
                    
                    // num1 = quantità num2 = indice della piastrella
                    Pavimentazione pav = new Pavimentazione(piastrelle.get(num2), num1);
                    
                    // aggiunta di ulteriori piastrelle alla pavimentazione
                    while(scan.hasNextInt()){
                        System.out.println("ENTRA");
                        num1 = scan.nextInt();
                        num2 = scan.nextInt();
                        pav.addPiastrella(piastrelle.get(num2), num1);
                    }
                    pavimentazione.add(pav);
                    
                    break;
                default:
                    System.out.println("Non riconosciuto");
                    return;
            }
            index++;
        }

        // stampa finale
        Iterator<Pavimentazione> it = pavimentazione.iterator();

        while(it.hasNext()){
            Pavimentazione pav = it.next();
            System.out.println(pav.getSuperficie() + " " + pav.getCosto());
        }

    }
}