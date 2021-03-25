----------

## Abstract Classes

Another form of polymorphism in Java involves abstract methods. These methods, however, require knowledge of abstract classes. So before we continue the discussion on polymorphism, we need to first talk about abstract classes.

<details>
  <summary><strong>Concrete Classes</strong></summary>
  Any class that is not an abstract class is called a concrete class. You do not need to use a keyword to indicate that a class is concrete.
</details><br>

The two defining characteristics of abstract classes is that they use the `abstract` keyword and you cannot instantiate an object of an abstract class. The way to use an abstract class is through inheritance. Create the `Engineer` class that extends `Person`. Add the attribute `speciality`, and create the `greeting` method.

```java
//add class definitions below this line

class Engineer extends Person {
  private String speciality;
  
  public Engineer(String n, String s) {
    setName(n);
    speciality = s;
  }
  
  public String greeting() {
    return "Hello, my name is " + getName() + " and I am a(n) " + speciality;
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

