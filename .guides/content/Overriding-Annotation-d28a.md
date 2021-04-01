----------

## Overriding Annotation

Java allows you to provide an optional annotation when overriding a method. The `@Override` annotation lets the Java compiler know that the following method overrides a method from the superclass. Adding annotations when overriding methods is also helpful when other developers look at your code. Java can flag an issue when method overriding does not work as expected. For example, the class below is supposed to override the `greeting` method, but there is a typo.

```java
//add class definitions below this line

class ClassB extends ClassA {
  public void greting() {
    System.out.println("Hello from Class B");
  }
}

//add class definitions above this line
```

Now create instances of `ClassA` and `ClassB` and call the `greeting` method. You would expect the output to be a greet from each class. However, due to a typo, `ClassB` does not override the `greeting` method. Instead it defines the method `greting`. Java runs the program without a problem, but the output is not correct.

```java
    //add code below this line
  
    ClassA a = new ClassA();
    ClassB b = new ClassB();
    
    a.greeting();
    b.greeting();
  
    //add code above this line  
```

{Try it}(sh .guides/bg.sh javac code/inheritance/OverridingAnnotation.java java -cp code/inheritance/ OverridingAnnotation 1)

If we add the `@Override` annotation to `ClassB`, you will see how Java notices the problem and brings it to your attention. Java expects `ClassB` to override the `greeting` method. Because it does not, the compiler generates an error message. Annotating method overriding helps programmers catch small problems that are otherwise hard to track down.

```java
//add class definitions below this line

class ClassB extends ClassA {
  @Override
  public void greting() {
    System.out.println("Hello from Class B");
  }
}

//add class definitions above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/OverridingAnnotation.java java -cp code/inheritance/ OverridingAnnotation 2)

|||challenge
## Try this variation:
* Fix the typo for the `greeting` method in `ClassB`.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  class ClassB extends ClassA {
    @Override
    public void greeting() {
      System.out.println("Hello from Class B");
    }
  }
  ```
</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/OverridingAnnotation.java java -cp code/inheritance/ OverridingAnnotation 3)

{Check It!|assessment}(fill-in-the-blanks-3981125571)
