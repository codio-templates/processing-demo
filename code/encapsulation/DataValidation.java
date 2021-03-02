//add class definitions below this line
    
class Person {
  private String name;
  private int age;
  
  public Person(String n, int a) {
    name = n;
    age = a;
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
    if (newAge >= 0) {
      age = newAge;
    }
  }
}
  
//add class definitions above this line

public class DataValidation {
  public static void main(String[] args) {
    
    //add code below this line

    Person myPerson = new Person("Calvin", 6);
    System.out.println(myPerson.getName() + " is " + myPerson.getAge() + " years old.");
    myPerson.setAge(-100);
    System.out.println(myPerson.getName() + " is " + myPerson.getAge() + " years old.");

    //add code above this line
  }
}