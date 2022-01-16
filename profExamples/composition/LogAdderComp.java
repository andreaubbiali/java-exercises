import java.util.*;

public class LogAdderComp {
  private final Adder adder = new Adder();
  private final List<Integer> seen = new ArrayList<>();

  public void add(int x) {
    seen.add(x);
    adder.add(x);
  }

  public void add(List<Integer> l) {
    seen.addAll(l);
    adder.add(l);
  }

  public int result() {
    return adder.result();
  }

  public List<Integer> log() {
    return List.copyOf(seen);
  }
}