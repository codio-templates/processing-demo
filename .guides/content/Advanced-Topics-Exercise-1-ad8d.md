----------

## Exercise 1

The `Vehicle` interface has already been defined in the IDE to the left. Create the `Car`, `RideShare`, and `Subway` classes that inherit from `Vehicle`. The table below describes the constructor for each class.

|Constructor|Arguments|
|-----------|---------|
|`Car`      |One double that represents miles traveled.|
|`RideShare`|Two doubles; one for miles traveled and the other for the fee per mile.|
|`Subway`|One double that represents the fare of a subway ticket.|

Create an instance for each class and call the `travel` method.

```java
    //add code below this line

    Car c = new Car(10);
    RideShare rs = new RideShare(20, 0.5);
    Subway s = new Subway(7.25);
    
    System.out.println(c.travel());
    System.out.println(rs.travel());
    System.out.println(s.travel());

    //add code above this line
```

Your code should produce the following output:

```markdown
There is no extra fee to travel 10.00 miles.
It costs $10.00 to travel 20.00 miles.
$7.25 will get you unlimited use for one day.
```

<details>
  <summary><strong>Hint</strong></summary>
  Notice that the output for numbers (type <code>double</code>) have two decimal places. Use <code>String.format</code> and <code>%.2f</code> to ensure that the doubles all have two decimal places. See the example code below:
  
  ```java
  double money = 3.2;
  String myString = String.format("I have $%.2f in my wallet.", money);
  ```
  
</details><br>

{Try it}(sh .guides/bg.sh javac code/advanced/exercise1/Exercise1.java java -cp code/advanced/exercise1/ Exercise1 1)

{Check It!|assessment}(test-485920902)
