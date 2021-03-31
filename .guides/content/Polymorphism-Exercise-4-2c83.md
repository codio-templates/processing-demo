----------

## Exercise 4

Create the `Median` class that has the method `calculateMedian` that calculates the median of the integers passed to the method. Use method overloading so that this method can accept anywhere from two to five parameters.

<details>
  <summary><strong>How to calculate median</strong></summary>
  The median can be thought of as the "middle" number in an ordered list of numbers. There are two numbers in the "middle", the median is the average of these two numbers.

  ![Calculate Median](.guides/img/polymorphism/median.png)
</details><br>

|Method Call|Return Value|
|-----------|------------|
|`m.calculateMedian(3, 5, 1, 4, 2)`|3.0|
|`m.calculateMedian(8, 6, 4, 2)`|5.0|
|`m.calculateMedian(9, 3, 7)`|7.0|
|`m.calculateMedian(5, 2)`|3.5|

<details>
  <summary><strong>Hint</strong></summary>
  Finding the median requires that the numbers be in order. You can use the method <code>Arrays.sort(myArray);</code> to sort an array of integers.
</details><br>

{Try it}(sh .guides/bg.sh javac code/polymorphism/exercise4/Exercise4.java java -cp code/polymorphism/exercise4/ Exercise4 1)

{Check It!|assessment}(test-2292953144)
