//add class definitions below this line

class ClassA {}
class ClassB extends ClassA {}
class ClassC {}
class ClassD extends ClassC {}

//add class definitions above this line

public class Hierarchy {
  public static void main(String[] args) {
    
    //add code below this line

    ClassA a = new ClassA();
    ClassB b = new ClassB();
    ClassC c = new ClassC();
    ClassD d = new ClassD();
    
    System.out.println(b.getClass());
    System.out.println(b instanceof ClassB);

    //add code above this line
  }
}