import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class LabChallengeTester {
  
  Podcast testPodcast;
  
  @Before
  public void setup() {
    String testName = "ATP";
    String testTitle = "It Might Not Be as Cool as You Think";
    int testLength = 7245;
    String testGenre = "technology";
    String testDate = "16 July 2020";
    testPodcast = new Podcast(testName, testTitle, testLength, testGenre, testDate);
  }
  
  @Test
  public void checkDisplayName() {
    String expectedName = "The name is ATP";
    assertEquals(expectedName, testPodcast.displayName());
  }
  
  @Test
  public void checkDisplayTitle() {
    String expectedTitle = "The title is It Might Not Be as Cool as You Think";
    assertEquals(expectedTitle, testPodcast.displayTitle());
  }
  
  @Test
  public void checkDisplayLength() {
    String expectedLength = "The length is 120 minutes and 45 seconds";
    assertEquals(expectedLength, testPodcast.displayLength());
  }
  
  @Test
  public void checkDisplayGenre() {
    String expectedGenre = "The genre is technology";
    assertEquals(expectedGenre, testPodcast.displayGenre());
  }
  
  @Test
  public void checkDisplayDate() {
    String expectedDate = "The date is 16 July 2020";
    assertEquals(expectedDate, testPodcast.displayDate());
  }
  
}