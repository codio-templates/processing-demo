----------

## The `super` Keyword

The `super` keyword is used in the subclass to invoke methods in the superclass. This is how constructors with parameters are called in inheritance. The `Person` class to the left has a constructor without any parameters. Add a second constructor to the `Person` class that has three parameters.

```java
  public Person() {
    name = "Sarah";
    age = 37;
    occupation = "VP Sales";
  }
  
  public Person(String n, int a, String o) {
    name = n;
    age = a;
    occupation = o;
  }
```

By default, Java will call the constructor with no parameters when the `Superhero` object is instantiated. Create a constructor for the `Superhero` class with three parameters. Use the `super` keyword followed by the parameters. Java will pass the parameters to the constructor for `Person` because that is the superclass. You are now able to specify the `name`, `age`, and `occupation` attributes for the subclass.

```java
//add class definitions below this line

class Superhero extends Person {
  public Superhero(String n, int a, String o) {
    super(n, a, o);
  }
}
  
//add class definitions above this line
```

Instantiate a `Superhero` object with a name, age, and occupation. Call the `sayName` and `sayAge` methods to verify that the `Superhero` object has the values `Wonder Woman` and `27` for the `name` and `age` attributes.

```java
    //add code below this line

    Superhero hero = new Superhero("Wonder Woman", 27, "intelligence officer");
    hero.sayHello();
    hero.sayAge();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/Super.java java -cp code/inheritance/ Super 1)

|||challenge
## Try this variation:
Add the following constructor to the `Person` class. 

```java
  public Person(String n) {
    name = n;
    age = 0;
    occupation = "";
  }
```

Create a constructor for the `Superhero` class that will call this new constructor in the superclass.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
    public Superhero(String n) {
      super(n);
    }
  ```
</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/Super.java java -cp code/inheritance/ Super 2)

## Every Class has a Superclass

The `Superhero` class has a superclass because it extends the `Person` class. But what about the `Person` class, does it have a superclass? In Java, every class has a superclass. The code below creates `Person` object. The variable `c` represents the class of the `Person` object, and the variable `sc` represents the superclass of the `Person` object.

```java
    //add code below this line

    Person p = new Person();
    Class c = p.getClass();
    Class sc = c.getSuperclass();
    System.out.println("Class: " + c);
    System.out.println("Superclass: " + sc);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/Super.java java -cp code/inheritance/ Super 3)

The second line of output should be `class java.lang.Object`. That means the `Object` class is the superclass for every object in Java. However, you do not need to declare that a user-defined class extends the `Object` class. Java assumes this automatically.

{Check It!|assessment}(multiple-choice-2940799859)
