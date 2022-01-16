import java.util.*;

public class Adder implements AdderInterface {

    private int result = 0;

    public void add(int x) {
        result += x;
    }

    public void add(List<Integer> l) {
        for (int x : l) add(x);
    }

    public int result() {
        return result;
    }
}
