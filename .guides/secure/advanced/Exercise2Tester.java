import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise2Tester {
  
  @Test
  public void checkToString1() {
    String[] members = {"Syd", "Nick", "Roger", "Richard", "David"};
    Band band = new Band("Pink Floyd", "rock'n roll", members);
    String expected = "Band[name=Pink Floyd, genre=rock'n roll, members=[Syd, Nick, Roger, Richard, David]]";
    String actual = band.toString();
    String feedback = "Output did not match.";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkToString2() {
    String[] members = {"RZA", "GZA", "Ol'Dirty Bastard", "Method Man", "Ghostface Killah", "Inspectah Deck", "U-God", "Masta Killa", "Cappadonna"};
    Band band = new Band("Wu-Tang Clan", "rap", members);
    String expected = "Band[name=Wu-Tang Clan, genre=rap, members=[RZA, GZA, Ol'Dirty Bastard, Method Man, Ghostface Killah, Inspectah Deck, U-God, Masta Killa, Cappadonna]]";
    String actual = band.toString();
    String feedback = "Output did not match.";
    assertEquals(feedback, expected, actual);
  }
  
}