import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class LabChallengeTester {
  Person testPerson;
  
  @Before
  public void setup() {
    testPerson = new Person("Adrian Beltre", 40, "third base");
  }
  
  @Test
  public void checkNameGetter() {
    assertEquals("Adrian Beltre", testPerson.getName());
  }
  
  @Test
  public void checkNameSetter() {
    testPerson.setName("Elvis Andrus");
    assertEquals("Elvis Andrus", testPerson.getName());
  }
  
  @Test
  public void checkAgeGetter() {
    assertEquals(40, testPerson.getAge());
  }
  
  @Test
  public void checkAgeSetter() {
    testPerson.setAge(32);
    assertEquals(32, testPerson.getAge());
  }
  
  @Test
  public void checkOccupationGetter() {
    assertEquals("third base", testPerson.getOccupation());
  }
  
  @Test
  public void checkOccupationSetter() {
    testPerson.setOccupation("shortstop");
    assertEquals("shortstop", testPerson.getOccupation());
  }
  
  @Test 
  public void checkPrivateName() {
    String attribute = "private String name";
    boolean hasPrivateAttribute = false;
    String path = "code/encapsulation/exercises/EncapsulationLabChallenge.java";
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
  public void checkPrivateAge() {
    String attribute = "private int age";
    boolean hasPrivateAttribute = false;
    String path = "code/encapsulation/exercises/EncapsulationLabChallenge.java";
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
  public void checkPrivateOccupation() {
    String attribute = "private String occupation";
    boolean hasPrivateAttribute = false;
    String path = "code/encapsulation/exercises/EncapsulationLabChallenge.java";
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