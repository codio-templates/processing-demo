import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise2Tester {
  
  @Test
  public void checkInheritance() {
    Airplane a = new Airplane(1);
    assertTrue(a instanceof Vehicle);
  }
  
  @Test
  public void checkOutput1() {
    Airplane a1 = new Airplane(75.13);
    double expected = 2931.5726;
    assertEquals(expected, a1.travel(39.02), 0.001);
  }
  
  @Test
  public void checkOutput2() {
    Airplane a2 = new Airplane(113.8);
    double expected = 11436.9;
    assertEquals(expected, a2.travel(100.5), 0.001);
  }
  
  @Test
  public void checkOutput3() {
    Airplane a3 = new Airplane(55.5);
    double expected = 4176.375;
    assertEquals(expected, a3.travel(75.25), 0.001);
  }
  
}