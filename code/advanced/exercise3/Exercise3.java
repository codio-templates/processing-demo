import java.util.*;

//add class definitions below this line

class Dog {
  private String name;
  private String breed;
  
  public Dog(String n, String b) {
    name = n;
    breed = b;
  }
  
  public String getName() {
    return name;
  }
  
  public String getBreed() {
    return breed;
  }
  
  public String toString() {
    return getClass().getName() + "[name=" + name + ", breed=" + breed + "]";
  }
}
 
//add class definitions above this line

public class Exercise3 {  
  public static void main(String[] args) {
    
    //add code below this line

    ArrayList<Dog> dogs = makeDogs();
    System.out.println(dogs);

    //add code above this line
    
  }
  
  //add method definition below this line

  public static ArrayList<Dog> makeDogs() {
    ArrayList<Dog> dogs = new ArrayList<Dog>();
    
    dogs.add(new Dog("Marceline", "German Shepherd"));
    dogs.add(new Dog("Cajun", "Belgian Malinois"));
    dogs.add(new Dog("Daisy", "Border Collie"));
    dogs.add(new Dog("Rocky", "Golden Retriever"));
    dogs.add(new Dog("Bella", "Irish Setter"));
    
    return dogs;
  }
 
  //add method definition above this line
}