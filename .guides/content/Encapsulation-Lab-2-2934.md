----------

## Lab 2

The next step is to add getter and setter methods for the `roaster`, `country`, `region`, and `stars` attributes. These methods should go after the `loadCoffee` method but still be a part of the `CoffeeJournal` class.

```java
  public String getRoaster() {
    return roaster;
  }

  public void setRoaster(String newRoaster) {
    roaster = newRoaster;
  }

  public String getCountry() {
    return country;
  }
  
  public void setCountry(String newCountry) {
    country = newCountry;
  }

  public String getRegion() {
    return region;
  }
  
  public void setRegion(String newRegion) {
    region = newRegion;
  }

  public String getStars() {
    return stars;
  }
  
  public void setStars(String newStars) {
    stars = newStars;
  }
```

## Testing Your Code

Use the newly created setters to add a value for each of the four attributes. Then print these attributes with the getter methods.

```java
    //add code below this line
    
    String file = "code/encapsulation/testJournal2.csv";
    CoffeeJournal journal = new CoffeeJournal(file);
    journal.setRoaster("Peace River");
    journal.setCountry("Rawanda");
    journal.setRegion("Remera");
    journal.setStars("***");

    System.out.println(journal.getRoaster());
    System.out.println(journal.getCountry());
    System.out.println(journal.getRegion());
    System.out.println(journal.getStars());

    //add code above this line
```

{Try it}(sh .guides/csv.sh EncapsulationLab2 1)

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

    public String getRoaster() {
      return roaster;
    }

    public void setRoaster(String newRoaster) {
      roaster = newRoaster;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String newCountry) {
      country = newCountry;
    }

    public String getRegion() {
      return region;
    }

    public void setRegion(String newRegion) {
      region = newRegion;
    }

    public String getStars() {
      return stars;
    }

    public void setStars(String newStars) {
      stars = newStars;
    }
  }

  //add class definitions above this line

  public class EncapsulationLab2 {
    public static void main(String[] args) {

      //add code below this line

      String file = "code/encapsulation/testJournal2.csv";
      CoffeeJournal journal = new CoffeeJournal(file);
      journal.setRoaster("Peace River");
      journal.setCountry("Rawanda");
      journal.setRegion("Remera");
      journal.setStars("***");

      System.out.println(journal.getRoaster());
      System.out.println(journal.getCountry());
      System.out.println(journal.getRegion());
      System.out.println(journal.getStars());

      //add code above this line
    }

    //add method definitions below this line



    //add method definitions above this line
  }
  ```
</details>
  
{Check It!|assessment}(multiple-choice-3169021649)
