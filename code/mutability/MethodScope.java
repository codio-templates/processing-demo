import java.util.ArrayList;

//add class definitions below this line

class Marble {
  static ArrayList<String> allColors = new ArrayList<String>();
  String color;
  
  Marble(String c) {
    color = c;
    allColors.add(c);
  }
  
  void showColor() {
    System.out.println(color);
  }
  
  void changeColor(String c) {
    color = c;
  }
  
  static void changeColor(Marble m, String c) {
    m.color = c;
  }
}
 
//add class definitions above this line

public class MethodScope {  
  public static void main(String[] args) {
    
    //add code below this line

    Marble m1 = new Marble("black");
    Marble m2 = new Marble("red");
    Marble m3 = new Marble("green");
    Marble m4 = new Marble("yellow");
    Marble m5 = new Marble("red");
    
    m1.showColor();
    m2.showColor();
    m3.showColor();
    m4.showColor();
    m5.showColor();

    //add code above this line
  }
}