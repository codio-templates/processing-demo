----------

## Exercise 2

`Vehicle` is an abstract class. Create the `Airplane` class as a subclass of `Vehicle`. Extend and override `Airplane` as necessary to meet the criteria below. The `distance` method should return the distance traveled by the `Airplane` object.

## Expected Output

If you instantiate an `Airplane` object as shown below, the table indicates the expected return values for three different method calls.

```java
    //add code below this line

    Airplane a = new Airplane(550.0);
    
    //add code above this line
```

|Method Call|Return Value|
|-----------|------------|
|`a.distance(2)`|1100.0    |
|`a.distance(3.15)`|1732.5 |
|`a.distance(10.63)`|5846.5|


{Try it}(sh .guides/bg.sh javac code/polymorphism/exercise2/Exercise2.java java -cp code/polymorphism/exercise2/ Exercise2 1)

{Check It!|assessment}(test-2016365405)
