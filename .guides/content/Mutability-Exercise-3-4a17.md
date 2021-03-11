----------

## Exercise 3

The class `Mass` is comprised of instance methods. None of these methods change object attributes. Convert these instance methods to static methods. **Note**, all comparisons are done in grams.

### Expected Output

The `combinedWeight` method should return `5506.532` when used with the following `Mass` objects.

```java
    //add code below this line
    
    Mass m1 = new Mass(800, 17, 3);
    Mass m2 = new Mass(732, 488, 2);
    System.out.println(Mass.combinedWeight(m1, m2));

    //add code above this line
```

The `heavier` method should return `The second object is heavier` when used with the following `Mass` objects.

```java
    //add code below this line
    
    Mass m1 = new Mass(80, 1, 3);
    Mass m2 = new Mass(1920, 1000, 2);
    System.out.println(Mass.heavier(m1, m2));

    //add code above this line
```

The `averageWeight` method should return `1146.51` when used with the following `Mass` objects.

```java
    //add code below this line
    
    Mass m1 = new Mass(3, 321, 0);
    Mass m2 = new Mass(17, 972, 1);
    System.out.println(Mass.averageWeight(m1, m2));

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/exercise3/Exercise3.java java -cp code/mutability/exercise3/ Exercise3 1)

{Check It!|assessment}(test-2519445590)
