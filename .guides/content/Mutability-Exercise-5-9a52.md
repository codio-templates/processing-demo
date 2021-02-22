----------

## Exercise 5

Use the `Subway` class below to help solve these problems.

```java
//add class definitions below this line

class Subway {
  static double fare = 2.4;
  String[] stops;
  String currentStop;
  String direction;
  int passengers;
  double totalFares;
  
  Subway() {
    stops = new String[]{"Alewife", "Davis", "Porter", "Harvard", "Central", "Kendall"};
    currentStop = "Alewife";
    direction = "south";
    passengers = 0;
    totalFares = 0;
  }
}
//add class definitions above this line
```

Create the following methods for the `Subway` class:
* `board` - Accepts an integer that represents the number of passengers boarding the subway.
* `disembark` - Accepts an integer that represents the number of passengers exiting the subway. There cannot be a negative number of passengers on a subway. The fewest number of passengers on a subway is 0.
* `advance` - Moves the subway to the next stop. If `direction` is `"south"` the subway moves from Alewife to Kendall. If `direction` is `"north"` the subway moves from Kendall to Alewife. When the subway has reached its final stop, `direction` should change.
* `distance` - Accepts a string that represents a stop and returns the number of stops between the subway and the desired stop. The distance should be a positive number.
* `changeFare` - Accepts a float and changes the fare for all instances of the `Subway` class.
* `calculate_fares` - Calculates the fare for each passenger boarding the subway and adds it to `totalFares`.

### Expected Output
Use the examples below to test if your program is working as expected.

* **Boarding the Subway**
If `passengers` is 220 and 45 people board the subway, then `passengers` would be 265.

* **Total Fares**
If 100 passengers, in total, have boarded the train, the `totalFares` would be 240.

* **Exiting the Subway**
If `passengers` is 113 and 23 people exit the subway, then `passengers` would be 90.

* **Advancing the Subway**
If the subway is currently at Kendall and is traveling South, advancing the subway would change `currentStop` to `"Central"` and `direction` would become `"north"`. If the subway is currently at Porter and is traveling South, advancing the subway would change `currentStop` to `Harvard` and `direction` would remain `"south"`.

* **Calculating Distance**
If the subway is currently at Davis and the desired stop is Central, the distance between them is 3 stops.

* **Changing the Fare**
If the subway fare increased to $2.75, then `fare` should be 2.75 for all instances of the `Subway` class.

{Try it}(sh .guides/bg.sh javac code/mutability/Exercise5.java java -cp code/mutability/ Exercise5 1)

{Check It!|assessment}(test-2231923768)
