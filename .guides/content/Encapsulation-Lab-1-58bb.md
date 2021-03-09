## Lab 1

This lab will focus on building a journal to rate different coffees. The journal will use encapsulation. Users enter the name of the roaster, the country of origin, the region and how many stars (\*) they rate the coffee. Entries are saved to a CSV file. Users can display coffees already in the journal, or they can add new coffees to the journal. There are two main parts to this project, the `CoffeeJournal` class and the command line interface.

## The `CoffeeJournal` Class

Since this project will be reading and writing to a CSV file, we need to first import the CSV module. After that we are going to create the constructor for the `CoffeeJournal` class. The `file` attribute is the file path the CSV file. The next four attributes are strings related to the coffee. Finally, the `coffee` attribute is going to be the contents of the CSV file stored as an ArrayList of arrays of strings. Even if no coffees have been saved, the CSV file contains headers for each column. 

```java
//add class definitions below this line
    
class CoffeeJournal {
  private String file;
  private String roaster;
  private String country;
  private String region;
  private String stars;
  private ArrayList<String[]> coffee;
  
  public CoffeeJournal(String f) {
    file = f;
    roaster = "";
    country = "";
    region = "";
    stars = "";
    coffee = loadCoffee();
  }
}
  
//add class definitions above this line
```

`loadCoffee` is a helper method that returns the contents of the CSV file. The file is read one line at a time. Each line is an array of strings, which is then added to the ArrayList `savedCoffee`. Once the file has been read, the method returns `savedCoffee`.

```java
  private ArrayList<String[]> loadCoffee() {
    ArrayList<String[]> savedCoffee = new ArrayList<String[]>();
    try {
      CSVReader reader = new CSVReader(new FileReader(file));
      for (String[] row : reader) {
        savedCoffee.add(row);
      }
      reader.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    return savedCoffee;
  }
```

## Testing Your Code

For the sake of legibility, the path to the CSV file is stored in its own variable. Instantiate a `CoffeeJournal` object and print this object. Java will print the object type followed by its location in memory. You should see something like this: `CoffeeJournal@378bf509`. Your memory location will be different.

```java
    //add code below this line
    
    String file = "code/encapsulation/testJournal1.csv";
    CoffeeJournal journal = new CoffeeJournal(file);
    System.out.println(journal);

    //add code above this line
```

{Try it}(sh .guides/csv.sh EncapsulationLab1 1)

<details>
  <summary><strong>Self-Check</strong></summary>
  This is what your code should look like.
  
  ```java
  import java.io.*;
  import com.opencsv.*;
  import org.apache.commons.lang3.ObjectUtils;
  import java.util.ArrayList;
  import java.util.Scanner;

  //add class definitions below this line

  class CoffeeJournal {
    private String file;
    private String roaster;
    private String country;
    private String region;
    private String stars;
    private ArrayList<String[]> coffee;

    public CoffeeJournal(String f) {
      file = f;
      roaster = "";
      country = "";
      region = "";
      stars = "";
      coffee = loadCoffee();
    }

    private ArrayList<String[]> loadCoffee() {
      ArrayList<String[]> savedCoffee = new ArrayList<String[]>();
      try {
        CSVReader reader = new CSVReader(new FileReader(file));
        for (String[] row : reader) {
          savedCoffee.add(row);
        }
        reader.close();
      } catch (Exception e) {
        System.out.println(e);
      }
      return savedCoffee;
    }
  }

  //add class definitions above this line

  public class EncapsulationLab1 {
    public static void main(String[] args) {

      //add code below this line

      String file = "code/encapsulation/testJournal1.csv";
      CoffeeJournal journal = new CoffeeJournal(file);
      System.out.println(journal);
  
      //add code above this line
    }

    //add method definitions below this line
    
  
  
    //add method definitions above this line
  }
  ```
  
</details>
  
{Check It!|assessment}(fill-in-the-blanks-333953468)
