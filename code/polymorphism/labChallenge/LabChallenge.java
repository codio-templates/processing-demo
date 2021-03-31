//add class definitions below this line

class Chef {
  private String name;
  private String cuisine;
  private int michelinStars;
  
  public Chef(String n) {
    name = n;
    cuisine = null;
    michelinStars = 0;
  }
  
  public Chef(String n, String c) {
    name = n;
    cuisine = c;
    michelinStars = 0;
  }
  
  public Chef(String n, String c, int s) {
    name = n;
    cuisine = c;
    michelinStars = s;
  }
  
  public String display() {
    String msg = String.format("%s is known for %s cuisine and has %d Michelin stars.", name, cuisine, michelinStars);
    return msg;
  }
}

//add class definitions above this line

public class LabChallenge {  
  public static void main(String[] args) {
    
    //add code below this line

    Chef c1 = new Chef("Marco Pierre White");
    Chef c2 = new Chef("Rene Redzepi", "Nordic");
    Chef c3 = new Chef("Thomas Keller", "French", 3);
    
    System.out.println(c1.display());
    System.out.println(c2.display());
    System.out.println(c3.display());
    
    //add code above this line
  }
}