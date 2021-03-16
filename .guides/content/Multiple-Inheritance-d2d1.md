----------

## Multiple Inheritance

Multiple inheritance is a condition where a class inherits from more than one superclass. Java, however, does not allow multiple inheritance if the superclasses are of different types. The image below shows `ClassA` and `ClassB` being of different types. This causes an error message. 

![Multiple Superclasses](.guides/img/inheritance/multiple_superclasses.png)

Java prohibits this kind of multiple inheritance because there is an ambiguity problem. Assume that both `ClassA` and `ClassB` have the method `greeting`. If an object of `ClassC` invokes the `greeting` method, which one does Java use? The one from `ClassA` or the one from `ClassB`? This is why a class cannot have more than one superclass of a different type.

## Multilevel Inheritance

Another form of multiple inheritance is called multilevel inheritance. That is a condition where a class inherits from more than one superclass, but each superclass is the same type. The image below shows `ClassC` inheriting from `ClassB`, which in turn inherits from `ClassA`. This is allowed in Java.

![Multilevel Inheritance](.guides/img/inheritance/inheritance_hierarchy2.png)

The classes `Carnivore` and `Dinosaur` are already defined. `Carnivore` is the superclass for `Dinosaur`. Create the `Tyrannosaurus` class which is a subclass for `Dinosaur`. The constructor for `Tyrannosaurus` takes a string and two doubles, and it calls the constructor from the `Dinosaur` class.

```java
//add class definitions below this line

class Tyrannosaurus extends Dinosaur {
  public Tyrannosaurus(String d, double s, double w) {
    super(d, s, w);
  }
}

//add class definitions above this line
```

Instantiate a `Tyrannosaurus` object with the appropriate arguments. This t-rex `tiny` is 12 meters tall, weighs 14 metric tons, and eats whatever it wants. Print one of the attributes to make sure inheritance is working as expected.

```java
    //add code below this line
  
    Tyrannosaurus tiny = new Tyrannosaurus("whatever it wants", 12, 14);
    System.out.println(tiny.getSize());
  
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/MultipleInheritance.java java -cp code/inheritance/ MultipleInheritance 1)

|||challenge
## Try these variations:
* Print the `weight` attribute
* Print the `diet` attribute

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/MultipleInheritance.java java -cp code/inheritance/ MultipleInheritance 2)

{Check It!|assessment}(multiple-choice-1007431142)
