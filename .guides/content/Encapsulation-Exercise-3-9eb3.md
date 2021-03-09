----------

## Exercise 3

Create the `Song` class which represents a song on a streaming service. The class should have the following attributes:

* `artist` - string representing who sings the song
* `title` - string representing the name of the song
* `album` - string representing the album on which the song appears
* `playCount` - integer representing how many times the song has been played
* `payRate` - a constant double that represents how much money the artist receives each time a song is played
* `moneyEarned` a double representing how much money the song has earned the artist

All attributes should have a getter method, and all attributes except for `payRate` and `moneyEarned` should have a setter method. Use the Java convention for naming the getters and setters. Users should be able to call the `play` method which updates the `playCount` and `moneyEarned` attributes.

### Expected Output
Instantiate a `Song` object and play the song one time. Print the money earned. Then play it another 10,000 times and print how much the song has earned. **Note**, the `moneyEarned` attribute only updates when the `play` method is called. Using the `setPlayCount` method will update `playCount` but it will not update `moneyEarned`. That is why the for loop is used.

```java
    //add code below this line

    Song mySong = new Song("led zeppelin", "ten years gone", "physical graffiti", 0.001);
    mySong.play();
    System.out.println(mySong.getMoneyEarned());
    for (int i = 0; i < 10000; i++) {
      mySong.play();
    }
    System.out.println(mySong.getMoneyEarned());

    //add code above this line
```

Your program should produce the following output:

```java
0.001
10.001
```

### Important
The `payRate` and `moneyEarned` attributes should not have a setter method. The values for `moneyEarned` and `playCount` should start with `0` when a `Song` object is instantiated.

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise3.java java -cp code/encapsulation/exercises/ CodingExercise3 1)

{Check It!|assessment}(test-1440786407)
