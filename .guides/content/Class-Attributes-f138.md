## Class Attributes

Up until now, the attributes created in the class are independent from one another when new objects are created. These are called object attributes. You can create an instance of the `Actor` class for Helen Mirren and another for Dwayne Johnson. Each object has different values for their attributes. A class attribute, however, is an attribute whose value is shared by each instance of a class.

To illustrate this, add the attribute `static String union` to the `Actor` class. The `static` keyword tells Java that this attribute is a class attribute. Set the value of `union` to the string `"Screen Actors Guid"`. Notice that class attributes are declared and initialized with a value outside of the constructor.

```java
//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
  String birthday;
  int totalFilms;
  int oscarNominations;
  int oscarWins;
  static String union = "Screen Actors Guild";
  
  public Actor(String fn, String ln, String bd, int tf) {
    firstName = fn;
    lastName = ln;
    birthday = bd;
    totalFilms = tf;
    oscarNominations = 0;
    oscarWins = 0;
  }
}
  
//add class definitions above this line
```

Create two instances of the `Actor` class and print the `union` attribute for both instances. Then change the attribute for one instances and print the `union` attribute for both instances.

```java
    //add code below this line

    Actor helen = new Actor("Helen", "Mirren", "July 26", 80);
    Actor dwayne = new Actor("Dwayne", "Johnson", "May 2", 34);
    System.out.println(helen.union);
    System.out.println(dwayne.union);
    helen.union = "Teamsters";
    System.out.println(helen.union);
    System.out.println(dwayne.union);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/ClassAttributes.java java -cp code/introObjects/ ClassAttributes 1)

Because this is a class attribute, the value is shared among all the instances. A change for instance, is a change for all instances.

|||challenge
## Try this variation:
* Remove the keyword `static` and run the code again.

|||

{Try it}(sh .guides/bg.sh javac code/introObjects/ClassAttributes.java java -cp code/introObjects/ ClassAttributes 2)

## Class Attributes as Constants

Changing a class attribute can cause problems for other instances of the same class. That is why class attributes are often created as a constant. Remember, the Java convention for constants is to write the variable name in all caps.

```java
//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
  String birthday;
  int totalFilms;
  int oscarNominations;
  int oscarWins;
  static final String UNION = "Screen Actors Guild";
  
  public Actor(String fn, String ln, String bd, int tf) {
    firstName = fn;
    lastName = ln;
    birthday = bd;
    totalFilms = tf;
    oscarNominations = 0;
    oscarWins = 0;
  }
}
  
//add class definitions above this line
```

Java will now prevent users from changing the value of `UNION`. You should see an error message that Java cannot assign a value to a final variable.

```java
    //add code below this line

    Actor helen = new Actor("Helen", "Mirren", "July 26", 80);
    Actor dwayne = new Actor("Dwayne", "Johnson", "May 2", 34);
    helen.UNION = "Teamsters";

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/ClassAttributes.java java -cp code/introObjects/ ClassAttributes 3)

{Check It!|assessment}(fill-in-the-blanks-359646314)
