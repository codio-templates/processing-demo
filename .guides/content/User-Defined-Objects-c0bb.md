----------

## Defining an Object

Assume you want to collect information about actors. Creating a class is a good way to keep this data organized. The `public` and `class` keywords are used to define a class. For now, do not add anything as the body of the class.

```java
//add class definitions below this line
    
public class Actor {
  
}  
  
//add class definitions above this line
```

<details>
  
  <summary><strong>Naming classes</strong></summary>The convention for naming classes in Java is to use a capital letter. A lowercase letter will not cause an error message, but it is not considered to be "correct". If a class has a name with multiple words, all of the words are pushed together, and a capital letter is used for the first letter of each word. This is called camel case.
  
</details><br>

Classes are just the blueprint. To you use a class, you need to instantiate an object. Here is an object to represent Helen Mirren. Be sure to put this code in the `main` method.

```java
    //add code below this line

    Actor helen = new Actor();
    System.out.println(helen.getClass());

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/UserDefined.java java -cp code/introObjects/ UserDefined 1)

So you now have `helen`, which is an instance of the `Actor` class.

## Adding Attributes

The point of having a class is to collect information and define actions that can modify the data. The `Actor` class should contain things like the name of the actor, notable films, awards they have won, etc. These pieces of information related to a class are called attributes. Attributes are declared in the class itself. The example below adds the `firstName` and `lastName` attributes which are both strings. 
```java
//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
}  
  
//add class definitions above this line
```

You can change the value of an attribute with the assignment operator, `objectName.attribute = attributeValue`. Notice that you always use `objectName.attribute` to reference an attribute. This is called dot notation. Once an attribute has a value, you can treat it like any other variable. Add the following code to the `main` method. You are assigning values to the attributes `fistName` and `lastName`, and then printing these values.

```java
    //add code below this line

    Actor helen = new Actor();
    helen.firstName = "Helen";
    helen.lastName = "Mirren";
    System.out.println(helen.firstName + " " + helen.lastName);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/UserDefined.java java -cp code/introObjects/ UserDefined 2)

|||challenge
## Try these variations:
* Change the print statement to:
```java
System.out.println(helen.firstName.toUpperCase() + " " + helen.lastName.toLowerCase());
```
* Add the attribute `totalFilms` and assign it the value `80`
* Add the print statement `System.out.println(helen);`

<details>
  <summary><strong>Code</strong></summary>
  
  You may have noticed that printing the object `helen` returns `Actor@` followed a series of numbers and letters. Java is telling you that `helen` is an object of class `Actor` and the numbers and letters represent the object's location in memory.
  
  ```java
  import java.lang.Class;

  //add class definitions below this line

  class Actor {
    String firstName;
    String lastName;
    int totalFilms;
  }  

  //add class definitions above this line

  public class UserDefined {  
    public static void main(String[] args) {

      //add code below this line

      Actor helen = new Actor();
      helen.firstName = "Helen";
      helen.lastName = "Mirren";
      helen.totalFilms = 80;
      System.out.println(helen.firstName.toUpperCase() + " " + helen.lastName.toLowerCase());
      System.out.println(helen.totalFilms);
      System.out.println(helen);

      //add code above this line
    }
  }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/introObjects/UserDefined.java java -cp code/introObjects/ UserDefined 4)

{Check It!|assessment}(multiple-choice-2424555517)
