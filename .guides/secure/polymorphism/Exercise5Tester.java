import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class Exercise5Tester {
  
  ArrayList<String> studentCode = new ArrayList<String>();
  
  @Before
  public void setup() {
    String path = "code/polymorphism/exercise5/Exercise5.java";
    
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
  public void checkOutput() {
    String studentOutput = "";
    String expectedOutput = "";
    String testText = ".guides/secure/polymorphism/exercise_5_source.txt";
    String answerText = ".guides/secure/polymorphism/exercise_5_output.txt";
    String expectedText = ".guides/secure/polymorphism/exercise_5_expected.txt";
    Stars studentTest = new Stars(testText, answerText);
    
    studentTest.swapWords();
    
    // read expected output file as a string
    try {
      BufferedReader reader = new BufferedReader(new FileReader(expectedText));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        studentOutput += currentLine;
        currentLine = reader.readLine();
      }
      expectedOutput = currentLine;
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
    
    // read student output file as a string
    try {
      BufferedReader reader = new BufferedReader(new FileReader(answerText));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        studentOutput += currentLine;
        currentLine = reader.readLine();
      }
      studentOutput = currentLine;
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
    
    assertEquals(expectedOutput, studentOutput);
  }
  
  @Test 
  public void checkEveryThirdWord() {
    String expected = "%3==0";
    boolean hasExpected = false;
    
    // find expected code
    for (int i = 0; i < studentCode.size(); i++) {
      if (studentCode.get(i).replaceAll(" ", "").contains(expected)) {
        hasExpected = true;
      }
    }
    
    assertTrue(hasExpected);
  }
  
}