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

public class EncapsulationLab4 {
  public static void main(String[] args) {

    //add code below this line



    //add code above this line
  }

  //add method definitions below this line



  //add method definitions above this line
}