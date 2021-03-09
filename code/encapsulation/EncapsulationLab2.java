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

public class EncapsulationLab2 {
  public static void main(String[] args) {

    //add code below this line

    

    //add code above this line
  }

  //add method definitions below this line
  


  //add method definitions above this line
}