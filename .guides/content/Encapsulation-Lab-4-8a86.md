----------

## Lab 4

The `CoffeeJournal` is now complete. This lab focuses on how using an object from this class and building a command line interface around it. The following code should be added to the method definition section at the end.

## Command Line Interface

Start by creating some helper methods that are not a part of the `CoffeeJournal` class. We want a menu-driven interface. The user will enter a loop and be presented with a list of choices, which is the `mainMenu` method. The `performAction` method takes the user choice and performs the appropriate action. **Note**, the code examples uses the parameter `journal` which is an instance of the `CoffeeJournal` class.

The menu provides three options. The first one can be handled by the `CoffeeJournal` object. The other two options require the `CoffeeJournal` object but need some additional assistance. The `enterCoffee` method prompts the user to enter information about the new coffee, while the `quit` method saves the new information and exits the loop. Add these methods after `performAction`. **Note**, `run` is a boolean variable that controls the loop.

```java
  //add method definitions below this line

  public static int mainMenu() {
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.println("Coffess of the World");
    System.out.println("\t1. Show Coffee");
    System.out.println("\t2. Add Coffee");
    System.out.println("\t3. Save and Quit");
    return sc.nextInt();
  }
  
  public static boolean performAction(CoffeeJournal journal, int choice) {
    if (choice == 1) {
      System.out.println();
      journal.showCoffee();
    } else if (choice == 2) {
      enterCoffee(journal);
    } else if (choice == 3) {
      quit(journal);
      return false;
    }
    return true;
  }
  
  //add method definitions above this line
```

The `enterCoffee` method asks the user to input information about the coffee. Setters are used to update the attributes of the `CoffeeJournal` object. Finally, these attributes are added to the `coffee` attribute. The `quit` method saves the information to the CSV file, and stops the loop by setting `run` to `false`.

```java
  public static void enterCoffee(CoffeeJournal journal) {
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.println("Enter the name of the roaster: ");
    String newRoaster = sc.nextLine();
    journal.setRoaster(newRoaster);
    System.out.println("Enter the country of origin: ");
    String newCountry = sc.nextLine();
    journal.setCountry(newCountry);
    System.out.println("Enter the region: ");
    String newRegion = sc.nextLine();
    journal.setRegion(newRegion);
    System.out.println("Enter the number of stars '*' (1-4): ");
    String newStars = sc.nextLine();
    journal.setStars(newStars);
    System.out.println();
    journal.addCoffee();
  }
  
  public static void quit(CoffeeJournal journal) {
    System.out.println("Closing the coffee journal");
    journal.save();
  }
```

## Testing Your Code

To test our code, we are going to set up a loop that controls the command line application. Create a `CoffeeJournal` object as before. In addition, create the variable `run` which controls the loop, and `choice` which represents the user input. The loop should run as long as `run` is `true`. Present the user with the menu of options. Finally perform the desired action.

```java
    //add code below this line
    
    String file = "code/encapsulation/coffeeJournal.csv";
    CoffeeJournal journal = new CoffeeJournal(file);
    boolean run = true;
    int choice;
    
    while (run) {
      choice = mainMenu();
      performAction(journal, choice, run);
    }

    //add code above this line
```

Use the following information to enter two new coffees.
|Roaster|Country|Origin|Stars|
|:------|:------|:-----|:---:|
|Ritual |Guatemala|Antigua|\*\*\*|
|Oak Cliff|Peru|Oxapampa|\*\*|

<details>
  <summary><strong>Using the Terminal</strong></summary>
  When using a <code>Scanner</code> object, you must type something in the terminal. That is why there is a terminal below the IDE.
</details><br>

{Try it|terminal}(sh .guides/csv.sh EncapsulationLab4 1)

You should see the following output:

```python
Roaster         Country         Region           Stars
Peace River     Rawanda         Remera           ***
Ritual          Guatemala       Antigua          ***
Oak Cliff       Peru            Oxapampa         **
```

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

    public void setRoaster(String newRoaster) {
      roaster = newRoaster;
    }

    public void setCountry(String newCountry) {
      country = newCountry;
    }

    public void setRegion(String newRegion) {
      region = newRegion;
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

  public class EncapsulationLab4 {
    public static void main(String[] args) {

      //add code below this line

      String file = "code/encapsulation/coffeeJournal.csv";
      CoffeeJournal journal = new CoffeeJournal(file);
      boolean run = true;
      int choice;

      while (run) {
        choice = mainMenu();
        run = performAction(journal, choice);
      }

      //add code above this line
    }

    //add method definitions below this line
    public static int mainMenu() {
      Scanner sc = new Scanner(System.in);
      System.out.println();
      System.out.println("Coffess of the World");
      System.out.println("\t1. Show Coffee");
      System.out.println("\t2. Add Coffee");
      System.out.println("\t3. Save and Quit");
      return sc.nextInt();
    }

    public static boolean performAction(CoffeeJournal journal, int choice) {
      if (choice == 1) {
        System.out.println();
        journal.showCoffee();
      } else if (choice == 2) {
        enterCoffee(journal);
      } else if (choice == 3) {
        quit(journal);
        return false;
      }
      return true;
    }

    public static void enterCoffee(CoffeeJournal journal) {
      Scanner sc = new Scanner(System.in);
      System.out.println();
      System.out.println("Enter the name of the roaster: ");
      String newRoaster = sc.nextLine();
      journal.setRoaster(newRoaster);
      System.out.println("Enter the country of origin: ");
      String newCountry = sc.nextLine();
      journal.setCountry(newCountry);
      System.out.println("Enter the region: ");
      String newRegion = sc.nextLine();
      journal.setRegion(newRegion);
      System.out.println("Enter the number of stars '*' (1-4): ");
      String newStars = sc.nextLine();
      journal.setStars(newStars);
      System.out.println();
      journal.addCoffee();
    }

    public static void quit(CoffeeJournal journal) {
      System.out.println("Closing the coffee journal");
      journal.save();
    }

    //add method definitions above this line
  }
  ```
</details>

{Check It!|assessment}(multiple-choice-1447429733)
