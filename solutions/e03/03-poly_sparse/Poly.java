import java.util.TreeMap;

// TODO vedi come l'ha fatto il profe

public class Poly implements PolyInterface{
    
    TreeMap<Integer, Monomy> poly;
    
    /**
    * Constructor of Poly.
    */
    public Poly(){
        poly = new TreeMap<>();
    }

    /** constructor of Poly.
    * instantiate a monomy \(cx^n\)
    * throws NegativeExponentException if n is negative
    */
    public Poly(int c, int n) throws NegativeExponentException {
        poly = new TreeMap<>();
        Monomy m = new Monomy(c, n);
        poly.put(n, m);
    }

    /**
    * add a monomy into this poly.
    * pre-condition: m is not null monomy.
    * post-condition: m added into this poly.
    */
    public void add(Monomy m){
        Monomy mon = poly.remove(m.getDegree());
        
        if (mon == null){
            // add new mon

            poly.put(m.getDegree(), m);
        } else {
            // update existing mon

            mon.setCoefficient(m.getCoefficient() + mon.getCoefficient());
            poly.put(mon.getDegree(), mon);
        }
    }

    /**
    * sub a monomy from this poly.
    * pre-condition: m is a not null monomy
    * post-condition: poly minus m.
    */
    public void sub(Monomy m){
        Monomy mon = poly.remove(m.getDegree());
        
        if (mon == null){
            // add the new mon

            poly.put(m.getDegree(), new Monomy( -m.getCoefficient(), m.getDegree()));
        } else {
            // sub the existing monomy

            mon.setCoefficient(mon.getCoefficient() - m.getCoefficient());
            poly.put(mon.getDegree(), mon);
        }
    }

    /**
    * Mul m with this poly.
    * pre-condition: m is a not null poly.
    * post-condition: poly * m
    */
    public void mul(Monomy m){
        int c = m.getCoefficient();
        int d = m.getDegree();
         
        for (int i = 0; i < poly.size(); i ++){
            Monomy mon = poly.remove(i);
            if (mon == null){
                continue;
            }

            mon.setCoefficient(mon.getCoefficient() * c);
            mon.setDegree(mon.getDegree() + d);
            
            poly.put(mon.getDegree(), mon);
        }

    }

    /**
    * Return the opposite poly.
    * pre-condition: poly is not null.
    * post-condition: returned the opposite poly.
    */
    public Poly minus(){
        Poly p = new Poly();

        for (int i = 0; i < poly.size(); i ++){
            Monomy mon = poly.get(i);
            if (mon == null){
                continue;
            }

            mon.setCoefficient(-mon.getCoefficient());
            p.add(mon);
        }

        return p;
    }

    /**
    * Return the degree of this.
    * pre-condition: poly is not null.
    * post-condition: returne the degree of the poly.
    */
    public int degree(){
        return (int)poly.lastKey();
    }

    /**
    * Return the coefficient of the term of d grade.
    * pre-condition: d >= 0.
    * post-condition: returned the coefficient.
    */
    // coeff of the term of d grade
    public int coeff(int d){
        Monomy m = poly.get(d);
        
        return m.getCoefficient();
    }

    @Override
    public String toString(){
        String res = "";

        for (int i = 0; i < poly.size(); i ++){
            Monomy mon = poly.get(i);
            if (mon == null){
                continue;
            }

            res += "" + mon.getCoefficient() + "x^" + mon.getDegree();
        }

        return res;
    }
}