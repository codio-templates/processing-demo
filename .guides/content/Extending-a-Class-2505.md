----------

## Extending the Constructor

The idea of inheritance is to borrow from a superclass and then add on functionality. Up until now, we have talked about borrowing from a superclass. The process of adding functionality to a subclass is known as either extending or overriding. Extending a class means that new attributes and methods are given to the subclass.

![Superhero and Person Classes](.guides/img/inheritance/parent_child_classes.png)

The code below will first call upon the superclass constructor (using `super`) to create the attributes `name`, `age`, and `occupation`. The constructor is extended when the attribute `secretIdentity` is added to the `Superhero` class.

```java
//add class definitions below this line

class Superhero extends Person {
  private String secretIdentity;
  
  public Superhero(String na, int a, String o, String s) {
    super(na, a, o);
    secretIdentity = s;
  }
  
  public String getSecretIdentity() {
    return secretIdentity;
  }
  
  public void setSecretIdentity(String newIdentity) {
    secretIdentity = newIdentity;
  }
}
  
//add class definitions above this line
```

Instantiate a `Superhero` object and print out each of the attributes. You should see the three attributes from the `Person` class as well as the new attribute `secretIdentity`.

```java
    //add code below this line

    Superhero hero = new Superhero("Spider-Man", 17, "student", "Peter Parker");
    System.out.println(hero.getName());
    System.out.println(hero.getAge());
    System.out.println(hero.getOccupation());
    System.out.println(hero.getSecretIdentity());

    //add code above this line
```

<details>
  <summary><strong>Inheritance is a One-Way Street</strong></summary>
  Inheritance shares attributes and methods from the superclass to the subclass. When a subclass is extended, it cannot share the new additions with their superclass. In the code above, <code>Superhero</code> has access to <code>name</code>, but <code>Person</code> does not have access to <code>secretIdentity</code>.
</details><br>

{Try it}(sh .guides/bg.sh javac code/inheritance/ExtendClass.java java -cp code/inheritance/ ExtendClass 1)

|||challenge
## Try this variation:
* Rewrite the `Superhero` class so that it extends the `Person` class by adding the attribute `nemesis`, Doc Octopus.
<details>
  <summary><strong>Solution</strong></summary>

```java
//add class definitions below this line

class Superhero extends Person {
  private String secretIdentity;
  private String nemesis;
  
  public Superhero(String na, int a, String o, String s, String ne) {
    super(na, a, o);
    secretIdentity = s;
    nemesis = ne;
  }
  
  public String getSecretIdentity() {
    return secretIdentity;
  }
  
  public void setSecretIdentity(String newIdentity) {
    secretIdentity = newIdentity;
  }
  
  public String getNemesis() {
    return nemesis;
  }
  
  public void setNemesis(String newNemesis) {
    nemesis = newNemesis;
  }
}
  
//add class definitions above this line
```
  
  Now instantiate a `Superhero` object and make sure that the new attribute works as expected.
  
```java
    //add code below this line

    Superhero hero = new Superhero("Spider-Man", 17, "student", "Peter Parker", "Doc Octopus");
    System.out.println(hero.getName());
    System.out.println(hero.getAge());
    System.out.println(hero.getOccupation());
    System.out.println(hero.getSecretIdentity());
    System.out.println(hero.getNemesis());

    //add code above this line
```  

</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/ExtendClass.java java -cp code/inheritance/ ExtendClass 2)

## Extending a Class by Adding New Methods

Another way to extend a class is to create new methods (besides getters and setters) that are unique to the subclass. For example, the `sayHello` method will give the superhero's name, but it will not divulge their secret identity. Create the method `revealSecretIdentity` to print the attribute `secretIdentity`.

```java
//add class definitions below this line

class Superhero extends Person {
  private String secretIdentity;
  private String nemesis;
  
  public Superhero(String na, int a, String o, String s, String ne) {
    super(na, a, o);
    secretIdentity = s;
    nemesis = ne;
  }
  
  public String getSecretIdentity() {
    return secretIdentity;
  }
  
  public void setSecretIdentity(String newIdentity) {
    secretIdentity = newIdentity;
  }
  
  public String getNemesis() {
    return nemesis;
  }
  
  public void setNemesis(String newNemesis) {
    nemesis = newNemesis;
  }
  
  public void revealSecretIdentity() {
    System.out.println("My real name is " + secretIdentity + ".");
  }
}

//add class definitions above this line
```

Now test out the newly added method.

```java
    //add code below this line

    Superhero hero = new Superhero("Spider-Man", 17, "student", "Peter Parker", "Doc Octopus");
    hero.revealSecretIdentity();

    //add code above this line
```  

{Try it}(sh .guides/bg.sh javac code/inheritance/ExtendClass.java java -cp code/inheritance/ ExtendClass 3)

|||challenge
## Try this variation:
* Create the method `sayNemesis` that prints the string:
`My nemesis is Doc Octopus.`.
<details><summary><strong>Solution</strong></summary>

```java
//add class definitions below this line

class Superhero extends Person {
  private String secretIdentity;
  private String nemesis;
  
  public Superhero(String na, int a, String o, String s, String ne) {
    super(na, a, o);
    secretIdentity = s;
    nemesis = ne;
  }
  
  public String getSecretIdentity() {
    return secretIdentity;
  }
  
  public void setSecretIdentity(String newIdentity) {
    secretIdentity = newIdentity;
  }
  
  public String getNemesis() {
    return nemesis;
  }
  
  public void setNemesis(String newNemesis) {
    nemesis = newNemesis;
  }
  
  public void revealSecretIdentity() {
    System.out.println("My real name is " + secretIdentity + ".");
  }
  
  public void sayNemesis() {
    System.out.println("My nemesis is " + nemesis + ".");
  }
}

//add class definitions above this line
```
  
  Now invoke the `sayNemesis` method.
  
```java
    //add code below this line

    Superhero hero = new Superhero("Spider-Man", 17, "student", "Peter Parker", "Doc Octopus");
    hero.sayNemesis();

    //add code above this line 
```

</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/ExtendClass.java java -cp code/inheritance/ ExtendClass 4)

{Check It!|assessment}(parsons-puzzle-678926361)
