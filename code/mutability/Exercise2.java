//add class definitions below this line

class CelestialBody {
  String name;
  double diameter;
  long distance;
  int moons;
  
  CelestialBody(String n, double diam, long dist, int m) {
    name = n;
    diameter = diam;
    distance = dist;
    moons = m;
  }
  
  static String closerToSun(CelestialBody b1, CelestialBody b2) {
    if (b1.distance < b2.distance) {
      return b1.name;
    } else {
      return b2.name;
    }
  }
}
 
//add class definitions above this line

public class Exercise2 {  
  public static void main(String[] args) {
    
    //add code below this line
    
    CelestialBody mercury = new CelestialBody("Mercury", 4879.4, 57909000, 0);
    CelestialBody venus = new CelestialBody("Venus", 12103.6, 108160000, 0);
    String closest = CelestialBody.closerToSun(mercury, venus);
    System.out.println(closest);
    
    

    //add code above this line
  }
}