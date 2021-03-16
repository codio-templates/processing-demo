----------

## Substitution Principle

When one class inherits from another, Java considers them to be related. They may have different data types, Java allows a subclass to be used in place of the superclass. This is called the substitution principle. In the code below, `ClassB` inherits from `ClassA`. Both classes have the `greeting` method which prints a greeting specific to the class.

```java
//add class definitions below this line

class ClassA {
  public void greeting() {
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

According to the substitution principle, an object of `ClassB` can be used in a situation that expects an object of `ClassA`. The `substitution` method explicitly calls for an argument of `ClassA`.

```java
  //add method definitions below this line
  
  public static void substitution(ClassA a) {
    a.greeting();
  }
  
  //add method definitions above this line
```

Instantiate an object of `ClassB` and pass it to the `substitution` method. Even though the object `b` has the wrong data type, the code should still work due to the substitution principle. Because `ClassB` extends `ClassA`, object `b` can be used in place of an object of type `ClassA`. Run the code to verify the output.

```java
    //add code below this line

    ClassB b = new ClassB();
    substitution(b);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/Substitution.java java -cp code/inheritance/ Substitution 1)

|||challenge
## Try this variation:
* Remove the `extends` keyword from the `ClassB` and run the code again.
<details>
  <summary><strong>Why did this produce an error?</strong></summary>
  Deleting <code>extends</code> means that <code>ClassB</code> no longer inherits from <code>ClassA</code>. Therefore, the substitution principle no longer applies. Java now says there is a type mismatch error.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/Substitution.java java -cp code/inheritance/ Substitution 2)

## The Substitution Principle is a One-Way Relationship

Like inheritance hierarchy, the substitution principle is a one-way relationship. Add a third class `ClassC` that inherits from `ClassB`. We now have an inheritance chain that flows from `ClassA` to `ClassB` to `ClassC`. 

```java
//add class definitions below this line

class ClassA {
  public void greeting() {
    System.out.println("Hello from Class A");
  }
}

class ClassB extends ClassA {
  public void greeting() {
    System.out.println("Hello from Class B");
  }
}

class ClassC extends ClassB {
  public void greeting() {
    System.out.println("Hello from Class C");
  }
}

//add class definitions above this line
```

The substitution principle states that the substitution will work with any subclass. Since `ClassB` is a subclass of `ClassA` and `ClassC` is a subclass of `ClassA`, then `ClassC` can be substituted for `ClassA`. Create an object of type `ClassC` and pass it to the `substitution` method. 

```java
    //add code below this line

    ClassC c = new ClassC();
    substitution(c);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/Substitution.java java -cp code/inheritance/ Substitution 3)

Change the method header for `substitution` so that the parameter is of type `ClassB`.

```java
  //add method definitions below this line
  
  public static void substitution(ClassB b) {
    b.greeting();
  }
  
  //add method definitions above this line
```

Now create an object of type `ClassA` and pass it to the `substitution` method. This should now cause an error because the substitution principle no longer applies because the `substitution` expects `ClassB` or a subclass. `ClassA` is a superclass, so it cannot be substituted for `ClassB`.

```java
    //add code below this line

    ClassA a = new ClassA();
    substitution(a);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/Substitution.java java -cp code/inheritance/ Substitution 4)

{Check It!|assessment}(fill-in-the-blanks-2412811547)
