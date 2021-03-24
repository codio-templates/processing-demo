----------

## Method Overloading

Method overloading is another example of polymorphism. Method overloading occurs when you have a single method name that can take different sets of parameters. Imagine you want to write the method `sum` that can sum up to three numbers. The math involved with three parameters is slightly different that two parameters, which is different from 1 parameter, etc. Traditionally, if you declare a method that takes three parameters but only pass two, Java will throw an error message. Instead let's create a class that has two `sum` methods; one with two parameters and another with three parameters.

```java
//add class definitions below this line

class TestClass {
  public int sum(int n1, int n2, int n3) {
    return n1 + n2 + n3;
  }
  
  public int sum(int n1, int n2) {
    return n1 + n2;
  }
}

//add class definitions above this line
```

Create an object of type `TestClass` and call both versions of the `sum` method. Be sure you are passing three arguments for one method and two arguments for the other. 

```java
    //add code below this line

    TestClass tc = new TestClass();
    System.out.println(tc.sum(1, 2, 3));
    System.out.println(tc.sum(1, 2));
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverloading.java java -cp code/polymorphism/ MethodOverloading 1)

Java looks at the number and types of arguments and, as long there is a matching method definition, runs the code without an error. Defining the same method with different sets of arguments is called overloading. It is also an example of polymorphism.

|||challenge
## Try this variation:
* Add on to the `sum` method such that it can take up to five numbers as parameters. Be sure to test all possible method calls.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  //add class definitions below this line

  class TestClass {
    public int sum(int n1, int n2, int n3, int n4, int n5) {
      return n1 + n2 + n3 + n4 + n5;
    }
  
    public int sum(int n1, int n2, int n3, int n4) {
      return n1 + n2 + n3 + n4;
    }
  
    public int sum(int n1, int n2, int n3) {
      return n1 + n2 + n3;
    }

    public int sum(int n1, int n2) {
      return n1 + n2;
    }
    
    public int sum(int n1) {
      return n1;
    }
  }

  //add class definitions above this line
  ```
</details><br>

|||

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverloading.java java -cp code/polymorphism/ MethodOverloading 2)

## Overloading the Constructor

Java will also allow you to overload the constructor so that objects are instantiated in a variety of ways. The `Person` class has a default constructor (no arguments) and a constructor with three arguments.

```java
//add class definitions below this line

class Person {
  private String name;
  private int number;
  private String street;
  
  public Person() {}
  
  public Person(String na, int nu, String s) {
    name = na;
    number = nu;
    street = s;
  }
  
  public String info() {
    return name + " lives at " + number + " " + street + ".";
  }
}

//add class definitions above this line
```

When you create a `Person` object with no arguments, the `info` method still works. That is because Java will use the default values for integers and strings. You can also instantiate an object with three arguments. Like method overloading, constructor overloading is a form of polymorphism.

<details>
  <summary><strong>Default Values</strong></summary>
  Here are the default values for various data types:
  
  |Data Type|Default Value|
  |:-------:|:-----------:|
  |int      |0            |
  |double   |0.0          |
  |String   |null         |
  |boolean  |false        |
  
</details>

```java
    //add code below this line

    Person p1 = new Person();
    Person p2 = new Person("Calvin", 37, "Main Street");
    System.out.println(p1.info());
    System.out.println(p2.info());
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverloading.java java -cp code/polymorphism/ MethodOverloading 3)

|||challenge
## Try these variations:
* Comment out both of the constructors.
```java
//   public Person() {}
  
//   public Person(String na, int nu, String s) {
//     name = na;
//     number = nu;
//     street = s;
//   }
```

Instantiate a `Person` object and call the `info` method.

```java
    //add code below this line

    Person p1 = new Person();
    System.out.println(p1.info());
    
    //add code above this line
```

<details>
  <summary><strong>Why does this work?</strong></summary>
  When you do not declare a constructor, Java will use the default constructor and give each of the attributes their default value.
</details><br>

* Uncomment only the constructor with three arguments.

```java
//   public Person() {}
  
  public Person(String na, int nu, String s) {
    name = na;
    number = nu;
    street = s;
  }
```

Do not make any changes to the object instantiation.

```java
    //add code below this line

    Person p1 = new Person();
    System.out.println(p1.info());
    
    //add code above this line
```

<details>
  <summary><strong>Why is there an error?</strong></summary>
  Java automatically uses the default constructor when there are no constructors defined. If you want to overload the constructor, you must declare the default constructor if you want to instantiate an object without any arguments.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/polymorphism/MethodOverloading.java java -cp code/polymorphism/ MethodOverloading 4)

{Check It!|assessment}(multiple-choice-994634395)
