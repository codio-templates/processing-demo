//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
  String birthday;
  int totalFilms;
  int oscarNominations;
  int oscarWins;
  
  public Actor(String fn, String ln, String bd, int tf, int on, int ow) {
    firstName = fn;
    lastName = ln;
    birthday = bd;
    totalFilms = tf;
    oscarNominations = on;
    oscarWins = ow;
  }
}
  
//add class definitions above this line

public class ConstructorParameters {
  public static void main(String[] args) {
    
    //add code below this line

    Actor denzel = new Actor("Denzel", "Washington", "December 28", 47, 8, 2);
    System.out.println(denzel.birthday);
    System.out.println(denzel.totalFilms);

    //add code above this line
  }
}