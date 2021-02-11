----------

## Exercise 2

Using the same `CelestialBody` class, write a static method `closerToSun` that compares two `CelectialBody` objects and returns the name of the object that is closes to the sun.

### Expected Output

If the objects `mercury` and `venus` are compared, then the method would return `Mercury`.

```java
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
}
 
//add class definitions above this line

public class Exercise2 {  
  public static void main(String[] args) {
    
    //add code below this line
    
    CelestialBody mercury = new CelestialBody("Mercury", 4879.4, 57909000, 0);
    CelestialBody venus = new CelestialBody("Venus", 12103.6, 108160000, 0);

    //add code above this line
  }
}
```

{Try it}(sh .guides/bg.sh javac code/mutability/Exercise2.java java -cp code/mutability/ Exercise2 1)

{Check It!|assessment}(test-3842605)
