----------

## Shallow Copies

The code below will instantiate `a` as an instance of the `ComicBookCharacter` class. Object `a` will be given a name, an age, and a type. Object `b` will be a copy of `a`. Finally, the `name` attribute of object `a` is changed. What do you expect to see when the `name` attributes of objects `a` and `b` are printed?

```java
class ComicBookCharacter {
  String name;
  int age;
  String type;
}
  
//add class definitions above this line

public class Copies {
  public static void main(String[] args) {
    
    //add code below this line

    ComicBookCharacter a = new ComicBookCharacter();
    a.name = "Calvin";
    a.age = 6;
    a.type = "human";
    
    ComicBookCharacter b = a;
    a.name = "Hobbes";
    
    System.out.println("Object a name: " + a.name);
    System.out.println("Object b name: " + b.name);
    
    //add code above this line
  }
}
```

{Try it}(sh .guides/bg.sh javac code/introObjects/Copies.java java -cp code/introObjects/ Copies 1)

Both of the `name` attributes changed, even though the code only changed the `name` attribute of object `a`. This is because object `b` is a shallow copy of object `a`. Java makes a copy of object `a`, but object `b` shares the attributes with object `a`. That is why changing `name` for object `a` also affects the `name` attribute for object `b`.

![Shallow Copy](.guides/img/intro/shallow-copy.png)

## Deep Copy

A deep copy is when Java makes a copy of object `a` and makes copies of each attribute. A deep copy keeps the attributes of one object independent of the other object. To create a deep copy, you are going to use something called a copy constructor.

![Deep Copy](.guides/img/intro/deep-copy.png)

The copy constructor is a constructor that creates an object by initializing it with a previously created object of the same class. Start by creating another constructor that take a `ComicBookCharacter` as a parameter. Assign each object attribute with the corresponding attribute from the parameter.

```java
//add class definitions below this line
    
class ComicBookCharacter {
  String name;
  int age;
  String type;
  
  ComicBookCharacter(String n, int a, String t) {
    name = n;
    age = a;
    type = t;
  }
  
  ComicBookCharacter(ComicBookCharacter c) {
    name = c.name;
    age = c.age;
    type = c.type;
  }
}
  
//add class definitions above this line
```

Now instantiate `b` using the copy constructor. Object `b` will now be a deep copy of object `a`, and their attributes are independent from one another.

```java
    //add code below this line

    ComicBookCharacter a = new ComicBookCharacter("Calvin", 6, "human");
    
    ComicBookCharacter b = new ComicBookCharacter(a);
    a.name = "Hobbes";
    
    System.out.println("Object a name: " + a.name);
    System.out.println("Object b name: " + b.name);
    
    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/Copies.java java -cp code/introObjects/ Copies 2)

{Check It!|assessment}(fill-in-the-blanks-2232783722)

