import java.util.*;


public class MainEF {

  public static void use(AdderInterface a) {
    a.add(List.of(1, 2, 3));
    System.out.println(a.result());
  }

  public static void main(String[] args) {
    AdderInterface a = new Adder();
    use(a);

    LogAdder la = new LogAdder(new Adder());
    use(la);
    System.out.println(la.log());
  }
}