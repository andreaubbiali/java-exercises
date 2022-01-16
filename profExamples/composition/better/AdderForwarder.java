import java.util.*;

public class AdderForwarder implements AdderInterface {

  private final AdderInterface adder;

  public AdderForwarder(AdderInterface adder) {
    this.adder = adder;
  }

  @Override
  public void add(int x) {
    adder.add(x);
  }

  @Override
  public void add(List<Integer> l) {
    adder.add(l);
  }

  @Override
  public int result() {
    return adder.result();
  }
}