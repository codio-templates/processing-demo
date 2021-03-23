import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Exercise5Tester {
  
  PlatinumClient testClient;
  CardHolder testHolder;
  
  @Before
  public void setup() {
    testClient = new PlatinumClient("Calvin", "3325 Runabout Court", 1618);
    testHolder = new CardHolder("Hobbes", "1618 S. Hampton Rd.", 3325);
  }
  
  @Test
  public void checkInheritance() {
    boolean cardHolderInheritance = testHolder instanceof Person;
    boolean platinumInheritance = testClient instanceof CardHolder;
    assertTrue(cardHolderInheritance && platinumInheritance);
  }
  
  @Test
  public void checkProcessSale() {
    PlatinumClient testClient = new PlatinumClient("Calvin", "3325 Runabout Court", 1618);
    testClient.processSale(173.86);
    assertEquals(173.86, testClient.getBalance(), 0.01);
  }
  
  @Test
  public void checkRewards() {
    PlatinumClient testClient = new PlatinumClient("Calvin", "3325 Runabout Court", 1618);
    testClient.processSale(250);
    assertEquals(5.0, testClient.getRewards(), 0.01);
  }
  
  @Test
  public void checkMakePayment() {
    PlatinumClient testClient = new PlatinumClient("Calvin", "3325 Runabout Court", 1618);
    testClient.processSale(107.25);
    testClient.makePayment(50);
    assertEquals(57.25, testClient.getBalance(), 0.01);
  }
  
  @Test
  public void checkInfo() {
    String expected = "Calvin lives at 3325 Runabout Court.";
    assertEquals(expected, testClient.info());
  }
  
}