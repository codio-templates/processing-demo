import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class Exercise1Tester {
  
  ArrayList<String> studentCode = new ArrayList<String>();
  
  @Before
  public void setup() {
    String path = "code/polymorphism/exercise1/Exercise1.java";
    
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
  }
  
  @Test
  public void checkInheritance() {
    PowerBall p = new PowerBall();
    assertTrue(p instanceof Lottery);
  }
  
  @Test
  public void checkArrayListLength() {
    PowerBall p = new PowerBall();
    assertEquals(6, p.shuffle().size());
  }
  
  @Test 
  public void check100Random() {
    String expected = "nextInt(100)";
    boolean hasExpected = false;
    
    // find expected code
    for (int i = 0; i < studentCode.size(); i++) {
      if (studentCode.get(i).contains(expected)) {
        hasExpected = true;
      }
    }
    
    assertTrue(hasExpected);
  }
  
}