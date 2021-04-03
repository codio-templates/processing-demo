//add class definitions below this line

class ClassA {}
class ClassB extends ClassA {}
class ClassC {}
class ClassD extends ClassB {}
 
//add class definitions above this line

public class MultilevelHierarchy {
  public static void main(String[] args) {
    
    //add code below this line
  
    ClassD d = new ClassD();
    System.out.println(d instanceof ClassC);
  
    //add code above this line      
  }
}