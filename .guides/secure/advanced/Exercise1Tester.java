import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise1Tester {
  
  @Test
  public void checkToString1() {
    BankAccount ba = new BankAccount(1234.56, 7890.12);
    String expected = "BankAccount[checking=1234.56, savings=7890.12]";
    String actual = ba.toString();
    String feedback = "Test did not pass.";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkToString2() {
    BankAccount ba = new BankAccount(3325.45, 1618.89);
    String expected = "BankAccount[checking=3325.45, savings=1618.89]";
    String actual = ba.toString();
    String feedback = "Test did not pass.";
    assertEquals(feedback, expected, actual);
  }
  
}