//add class definitions below this line

class Rectangle {
  int width;
  int length;
  static String description = "I am the Rectangle class.";
  
  Rectangle(int w, int l) {
    width = w;
    length = l;
    instances++;
  }
  
  int area() {
    return width * length;
  }
  
  static int combinedArea(Rectangle r1, Rectangle r2) {
    return r1.area() + r2.area();
  }
}
 
//add class definitions above this line

public class StaticMethods {  
  public static void main(String[] args) {
    
    //add code below this line

    System.out.println("Start with: " + Rectangle.instances);

    //add code above this line
  }
}