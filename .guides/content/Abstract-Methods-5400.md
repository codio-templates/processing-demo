ii----------

## Abstract Classes

Another form of polymorphism in Java involves abstract methods. These methods, however, require knowledge of abstract classes. So before we continue the discussion on polymorphism, we need to first talk about abstract classes.

<details>
  <summary><strong>Concrete Classes</strong></summary>
  Any class that is not an abstract class is called a concrete class. You do not need to use a keyword to indicate that a class is concrete.
</details><br>

The two defining characteristics of abstract classes is that they use the `abstract` keyword and you cannot instantiate an object of an abstract class. The way to use an abstract class is through inheritance. Create the `Engineer` class that extends `Person`. Add the attribute `specialty`, and create the `greeting` method.

```java
//add class definitions below this line

class Engineer extends Person {
  private String specialty;
  
  public Engineer(String n, String s) {
    setName(n);
    specialty = s;
  }
  
  public String greeting() {
    return "Hello, my name is " + getName() + " and I am a(n) " + specialty + ".";
  }
}

//add class definitions above this line
```

Instantiate an `Engineer` object and print the output from `greeting`.

```java
    //add code below this line

    Engineer e = new Engineer("Calvin", "civil engineer");
    System.out.println(e.greeting());
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/AbstractMethods.java java -cp code/polymorphism/ AbstractMethods 1)

|||challenge
## Try this variation:
Instead of instantiating an `Engineer` object, create a `Person` object.
```java
    //add code below this line

    Person p = new Person();
    
    //add code above this line
```

<details>
  <summary><strong>Why is there an error?</strong></summary>
  The <code>Person</code> class is an abstract class. Java will not allow you to directly instantiate an object of an abstract class. You must use the abstract class through inheritance.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/polymorphism/AbstractMethods.java java -cp code/polymorphism/ AbstractMethods 2)

## Abstract Methods

Once you have an abstract class, you can create an abstract method. These methods do not have a body. Rewrite the `Person` class so that the method `greeting` is a part of the class. Be sure to use the `abstract` keyword. Since the method does not have a body, you do not need the curly braces. However, you do need a semi-colon.

```java
abstract class Person {
  private String name;
  
  public String getName() {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public abstract String greeting();
}
```

When you create an abstract method, the subclass is required to override it. This is helpful when you want a subclass to have a specific method, but want to let the subclass decide how to implement it. To demonstrate this, create another subclass called `Artist`. This class is almost identical to the `Engineer` class except for the output of the `greeting` method. 

```java
//add class definitions below this line

class Engineer extends Person {
  private String specialty;
  
  public Engineer(String n, String s) {
    setName(n);
    specialty = s;
  }
  
  public String greeting() {
    return "Hello, my name is " + getName() + " and I am a(n) " + specialty + ".";
  }
}

class Artist extends Person {
  private String specialty;
  
  public Artist(String n, String s) {
    setName(n);
    specialty = s;
  }
  
  public String greeting() {
    return "My name is " + getName() + " and I work with " + specialty + ".";
  }
}

//add class definitions above this line
```

Instantiate an object of the `Artist` class and call the `greeting` method. Using an abstract method forces you to override a method, and overriding a method is a form of polymorphism. Therefore, abstract methods are also a form of polymorphism.

```java
    //add code below this line

    Person p = new Engineer("Calvin", "civil engineer");
    Person a = new Artist("Maria", "water colors");
    
    System.out.println(p.greeting());
    System.out.println(a.greeting());
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/AbstractMethods.java java -cp code/polymorphism/ AbstractMethods 3)

|||challenge
## Try these variations:
* Comment out the `greeting` method in both the `Engineer` and `Artist` classes.
```java
//add class definitions below this line

class Engineer extends Person {
  private String speciality;
  
  public Engineer(String n, String s) {
    setName(n);
    speciality = s;
  }
  
//   public String greeting() {
//     return "Hello, my name is " + getName() + " and I am a(n) " + speciality + ".";
//   }
}

class Artist extends Person {
  private String medium;
  
  public Artist(String n, String m) {
    setName(n);
    medium = m;
  }
  
//   public String greeting() {
//     return "My name is " + getName() + " and I work with " + medium + ".";
//   }
}

//add class definitions above this line
```

<details>
  <summary><strong>Why is there an error?</strong></summary>
  A subclass <strong>must</strong> override an abstract method. Because the <code>greeting</code> methods are commented out in the subclasses, they do not override the abstract method in the <code>Person</code> class. That is why Java throws an error.
</details><br>

* Make the `Person` class concrete (remove the `abstract` keyword).

```java
class Person {
  private String name;
  
  public String getName() {
    return name;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public abstract String greeting();
}
```

<details>
  <summary><strong>Why is there an error?</strong></summary>
  The method <code>greeting</code> is an abstract method. Abstract methods can only appear in an abstract class. That is why Java throws an error.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/polymorphism/AbstractMethods.java java -cp code/polymorphism/ AbstractMethods 4)

{Check It!|assessment}(parsons-puzzle-1047831703)
