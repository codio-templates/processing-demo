//add class definitions below this line

class Mass {
  int milligrams;
  int grams;
  int kilograms;
  
  Mass(int mg, int g, int kg) {
    milligrams = mg;
    grams = g;
    kilograms = kg;
  }
  
  double totalWeight() {
    double tw = kilograms * 1000 + grams + milligrams / 1000;
    return tw;
  }
  
  double combinedWeight(Mass m) {
    return totalWeight() + m.totalWeight();
  }
  
  String heavier(Mass m) {
    double mass1 = totalWeight();
    double mass2 = m.totalWeight();
    if (mass1 > mass2) {
      return "The first object is heavier"
    } else if (mass2 > mass1) {
      return "The second object is heavier"
    } else {
      return "The two objects weigh the same"
    }
  }
  
  double averageWeight(Mass m) {
    return combinedWeight(m) / 2;
  }
}
 
//add class definitions above this line

public class Exercise3 {  
  public static void main(String[] args) {
    
    //add code below this line
    
    Mass m1 = new Mass(55, 300, 5);
    Mass m2 = new Mass(45, 200, 2);
    System.out.println(Mass.averageWeight(m1, m2));

    //add code above this line
  }
}