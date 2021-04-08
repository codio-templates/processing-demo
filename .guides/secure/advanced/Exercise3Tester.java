import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class Exercise3Tester {
  
  ArrayList<Dog> dogs = new ArrayList<Dog>();
  
  @Before
  public void setup() {
    dogs = makeDogs();
  }
  
  @Test
  public void checkNames() {
    String[] names;
    String[] expected = new String[0];
    String[] actual = {"Marceline", "Cajun", "Daisy", "Rocky", "Bella"};
    String feedback = "Names did not match.";
    
    for (Dog dog : dogs) {
      expected += dog.getName();
    }
    
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkBreeds() {
    String[] breeds;
    String[] expected = new String[0];
    String[] actual = {"German Shepherd", "Belgian Malinois", "Border Collie", "Golden Retreiver", "Irish Setter"};
    String feedback = "Breeds did not match.";
    
    for (Dog dog : dogs) {
      expected += dog.getBreed();
    }
    
    assertEquals(feedback, expected, actual);
  }
  
}