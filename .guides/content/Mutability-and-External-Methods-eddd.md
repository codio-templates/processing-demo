----------

## Mutability

Objects are mutable, which means that objects (specifically their attributes) can change value. Think of a video game; the main character in the game is constantly changing. It could be their position on the screen, the score, their health, the items in their inventory, etc. Imagine a simple class called `Player`. A newly instantiated `Player` object has a `health` of 100, a `score` of 0, and starts on `level` 1. This object can lose health, increase their score, and advance levels.

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
}    
 
//add class definitions above this line
```

Print out the attributes of `player1`. Then change each attribute and print out the attributes again.

```java
    //add code below this line

    Player player1 = new Player();
    System.out.println("This player has " + player1.health + " health, a score of " + player1.score + " and is on level " + player1.level + ".");
    player1.health -= 10;
    player1.score += 25;
    player1.level += 1;
    System.out.println("This player has " + player1.health + " health, a score of " + player1.score + " and is on level " + player1.level + ".");

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/ExternalMethods.java java -cp code/mutability/ ExternalMethods 1)

|||challenge
## Try these variations:
* Change the health of `player1` to 0?
* Print the status of `player1` once their `health` is 0?
<details>
  <summary><strong>One Possible Solution</strong></summary>
  
  ```java
  System.out.println("This player is dead. They died on level " + player1.level + " with a score of " + player1.score + ".");
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/ExternalMethods.java java -cp code/mutability/ ExternalMethods 2)

## External Methods and Objects

One of the benefits of methods is code reusability. The example above has a repetition of the `System.out.println` statement. This is a good opportunity to use a method.

```java
  //add method definitions below this line
  
  public static String printPlayer(Player p) {
    return "This player has " + p.health + " health, a score of " + p.score + " and is on level " + p.level + ".";
  }
  
  //add method definitions above this line
```

In the `main` method, replace the strings inside the print statements with a call to the `printPlayer` method. Don't forget to pass the `player1` object to the `printPlayer` method.

```java
    //add code below this line

    Player player1 = new Player();
    System.out.println(printPlayer(player1));
    player1.health -= 10;
    player1.score += 25;
    player1.level += 1;
    System.out.println(printPlayer(player1));

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/ExternalMethods.java java -cp code/mutability/ ExternalMethods 3)

Using a method to print the status of `player1` may not seem like it was worth the effort to change the code. But when these methods become more complex, The efficiency becomes clear.

```java
  //add method definitions below this line
  
  public static String printPlayer(Player p) {
    if (p.health <= 0) {
      return "This player is dead. They died on level " + p.level + " with a score of " + p.score + ".");
    } else {
      return "This player has " + p.health + " health, a score of " + p.score + " and is on level " + p.level + ".";
    }
  }
  
  //add method definitions above this line
```

Now that the `printPlayer` method will return two different strings, call the method when the `player1` object has full health, and call it again when the object has no health.

```java
    //add code below this line

    Player player1 = new Player();
    System.out.println(printPlayer(player1));
    player1.health = 0;
    player1.score += 25;
    player1.level += 1;
    System.out.println(printPlayer(player1));

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/ExternalMethods.java java -cp code/mutability/ ExternalMethods 4)

|||challenge
## Can you:
* Create a function to change a player's health?
<details>
  <summary><strong>One possible solution</strong></summary>
      
  ```java
  public static void changeHealth(Player p, int amount) {
    p.health += amount;
  }
  ```
  
</details><br>

* Create a function to change a player's level?
<details>
  <summary><strong>One possible solution</strong></summary>
  
  ```java
  public static void changeLevel(Player p) {
    p.level += 1;
  }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/ExternalMethods.java java -cp code/mutability/ ExternalMethods 5)

{Check It!|assessment}(multiple-choice-4222575896)
