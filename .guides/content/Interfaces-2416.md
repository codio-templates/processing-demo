----------

## Interfaces

Interfaces are similar to abstract classes in that they cannot be instantiated and methods must be defined by subclasses. However, interfaces force the user to implement (write code for) all of the methods. The `Dog` interface is defined in the IDE to the left. Notice that there is no access modifier for the `bark` method. Methods in an interface are designed to be used by other classes, so they are public by default. There is no need to add the `public` access modifier.

To use an interface, create a class with the `implements` keyword. The `Chihuahua` class **must** override the `bark` method. Be sure to use the `public` keyword so objects can call the method.

```java
//add class definitions below this line

class Chihuahua implements Dog {
  public String bark() {
    return "woof woof";
  }
}
 
//add class definitions above this line
```

Instantiate a `Chihuahua` object and print the output of the `bark` method.

```java
    //add code below this line

    Chihuahua c = new Chihuahua();
    System.out.println(c.bark());

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/Interfaces.java java -cp code/advanced/ Interfaces 1)

|||challenge
## Try this variation:
* Comment out the definition for the `bark` method in the `Chihuahua` class.

```java
//add class definitions below this line

class Chihuhua implements Dog {
//   public String bark() {
//     return "woof woof";
//   }
}
 
//add class definitions above this line
```

<details>
  <summary><strong>Why does this cause an error?</strong></summary>
  The <code>Dog</code> interface requires that classes override the <code>bark</code> method. Since the method is commented out, Java throws an error.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/advanced/Interfaces.java java -cp code/advanced/ Interfaces 2)

## Extending a Class and Implementing an Interface

Another benefit to interfaces is the ability to inherit from a class as well as implement an interface. For example, some people consider their pets to be a member of their family. Create the `FamilyMember` class with attributes for `name` and `age` and the `info` method. Then have the `Chihuahua` class extend the `FamilyMember` class and implement the `Dog` class.

```java
//add class definitions below this line

class FamilyMember {
  private String name;
  private int age;
  
  public FamilyMember(String n, int a) {
    name = n;
    age = a;
  }
  
  public String info() {
    return String.format("%s is %d years old.", name, age);
  }
}

class Chihuahua extends FamilyMember implements Dog {
  public Chihuahua(String name, int age) {
    super(name, age);
  }
  
  public String bark() {
    return "woof woof";
  }
}
 
//add class definitions above this line
```

```java
    //add code below this line

    Chihuahua c = new Chihuahua("Henry", 5);
    System.out.println(c.bark());
    System.out.println(c.info());

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/Interfaces.java java -cp code/advanced/ Interfaces 3)

|||challenge
## Try This Variation:
* Create the `movieStar` interface with the `movieDetails` method. Modify the `Chihuahua` class so that it extends the `FamilyMember` class and implements the `Dog` and `MovieStar` interfaces. Add the `film` and `revenue` attributes to help with overriding the `movieDetails` method.
```java
//add class definitions below this line

interface MovieStar {
  String movieDetails();
}

class FamilyMember {
  private String name;
  private int age;
  
  public FamilyMember(String n, int a) {
    name = n;
    age = a;
  }
  
  public String info() {
    return String.format("%s is %d years old.", name, age);
  }
}

class Chihuahua extends FamilyMember implements Dog, MovieStar {
  private String film;
  private String revenue;
  
  public Chihuahua(String n, int a, String f, String r) {
    super(n, a);
    film = f;
    revenue = r;
  }
  
  public String bark() {
    return "woof woof";
  }
  
  public String movieDetails() {
    return String.format("The move %s grossed %s worldwide.", film, revenue);
  }
}
 
//add class definitions above this line
```

Change the instantiation of the `Chihuahua` object so that the new arguments are passed to the constructor. Then call the `movieDetails` method.

```java
    //add code below this line

    Chihuahua c = new Chihuahua("Henry", 5, "Beverly Hills Chihuahua", "$149,281,606");
    System.out.println(c.bark());
    System.out.println(c.info());
    System.out.println(c.movieDetails());

    //add code above this line
```

|||

{Try it}(sh .guides/bg.sh javac code/advanced/Interfaces.java java -cp code/advanced/ Interfaces 4)

## Interface vs Abstract Class

You may have noticed that there are many similarities between interfaces and abstract classes. The table below highlights some of the similarities and differences.

|Category|Abstract Class|Interface|
|--------|--------------|------------|
|**Keyword:**|`extends`|`implements`|
|**Inheritance:**|Extend one superclass|Can extend a superclass and implement an interface|
|**Access Modifier:**|Use `public`, `private`, and/or `abstract`|All methods are `public` by default, no need to use an access modifier|
|**Implementation:**|Must override `abstract` methods|Must override **all** methods|

With these concepts being so much alike, how do you know when to use one or the other? First, we need to understand two words: behavior and implementation. Behavior means the name but not the code of a method, while implementation means pre-written code for a method. Abstract classes allow for behavior (abstract methods) **and** implementation (concrete methods). Interfaces, however, only allow for behavior. You cannot create a concrete method in an interface. So if you want to define only behavior, use an interface. If you want to define behavior and implementation, use an abstract class.

{Check It!|assessment}(fill-in-the-blanks-2980100207)
