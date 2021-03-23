----------

## Overriding Annotation

In Java, you can override any public method from the superclass. The code below overrides the `greeting` method. But what if you do not want another user to override a method from your class? The `final` keyword will keep users from overriding a method. Notice how the `greeting` method in `ClassA` uses `final`. Copy and paste this code into the IDE and run it.

```java
//add class definitions below this line

class ClassA {
  public final void greeting() {
    System.out.println("Hello from Class A");
  }
}

class ClassB extends ClassA {
  public void greeting() {
    System.out.println("Hello from Class B");
  }
}

//add class definitions above this line
```

Instantiate an object of type `ClassB` and call the `greeting` method. This code will not work. Java says that you cannot override a method that uses `final`.

```java
    //add code below this line
  
    ClassB b = new ClassB();
    b.greeting();
  
    //add code above this line  
```

{Try it}(sh .guides/bg.sh javac code/inheritance/ProhibitOverriding.java java -cp code/inheritance/ ProhibitOverriding 1)

Normally, you would override `greeting` and then use the `super` keyword to access this method in the superclass. Using `final` makes this impossible. Instead of trying to override `greeting`, create the method `greeting2` in `ClassB`. 

```java
//add class definitions below this line

class ClassA {
  public final void greeting() {
    System.out.println("Hello from Class A");
  }
}

class ClassB extends ClassA {
  public void greeting2() {
    System.out.println("Hello from Class B");
  }
}

//add class definitions above this line
```

Call both `greeting` and `greeting2` with the `b` object. The program should run and print two different greetings.

```java
    //add code below this line
  
    ClassB b = new ClassB();
    b.greeting();
    b.greeting2();
  
    //add code above this line 
```

{Try it}(sh .guides/bg.sh javac code/inheritance/ProhibitOverriding.java java -cp code/inheritance/ ProhibitOverriding 2)

{Check It!|assessment}(parsons-puzzle-2513308691)
