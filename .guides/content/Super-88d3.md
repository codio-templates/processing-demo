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

## Calling Methods with `super`
