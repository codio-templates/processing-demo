import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class Exercise3Tester {
  
  ArrayList<Dog> dogs = new ArrayList<Dog>();
  
  @Before
  public void setup() {
    dogs.add(new Dog("Marceline", "German Shepherd"));
    dogs.add(new Dog("Cajun", "Belgian Malinois"));
    dogs.add(new Dog("Daisy", "Border Collie"));
    dogs.add(new Dog("Rocky", "Golden Retriever"));
    dogs.add(new Dog("Bella", "Irish Setter"));
  }
  
  @Test
  public void checkNames() {
    ArrayList<String> names = new ArrayList<String>();
    String[] expected = {"Marceline", "Cajun", "Daisy", "Rocky", "Bella"};
    String feedback = "Names did not match.";
    
    for (Dog dog : dogs) {
      names.add(dog.getName());
    }
    
    String[] actual = names.toArray(new String[names.size()]);
    
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkBreeds() {
    ArrayList<String> breeds = new ArrayList<String>();
    String[] expected = {"German Shepherd", "Belgian Malinois", "Border Collie", "Golden Retriever", "Irish Setter"};
    String feedback = "Breeds did not match.";
    
    for (Dog dog : dogs) {
      breeds.add(dog.getBreed());
    }
    
    String[] actual = breeds.toArray(new String[breeds.size()]);
    
    assertEquals(feedback, expected, actual);
  }
  
}