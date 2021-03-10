----------

## Exercise 4

Use the `Library` class below for this coding exercise.

```java
//add class definitions below this line

class Library {
  ArrayList<String> available;
  ArrayList<String> onLoan;
  
  Library() {
    available = new ArrayList<String>();
    onLoan = new ArrayList<String>();
  }
}
 
//add class definitions above this line
```

Create the following instance methods for the `Library` class:
* `addBooks` - takes an list of book titles (strings) and adds each title to the ArrayList of available books
* `borrowBook` - takes a book title (string) and moves it from the available ArrayList to the ArrayList of books on loan
* `returnBook` - takes a book title (string) and moves it from the ArrayList of books on loan to the ArrayList of available books

### Expected Output

Assume you have an instance of the `Library` class called `myLibrary`. Add some books to object, and then print the list of available books.

```java
    Library myLibrary = new Library();
    String[] books = {"Four Seasons", "Say Nothing", "Milkman", "Harry Potter and the Order of the Phoenix"};
    myLibrary.addBooks(books);
    System.out.println(myLibrary.available);
```

You should see the following output:

```java
[Four Seasons, Say Nothing, Milkman, Harry Potter and the Order of the Phoenix]
```
{Try it}(sh .guides/bg.sh javac code/mutability/Exercise4.java java -cp code/mutability/ Exercise4 1)

Now borrow "Harry Potter and the Order of the Phoenix" and "Say Nothing". Then print the lists of available books and books on loan.

```java
    myLibrary.borrowBook("Harry Potter and the Order of the Phoenix");
    myLibrary.borrowBook("Say Nothing");
    System.out.println(myLibrary.available);
    System.out.println(myLibrary.onLoan);
```

You should see the following output:

```java
[Four Seasons, Milkman]
[Harry Potter and the Order of the Phoenix, Say Nothing]
```

{Try it}(sh .guides/bg.sh javac code/mutability/Exercise4.java java -cp code/mutability/ Exercise4 2)

Finally, return "Say Nothing" and print the lists of the books on loan and the available books.

```java
    myLibrary.returnBook("Say Nothing");
    System.out.println(myLibrary.available);
    System.out.println(myLibrary.onLoan);
```

You should see the following output:

```java
[Four Seasons, Milkman, Say Nothing]
[Harry Potter and the Order of the Phoenix]
```

{Try it}(sh .guides/bg.sh javac code/mutability/Exercise4.java java -cp code/mutability/ Exercise4 3)

{Check It!|assessment}(test-3144038960)
