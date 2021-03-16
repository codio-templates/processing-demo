class Carnivore {
  private String diet;
  
  public Carnivore(String d) {
    diet = d;
  }
  
  public String getDiet() {
    return diet;
  }
  
  public void setDiet(String newDiet) {
    diet = newDiet;
  }
}

class Dinosaur extends Carnivore {
  private double size;
  private double weight;
  
  public Dinosaur(String d, double s, double w) {
    super(d);
    size = s;
    weight = w;
  }
  
  public double getSize() {
    return size;
  }
  
  public void setSize(double newSize) {
    size = newSize;
  }
  
  public double getWeight() {
    return weight;
  }
  
  public void setWeight(double newWeight) {
    weight = newWeight;
  }
}

//add class definitions below this line



//add class definitions above this line

public class MultipleInheritance {
  public static void main(String[] args) {
    
    //add code below this line
  
    
  
    //add code above this line   
  }
}