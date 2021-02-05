import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise2Tester {
  Cat testCat = new Cat();
  
  @Test
  public void checkBreed() {
    assertEquals(testCat.breed, "american shorthair");
  }
  
  @Test
  public void checkColor() {
    assertEquals(testCat.color, "black");
  }
  
  @Test
  public void checkName() {
    assertEquals(testCat.name, "kiwi");
  }

}