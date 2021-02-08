----------

## Class Methods

Back in the introduction to classes and objects lesson, a class was defined as "a collection of data and the actions that can modify the data." The constructor built the "collection of data", but nothing in the class modified the data. Instead, external methods were used to modify the object.

Instead of external methods, class methods should be used to modify an object. Think of a class method as a method that is attached to an object. The class method is the most common type of method. Notice how class methods are declared inside of the class. The keyword `self` is used to represent the instance being modified by the method. These methods are called instance methods because they have access to the instance variables (the attributes declared in the constructor). Methods are invoked using dot-notation.

![Functions vs Methods](.guides/img/mutability/functions-vs-methods.png)

When mutability was first introduced, you made a `Player` class with a few functions. You are now going to transform these functions into methods. The `Player` class will be defined just as before. This time, however, `printPlayer` will be a part of class (indented to match the constructor), `self` replaces `p` to represent the `Player` object being modified, and the method is called using dot-notation.

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
      
mario = new Player();
mario.printPlayer();
```

{Try it}(sh .guides/bg.sh javac code/mutability/Mutability.java java -cp code/mutability/ Mutability 1)

|||challenge
## Try this variation:
Call `print_player` like this?
```python
mario = Player()
print_player(mario)
```

<details>
  <summary><strong>Why did this generate an error?</strong></summary>
  Python says that <code>print_player</code> is not defined even though the definition is on line 8. Because nothing comes before <code>print_player</code>, Python assumes that this is a function. However, <code>print_player</code> is indented inside the <code>Player</code> class, which means it is a method. Methods must be called with dot-notation like <code>mario.print_player()</code>.
</details>

|||

{try it}(python3 code/mutability/methods1.py 2)

## More Player Methods

The next methods to add to the `Player` class are those to print the `health` and `level` of the `Player` instance. Start with the method `change_health`. This method takes `self` and the `amount` of change as parameters. `change_health` will add `amount` to the `health` attribute. If a player's health increases, `amount` is positive. If their health decreases, `amount` is negative. Remember, make sure `change_health` is indented so that it is a part of the `Player` class.

```python
  def change_health(self, amount):
    """Change a player's health"""
    self.health += amount
```

{try it}(python3 code/mutability/methods1.py 3)

The method `change_level` is going to be similar to `change_health` except for one difference. `change_level` only needs one parameter, `self`. In video games, players go up in levels; rarely do they decrease. So the `level` attribute will increase by one when the method is called. This method also needs to be indented so it is a part of the `Player` class.

```python
  def change_level(self):
    """Change a player's level"""
    self.level += 1
```

{try it}(python3 code/mutability/methods1.py 4)

|||challenge
## Try these variations:
* Call `change_health` and `chagne_level` for `mario`, and then print the player to make sure the methods work.
<details>
  <summary><strong>One possible solution</strong></summary>
  
  ```python
  mario = Player()
  mario.print_player()
  mario.change_health(-10)
  mario.change_level()
  mario.print_player()
  ```
  
</details><br>

* Create a method to change a player's score?
<details>
  <summary><strong>One possible solution</strong></summary>
  
  ```python
  def change_score(self, amount):
    """Change a player's score"""
    self.score += amount
  ```
  
</details>

|||

{try it}(python3 code/mutability/methods1.py 5)

<details>
  <summary><strong>Why learn about external methods that modify objects when Java has class methods?</strong></summary>
  It might seem like a waste of time to learn how to write functions that modify objects. But this approach builds upon concepts you have already seen — functions and objects. This allows you to understand mutability without having to worry about methods. Once you understand how these ideas work, transforming a function into a method is much simpler. Functions that modify objects serve as an intermediary step on the way to learning about methods.
</details>


