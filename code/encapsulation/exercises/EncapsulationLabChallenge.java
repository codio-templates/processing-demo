//add class definitions below this line
    
class Person {
  private String name;
  private int age;
  private String occupation;
  
  public Person(String n, int a, String o) {
    name = n;
    age = a;
    occupation = o;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int newAge) {
    age = newAge;
  }
  
  public String getOccupation() {
    return occupation;
  }
  
  public void setOccupation(String newOccupation) {
    occupation = newOccupation;
  }
}
  
//add class definitions above this line

public class EncapsulationLabChallenge {
  public static void main(String[] args) {
    
    //add code below this line

    Person myPerson = new Person("Citra Curie", 16, "student");
    
    System.out.println(myPerson.getName());
    myPerson.setName("Roman Faraday");
    System.out.println(myPerson.getName());
    
    System.out.println(myPerson.getAge());
    myPerson.setAge(18);
    System.out.println(myPerson.getAge());
    
    System.out.println(myPerson.getOccupation());
    myPerson.setOccupation("plumber");
    System.out.println(myPerson.getOccupation());

    //add code above this line
  }
}