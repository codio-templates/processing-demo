import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise5Tester {
  String[] habitat1 = {"asia", "africa"};
  String[] habitat2 = {"north america", "south america"};
  
  BigCat cat1 = new BigCat("leo", "lion", habitat1);
  BigCat cat2 = new BigCat("onca", "jaguar", habitat2);
  
  @Test
  public void checkSpecies() {
    assertEquals("leo", cat1.species);
    assertEquals("onca", cat2.species);
  }
  
  @Test
  public void checkCommonName() {
    assertEquals("lion", cat1.commonName);
    assertEquals("jaguar", cat2.commonName);
  }
  
  @Test
  public void checkHabitat() {
    assertEquals(habitat1, cat1.habitat);
    assertEquals(habitat2, cat2.habitat);
  }
  
  @Test
  public void checkGenus() {
    cat1.genus = "bird";
    assertEquals("bird", cat2.genus);
  }

}