----------

## Exercise 1

The code below creates the `CelestialBody` class as well as the external method `comparedToEarth`. Transform the `comparedToEarth` method so that it becomes an instance method of the `CelestialBody` class.

### Expected Output

Printing the `comparedToEarth` instance method should return `11.200990184327827`.

<details>
  <summary><strong>What is the long data type?</strong></summary>
  In Java, the <code>int</code> data type can store up to 32-bits of information. Some of the numbers used in the evaluation of your code are too big for the <code>int</code> data type. That is why the <code>distance</code> attribute is a <code>long</code>. The <code>long</code> data type stores up to 64-bits of information. 
</details>

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

public class Exercise1 {  
  public static void main(String[] args) {
    
    //add code below this line
    

    CelestialBody planet = new CelestialBody("Jupiter", 142984, 778360000L, 79);
    System.out.println(comparedToEarth(planet));

    //add code above this line
  }
  
  //add method definitions below this line
  
  public static double comparedToEarth(CelestialBody planet) {
    double earth = 12765.3;
    double relativeSize = planet.diameter / earth;
    return relativeSize;
  }
  
  //add method definitions above this line
}
```

<details>
  <summary><strong>Units of Measure</strong></summary>
  Kilometers are the units of measure for the <code>diameter</code> and <code>distance</code> attributes. The <code>distance</code> attribute refers to the distance between the celestial body and the sun. Information used for this activity was taken from <a href="https://upload.wikimedia.org/wikipedia/commons/6/64/Solar-System.pdf">Wikipedia</a>.
</details><br>

{Try it}(sh .guides/bg.sh javac code/mutability/Exercise1.java java -cp code/mutability/ Exercise1 1)

{Check It!|assessment}(test-643654737)
