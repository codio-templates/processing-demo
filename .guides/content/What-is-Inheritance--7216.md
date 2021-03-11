----------

## Defining Inheritance

Imagine you want to create two Java classes, `Person` and `Superhero`. These respective classes might look something like this:

![No_Inheritance](.guides/img/inheritance/noInheritance.png)

There are some similarities between the `Person` class and the `Superhero` class. If the `Person` class already exists, it would be helpful to "borrow" from the `Person` class so you only have to create the new attributes and methods for the`Superhero` class. This situation describes inheritance — one class copies the attributes and methods from another class.

## Inheritance Syntax

In the IDE on the left, the `Person` class is already defined. To create the `Superhero` class that inherits from the `Person` class, add the following code at the end of the program. Notice how `Superhero` definition adds `extends Person`. This is how you indicate to Java that the `Superhero` class inherits from the `Person` class. You can also say that `Person` is the superclass and `Superhero` is the subclass.

```java
//add class definitions below this line

class Superhero extends Person {
  
}
  
//add class definitions above this line
```

Now declare an instance of the `Superhero` class and print the value of the `name` and `age` attributes using their getter methods.

```java
    //add code below this line

    Superhero s = new Superhero();
    System.out.println(s.getName());
    System.out.println(s.getAge());

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/WhatIsInheritance.java java -cp code/inheritance/ WhatIsInheritance 1)

<details>
  <summary><strong>Why does the program print <code>null</code> and <code>0</code>?</strong></summary>
  The <code>Person</code> class does not have a constructor. So when Java creates the attributes, it gives <code>null</code> as the initial value for strings and <code>0</code> for the initial value of integers.
</details>

|||challenge
## Try these variations:
* Print the `occupation` attribute.
* Call the `sayHello` method from the `Superhero` object.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
      //add code below this line

      Superhero s = new Superhero();
      System.out.println(s.getName());
      System.out.println(s.getAge());
      System.out.println(s.getOccupation());
      s.sayHello();

      //add code above this line
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/WhatIsInheritance.java java -cp code/inheritance/ WhatIsInheritance 2)

## Limitations of Inheritance

Java place some rules about how inheritance works. Most importantly, only public methods and attributes in superclass are directly accessible to the subclass. The following code creates an error. While the subclass inherits the `name` attribute, it can only access it through the getter method. For inheritance to work properly, the superclass needs to have getters, setters, and other public methods 

```java
    //add code below this line

    Superhero s = new Superhero();
    System.out.println(s.name);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/WhatIsInheritance.java java -cp code/inheritance/ WhatIsInheritance 3)

Constructors can also be a bit tricky with inheritance. Java will automatically call the constructor of the superclass when the subclass object is instantiated. The superclass should have a constructor without any parameters. Add the following constructor to the `Person` class. This will avoid the situation above where attributes have values like `null` and `0`.

```java
  public Person() {
    name = "Sarah";
    age = 37;
    occupation = "VP Sales";
  }
```

Now call the `sayHello` and `sayAge` methods from the `Superhero` object.

```java
    //add code below this line

    Superhero s = new Superhero();
    s.sayHello();
    s.sayAge();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/inheritance/WhatIsInheritance.java java -cp code/inheritance/ WhatIsInheritance 4)

|||challenge
## Try these variations:
* Change the constructor of the `Person` class so that the default values are `Rodrigo`, `19`, `student`.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  public Person() {
    name = "Rodrigo";
    age = 19;
    occupation = "student";
  }
  ```
  
</details><br>

* Change the constructor of the `Person` class to look like the following code:

```java
  public Person(String n, int a, Strig o) {
    name = n;
    age = a;
    occupation = o;
  }
```
<details>
  <summary><strong>Why is there an error?</strong></summary>
  Java tries to call the constructor of the superclass when instantiating a subclass object. This happens automatically and without any parameters, but the <code>Person</code> class expects three parameters. This is why the code generates an error. The next page describes how to call a superclass constructor with parameters.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/inheritance/WhatIsInheritance.java java -cp code/inheritance/ WhatIsInheritance 5)

{Check It!|assessment}(multiple-choice-2081032533)
