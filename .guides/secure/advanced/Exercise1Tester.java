import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise1Tester {
  
  @Test
  public void checkCarTravel() {
    Car c = new Car(1234.5);
    String expected = "There is no extra feel to travel 1234.50 miles.";
    String actual = c.travel();
    String feedback = "Car travel output did not match.";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkCarInheritance() {
    Car c = new Car(1234.5);
    String feedback = "Car object did not inherit from the Vehicle interface.";
    assertTrue(feedback, c instanceof Vehicle);
  }
  
  @Test
  public void checkRideShareTravel() {
    RideShare rs = new RideShare(400, 0.25);
    String expected = "It costs $100.00 to travel 400.00 miles.";
    String actual = rs.travel();
    String feedback = "RideShare travel output did not match.";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkRideShareInheritance() {
    RideShare rs = new RideShare(400, 0.25);
    String feedback = "RideShare object did not inherit from the Vehicle interface.";
    assertTrue(feedback, rs instanceof Vehicle);
  }
  
  @Test
  public void checkSubwayTravel() {
    Subway s = new Subway(8.1);
    String expected = "$8.10 will get you unlimited use for one day.";
    String actual = s.travel();
    String feedback = "Subway travel output did not match.";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkSubwayInheritance() {
    Subway s = new Subway(8.1);
    String feedback = "Subway object did not inherit from the Vehicle interface.";
    assertTrue(feedback, s instanceof Vehicle);
  }
  
}