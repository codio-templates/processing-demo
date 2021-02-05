----------

## Too Much Code

Imagine that the `Actor` class has more attributes than on the previous page.

```java
//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
  String birthday;
  int totalFilms;
  int oscarNominations;
  int oscarWins;
}
  
//add class definitions above this line
```

Now create a object for Helen Mirren with values for each attribute. Adding each attribute individually requires several lines of code. This is especially true if you more than one instance of the `Actor` class.

```java
    //add code below this line

    Actor helen = new Actor();
    helen.firstName = "Helen";
    helen.lastName = "Mirren";
    helen.birthday = "July 26";
    helen.totalFilms = 80;
    helen.oscarNominations = 4;
    helen.oscarWins = 1;
    System.out.println(helen.firstName + " " + helen.lastName);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/Constructor.java java -cp code/introObjects/ Constructor 1)

The class `Actor` creates a class and its attributes. It does not assign value to any attributes; the user has to do this. A class is suppose to be a blueprint. It should lay out all of the attributes and their values for the user. Classes can do this when you use the constructor.

## The Constructor

The constructor is a special method for a class. Its job is to assign value for attributes associated with the object. These attributes can also be called instance variables. In Java, the constructor is the keyword `public`, the class name, followed by parentheses and curly brackets. Inside of the constructor, give attributes their values.

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

Instantiating `helen` as an instance of the `Actor` class automatically calls the constructor. Since the instance variables (attributes) have values, you can remove those lines of code from the `main` method.

```java
    //add code below this line

    Actor helen = new Actor();
    System.out.println(helen.firstName + " " + helen.lastName);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/Constructor.java java -cp code/introObjects/ Constructor 2)

|||challenge
## Try these variations:
* Add this print statement to the `main` method:
```java
System.out.println(helen.firstName + " " + helen.lastName + "\'s birthday is " + helen.birthday);
```
* Add this print statement to the `main` method:
```java
System.out.println(helen.firstName + " " + helen.lastName + " won " + helen.oscarWins + " Oscar out of " + helen.oscarNominations + " nominations");
```

|||

{Try it}(sh .guides/bg.sh javac code/introObjects/Constructor.java java -cp code/introObjects/ Constructor 3)

{Check It!|assessment}(multiple-choice-2364413442)
