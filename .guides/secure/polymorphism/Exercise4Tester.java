import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise4Tester {
  
  @Test
  public void checkTwoArguments() {
    Median m = new Median();
    double expected = 4.0;
    assertEquals(expected, m.calculateMedian(8, 0), 0.01);
  }
  
  @Test
  public void checkThreeArguments() {
    Median m = new Median();
    double expected = 7.0;
    assertEquals(expected, m.calculateMedian(9, 1, 7), 0.01);
  }
  
  @Test
  public void checkFourArguments() {
    Median m = new Median();
    double expected = 3.5;
    assertEquals(expected, m.calculateMedian(2, 4, 8, 3), 0.01);
  }
  
  @Test
  public void checkFiveArguments() {
    Median m = new Median();
    double expected = 7.0;
    assertEquals(expected, m.calculateMedian(3, 7, 7, 9, 1), 0.01);
  }

}