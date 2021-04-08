import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class Exercise4Tester {
  
  Library library;
  Book book1;
  Book book2;
  
  @Before
  public void setup() {
    library = new Library();
    book1 = new Book("New Kid", "Jenny Craft", "Fiction");
    book2 = new Book("Say Nothing", "Patrick Radden Keefe", "Nonfiction");
    library.addBook(book1);
    library.addBook(book2);
    library.sortBooks();
  }
  
  @Test
  public void checkLength() {
    int expected = 2;
    int actual = library.getBooks().size();
    String feedback = "Incorrect number of books in the library";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkFiction() {
    String expected = "Book[title=New Kid, author=Jenny Craft, genre=Fiction]";
    String actual = library.getFiction().get(0).toString();
    String feedback = "Fiction books did not match.";
    assertTrue(feedback, library.getFiction().size() == 1 && expected.equals(actual));
  }
  
  @Test
  public void checkNonfiction() {
    String expected = "Book[title=Say Nothing, author=Patrick Radden Keefe, genre=Nonfiction]";
    String actual = library.getNonfiction().get(0).toString();
    String feedback = "Nonfiction books did not match.";
    assertTrue(feedback, library.getNonfiction().size() == 1 && expected.equals(actual));
  }
  
  @Test
  public void checkAuthorFound() {
    String expected = "Book[title=Say Nothing, author=Patrick Radden Keefe, genre=Nonfiction]";
    String actual = library.searchAuthor("Patrick Radden Keefe").get(0).toString();
    String feedback = "List of books by an author in the library does not match.";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkAuthorNotFound() {
    int expected = 0;
    int actual = library.searchAuthor("Bill Watterson").size();
    String feedback = "List of books by an author not in the library does not match.";
    assertEquals(feedback, expected, actual);
  }
  
  @Test
  public void checkTitleFound() {
    boolean actual = library.searchTitle("Say Nothing");
    String feedback = "Author is in the library.";
    assertTrue(feedback, actual);
  }
  
  @Test
  public void checkTitleNotFound() {
    boolean actual = library.searchTitle("Calvin and Hobbes");
    String feedback = "Author is not in the library.";
    assertTrue(feedback, !actual);
  }
  
}