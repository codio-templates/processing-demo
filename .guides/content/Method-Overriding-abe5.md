----------

## What is Polymorphism?

Polymorphism is a concept in object-oriented programming in which a single interface takes different forms (polymorphism means "many forms"). Often this means similar operations are grouped together with the same name. However, these operations with the same name will produce different results. You have already encountered a few examples of polymorphism. Enter the following code into the IDE.

```java
    //add code below this line

    int a = 5;
    int b = 10;
    System.out.println(a + b);
    
    String c = "5";
    String d = "10";
    System.out.println(c + d);
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverriding.java java -cp code/polymorphism/ MethodOverriding 1)

Notice how the plus operator can add together two numbers and concatenate two strings. You have a single interface (the plus operator) taking different forms — one that works with integers and and another that works with strings. This is an example of polymorphism.

<details>
  <summary><strong>Operator Overloading</strong></summary>
  Because the plus operator can work with different forms, we can say that it is overloaded. Java overloads this operator by default. However, a user cannot manually overload an operator.
</details>

|||challenge
## Try this variation:
Change your code to look like this:
```java
    //add code below this line

    int a = 5;
    String b = "10";
    System.out.println(a + b);
    
    //add code above this line
```

<details>
  <summary><strong>Why is there an error?</strong></summary>
Polymorphism allows Java to use the plus operator with different data types, but that does not mean that the plus operator can be used with all data types. The example above causes an error message because the plus operator cannot be used with an integer and a string. There are limits to polymorphism.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverriding.java java -cp code/polymorphism/ MethodOverriding 2)

## Method Overriding

Method overriding is another example of polymorphism that you have already seen. Overriding a method means that you have two methods with the same name, but they perform different tasks. Again you see a single interface (the method name) being used with different forms (the superclass and the subclass). Create the following classes.

```java
class Alpha {
  public void show() {
    System.out.println("I am from class Alpha");
  }
}

class Bravo extends Alpha {
  public void show() {
    System.out.println("I am from class Bravo");
  }
}
```

Instantiate an `Alpha` object and call the `show` method.

```java
    //add code below this line

    Alpha testObject = new Alpha();
    testObject.show();
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverriding.java java -cp code/polymorphism/ MethodOverriding 3)

As expected, the script prints `I am from class Alpha`. Now change the line of code in which you instantiate the object `testObject`. Make no other changes and run the code again.

```java
    Bravo testObject = new Bravo();
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverriding.java java -cp code/polymorphism/ MethodOverriding 4)

Now the script prints `I am from class Bravo`. The method call did not change, but the output did. A single interface (the `show` method) works with multiple forms (the `Alpha` and `Bravo` data types). This is why method overriding is an example of polymorphism.

|||challenge
## Try this variation:
* Create and overload the method `hello` that prints `Hello from Alpha` and `Hello from Bravo`. Test the method with both class types.
<details>
  <summary><strong>Solution</strong></summary>

  ```java
  class Alpha {
    public void show() {
      System.out.println("I am from class Alpha");
    }

    public void hello() {
      System.out.println("Hello from Alpha")
    }
  }

  class Bravo extends Alpha {
    public void show() {
      System.out.println("I am from class Bravo");
    }

    public void hello() {
      System.out.println("Hello from Bravo")
    }
  }
  ```

</details>

|||

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverriding.java java -cp code/polymorphism/ MethodOverriding 5)

{Check It!|assessment}(multiple-choice-1767969218)
