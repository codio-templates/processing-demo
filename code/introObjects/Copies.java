//add class definitions below this line
    
class ComicBookCharacter {
  String name;
  int age;
  String type;
  
  public ComicBookCharacter(String n, int a, String t) {
    name = n;
    age = a;
    type = t;
  }
  
  ComicBookCharacter(ComicBookCharacter c) {
    name = c.name;
    age = c.age;
    type = c.type;
  }
}
  
//add class definitions above this line

public class Copies {
  public static void main(String[] args) {
    
    //add code below this line

    ComicBookCharacter a = new ComicBookCharacter("Calvin", 6, "human");
    
    ComicBookCharacter b = new ComicBookCharacter(a);
    a.name = "Hobbes";
    
    System.out.println("Object a name: " + a.name);
    System.out.println("Object b name: " + b.name);
    
    //add code above this line
  }
}