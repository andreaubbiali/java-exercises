

public class Monomy{

    private int coefficient;
    private int degree;

    public Monomy(int coef, int deg) throws NegativeExponentException {
        if (deg < 0) {
            throw new NegativeExponentException();
        }

        degree = deg;
        coefficient = coef;
    }

    public void setCoefficient(int c){
        this.coefficient = c;
    }

    public void setDegree(int d){
        this.degree = d;
    }

    public int getCoefficient(){
        return coefficient;
    }

    public int getDegree(){
        return degree;
    }

}