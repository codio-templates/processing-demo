----------

## Independence From Objects

Another unique characteristic of static methods is that they do not require the instantiation of an object before you can use them. Take a look at the `Car` class. It has some instance attributes, a constructor, and the static method `honk`.

```java
//add class definitions below this line

class Car {
  String make;
  String model;
  String color;
  
  Car(String ma, String mo, String co) {
    make = ma;
    model = mo;
    color = co;
  }
  
  static void honk() {
    System.out.println("Beep! Beep!");
  }
}
 
//add class definitions above this line
```

In the `main` method, **do not** instantiate a `Car` object. Instead, call the `honk` method from the class.

```java
    //add code below this line

    Car.honk();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/Independent.java java -cp code/mutability/ Independent 1)

This works because `honk` is a static method. If you remove the `static` keyword from the method definition, your program will not compile. You have used several static methods several times up to now. Type casting between different data types is often done with static methods.

* `String.valueOf(20)` - This static method returns the string representation of integer 20.
* `Integer.parseInt("20")` - This static method returns the integer representation of the string "20".
* `Double.valueOf(20)` - This static method returns the double representation of the integer 20. 

|||challenge
## Try this variation:
The `Math` class is full of static methods. Using the Java [documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html) for the `Math` class, see if you can write code using static methods that do the following things:

* Prints the largest number between `17` and `142`
* Prints the absolute value of `-2.34`
* Prints `3` to the power of `5`
* Prints the cosine of `34.1`
* Prints a random number between 0 and 1

<details>
  <summary><strong>Code</strong></summary>
  Here are the static methods:
  
  ```java
      System.out.println(Math.max(17, 142));
      System.out.println(Math.abs(-2.34));
      System.out.println(Math.pow(3, 5));
      System.out.println(Math.cos(34.1));
      System.out.println(Math.random());
  ```
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/Independent.java java -cp code/mutability/ Independent 2)
  
## Limits of Static Methods
  
Because static methods are independent from objects, that means that static methods cannot directly access instance attributes of an object. Add the following static method to the `Car` class.

```java
  static void describe() {
    System.out.println(color + " " + make + " " + model);
  }
```

Now call this method from the `Car` class as before. **Important**, running this code will cause an error. Java says that a non-static variable (instance attribute) cannot be referenced from a static context. That is, the static method `describe` cannot directly access the `color`, `make`, or `model` instance attributes of the `Car` class.

```java
    //add code below this line

    Car.describe();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/Independent.java java -cp code/mutability/ Independent 3)

The way to avoid these types of errors is to pass a `Car` object to the `describe` method. Static methods can indirectly access instance attributes through an instance of the class. Change the `describe` method so that it has a `Car` object as a parameter. `describe` can now access the instance attributes by referencing the object name and the attribute using dot notation.

```java
  static void describe(Car c) {
    System.out.println(c.color + " " + c.make + " " + c.model);
  }
```

Instantiate an instance of the `Car` class, and then pass this instance to the `describe` method. Java should run the code without an error.

```java
    //add code below this line

    Car myCar = new Car("Honda", "Accord", "red");
    Car.describe(myCar);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/Independent.java java -cp code/mutability/ Independent 4)

{Check It!|assessment}(fill-in-the-blanks-3303739284)

