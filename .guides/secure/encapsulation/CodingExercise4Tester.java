import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class CodingExercise4Tester {
  
  ArrayList<String> code = new ArrayList<String>();
  
  @Before
  public void setup() {
    String path = "code/encapsulation/exercises/CodingExercise4.java";
    
    // read student file into ArrayList
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        code.add(currentLine);
        currentLine = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  @Test
  public void checkMoneyGetter() {
    Atm testAtm = new Atm(157.12);
    assertEquals(157.12, testAtm.getMoney(), 0.01);
  }
  
  @Test 
  public void checkPrivateMoney() {
    String attribute = "private double money";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test
  public void checkDeposit() {
    Atm testAtm = new Atm(157.12);
    testAtm.deposit(18.38);
    assertEquals(175.5, testAtm.getMoney(), 0.01);
  }
  
  @Test
  public void checkDepositNegative() {
    Atm testAtm = new Atm(157.12);
    testAtm.deposit(-25);
    assertEquals(157.12, testAtm.getMoney(), 0.01);
  }
  
  @Test
  public void checkWithdraw() {
    Atm testAtm = new Atm(157.12);
    testAtm.withdraw(70.5);
    assertEquals(86.62, testAtm.getMoney(), 0.01);
  }
  
  @Test
  public void checkWithdrawNegative() {
    Atm testAtm = new Atm(157.12);
    testAtm.deposit(-70.5);
    assertEquals(157.12, testAtm.getMoney(), 0.01);
  }
  
  @Test
  public void checkWithdrawTooLarge() {
    Atm testAtm = new Atm(157.12);
    testAtm.withdraw(170.5);
    assertEquals(157.12, testAtm.getMoney(), 0.01);
  }

}