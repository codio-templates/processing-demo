import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class Exercise4Tester {
  Library testLibrary;
  String[] testBooks = new String[5];
  ArrayList<String> expectedAddBooks = new ArrayList<String>();
  ArrayList<String> expectedAvailable = new ArrayList<String>();
  ArrayList<String> expectedOnLoan = new ArrayList<String>();
  
  @Before
  public void setup() {
    testLibrary = new Library();
    
    testBooks[0] = "Green Eggs and Ham";
    testBooks[1] = "War and Peace";
    testBooks[2] = "Lolita";
    testBooks[3] = "1984";
    testBooks[4] = "Animal Farm";
    
    for(String book : testBooks) {
      expectedAddBooks.add(book);
    }
    
  }
  
  @Test
  public void checkAddBooks() {
    testLibrary.addBooks(testBooks);
    assertTrue(expectedAddBooks.equals(testLibrary.available));
  }
  
  @Test
  public void checkBorrowBook() {
    testLibrary.borrowBook("1984");
    testLibrary.borrowBook("Lolita");
    
    expectedOnLoan.add("1984");
    expectedOnLoan.add("Lolita");
    expectedAvailable.remove("1984");
    expectedAvailable.remove("Lolita");
    
    assertTrue(expectedAvailable.equals(testLibrary.available));
    assertTrue(expectedOnLoan.equals(testLibrary.onLoan));
  }
  
  @Test
  public void checkReturnBook() {
    testLibrary.returnBook("1984");
    
    expectedOnLoan.remove("1984");
    expectedAvailable.add("1984");
    
    assertTrue(expectedAvailable.equals(testLibrary.available));
    assertTrue(expectedOnLoan.equals(testLibrary.onLoan));
  }

}