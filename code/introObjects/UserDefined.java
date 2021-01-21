import java.lang.Class;

//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
}  
  
//add class definitions above this line

public class UserDefined {  
  public static void main(String[] args) {
    
    //add code below this line

    Actor helen = new Actor();
    helen.firstName = "Helen";
    helen.lastName = "Mirren";
    System.out.println(helen.firstName + " " + helen.lastName);

    //add code above this line
  }
}