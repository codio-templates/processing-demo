import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Exercise3Tester {
  
  Conversion c;
  
  @Before
  public void setup() {
    c = new Conversion();
  }
  
  @Test
  public void checkInheritance() {
    assertTrue(c instanceof Temperature);
  }
  
  @Test
  public void checkCelsiusOutput1() {
    double expected = 7.2222222222;
    assertEquals(expected, c.convertTo("cElsiUs", 45), 0.001);
  }
  
  @Test
  public void checkCelsiusOutput2() {
    double expected = 41.777777778;
    assertEquals(expected, c.convertTo("cELSIUS", 107.2), 0.001);
  }
  
  @Test
  public void checkCelsiusOutput3() {
    double expected = -4.9333333333;
    assertEquals(expected, c.convertTo("celsiuS", 23.12), 0.001);
  }
  
  @Test
  public void checkFahrenheitOutput1() {
    double expected = 82.58;
    assertEquals(expected, c.convertTo("fahrenheiT", 28.1), 0.001);
  }
  
  @Test
  public void checkFahrenheitOutput2() {
    double expected = 118.4;
    assertEquals(expected, c.convertTo("fahrenheiT", 48), 0.001);
  }
  
  @Test
  public void checkFahrenheitOutput3() {
    double expected = 134.06;
    assertEquals(expected, c.convertTo("fahrenheiT", 56.7), 0.001);
  }
  
}