----------

## Exercise 1

Use the `CelestialBody` class to the left as the superclass. Create the `Satellite` and `Planet` classes, both of which are subclasses of `CelestialBody`. Using the `super` keyword to extend the constructor of `CelestialBody`, add the attribute `hostPlanet` to the `Satellite` class and add the attribute `hostStar` to the `Planet` class.

## Expected Attributes

After extending the constructor, your classes should have the following attributes.

|`CelestialBody`|`Satellite`|`Planet`|
|:-------------:|:----:|:------:|
|size|size|size|
|mass|mass|mass|
|composition|composition|composition|
|name|name|name|
|    |host_planet|host_star|

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise1/Exercise1.java java -cp code/inheritance/exercise1/ Exercise1 1)