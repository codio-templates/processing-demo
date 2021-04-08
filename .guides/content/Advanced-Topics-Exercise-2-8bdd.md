----------

## Exercise 2

You have been given the class `Band`. Extend the class such that it will produce a string representation of a `Band` object.

### Expected Output
Initialize an object of the `Band` class as follows: 

```java
    //add code below this line
    
    String[] members = {"Jerry", "Bob", "Mickey", "Bill", "Phil", "Pigpen"};
    Band dead = new Band("The Grateful Dead", "rock'n roll", members);

    //add code above this line
```

When you print the `dead` object you should see the following output:

```markdown
Band[name=The Grateful Dead, genre=rock'n roll, members=[Jerry, Bob, Mickey, Bill, Phil, Pigpen]]
```

<details>
  <summary><strong>Hint</strong></summary>
  Use the <code>Array.toString()</code> method to convert the <code>members</code> attribute into a string that shows the value of each element.
</details><br>

{Try it}(sh .guides/bg.sh javac code/advanced/exercise2/Exercise2.java java -cp code/advanced/exercise2/ Exercise2 1)

{Check It!|assessment}(test-326602571)
