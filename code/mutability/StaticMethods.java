//add class definitions below this line

class Rectangle {
  int width;
  int length;
  
  Rectangle(int w, int l) {
    width = w;
    length = l;
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

    Rectangle rect1 = new Rectangle(12, 27);
    Rectangle rect2 = new Rectangle(9, 3);
    System.out.println(rect.combinedArea(rect1, rect2));

    //add code above this line
  }
}