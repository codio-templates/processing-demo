----------

## Overriding a Method

Extending a class means adding new attributes or methods to the subclass. Another way to add new functionality to a subclass is through method overriding. Overriding a method means to inherit a method from the superclass, keep its name, but change the contents of the method.

Extend the `Superhero` class by overriding the `sayHello`. Remember, the `name` attribute is part of the superclass, so you need to use the `getName` method to access this attribute.

```java
  public void revealSecretIdentity() {
    System.out.println("My real name is " + secretIdentity + ".");
  }
  
  public void sayNemesis() {
    System.out.println("My nemesis is " + nemesis + ".");
  }

  public void sayHello() {
    System.out.println("My name is " + getName() + ", and criminals fear me.");
  }
```

Instantiate a `Superhero` object and call the `sayHello` method. 

```java
    //add code below this line

    Superhero hero = new Superhero("Storm", 30, "Queen of Wakanda", "Ororo Munroe", "Shadow King");
    hero.sayHello();
    
    //add code above this line 
```

{Try it}(sh .guides/bg.sh javac code/inheritance/OverrideMethod.java java -cp code/inheritance/ OverrideMethod 1)

<details>
  <summary><strong>Differentiating Overriding and Extending</strong></summary>
  The difference between extending and overriding can be slight. Both approaches are used to make a subclass unique from the superclass. Overriding deals with changing a pre-existing method from the superclass, while extending deals with adding new methods and attributes.
</details>

|||challenge
## Try this variation:
* Override the `sayAge` method so that it prints the string:
`Young or old, I will triumph over evil.`
<details><summary><strong>Solution</strong></summary>
Add the following method to the <code>Superhero</code> class:
  
```java
  public void sayAge() {
    System.out.println("Young or old, I will triumph over evil.");
  }
```
  
Call the method to verify it works as expected.

```java
    //add code below this line
  
    Superhero hero = new Superhero("Storm", 30, "Queen of Wakanda", "Ororo Munroe", "Shadow King");
    hero.sayHello();
    hero.sayAge();
  
    //add code above this line 
```

</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/OverrideMethod.java java -cp code/inheritance/ OverrideMethod 2)

## What Happens When You Override a Method?

If you can override a method from the superclass, what happens to the original method? Java defaults to the instance. So `hero.sayHello()` will always use the method from the `Superhero` class. But that does not mean you cannot call `sayHello` from the `Person` class. Just as we used the `super` keyword to access the constructor from the superclass, we can use `super` to invoke `sayHello` from the `Person` class. Add the method `oldHello` to the `Superhero` class. Use `super` followed by the method name to tell Java to look in the `Person` class.

```java
  public void sayHello() {
    System.out.println("My name is " + getName() + ", and criminals fear me.");
  }
  
  public void sayAge() {
    System.out.println("Young or old, I will triumph over evil.");
  }
  
  public void oldHello() {
    super.sayHello();
  }
```

```java
    //add code below this line
  
    Superhero hero = new Superhero("Storm", 30, "Queen of Wakanda", "Ororo Munroe", "Shadow King");
    hero.sayHello();
    hero.oldHello();
  
    //add code above this line 
```

{Try it}(sh .guides/bg.sh javac code/inheritance/OverrideMethod.java java -cp code/inheritance/ OverrideMethod 3)

|||challenge
## Try this variation:
* Add the method `oldAge` to the `Superhero` class and then call it.

<details>
  <summary><strong>Solution</strong></summary>
  Add the following method to the <code>Superhero</code> class.

```java
  public void oldAge() {
    super.sayAge();
  }
```
  
  Call the method to verify the output works as expected.
  
```java
    //add code below this line
  
    Superhero hero = new Superhero("Storm", 30, "Queen of Wakanda", "Ororo Munroe", "Shadow King");
    hero.sayAge();
    hero.oldAge();
  
    //add code above this line  
```

</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/OverrideMethod.java java -cp code/inheritance/ OverrideMethod 4)

{Check It!|assessment}(multiple-choice-1159177153)
