import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.lang.Class;
import java.lang.reflect.*;

public class Exercise3Tester {
  Mass m1;
  Mass m2;
  
  @Before
  public void setup() {
    m1 = new Mass(55, 300, 5);
    m2 = new Mass(45, 200, 2);
  }
  
  @Test
  public void checkCombinedWeightMethod() {
    assertEquals(7500.1, Mass.combinedWeight(m1, m2), 0.001);
  }
  
  @Test
  public void checkHeavierMethod() {
    assertEquals("The first object is heavier", Mass.heavier(m1, m2));
  }
  
  @Test
  public void checkAverageWeightMethod() {
    assertEquals(3750.05, Mass.averageWeight(m1, m2), 0.001);
  }

}