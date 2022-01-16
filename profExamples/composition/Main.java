import java.util.*;

public class Main{

    public static void main(String[] args){
        Adder a = new Adder();
        a.add(List.of(1, 2, 3));
        System.out.println(a.result());

        // this create problems
        LogAdderExt lae = new LogAdderExt();
        lae.add(List.of(1, 2, 3));
        System.out.println(lae.result());
        System.out.println(lae.log());

        // this doesn't create any problem
        LogAdderComp lac = new LogAdderComp();
        lac.add(List.of(1, 2, 3));
        System.out.println(lac.result());
        System.out.println(lac.log());
    }
}