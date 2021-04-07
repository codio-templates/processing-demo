----------

## Object Equality

The equality operator (`==`) is overloaded, which means it can compare two integers, two floats, etc. It can even compare two objects. Create the `ExampleClass` that has two attributes.

```java
//add class definitions below this line

class ExampleClass {
  private int attribute1;
  private String attribute2;
  
  public ExampleClass(int a1, String a2) {
    attribute1 = a1;
    attribute2 = a2;
  }
}
 
//add class definitions above this line
```

Create the `ExampleClass` object `example1` with `7` and `"hello"` as the attributes. Now make a copy of `example1` and save it to the variable `example2`. Comparing the two objects with `==` should return `true`.

```java
    //add code below this line

    ExampleClass example1 = new ExampleClass(7, "hello");
    ExampleClass example2 = example1;
    System.out.println(example1 == example2);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/ObjectEquality.java java -cp code/advanced/ ObjectEquality 1)

Instead of making `example2` a copy of `example1`, create a new object with the same values passed to the constructor. The program should now print `false`.  

```java
    //add code below this line

    ExampleClass example1 = new ExampleClass(7, "hello");
    ExampleClass example2 = new ExampleClass(7, "hello");
    System.out.println(example1 == example2);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/ObjectEquality.java java -cp code/advanced/ ObjectEquality 2)

If the objects have the same type and the same values for their attributes, are they not the same? When comparing user-defined functions, the equality operator compares memory addresses. When `example2` is a shallow copy of `example1`, the two objects share the same memory address. When `example2` is created with the constructor, Java gives this object its own memory address.

Override the `eqauls` method if you want to compare attributes of different objects. If each attribute in one object is the same as the corresponding attribute in another object, the method should return `true`. Use a compound boolean expression to compare both attributes. Since `attribute1` is an integer, you can use `==` for the comparison. `attribute2` is a string, so you need to use the `equals` method.

```java
//add class definitions below this line

class ExampleClass {
  private int attribute1;
  private String attribute2;
  
  public ExampleClass(int a1, String a2) {
    attribute1 = a1;
    attribute2 = a2;
  }
  
  public boolean equals(ExampleClass other) {
    return attribute1 == other.attribute1 && attribute2.equals(other.attribute2);
  }
  
}
 
//add class definitions above this line
```

Finally, check for equality using the `equals` method. Java should return `true`.

```java
    //add code below this line

    ExampleClass example1 = new ExampleClass(7, "hello");
    ExampleClass example2 = new ExampleClass(7, "hello");
    System.out.println(example1.equals(example2));

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/advanced/ObjectEquality.java java -cp code/advanced/ ObjectEquality 3)

|||challenge
## Try this variation:
* Change the values passed to the constructor for the `example2` object.
```java
    //add code below this line

    ExampleClass example1 = new ExampleClass(7, "hello");
    ExampleClass example2 = new ExampleClass(-32, "goodbye");
    System.out.println(example1.equals(example2));

    //add code above this line
```

|||

{Try it}(sh .guides/bg.sh javac code/advanced/ObjectEquality.java java -cp code/advanced/ ObjectEquality 4)

{Check It!|assessment}(fill-in-the-blanks-1727359970)
