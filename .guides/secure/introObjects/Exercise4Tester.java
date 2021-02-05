import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise4Tester {
  Observation observe1 = new Observation("July 4, 1776", 6.2, 1132.4, 4);
  Observation observe2 = new Observation("December 7, 1941", 13.9, 1485.7, 13);
  
  @Test
  public void checkDate() {
    assertEquals("July 4, 1776", observe1.date);
    assertEquals("December 7, 1941", observe2.date);
  }
  
  @Test
  public void checkTemperature() {
    assertEquals(6.2, observe1.temperature, 0.0);
    assertEquals(13.9, observe2.temperature, 0.0);
  }
  
  @Test
  public void checkElevation() {
    assertEquals(1132.4, observe1.elevation, 0.0);
    assertEquals(1485.7, observe2.elevation, 0.0);
  }
  
  @Test
  public void checkPenguins() {
    assertEquals(4, observe1.penguins);
    assertEquals(13, observe2.penguins);
  }
  
  @Test
  public void checkPrecipitation() {
    assertEquals(0.0, observe1.precipitation, 0.0);
    assertEquals(0.0, observe2.precipitation, 0.0);
  }

}