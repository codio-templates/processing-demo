import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Exercise5Tester {
  
  @Before
  public void setup() {
    
  }
  
  @Test
  public void checkBoarding() {
    Subway testSubway = new Subway();
    testSubway.board(54);
    testSubway.board(32);
    testSubway.board(14);
    assertEquals(100, testSubway.passengers);
  }
  
  @Test
  public void checkFares() {
    Subway testSubway = new Subway();
    testSubway.board(17);
    testSubway.disembark(5);
    assertEquals(54.57, testSubway.totalFares, 0.01);
  }
  
  @Test
  public void checkChangeFare() {
    Subway testSubway1 = new Subway();
    Subway testSubway2 = new Subway();
    Subway.changeFare(3.21);
    assertEquals(testSubway1.fare, testSubway2.fare, 0.01);
  }
  
  @Test
  public void checkDistancePositive() {
    Subway testSubway = new Subway();
    testSubway.currentStop = "Porter";
    assertEquals(2, testSubway.distance("Central"));
  }
  
  @Test
  public void checkDistanceNegative() {
    Subway testSubway = new Subway();
    testSubway.currentStop = "Porter";
    assertEquals(2, testSubway.distance("Alewife"));
  }
  
  @Test
  public void checkAdvanceSouth() {
    Subway testSubway = new Subway();
    for (int i = 0; i < 2; i++) {
      testSubway.advance();
    }
    assertEquals("Porter", testSubway.currentStop);
  }
  
  @Test
  public void checkAdvanceSouthTerminus() {
    Subway testSubway = new Subway();
    testSubway.currentStop = "Kendall";
    for (int i = 0; i < 2; i++) {
      testSubway.advance();
    }
    assertEquals("Harvard", testSubway.currentStop);
  }
  
  @Test
  public void checkAdvanceNorth() {
    Subway testSubway = new Subway();
    testSubway.currentStop = "Harvard";
    testSubway.direction = "north";
    for (int i = 0; i < 2; i++) {
      testSubway.advance();
    }
    assertEquals("Davis", testSubway.currentStop);
  }
  
  @Test
  public void checkAdvanceNorthTerminus() {
    Subway testSubway = new Subway();
    testSubway.currentStop = "Harvard";
    testSubway.direction = "north";
    for (int i = 0; i < 5; i++) {
      testSubway.advance();
    }
    assertEquals("Porter", testSubway.currentStop);
  }
  
}