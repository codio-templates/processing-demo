----------

## Exercise 2

Create the `Watch` class following the conventions of encapsulation. The class should have the following attributes:
* `manufacturer` - string that represents who makes the watch
* `model` - string that represents the specific watch
* `diameter` - integer that represents (in millimeters) the diameter of the watch
* `waterResistance` - integer that represents (in meters) the water resistance of the watch
* `material` - string that represents what the watch is made of

Each attribute has a getter and a setter. In addition, the method `printWatch` will return a multiline string that is a summary of the `Watch` instance. 

### Expected Output

The code below instantiates a `Watch` object. It then calls the `printWatch` method.

```java
    //add code below this line

    Watch myWatch = new Watch("omega", "speedmaster", 42, 50, "steel");
    System.out.println(myWatch.summary());

    //add code above this line
```

Your code should produce the following output:

```java
Manufacturer: Omega
Model: Speedmaster
Diameter: 42 mm
Water Resistance: 50 m
Material: Steel
```

### Important

Use the conventional naming scheme when creating your getters and setters. When instantiating a `Watch` object, the strings are all lowercase. The output from `summary` is a multiline string that uses capital letters and units of measure for the numbers. There should **not** be a newline character at the end of the output from the `summary` method.

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise2.java java -cp code/encapsulation/exercises/ CodingExercise2 1)

{Check It!|assessment}(test-3393708180)
