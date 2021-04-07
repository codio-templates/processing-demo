----------

## Exercise 4

You are given code for the `Library` class (in its own file). This is a composite class. You are going to create the `Book` class (the component class) in `book.py` file. Look over the `Library` class carefully to determine what attributes are needed for the `Book` class. In addition, the table of output contains a hint as to what method the `Book` class needs.

### Expected Output
To check your work, open the `exercise4.py` file and enter the following code.

```python
library = Library()
book1 = Book('Three Musketeers', 'Alexandre Dumas', 'fiction')
book2 = Book('The Count of Monte Cristo', 'Alexandre Dumas', 'fiction')
book3 = Book('Educated', 'Tara Westover', 'nonfiction')

library.add_book(book1)
library.add_book(book2)
library.add_book(book3)
library.sort_books()
```

The following commands should produce the output on the right.

|Command                                          |Output|
|-------------------------------------------------|------|
|`print(library.books)`                           |[Book(Three Musketeers, Alexandre Dumas, fiction), Book(The Count of Monte Cristo, Alexandre Dumas, fiction), Book(Educated, Tara Westover, nonfiction)]|
|`print(library.fiction)`                         |[Book(Three Musketeers, Alexandre Dumas, fiction), Book(The Count of Monte Cristo, Alexandre Dumas, fiction)]|
|`print(library.nonfiction)`                      |[Book(Educated, Tara Westover, nonfiction)]|
|`print(library.search_author('Alexandre Dumas'))`|[Book(Three Musketeers, Alexandre Dumas, fiction), Book(The Count of Monte Cristo, Alexandre Dumas, fiction)]|
|`print(library.search_author('Herman Melville'))`|[]|
|`print(library.search_title('Educated'))`        |True|
|`print(library.search_title('Moby Dick'))`       |False|

{Try it}(sh .guides/bg.sh javac code/advanced/exercise4/Exercise4.java java -cp code/advanced/exercise4/ Exercise4 1)