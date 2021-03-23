import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Exercise2Tester {
  
  BlogPost testBlog;
  
  @Before
  public void setup() {
    testBlog = new BlogPost("Google the Great", "Rachael Smith", "technology", "Wired", 1732, 5399);
  }
  
  @Test
  public void checkTitle() {
    String expected = "Google the Great";
    assertEquals(expected, testBlog.getTitle());
  }
  
  @Test
  public void checkAuthor() {
    String expected = "Rachael Smith";
    assertEquals(expected, testBlog.getAuthor());
  }
  
  @Test
  public void checkGenre() {
    String expected = "technology";
    assertEquals(expected, testBlog.getGenre());
  }
  
  @Test
  public void checkWebsite() {
    String expected = "Wired";
    assertEquals(expected, testBlog.getWebsite());
  }
  
  @Test
  public void checkWordCount() {
    int expected = 1732;
    assertEquals(expected, testBlog.getWordCount());
  }
  
  @Test
  public void checkPageViews() {
    int expected = 5399;
    assertEquals(expected, testBlog.getPageViews());
  }
  
}