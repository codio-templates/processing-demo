import java.util.ArrayList;

//add class definitions below this line

class Meal {
  ArrayList<String> drinks = new ArrayList<String>();
  ArrayList<String> appetizers = new ArrayList<String>();
  ArrayList<String> mainCourse = new ArrayList<String>();
  ArrayList<String> dessert = new ArrayList<String>();

  void addDrink(String d) {
    drinks.add(d);
  }

  void addAppetizer(String a) {
    appetizers.add(a);
  }

  void addCourse(String c) {
    mainCourse.add(c);
  }

  void addDessert(String d) {
    dessert.add(d);
  }
  
  void printMeal() {
    printCourse(drinks, "drinks");
    printCourse(appetizers, "appetizers");
    printCourse(mainCourse, "main course");
    printCourse(dessert, "dessert");
  }
  
  void printCourse(ArrayList<String> course, String name) {
    if (course.size() == 0) {
      String verb = "";
    
      if (name.equals("drinks")) {
        verb = "drinks were";
      } else if (name.equals("appetizers")) {
        verb = "appetizers were";
      } else if (name.equals("main course")) {
        verb = "main course was";
      } else if (name.equals("dessert")) {
        verb = "dessert was";
      }
      
      System.out.println("No " + verb + " served with the meal.");
    } else if (course.size() == 1) {
      String item = course.get(0);
      item = item.substring(0, 1).toUpperCase() + item.substring(1);
      System.out.println(item + " was served with the meal.");
    }
  }
}

//add class definitions above this line

public class MoreMethods {  
  public static void main(String[] args) {

    //add code below this line

    Meal dinner = new Meal();
    dinner.addDrink("water");
    dinner.addDrink("coffee");
    dinner.addCourse("roast chicken");
    dinner.addCourse("mashed potatoes");
    dinner.addCourse("salad");
    dinner.addDessert("chocolate cake");
    dinner.printMeal();
    
    //add code above this line
  }
}