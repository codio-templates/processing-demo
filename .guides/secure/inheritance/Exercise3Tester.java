import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Exercise3Tester {
  
  Child testChild;
  
  @Before
  public void setup() {
    testChild = new Child();
  }
  
  @Test
  public void checkIdentify() {
    String expected = "This method is called from Child";
    assertEquals(expected, testChild.identify());
  }
  
  @Test
  public void checkIdentify2() {
    String expected = "This method is called from Parent2";
    assertEquals(expected, testChild.identify2());
  }
  
  @Test
  public void checkIdentify3() {
    String expected = "This method is called from Parent1";
    assertEquals(expected, testChild.identify3());
  }
  
}