----------

## Exercise 1

Use the `CelestialBody` class to the left as the superclass. Create the `Satellite` and `Planet` classes, both of which are subclasses of `CelestialBody`. Using the `super` keyword to extend the constructor of `CelestialBody`, add the attribute `hostPlanet` (string) to the `Satellite` class and add the attribute `hostStar` (string) to the `Planet` class.

## Expected Attributes

After extending the constructor, your classes should have the following attributes.

|`CelestialBody`|`Satellite`|`Planet`|
|:-------------:|:----:|:------:|
|size|size|size|
|mass|mass|mass|
|composition|composition|composition|
|name|name|name|
|    |hostPlanet|hostStar|

Instantiate an object for both the `Satellite` and `Planet` classes:

```java
    //add code below this line
  
    Satellite s = new Satellite(2651, 3716, "helium", "moon", "earth");
    Planet p = new Planet(5349, 8910, "nitrogen", "earth", "sun");
  
    //add code above this line
```

Your code should produce the following output for the given print statements:

|Prin Statements|Output|
|:--------------|:-----|
|`System.out.println(s.getSize());`|`2651.0`|
|`System.out.println(s.getMass());`|`3716.0`|
|`System.out.println(s.getComposition());`|`helium`|
|`System.out.println(s.getName());`|`moon`|
|`System.out.println(s.getHostPlanet());`|`earth`|
|`System.out.println(p.getSize());`|`5349.0`|
|`System.out.println(p.getMass());`|`8190.0`|
|`System.out.println(p.getComposition());`|`nitrogen`|
|`System.out.println(p.getName());`|`earth`|
|`System.out.println(p.getHostStar());`|`sun`|

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise1/Exercise1.java java -cp code/inheritance/exercise1/ Exercise1 1)

{Check It!|assessment}(test-51862033)
