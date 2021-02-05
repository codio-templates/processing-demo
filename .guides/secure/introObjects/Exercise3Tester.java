import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise3Tester {
  String[] powers1 = {"healing", "heightened senses", "claws"};
  String[] powers2 = {"deity"};
  
  Superhero hero1 = new Superhero("Wolverine", "Logan Howlett", powers1);
  Superhero hero2 = new Superhero("Doctor Manhattan", "Jon Osterman", powers2);
  
  @Test
  public void checkName() {
    assertEquals(hero1.name, "Wolverine");
    assertEquals(hero2.name, "Doctor Manhattan");
  }
  
  @Test
  public void checkSecretIdentity() {
    assertEquals(hero1.secretIdentity, "Logan Howlett");
    assertEquals(hero2.secretIdentity, "Jon Osterman");
  }
  
  @Test
  public void checkPowers() {
    assertEquals(hero1.powers, powers1);
    assertEquals(hero2.powers, powers2);
  }

}