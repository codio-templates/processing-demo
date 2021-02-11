import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.lang.Class;
import java.lang.reflect.*;

public class Exercise2Tester {
  CelestialBody saturn;
  CelestialBody neptune;
  CelestialBody mars;
  CelestialBody uranus;
  
  @Before
  public void setup() {
    saturn = new CelestialBody("Saturn", 120536, 1433500000L, 62);
    neptune = new CelestialBody("Neptune", 49528, 4498400000L, 14);
    mars = new CelestialBody("Mars", 6792.4, 227990000L, 2);
    uranus = new CelestialBody("Uranus", 51118, 2872400000L, 27);
  }
  
  @Test
  public void checkStatic() {
    Method m = mars.getClass().getDeclaredMethods()[0];
    boolean hasStatic = Modifier.isStatic(m.getModifiers());
    assertTrue(hasStatic);
  }
  
  @Test
  public void checkSaturnNeptune() {
    String expected = "Saturn";
    String actual = CelestialBody.closerToSun(saturn, neptune);
    assertEquals(expected, actual);
  }
  
  @Test
  public void checkMarsUranus() {
    String expected = "Mars";
    String actual = CelestialBody.closerToSun(mars, uranus);
    assertEquals(expected, actual);
  }

}