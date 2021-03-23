----------

## Determining Inheritance Hierarchy

You can use the `instanceof` operator to determine inheritance hierarchy with multilevel inheritance just like you can with single inheritance. Create the following classes.

```java
//add class definitions below this line

class ClassA {}
class ClassB extends ClassA {}
class ClassC {}
class ClassD extends ClassB {}
 
//add class definitions above this line
```

Now instantiate an object of type `ClassD`. Use the `instanceof` operator to determine the objects inheritance hierarchy. The program should print `true` twice because `ClassD` is a subclass of both `ClassA` and `ClassB` due to multilevel inheritance.

```java
    //add code below this line
  
    ClassD d = new ClassD();
    System.out.println(d instanceof ClassA);
    System.out.println(d instanceof ClassB);
  
    //add code above this line  
```

{Try it}(sh .guides/bg.sh javac code/inheritance/MultilevelHierarchy.java java -cp code/inheritance/ MultilevelHierarchy 1)

|||challenge
## Try this variation:
* Change a print statement to:
```java
    System.out.println(d instanceof ClassC);
```

<details>
  <summary><strong>Why is this false?</strong></summary>
  <code>ClassC</code> is not a part of the same inheritance chain as <code>ClassD</code>. That is, <code>ClassC</code> is not a superclass to object <code>d</code>.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/MultilevelHierarchy.java java -cp code/inheritance/ MultilevelHierarchy 2)

## Overriden Methods in the Superclasses

We talked about the ambiguity problem when superclasses of different types have a method with the same name. Java does not know which one to call. With multilevel inheritance, however, this problem does not exist. The code below shows an inheritance chain where `Child` inherits from `Grandparent` and `Parent`. Both `Grandparent` and `Parent` have a method called `hello`.

```java
//add class definitions below this line

class Grandparent {
  public void hello() {
    System.out.println("Hello from the Grandparent class");
  }
}

class Parent extends Grandparent {
  public void hello() {
    System.out.println("Hello from the Parent class");
  }
}

class Child extends Parent {}

//add class definitions above this line
```

Instantiate an object of type `Child` and call the `hello` method. Java prints `Hello from the Parent class`. Why? How come the ambiguity problem does not exist? When `Parent` declares the `hello` method, it overrides the `hello` method from `Grandparent`. Therefore Java uses the overriden method from `Parent` and not the method from `Grandparent`.

```java
    //add code below this line
  
    Child c = new Child();
    c.hello();
  
    //add code above this line 
```

{Try it}(sh .guides/bg.sh javac code/inheritance/MultilevelHierarchy.java java -cp code/inheritance/ MultilevelHierarchy 3)

Now imagine all three class have a `hello` method and that we want to access all of them from `Child`. This is possible as long as you use the `super` keyword. However, when an object of type `Child` uses `super` it is referencing `Parent`. In order for `Child` to invoke an overriden method in `Grandparent`, then `Parent` must also use the `super` keyword.

```java
//add class definitions below this line

class Grandparent {
  public void hello() {
    System.out.println("Hello from the Grandparent class");
  }
}

class Parent extends Grandparent {
  public void hello() {
    System.out.println("Hello from the Parent class");
  }
  
  public void parentHello() {
    super.hello();
  }
}

class Child extends Parent {
  public void hello() {
    System.out.println("Hello from the Child class");
  }
  
  public void parentHello() {
    super.hello();
  }
  
  public void grandparentHello() {
    super.parentHello();
  }
}

//add class definitions above this line
```

Instantiate a `Child` object and call each of its three methods. You should see a message from the `Child`, `Parent`, and `Grandparent` classes.

```java
    //add code below this line
  
    Child c = new Child();
    c.hello();
    c.parentHello();
    c.grandparentHello();
  
    //add code above this line 
```

{Try it}(sh .guides/bg.sh javac code/inheritance/MultilevelHierarchy.java java -cp code/inheritance/ MultilevelHierarchy 4)

{Check It!|assessment}(fill-in-the-blanks-1778577812)
