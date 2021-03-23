import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class Exercise1Tester {
  
  Planet testPlanet;
  Satellite testSatellite;
  ArrayList<String> code = new ArrayList<String>();
  
  @Before
  public void setup() {
    testPlanet = new Planet(3389, 64171, "iron oxide", "mars", "sun");
    testSatellite = new Satellite(1560, 4799, "ice", "europa", "jupiter");
    String path = "code/inheritance/exercise1/Exercise1.java";
    
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
  public void checkPlanetGetSize() {
    double expected = 3389;
    assertEquals(expected, testPlanet.getSize(), 0.01);
  }
  
  @Test
  public void checkPlanetGetMass() {
    double expected = 64171;
    assertEquals(expected, testPlanet.getMass(), 0.01);
  }
  
  @Test
  public void checkPlanetGetComposition() {
    String expected = "iron oxide";
    assertEquals(expected, testPlanet.getComposition());
  }
  
  @Test
  public void checkPlanetGetName() {
    String expected = "mars";
    assertEquals(expected, testPlanet.getName());
  }
  
  @Test
  public void checkPlanetGetHostStar() {
    String expected = "sun";
    assertEquals(expected, testPlanet.getHostStar());
  }
  
  @Test
  public void checkSatelliteGetSize() {
    double expected = 1560;
    assertEquals(expected, testSatellite.getSize(), 0.01);
  }
  
  @Test
  public void checkSatelliteGetMass() {
    double expected = 4799;
    assertEquals(expected, testSatellite.getMass(), 0.01);
  }
  
  @Test
  public void checkSatelliteGetComposition() {
    String expected = "ice";
    assertEquals(expected, testSatellite.getComposition());
  }
  
  @Test
  public void checkSatelliteGetName() {
    String expected = "europa";
    assertEquals(expected, testSatellite.getName());
  }
  
  @Test
  public void checkSatelliteGetHostPlanet() {
    String expected = "jupiter";
    assertEquals(expected, testSatellite.getHostPlanet());
  }
  
  @Test 
  public void checkPrivateModel() {
    String attribute = "super";
    int superCount = 0;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        superCount++;
      }
    }
    
    assertTrue(superCount == 2);
  }
  
}