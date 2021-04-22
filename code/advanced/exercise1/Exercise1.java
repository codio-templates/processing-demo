interface Vehicle {
  String travel();
}

//add class definitions below this line

class Car implements Vehicle {
  private double miles;
  
  public Car(double m) {
    miles = m;
  }
  
  public String travel() {
    return String.format("There is no extra fee to travel %.2f miles.", miles);
  }
}

class RideShare implements Vehicle {
  private double miles;
  private double fee;
  
  public RideShare(double m, double f) {
    miles = m;
    fee = f;
  }
  
  public String travel() {
    return String.format("It costs $%.2f to travel %.2f miles.", (fee * miles), miles);
  }
}

class Subway implements Vehicle {
  private double fare;
  
  public Subway(double f) {
    fare = f;
  }
  
  public String travel() {
    return String.format("$%.2f will get you unlimited use for one day.", fare);
  }
}
 
//add class definitions above this line

public class Exercise1 {  
  public static void main(String[] args) {
    
    //add code below this line

    Car c = new Car(10);
    RideShare rc = new RideShare(20, 0.5);
    Subway s = new Subway(7.25);
    
    System.out.println(c.travel());
    System.out.println(rc.travel());
    System.out.println(s.travel());

    //add code above this line
    
  }
}