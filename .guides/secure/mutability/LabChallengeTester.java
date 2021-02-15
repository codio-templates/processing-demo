import static org.junit.Assert.*;
import org.junit.Test;

public class LabChallengeTester {
  
  @Test
  public void checkTotalAnimals() {
    Zoo testZoo = new Zoo(52, 80, 78, 45);
    assertEquals(255, testZoo.totalAnimals());
  }
  
  @Test
  public void checkTotalMammals() {
    Zoo testZoo = new Zoo(33, 67, 90, 61);
    assertEquals(100, testZoo.totalMammals());
  }
  
  @Test
  public void checkMostAnimals() {
    Zoo testZoo = new Zoo(25, 88, 218, 145);
    assertEquals("reptiles", testZoo.mostAnimals());
  }

}