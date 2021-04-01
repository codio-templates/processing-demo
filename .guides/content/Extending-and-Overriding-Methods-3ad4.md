----------

## Extending a Class with Multiple Inheritance

Multilevel inheritance has no effect on extending a subclass. The `bonjour` method is not present in either superclass. There is no need for special syntax to extend `ClassC`. Extending a class works just like it does for single inheritance.

```java
//add class definitions below this line

class ClassC extends ClassB {
  public void bonjour() {
    System.out.println("Bonjour");
  }  
}

//add class definitions above this line
```

Instantiate a `ClassC` object and call the `bonjour` method.

```java
    //add code below this line
  
    ClassC c = new ClassC();
    c.bonjour();
  
    //add code above this line 
```

{Try it}(sh .guides/bg.sh javac code/inheritance/MultilevelExtendOverride.java java -cp code/inheritance/ MultilevelExtendOverride 1)

|||challenge
## Try this variation:
* Extend `ClassC` with the method `goodbye` that prints `Goodbye`. Then call this method.
<details>
  <summary><strong>Solution</strong></summary>
  
```java
//add class definitions below this line

class ClassC extends ClassB {
  public void bonjour() {
    System.out.println("Bonjour");
  }
  
  public void goodbye() {
    System.out.println("Goodbye");
  }
}

//add class definitions above this line
```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/MultilevelExtendOverride.java java -cp code/inheritance/ MultilevelExtendOverride 2)

## Overriding a Method with Multiple Inheritance

Like extending a class, overriding a method works the same in multilevel inheritance as it does in single inheritance. Override the `hello` method so that it prints a message.

```java
//add class definitions below this line

class ClassC extends ClassB {  
  public void hello() {
    System.out.println("Hello from Class C");
  }  
}
 
//add class definitions above this line
```

Now call the `hello` method.

```java
    //add code below this line
  
    ClassC c = new ClassC();
    c.hello();
  
    //add code above this line 
```

{Try it}(sh .guides/bg.sh javac code/inheritance/MultilevelExtendOverride.java java -cp code/inheritance/ MultilevelExtendOverride 3)

{Check It!|assessment}(fill-in-the-blanks-154590934)
