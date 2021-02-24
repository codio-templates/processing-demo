----------

## What is Encapsulation?

Encapsulation is a concept in which related data and methods are grouped together, and in which access to data is restricted. Grouping related data and methods makes thinking about your program a bit easier. Hiding or restricting how the user interacts with the data can keep the user from making unwanted changes. 

The two main ideas of data restriction are public and private. These adjectives can refer to classes, methods, and attributes. Public means that the constructors, methods, or attributes can be accessed by an instance of a class. Private means that the constructor, attribute, or method can only be accessed by the class itself.

## Classes as Encapsulation

Classes in Java are a form of encapsulation; they group together related data and methods. In the image below, the attributes `num1` and `num2` are grouped together with the methods `describe` and `sum`. They are all a part of `ExampleClass` (highlighted in red). The instance `myExample` is not a part of the class itself; it is considered to be separate.

![Classes as Encapsulation](.guides/img/encapsulation/java-encapsulation.png)

## Hiding Data

Up until now, we have been creating classes without using `public` or `private` keywords. That means we have not fully implemented encapsulation because we did not put any restrictions on accessing the class. From now on, **all** classes will use `public` and `private` keywords. The chart below gives a brief overview of when to use each keyword.

|Category   |Public|Private|
|:----------|:----:|:-----:|
|Constructor|X     |       |
|Methods    |X     |X      |
|Attributes |      |X      |

<details>
  <summary><strong>Why are methods both public and private?</strong></summary>
  In the pages that follow, you will see when making methods public is a good idea, and when keeping methods private is preferable. A well designed program will use a mix of public and private methods.
</details><br>

This is the `ExampleClass` from the image above. It now uses the `public` and `private` keywords to hide data.

```java
//add class definitions below this line
    
public class ExampleClass {
  private int num1;
  private int num2;

  public ExampleClass(int n1, int n2) {
    num1 = n1;
    num2 = n2;
  }

  public String describe() {
    return ("My numbers are: " + num1 + " and " + num2);
  }

  public int sum() {
    return num1 + num2;
  }
}
  
//add class definitions above this line
```

Now instantiate an object of the `ExampleClass` and call the `describe` and `sum` methods. Run the program.

```java
    //add code below this line

    ExampleClass myExample = new ExampleClass(5, 7);
    System.out.println(myExample.describe());
    System.out.println(myExample.sum());

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/Encapsulation.java java -cp code/encapsulation/ Encapsulation 1)

Your code should run fine because the instance is only interacting with `public` information. Now try to print the values for the `num1` and `num2` attributes.

```java
    //add code below this line

    ExampleClass myExample = new ExampleClass(5, 7);
    System.out.println(myExample.num1);
    System.out.println(myExample.num2);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/Encapsulation.java java -cp code/encapsulation/ Encapsulation 2)

Java produces an error message because an instance cannot directly access a `private` attribute. This is an example of hiding data. The `myExample` cannot print `num1` or `num2` because they are private. However, `myExample` can access the public methods, which then access the private attributes.

|||challenge
## Try this variation:
* Create the methods `printNum1` and `printNum2` that print the `num1` and `num2` attributes.

<details>
  <summary><strong>Possible Solution</strong></summary>
  
  ```java
    public void printNum1() {
     System.out.println(num1);
    }
  
    public void printNum2() {
      System.out.println(num2);
    }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/encapsulation/Encapsulation.java java -cp code/encapsulation/ Encapsulation 3)

{Check It!|assessment}(multiple-choice-2390758956)
