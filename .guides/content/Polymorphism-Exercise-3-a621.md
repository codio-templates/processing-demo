----------

## Exercise 3

The `Temperature` class is an abstract class with two abstract methods. Create the `Conversion` class which inherits from `Temperature`. Use the formulas below to help with the temperature conversions.

### Convert Fahrenheit to Celsius
$$
°C = \frac{°F - 32}{1.8}
$$

### Convert Celsius to Fahrenheit
$$
°F = °C * 1.8 + 32
$$

## Expected Output

Instantiate a `Conversion` object. 

```java
    //add code below this line

    Conversion c = new Conversion();
    
    //add code above this line
```

Calling the `convertTo` method with the following arguments should produce the return values in the table below. **Note**, capitalization for the string argument should not affect the output.

|Method Call|Return Value|
|-----------|------------|
|`c.convertTo("Celsius", 212.0)`|100|
|`c.convertTo("CELSIUS", 78.0)`|25.555555555555554|
|`c.convertTo("celsius", 23.0)`|-5.0|
|`c.convertTo("Fahrenheit", 0.0)`|32.0|
|`c.convertTo("FAHRENHEIT", 29.0)`|84.2|
|`c.convertTo("fahrenheit", 112.0)`|233.6|

{Try it}(sh .guides/bg.sh javac code/polymorphism/exercise3/Exercise3.java java -cp code/polymorphism/exercise3/ Exercise3 1)

{Check It!|assessment}(test-1241253698)
