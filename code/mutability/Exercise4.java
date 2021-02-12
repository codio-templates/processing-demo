import java.util.ArrayList;

//add class definitions below this line

class Library {
  ArrayList<String> available;
  ArrayList<String> onLoan;
  
  Library() {
    available = new ArrayList<String>();
    onLoan = new ArrayList<String>();
  }
  
  void addBooks(String[] books) {
    for (String book : books) {
      available.add(book);
    }
  }
  
  void borrowBook(String book) {
    onLoan.add(book);
    available.remove(book);
  }
  
  void returnBook(String book) {
    onLoan.remove(book);
    available.add(book);
  }
}
 
//add class definitions above this line

public class Exercise4 {  
  public static void main(String[] args) {
    
    //add code below this line
    
    Library myLibrary = new Library();
    String[] books = {"Four Seasons", "Say Nothing", "Milkman", "Harry Potter and the Order of the Phoenix"};
    myLibrary.addBooks(books);
    myLibrary.borrowBook("Harry Potter and the Order of the Phoenix");
    myLibrary.borrowBook("Say Nothing");
    myLibrary.returnBook("Say Nothing");
    System.out.println(myLibrary.available);
    System.out.println(myLibrary.onLoan);  

    //add code above this line
  }
}