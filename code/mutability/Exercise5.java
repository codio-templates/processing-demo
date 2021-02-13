import java.util.ArrayList;

//add class definitions below this line

class Subway {
  static double fare = 2.4;
  String[] stops;
  String currentStop;
  String direction;
  int passengers;
  double totalFares;
  
  Subway() {
    stops = new String[]{"Alewife", "Davis", "Porter", "Harvard", "Central", "Kendall"};
    currentStop = "Alewife";
    direction = "south";
    passengers = 0;
    totalFares = 0;
  }
  
  void board(int p) {
    passengers += p;
    calculateFares(p);
  }
  
  void disembark(int p) {
    if (passengers - p < 0) {
      passengers = 0;
    } else {
      passengers -= p;
    }
  }
  
  int getIndex(String element) {
    for (int i = 0; i < stops.length; i++) {
      if (element.equals(stops[i])) {
        return i;
      }
    }
    return -1;
  }
  
  void advance() {
    int currentIndex = getIndex(currentStop);
    if (direction.equals("south")) {
      if (currentStop.equals("Kendall")) {
        currentStop = "Central";
        direction = "north";
      } else {
        currentStop = stops[currentIndex + 1];
      }
    } else if (direction.equals("north")) {
      if (currentStop.equals("Alewife")) {
        currentStop = "Davis";
        direction = "south";
      } else {
        currentStop = stops[currentIndex - 1];
      }
    }
  }
  
  int distance(String destination) {
    int currentIndex = getIndex(currentStop);
    int destinationIndex = getIndex(destination);
    return Math.abs(destinationIndex - currentIndex);
  }
  
  static void changeFare(double newFare) {
    fare = newFare;
  }
  
  void calculateFares(int p) {
    totalFares += p * fare;
  }
}
 
//add class definitions above this line

public class Exercise5 {  
  public static void main(String[] args) {
    
    //add code below this line
    
    Subway testSubway1 = new Subway();
    Subway testSubway2 = new Subway();
    Subway.changeFare(3.21);
    System.out.println(testSubway1.fare);
    System.out.println(testSubway2.fare);

    //add code above this line
  }
}