----------

## Lab 3

We will finish up the `CoffeeJournal` class with some methods that add a coffee to the journal, prints the journal, and saves the updated journal to the CSV file. Printing the journal will use string formatting to make the output look organized. Only when the user quits the program will the new information be saved to the CSV file. All of these methods are public.

## Methods

The `addCoffee` method stores the `roaster`, `country`, `region`, and `stars` attributes in an array and then adds it to the `coffee` ArrayList. This method should go after the last setter method but remain in the `CoffeeJournal` class.

```java
  public void addCoffee() {
    String[] newCoffee = new String[4];
    newCoffee[0] = roaster;
    newCoffee[1] = country;
    newCoffee[2] = region;
    newCoffee[3] = stars;
    coffee.add(newCoffee);
  }
```

The `save` method opens the CSV file in write mode. It then iterates over the `coffee` attribute. Each array of strings is written to the file. **Note**, eventually the `save` method will be linked to stopping the program. So saving should be the last thing you do before exiting the program. This method should go after `addCoffee` but remain in the `CoffeeJournal` class.

```java
  public void save() {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter(file));
      for (String[] c : coffee) {
        writer.writeNext(c);
      }
      writer.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
```

The `showCoffee` method takes into account two cases. First, there is no information about a coffee in either the `coffee` attribute. If the size of `coffee` is one there is no coffee information (the one row is the headers). In this case, prompt the user to enter information. In all ther cases, iterate through `coffee` and print each element in the array of strings. `String.format` allows you to add spacing to the output. This method should go after `save` but remain in the `CoffeeJournal` class.

```java
  public void showCoffee() {
    if (coffee.size() == 1) {
      System.out.println("Enter a coffee");
    } else {
      for (String[] row : coffee) {
        String info = String.format("%-13s %-13s %-13s %-13s", row[0], row[1], row[2], row[3]);
        System.out.println(info);
      }
    }
  }
```

## Testing Your Code

### Test 1
Let's make sure your class is working as expected. The first test is going to try and print the coffee journal with no information in it.

```java
    //add code below this line
    
    String file = "code/encapsulation/testJournal3.csv";
    CoffeeJournal journal = new CoffeeJournal(file);
    journal.showCoffee();

    //add code above this line
```

You should see the following output:

```python
Enter a coffee 
```

{Try it}(sh .guides/csv.sh EncapsulationLab3 1)

### Test 2
Change your testing code to look like the code below. The second test is going to add a coffee to the journal and print its contents.

```java
    //add code below this line
    
    String file = "code/encapsulation/testJournal3.csv";
    CoffeeJournal journal = new CoffeeJournal(file);
    journal.setRoaster("Peace River");
    journal.setCountry("Rawanda");
    journal.setRegion("Remera");
    journal.setStars("***");
    journal.addCoffee();
    journal.showCoffee();
    journal.save();

    //add code above this line
```

You should see the following output:

```python
Roaster         Country         Region           Stars          
Peace River     Rawanda         Remera           ***            
```

{Try it}(sh .guides/csv.sh EncapsulationLab3 2)

### Test 3
Change your testing code to look like the code below. The third test is going to add a coffee to the journal and print the coffee information already stored in the CSV file (Test 2) plus the newly entered coffee.

```java
    //add code below this line
    
    String file = "code/encapsulation/testJournal3.csv";
    CoffeeJournal journal = new CoffeeJournal(file);
    journal.setRoaster("Peace River");
    journal.setCountry("Ethiopia");
    journal.setRegion("Sidoma");
    journal.setStars("****");
    journal.addCoffee();
    journal.showCoffee();
    journal.save();

    //add code above this line
```

You should see the following output:

```python
Roaster         Country         Region           Stars          
Peace River     Rawanda         Remera           ***            
Peace River     Ethiopia        Sidoma           ****  
```

{Try it}(sh .guides/csv.sh EncapsulationLab3 3)

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

    public void addCoffee() {
      String[] newCoffee = new String[4];
      newCoffee[0] = roaster;
      newCoffee[1] = country;
      newCoffee[2] = region;
      newCoffee[3] = stars;
      coffee.add(newCoffee);
    }

    public void save() {
      try {
        CSVWriter writer = new CSVWriter(new FileWriter(file));
        for (String[] c : coffee) {
          writer.writeNext(c);
        }
        writer.close();
      } catch (IOException e) {
        System.out.println(e);
      }
    }

    public void showCoffee() {
      if (coffee.size() == 1) {
        System.out.println("Enter a coffee");
      } else {
        for (String[] row : coffee) {
          String info = String.format("%-13s %-13s %-13s %-13s", row[0], row[1], row[2], row[3]);
          System.out.println(info);
        }
      }
    }
  }

  //add class definitions above this line

  public class EncapsulationLab3 {
    public static void main(String[] args) {

      //add code below this line

      // Test 1
      String file = "code/encapsulation/testJournal3.csv";
      CoffeeJournal journal = new CoffeeJournal(file);
      journal.showCoffee();

      // Test 2
      String file = "code/encapsulation/testJournal3.csv";
      CoffeeJournal journal = new CoffeeJournal(file);
      journal.setRoaster("Peace River");
      journal.setCountry("Rawanda");
      journal.setRegion("Remera");
      journal.setStars("***");
      journal.addCoffee();
      journal.showCoffee();
      journal.save();

      // Test 3
      String file = "code/encapsulation/testJournal3.csv";
      CoffeeJournal journal = new CoffeeJournal(file);
      journal.setRoaster("Peace River");
      journal.setCountry("Ethiopia");
      journal.setRegion("Sidoma");
      journal.setStars("****");
      journal.addCoffee();
      journal.showCoffee();
      journal.save();

      //add code above this line
    }

    //add method definitions below this line



    //add method definitions above this line
  }
  ```
</details>
  
{Check It!|assessment}(multiple-choice-3946797564)
