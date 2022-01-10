
public interface PolyInterface{
    void add(Monomy q);

    void sub(Monomy q);

    void mul(Monomy q);

    // get the opposite poly
    Poly minus();

    // degree of the poly
    int degree();

    // coeff of the term of d grade
    int coeff(int d);
}