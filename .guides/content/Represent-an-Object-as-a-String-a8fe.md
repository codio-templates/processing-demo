----------

## The `toString` Method

When you print out the instance of a user-created class, Java returns only the class name and its location in memory. 

```java
//add class definitions below this line

class Animal {
  private int age;
  
  public Animal(int a) {
    age = a;
  }
}
 
//add class definitions above this line
```

Instantiate an `Animal` object and print it.

```java
  //add code below this line

  Animal a = new Animal(3);
  System.out.println(a);

  //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/StringRepresentation.java java -cp code/advanced/ StringRepresentation 1)

This is not very helpful. That is why we have seen code examples where classes have a method called `describe` or `display` that print out a description of the object. However, a better way of representing an object as a string is to override the `toString` method. **Note**, it is not necessary to explicitly call the `toString` method. This is automatically done with `System.out.println`.

```java
//add class definitions below this line

class Animal {
  private int age;
  
  public Animal(int a) {
    age = a;
  }
  
  public String toString() {
    return getClass().getName() + "[age=" + age + "]";
  }
}
 
//add class definitions above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/StringRepresentation.java java -cp code/advanced/ StringRepresentation 2)

## String Representation and Inheritance

The example above uses `getClass().getName()` to print the name of the class instead of manually printing `Animal`. This makes printing a string representation of a subclass much easier. Create the `Dog` class which extends the `Animal` class.

```java
//add class definitions below this line

class Animal {
  private int age;
  
  public Animal(int a) {
    age = a;
  }
  
  public String toString() {
    return getClass().getName() + "[age=" + age + "]";
  }
}

class Dog extends Animal {
  private String name;
  private String breed;
  
  public Dog(String n, String b, int a) {
    super(a);
    name = n;
    breed = b;
  }
}
 
//add class definitions above this line
```

Change the object creation from an `Animal` to a `Dog`. When you run the program, Java will print `Dog` as the class name. However, it only prints out the `age` attribute but not the `name` or `breed` attributes. That is because `toString` is defined in `Animal` which does not have `name` or `breed` attributes.

```java
  //add code below this line

  Dog d = new Dog("Rocky", "Pomeranian", 3);
  System.out.println(d);

  //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/StringRepresentation.java java -cp code/advanced/ StringRepresentation 3)

To get a string representation of the `Dog` class, override the `toString` method. Call `toString` from the superclass and append the attributes (`name` and `breed`) from the subclass. You should see the name of the class (`Dog`), a set of square brackets with the attribute from the superclass, and another set of square brackets with attributes from the subclass.

```java
class Dog extends Animal {
  private String name;
  private String breed;
  
  public Dog(String n, String b, int a) {
    super(a);
    name = n;
    breed = b;
  }
  
  public String toString() {
    return super.toString() + "[name= " + name + ", breed=" + breed + "]";
  }
}
```

{Try it}(sh .guides/bg.sh javac code/advanced/StringRepresentation.java java -cp code/advanced/ StringRepresentation 4)

{Check It!|assessment}(multiple-choice-3537822719)
