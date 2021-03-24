----------

## Abstract Classes

Another form of polymorphism in Java involves abstract methods. These methods, however, require knowledge of abstract classes. So before we continue the discussion on polymorphism, we need to first talk about abstract classes.

<details>
  <summary><strong>Concrete Classes</strong></summary>
  Any class that is not an abstract class is called a concrete class. You do not need to use a keyword to indicate that a class is concrete.
</details><br>

The two defining characteristics of abstract classes is that they use the `abstract` keyword and you cannot instantiate an object of an abstract class. The `Person` class is an abstract without a constructor, but the `name` attribute has a getter and a setter. Try to instantiate a `Person` object. Java will tell you that the class is abstract and cannot be instantiated.

```java
    //add code below this line

    Person p = new Person();
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/polymorphism/AbstractClasses.java java -cp code/polymorphism/ AbstractClasses 1)

Using inheritance will allow you to instantiate a subclass of an abstract class. Create the `Engineer` class that extends `Person`. This class should have a constructor that takes values for the `name` and `specialty` attributes. 

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