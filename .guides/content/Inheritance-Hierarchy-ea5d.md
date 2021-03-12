----------

## Inheritance Hierarchy

You have seen how the `Superhero` class becomes the subclass of the `Person` class though inheritance. The relationship between these two classes is called inheritance (or class) hierarchy. Java has a built-in operator to help you determine the hierarchy of classes.

Start by creating four classes, where `ClassA` is the superclass to `ClassB` and `ClassC` is the superclass to `ClassD`. These classes do not need to do anything, so do not create attributes, a constructor, or methods.

```java
//add class definitions below this line

class ClassA {}
class ClassB extends ClassA {}
class ClassC {}
class ClassD extends ClassC {}

//add class definitions above this line
```

Now, create an instance for each class.

```java
    //add code below this line

    ClassA a = new ClassA();
    ClassB b = new ClassB();
    ClassC c = new ClassC();
    ClassD d = new ClassD();

    //add code above this line
```

The `instanceof` operator returns a boolean when comparing an object and a class. It returns `true` is the object is an instance of a class, and it returns `false` if the object is not an instance of a class. The code below prints the class for object `b` which is `ClassB`. Surprisingly, it also prints `true` when asking if `b` is an instance of `ClassA`. This is because of inheritance. Because `ClassB` inherits from `ClassA`, `b` is considered to be an instance of `ClassA`. 

```java
    //add code below this line

    ClassA a = new ClassA();
    ClassB b = new ClassB();
    ClassC c = new ClassC();
    ClassD d = new ClassD();
    
    System.out.println(b.getClass());
    System.out.println(b instanceof ClassB);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/Hierarchy.java java -cp code/inheritance/ Hierarchy 1)

|||challenge
## Try these variations:
* `System.out.println(d instanceof ClassC);`
* `System.out.println(d instanceof ClassA);`
* `System.out.println(b instanceof ClassB);`

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/Hierarchy.java java -cp code/inheritance/ Hierarchy 2)