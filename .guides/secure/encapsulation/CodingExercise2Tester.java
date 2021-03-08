import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class CodingExercise2Tester {
  Watch testWatch;
  Watch testWatch2;
  ArrayList<String> code = new ArrayList<String>();
  
  @Before
  public void setup() {
    testWatch = new Watch("patek phillipe", "calatrava", 37, 30, "rose gold");
    testWatch2 = new Watch("rolex", "submariner", 41, 300, "steel");
    String path = "code/encapsulation/exercises/CodingExercise2.java";
    
    // read student file into ArrayList
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        code.add(currentLine);
        currentLine = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  @Test
  public void checkManufacturerGetter() {
    assertEquals("patek phillipe", testWatch.getManufacturer());
  }
  
  @Test
  public void checkManufacturerSetter() {
    testWatch.setManufacturer("rolex");
    assertEquals("rolex", testWatch.getManufacturer());
  }
  
  @Test
  public void checkModelGetter() {
    assertEquals("calatrava", testWatch.getModel());
  }
  
  @Test
  public void checkModelSetter() {
    testWatch.setModel("submariner");
    assertEquals("submariner", testWatch.getModel());
  }
  
  @Test
  public void checkDiameterGetter() {
    assertEquals(37, testWatch.getDiameter());
  }
  
  @Test
  public void checkDiameterSetter() {
    testWatch.setDiameter(41);
    assertEquals(41, testWatch.getDiameter());
  }
  
  @Test
  public void checkWaterResistanceGetter() {
    assertEquals(30, testWatch.getWaterResistance());
  }
  
  @Test
  public void checkWaterResistanceSetter() {
    testWatch.setWaterResistance(300);
    assertEquals(300, testWatch.getWaterResistance());
  }
  
  @Test
  public void checkMaterialGetter() {
    assertEquals("rose gold", testWatch.getMaterial());
  }
  
  @Test
  public void checkMaterialSetter() {
    testWatch.setMaterial("steel");
    assertEquals("steel", testWatch.getMaterial());
  }
  
  @Test 
  public void checkPrivateManufacturer() {
    String attribute = "private String manufacturer";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateModel() {
    String attribute = "private String model";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateDiameter() {
    String attribute = "private int diameter";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateWaterResistance() {
    String attribute = "private int waterResistance";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateMaterial() {
    String attribute = "private String material";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test
  public void checkSummaryMethod() {
    String expectedOutput = "Manufacturer: Rolex\nModel: Submariner\nDiameter: 41 mm\nWater Resistance: 300 m\nMaterial: Steel";
    assertEquals(expectedOutput, testWatch2.summary());
  }

}