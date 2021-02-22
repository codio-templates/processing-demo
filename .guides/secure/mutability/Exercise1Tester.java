import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Exercise1Tester {
  CelestialBody saturn;
  CelestialBody neptune;
  CelestialBody mars;
  double earth;
  double delta;
  
  @Before
  public void setup() {
    saturn = new CelestialBody("Saturn", 120536, 1433500000L, 62);
    neptune = new CelestialBody("Neptune", 49528, 4498400000L, 14);
    mars = new CelestialBody("Mars", 6792.4, 227990000L, 2);
    earth = 12765.3;
    double delta = 0.000001;
  }
  
  @Test
  public void checkSaturn() {
    double expected = saturn.diameter / earth;
    double actual = saturn.comparedToEarth();
    assertEquals(expected, actual, delta);
  }
  
  @Test
  public void checkNeptune() {
    double expected = neptune.diameter / earth;
    double actual = neptune.comparedToEarth();
    assertEquals(expected, actual, delta);
  }
  
  @Test
  public void checkMars() {
    double expected = mars.diameter / earth;
    double actual = mars.comparedToEarth();
    assertEquals(expected, actual, delta);
  }

}