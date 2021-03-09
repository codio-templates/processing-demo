import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class CodingExercise3Tester {
  Song testSong;
  ArrayList<String> code = new ArrayList<String>();
  
  @Before
  public void setup() {
    testSong = new Song("phoebe bridgers", "kyoto", "punisher", 0.02);
    String path = "code/encapsulation/exercises/CodingExercise3.java";
    
    // read student file into ArrayList
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        code.add(currentLine);
        currentLine = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  @Test
  public void checkArtistGetter() {
    assertEquals("phoebe bridgers", testSong.getArtist());
  }
  
  @Test
  public void checkArtistSetter() {
    testSong.setArtist("chvrches");
    assertEquals("chvrches", testSong.getArtist());
  }
  
  @Test
  public void checktitleGetter() {
    assertEquals("kyoto", testSong.getTitle());
  }
  
  @Test
  public void checkTitleSetter() {
    testSong.setTitle("do i wanna know");
    assertEquals("do i wanna know", testSong.getTitle());
  }
  
  @Test
  public void checkAlbumGetter() {
    assertEquals("punisher", testSong.getAlbum());
  }
  
  @Test
  public void checkAlbumSetter() {
    testSong.setAlbum("every open eye");
    assertEquals("every open eye", testSong.getAlbum());
  }
  
  @Test
  public void checkPlayCountGetter() {
    assertEquals(0, testSong.getPlayCount());
  }
  
  @Test
  public void checkPlayCountSetter() {
    testSong.setPlayCount(50);
    assertEquals(50, testSong.getPlayCount());
  }
  
  @Test
  public void checkPayRateGetter() {
    assertEquals(0.02, testSong.getPayRate(), 0.001);
  }
  
  @Test
  public void checkMoneyEarnedGetter() {
    assertEquals(0, testSong.getMoneyEarned(), 0.001);
  }
  
  @Test 
  public void checkPrivateArtist() {
    String attribute = "private String artist";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateTitle() {
    String attribute = "private String title";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateAlbum() {
    String attribute = "private String album";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivatePlayCount() {
    String attribute = "private int playCount";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivatePayRate() {
    String attribute = "private final double payRate";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateMoneyEarned() {
    String attribute = "private double moneyEarned";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test
  public void checkPlayMethod() {
    Song testSong2 = new Song("tame impala", "the moment", "currents", 0.001);
    for (int i = 0; i < 50; i++) {
      testSong2.play();
    }
    assertEquals(50, testSong2.getPlayCount());
    assertEquals(0.05, testSong2.getMoneyEarned(), 0.001);
  }

}