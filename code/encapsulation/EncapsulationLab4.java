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