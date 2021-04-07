//add class definitions below this line

class Band {
  private String name;
  private String genre;
  private String[] members;
  
  public Band(String n, String g, String[]m) {
    name = n;
    genre = g;
    members = m;
  }
  
  public String getName() {
    return name;
  }
  
  public String getGenre() {
    return genre;
  }
  
  public String[] getMembers() {
    return members;
  }
}
 
//add class definitions above this line

public class Exercise2 {  
  public static void main(String[] args) {
    
    //add code below this line
    
    String[] members = {"Jerry", "Bob", "Mickey", "Bill", "Phil", "Pigpen"};
    Band dead = new Band("The Grateful Dead", "rock'n roll", members);

    //add code above this line
    
  }
}