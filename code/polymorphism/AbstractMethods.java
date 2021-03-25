abstract class Person {
  private String name;
  
  public String getName() {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public abstract String greeting();
}

//add class definitions below this line

class Engineer extends Person {
  private String speciality;
  
  public Engineer(String n, String s) {
    setName(n);
    speciality = s;
  }
  
  public String greeting() {
    return "Hello, my name is " + getName() + " and I am a(n) " + speciality;
  }
}

class Artist extends Person {
  private String medium;
  
  public Artist(String n, String m) {
    setName(n);
    medium = m;
  }
  
  public String greeting() {
    return "My name is " + getName() + " and I work with " + medium;
  }
}

//add class definitions above this line

public class AbstractMethods {  
  public static void main(String[] args) {
    
    //add code below this line

    Person p = new Engineer("Calvin", "civil engineer");
    Person a = new Artist("Maria", "water colors");
    
    System.out.println(p.greeting());
    System.out.println(a.greeting());
    
    //add code above this line
  }
}