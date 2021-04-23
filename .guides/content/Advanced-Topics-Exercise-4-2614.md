----------

## Exercise 4

You are given code for the `Library` class (in its own file). This is a composite class. You are going to create the `Book` class (the component class) in `Book.java` file. Look over the `Library` class carefully to determine what attributes are needed for the `Book` class. In addition, the table of output contains a hint as to what method the `Book` class needs.

### Expected Output
To check your work, open the `Exercise4.java` file and enter the following code samples. Be sure your output matches the given output for each scenario.

### Check 1
Return all of the books in the library. Change the code in `Exercise4.java` to look like this:

```java
    //add code below this line

    Library library = new Library();
    Book book1 = new Book("Three Musketeers", "Alexandre Dumas", "fiction");
    Book book2 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "fiction");
    Book book3 = new Book("Educated", "Tara Westover", "nonfiction");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.sortBooks();
    System.out.println(library.getBooks());

    //add code above this line
```

Java should print the following output:

```markdown
[[Book[title=Three Musketeers, author=Alexandre Dumas, genre=fiction], Book[title=The Count of Monte Cristo, author=Alexandre Dumas, genre=fiction], Book[title=Educated, author=Tara Westover, genre=nonfiction]]
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise4/Exercise4.java code/advanced/exercise4/Library.java code/advanced/exercise4/Book.java java -cp code/advanced/exercise4/ Exercise4 1)

### Check 2
Return just the fiction books. Change the code in `Exercise4.java` to look like this:

```java
    //add code below this line

    Library library = new Library();
    Book book1 = new Book("Three Musketeers", "Alexandre Dumas", "fiction");
    Book book2 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "fiction");
    Book book3 = new Book("Educated", "Tara Westover", "nonfiction");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.sortBooks();
    System.out.println(library.getFiction());

    //add code above this line
```

Java should print the following output:

```markdown
[Book[title=Three Musketeers, author=Alexandre Dumas, genre=fiction], Book[title=The Count of Monte Cristo, author=Alexandre Dumas, genre=fiction]]
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise4/Exercise4.java code/advanced/exercise4/Library.java code/advanced/exercise4/Book.java java -cp code/advanced/exercise4/ Exercise4 2)

### Check 3
Return just the nonfiction books. Change the code in `Exercise4.java` to look like this:

```java
    //add code below this line

    Library library = new Library();
    Book book1 = new Book("Three Musketeers", "Alexandre Dumas", "fiction");
    Book book2 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "fiction");
    Book book3 = new Book("Educated", "Tara Westover", "nonfiction");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.sortBooks();
    System.out.println(library.getNonfiction());

    //add code above this line
```

Java should print the following output:

```markdown
[Book[title=Educated, author=Tara Westover, genre=nonfiction]]
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise4/Exercise4.java code/advanced/exercise4/Library.java code/advanced/exercise4/Book.java java -cp code/advanced/exercise4/ Exercise4 3)

### Check 4
Return a list of books by an author in the library. Change the code in `Exercise4.java` to look like this:

```java
    //add code below this line

    Library library = new Library();
    Book book1 = new Book("Three Musketeers", "Alexandre Dumas", "fiction");
    Book book2 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "fiction");
    Book book3 = new Book("Educated", "Tara Westover", "nonfiction");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.sortBooks();
    System.out.println(library.searchAuthor("Alexandre Dumas"));

    //add code above this line
```

Java should print the following output:

```markdown
[Book[title=Three Musketeers, author=Alexandre Dumas, genre=fiction], Book[title=The Count of Monte Cristo, author=Alexandre Dumas, genre=fiction]]
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise4/Exercise4.java code/advanced/exercise4/Library.java code/advanced/exercise4/Book.java java -cp code/advanced/exercise4/ Exercise4 4)

### Check 5
Return a list of books by an author not in the library. Change the code in `Exercise4.java` to look like this:

```java
    //add code below this line

    Library library = new Library();
    Book book1 = new Book("Three Musketeers", "Alexandre Dumas", "fiction");
    Book book2 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "fiction");
    Book book3 = new Book("Educated", "Tara Westover", "nonfiction");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.sortBooks();
    System.out.println(library.searchAuthor("Herman Melville"));

    //add code above this line
```

Java should print the following output:

```markdown
[]
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise4/Exercise4.java code/advanced/exercise4/Library.java code/advanced/exercise4/Book.java java -cp code/advanced/exercise4/ Exercise4 5)

### Check 6
Return a boolean for a title in the library. Change the code in `Exercise4.java` to look like this:

```java
    //add code below this line

    Library library = new Library();
    Book book1 = new Book("Three Musketeers", "Alexandre Dumas", "fiction");
    Book book2 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "fiction");
    Book book3 = new Book("Educated", "Tara Westover", "nonfiction");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.sortBooks();
    System.out.println(library.searchTitle("Educated"));

    //add code above this line
```

Java should print the following output:

```markdown
true
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise4/Exercise4.java code/advanced/exercise4/Library.java code/advanced/exercise4/Book.java java -cp code/advanced/exercise4/ Exercise4 6)

### Check 7
Return a boolean for a title not in the library. Change the code in `Exercise4.java` to look like this:

```java
    //add code below this line

    Library library = new Library();
    Book book1 = new Book("Three Musketeers", "Alexandre Dumas", "fiction");
    Book book2 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "fiction");
    Book book3 = new Book("Educated", "Tara Westover", "nonfiction");

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.sortBooks();
    System.out.println(library.searchTitle("Moby Dick"));

    //add code above this line
```

Java should print the following output:

```markdown
false
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise4/Exercise4.java code/advanced/exercise4/Library.java code/advanced/exercise4/Book.java java -cp code/advanced/exercise4/ Exercise4 7)

{Check It!|assessment}(test-1539171007)

