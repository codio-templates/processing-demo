----------

## Class Methods

Back in the introduction to classes and objects lesson, a class was defined as "a collection of data and the actions that can modify the data." The constructor built the "collection of data", but nothing in the class modified the data. Instead, external methods were used to modify the object.

Instead of external methods, class methods should be used to modify an object. Think of a class method as a method that is attached to an object. The class method is the most common type of method. Notice how class methods are declared inside of the class. The keyword `self` is used to represent the instance being modified by the method. These methods are called instance methods because they have access to the instance variables (the attributes declared in the constructor). Methods are invoked using dot-notation.

![External Methods vs Class Methods](.guides/img/mutability/external-methods-vs-class-methods.png)

When mutability was first introduced, you made a `Player` class with a few external methods. You are now going to transform these external methods into class methods. The `Player` class will be defined just as before. This time, however, `printPlayer` will be a part of the class (indented to match the constructor). 

```java
//add class definitions below this line

class Player {
  int health;
  int score;
  int level;
  
  Player() {
    health = 100;
    score = 0;
    level = 1;
  }
  
  void printPlayer() {
    if (health <= 0) {
      System.out.println("This player is dead. They died on level " + level + " with a score of " + score + ".");
    } else {
      System.out.println("This player has " + health + " health, a score of " + score + " and is on level " + level + ".");
    }
  }
}
 
//add class definitions above this line
```

Instantiate a `Player` object. Call the class method `printPlayer` using dot-notation.

```java
    //add code below this line

    Player mario = new Player();
    mario.printPlayer();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/Mutability.java java -cp code/mutability/ Mutability 1)

|||challenge
## Try this variation:
Call `printPlayer` like this:
```java
Player mario = new Player();
printPlayer(mario);
```

<details>
  <summary><strong>Why did this generate an error?</strong></summary>
  Java says it cannot find the symbol <code>printPlayer</code>, even though the definition is on line 14. Because nothing comes before <code>printPlayer</code>, Java assumes that this is an external method. However, <code>printPlayer</code> is a part of the <code>Player</code> class, which means it is a class method. Class methods must be called with dot-notation like <code>mario.printPlayer();</code>.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/Mutability.java java -cp code/mutability/ Mutability 2)

## More Player Methods

The next class methods to add to the `Player` class are those to print the `health` and `level` attributes of the `Player` instance. Start with the class method `changeHealth`. This method takes `amount` as a parameter. `changeHealth` will add `amount` to the `health` attribute. If a player's health increases, `amount` is positive. If their health decreases, `amount` is negative. 

```java
  void printPlayer() {
    if (health <= 0) {
      System.out.println("This player is dead. They died on level " + level + " with a score of " + score + ".");
    } else {
      System.out.println("This player has " + health + " health, a score of " + score + " and is on level " + level + ".");
    }
  }

  void changeHealth(int amount) {
    health += amount;
  }
```

{Try it}(sh .guides/bg.sh javac code/mutability/Mutability.java java -cp code/mutability/ Mutability 3)

The class method `changeLevel` is going to be similar to `changeHealth` except for one difference. `changeLevel` has no parameters. In video games, players go up in levels; rarely do they decrease. So the `level` attribute will increase by one when the class method is called. 

```java
  void changeHealth(int amount) {
    health += amount;
  }

  void changeLevel() {
    level += 1;
  }
```

{Try it}(sh .guides/bg.sh javac code/mutability/Mutability.java java -cp code/mutability/ Mutability 4)

|||challenge
## Try these variations:
* Call `changeHealth` and `chagneLevel` for `mario`, and then print the player to make sure the class methods work.
<details>
  <summary><strong>One possible solution</strong></summary>
  
  ```java
      //add code below this line

      Player mario = new Player();
      mario.printPlayer();
      mario.changeHealth(-10);
      mario.changeLevel();
      mario.printPlayer();

      //add code above this line
  ```
  
</details><br>

* Create a class method to change a player's score?
<details>
  <summary><strong>One possible solution</strong></summary>
  
  ```java
    void changeScore(int amount) {
      score += amount;
    }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/Mutability.java java -cp code/mutability/ Mutability 5)

<details>
  <summary><strong>Why learn about external methods that modify objects when Java has class methods?</strong></summary>
  It might seem like a waste of time to learn how to write external methods that modify objects. But this approach builds upon concepts you have already seen — external methods and objects. This allows you to understand mutability without having to worry about class methods. Once you understand how these ideas work, transforming an external method into a class method is much simpler. External methods that modify objects serve as an intermediary step on the way to learning about class methods.
</details>

{Check It!|assessment}(fill-in-the-blanks-680032819)
