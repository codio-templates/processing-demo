//add class definitions below this line
    
class Dog {
  String name;
  String breed;
  
  public Dog(String n, String b) {
    name = n;
    breed = b;
  }
  
  Dog(Dog d) {
    name = d.name;
    breed = d.breed;
  }
}
  
//add class definitions above this line

public class LabChallenge {
  public static void main(String[] args) {
    
    //add code below this line

    Dog dog1 = new Dog("Marceline", "German Shepherd");
    Dog dog2 = new Dog(dog1);
    dog2.name = "Cajun";
    dog2.breed = "Belgian Malinois";
    
    System.out.println(dog1);
    System.out.println(dog2);

    //add code above this line
  }
}