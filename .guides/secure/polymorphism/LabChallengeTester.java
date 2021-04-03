import static org.junit.Assert.*;
import org.junit.Test;

public class LabChallengeTester {
  
  @Test
  public void checkConstructorOneArgument() {
    Chef testChef = new Chef("Alice");
    String expected = "Alice is known for null cuisine and has 0 Michelin stars.";
    assertEquals(expected, testChef.display());
  }
  
  @Test
  public void checkConstructorTwoArguments() {
    Chef testChef = new Chef("Alice", "Italian");
    String expected = "Alice is known for Italian cuisine and has 0 Michelin stars.";
    assertEquals(expected, testChef.display());
  }
  
  @Test
  public void checkConstructorThreeArguments() {
    Chef testChef = new Chef("Alice", "Italian", 1);
    String expected = "Alice is known for Italian cuisine and has 1 Michelin stars.";
    assertEquals(expected, testChef.display());
  }

}