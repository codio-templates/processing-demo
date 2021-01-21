----------

## Defining an Object

Assume you want to collect information about actors. Creating a class is a good way to keep this data organized. The `class` keyword is used to define a class. For now, use `pass` as the body of the class. Declaring a class does not doing anything on its own, so print `Actor`.

```java
//add class definitions below this line
    
class Actor {
  
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

The point of having a class is to collect information and define actions that can modify the data. The `Actor` class should contain things like the name of the actor, notable films, awards they have won, etc. These pieces of information related to a class are called attributes. You access the attributes by using dot notation, which is ` type objectName.attribute;`. Attributes are declared when creating the class. The example below adds the `firstName` and `lastName` attributes which are both strings. Adding an attribute is done with the assignment operator, `objectName.attribute = attributeValue`. Object attributes can be treated like any other variable. 

```java
//add class definitions below this line
    
class Actor {
  String firstName;
  String lastName;
}  
  
//add class definitions above this line
```

Adding an attribute is done with the assignment operator, `objectName.attribute = attributeValue`. Object attributes can be treated like any other variable. Add the following code to the `main` method.

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
* Add the print statement `print(helen.first_name.upper(), helen.last_name.lower())`
* Add the attribute `total_films` with the value of `80`
* Add the attribute `notable_films` with the value of `["The Queen", "The Madness of King George", "Gosford Park"]`
* Add the print statement `print(helen)`

|||

{Try it}(sh .guides/bg.sh javac code/introObjects/UserDefined.java java -cp code/introObjects/ UserDefined 4)

<details>
  
  <summary><strong>What is all that gibberish after <code>at</code>?</strong></summary>All of that gibberish is the location in your computer's memory where the object is being stored.
  
</details>