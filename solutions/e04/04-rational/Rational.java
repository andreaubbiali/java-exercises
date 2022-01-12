
import java.util.Objects;
/**
* Overview: Instances of this class are rational numbers.
            This objects are mutable.
            A typical rational number is n/d with d != 0.
*/
public class Rational{

    /**
    * atrributes numerator and denominator of the rational number.
    */
    private int num, den;

    /*-
    * ABS FUN: AF(numerator, denominator) = numerator/denominator
    * REP INV: denominator > 0
    * ABS INV: denominator != 0 (la preservazione è implicata dalla preservazione della REP INV)
    */

    /**
    * Constructor of the rational object.
    */
    public Rational(int num, int den){
        this.num = num; 
        this.den = den;

        assert repOK();
    }

    /**
    * Add r to this.
    * pre-condition: r is not null.
    * post-condition: return this + r.
    * throws: NotValidRationalException if r is null.
    */
    public Rational add(Rational r) throws NotValidRationalException{
        if (r == null){
            throw new NotValidRationalException("The value can't be null");
        }

        Rational res;

        if (this.den == r.den){
            // same den 

            res = new Rational(this.num + r.num, this.den);
        } else {
            // calculate den and num
            int d = this.den * r.den;
            int n = (this.num*den) + (num * this.den);

            res = new Rational(n, d);
        }

        res.simplify();
        return res;
    }

    /**
    * Sub r to this.
    * pre-condition: r is not null.
    * post-condition: return this - r.
    * throws: NotValidRationalException if r is null.
    */
    Rational sub(Rational r) throws NotValidRationalException{
        if (r == null){
            throw new NotValidRationalException("The value can't be null");
        }

        Rational res;

        if (this.den == r.den){
            // same den 

            res = new Rational(this.num - r.num, this.den);
        } else {
            // calculate den and num
            int d = this.den * r.den;
            int n = (this.num*den) - (num * this.den);

            res = new Rational(n, d);
        }

        res.simplify();
        return res;
    }

    /**
    * Mul r to this.
    * pre-condition: r is not null.
    * post-condition: return this * r.
    * throws: NotValidRationalException if r is null.
    */
    public Rational mul(Rational r) throws NotValidRationalException{
        if (r == null){
            throw new NotValidRationalException("The value can't be null");
        }

        Rational res = new Rational(this.num * r.num, this.den * r.den);

        res.simplify();
        return res;
    }  

    /**
    * Div r to this.
    * pre-condition: r is not null.
    * post-condition: return this / r.
    * throws: NotValidRationalException if r is null.
    */
    public Rational div(Rational r)throws NotValidRationalException{
        if (r == null){
            throw new NotValidRationalException("The value can't be null");
        }

        // invert the second member.
        Rational inv = new Rational(r.den, r.num);

        return this.mul(inv);
    }

    /**
    * Simplify this to the rational.
    * pre-condition: this is not null.
    * post-condition: this simplified.
    */
    public void simplify(){
        assert repOK();

        int min = (num < den) ? num : den;

        for (int i = 1; i < min/2; i++){
            if (num % i == 0 && den % i == 0){
                num = num/i;
                den = den/i;
            }
        }
    }

    @Override
    public String toString(){
        assert repOK();

        return this.num + "/" + this.den;
    }

    @Override
    public boolean equals(Object o){
        assert repOK();
        
        this.simplify();
        if (!(o instanceof Rational)){
            return false;
        }
        Rational r = (Rational) o;

        return this.num == r.num && this.den == r.den;
    }

    @Override
    public int hashCode(){
        return Objects.hash(num, den);
    }

    public boolean repOK(){
        return this != null
            && this.den >= 0;
    }
}