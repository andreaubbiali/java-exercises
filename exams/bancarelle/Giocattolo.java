
public class Giocattolo implements GiocattoloInterface{

    private String nome;
    private String materiale;

    /**
    * Costruttore.
    * @param nome il nome del giocattolo.
    * @param materiale materiale del giocattolo.
    */
    public Giocattolo(final String nome, final String materiale){
        this.nome = nome;
        this.materiale = materiale;
    }

    @Override
    public boolean equals(Object o){
        //Due giocattoli sono uguali se e solo se hanno lo stesso nome e sono fatti dello stesso materiale.
        if (o == null || !(o instanceof Giocattolo)){
            return false;
        }

        Giocattolo g = (Giocattolo) o;
        if (this.nome == g.nome && this.materiale == g.materiale){
            return true;
        }
        return false;
    }
}