----------

## The Constructor and Parameters

Now imagine that you want to use the `Actor` class to instantiate an object for Helen Mirren and Tom Hanks. Create the `Actor` class just as before.

```java
//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
  String birthday;
  int totalFilms;
  int oscarNominations;
  int oscarWins;
  
  public Actor() {
    firstName = "Helen";
    lastName = "Mirren";
    birthday = "July 26";
    totalFilms = 80;
    oscarNominations = 4;
    oscarWins = 1;
  }
}
  
//add class definitions above this line
```

Now instantiate two `Actor` objects, one for Helen Mirren and the other for Tom Hanks. Print the `fistName` and `lastName` attributes for each object.

```java
    //add code below this line

    Actor helen = new Actor();
    Actor tom = new Actor();
    System.out.println(helen.firstName + " " + helen.lastName);
    System.out.println(tom.firstName + " " + tom.lastName);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/ConstructorParameters.java java -cp code/introObjects/ ConstructorParameters 1)

The constructor `Actor` class only creates an object with information about Helen Mirren. You can make the `Actor` class more flexible by passing it an argument for each of attributes in the constructor. Parameters for the constructor method work just as they do for user-defined methods, be sure to indicate the data type for each parameter.

```java
//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
  String birthday;
  int totalFilms;
  int oscarNominations;
  int oscarWins;
  
  public Actor(String fn, String ln, String bd, int tf, int on, int ow) {
    firstName = fn;
    lastName = ln;
    birthday = bd;
    totalFilms = tf;
    oscarNominations = on;
    oscarWins = ow;
  }
}
  
//add class definitions above this line
```

When you instantiate the two `Actor` objects, you can pass the constructor the relevant information for both Helen Mirren and Tom Hanks. The code should now print the correct first and last names.

```java
    //add code below this line

    Actor helen = new Actor("Helen", "Mirren", "July 26", 80, 4, 1);
    Actor tom = new Actor("Tom", "Hanks", "July 9", 76, 5, 2);
    System.out.println(helen.firstName + " " + helen.lastName);
    System.out.println(tom.firstName + " " + tom.lastName);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/ConstructorParameters.java java -cp code/introObjects/ ConstructorParameters 2)


|||challenge
## Try these variations:
* Create an instance of the `Actor` class for Denzel Washington (December 28, 47 films, 8 nominations, 2 wins)
* Print the `birthday` and `totalFilms` attributes for the newly created object

<details>
  <summary><strong>Code</strong></summary>
  Your code for the object representing Denzel Washington should look something like this:
  
  ```java
      //add code below this line

      Actor denzel = new Actor("Denzel", "Washington", "December 28", 47, 8, 2);
      System.out.println(denzel.birthday);
      System.out.println(denzel.totalFilms);

      //add code above this line
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/introObjects/ConstructorParameters.java java -cp code/introObjects/ ConstructorParameters 3)

{Check It!|assessment}(multiple-choice-3801306128)
