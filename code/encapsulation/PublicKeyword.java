//add class definitions below this line
    
class Phone {
  private String model;
  private int storage;
  private int megapixels;
  
  private Phone(String mo, int st, int me) {
    model = mo;
    storage = st;
    megapixels = me;
  }
  
  public void describe() {
    System.out.println("My " + storage + " gig " + model + " has a " + megapixels + " megapixel camera.");
  }
}
  
//add class definitions above this line

public class PublicKeyword {
  public static void main(String[] args) {
    
    //add code below this line

    Phone myPhone = new Phone("iPhone", 256, 12);
    myPhone.describe();

    //add code above this line
  }
}