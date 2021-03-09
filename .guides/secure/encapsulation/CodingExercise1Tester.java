import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class CodingExercise1Tester {
  
  Fruit testFruit;
  
  @Before
  public void setup() {
    testFruit = new Fruit("apple", "green");
  }
  
  @Test
  public void checkNameGetter() {
    assertEquals("apple", testFruit.getName());
  }
  
  @Test
  public void checkColorGetter() {
    assertEquals("green", testFruit.getColor());
  }
  
  @Test
  public void checkNameSetter() {
    testFruit.setName("kiwi");
    assertEquals("kiwi", testFruit.getName());
  }
  
  @Test
  public void checkColorSetter() {
    testFruit.setColor("brown");
    assertEquals("brown", testFruit.getColor());
  }
  
  @Test 
  public void checkPrivateName() {
    String attribute = "private String name";
    boolean hasPrivateAttribute = false;
    String path = "code/encapsulation/exercises/CodingExercise1.java";
    ArrayList<String> studentCode = new ArrayList<String>();
    
    // read student file into ArrayList
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        studentCode.add(currentLine);
        currentLine = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
    
    // find attribute declaration
    for (int i = 0; i < studentCode.size(); i++) {
      if (studentCode.get(i).contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateColor() {
    String attribute = "private String color";
    boolean hasPrivateAttribute = false;
    String path = "code/encapsulation/exercises/CodingExercise1.java";
    ArrayList<String> studentCode = new ArrayList<String>();
    
    // read student file into ArrayList
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        studentCode.add(currentLine);
        currentLine = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
    
    // find attribute declaration
    for (int i = 0; i < studentCode.size(); i++) {
      if (studentCode.get(i).contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
}