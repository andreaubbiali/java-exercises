import java.util.*;

public class LogAdder extends AdderForwarder {
  private final List<Integer> seen = new ArrayList<>();

  public LogAdder(AdderInterface adder) {
    super(adder);
  }

  @Override
  public void add(int x) {
    seen.add(x);
    super.add(x);
  }

  @Override
  public void add(List<Integer> l) {
    seen.addAll(l);
    super.add(l);
  }

  public List<Integer> log() {
    return List.copyOf(seen);
  }
}