import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Exercise4Tester {
  
  @Test
  public void checkInheritance() {
    double[][] accounts = {{}};
    RegionalBank testBank = new RegionalBank("test bank", 0, accounts);
    assertTrue(testBank instanceof Bank);
  }
  
  @Test
  public void checkRegionalTotal() {
    double[][] accounts = {{800, 200, 700, 300},
                           {975, 125, 350, 550},
                           {400, 500, 300, 800},
                           {350, 450, 550, 650}};
    RegionalBank testBank = new RegionalBank("test bank", 0, accounts);
    assertEquals(8000, testBank.regionalTotal(), 0.01);
  }
  
}