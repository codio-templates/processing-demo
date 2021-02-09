----------

## Static Methods

Imagine a `Rectangle` class in which objects have a length, width, and a method to calculate the area. 

```java
//add class definitions below this line

class Rectangle {
  int width;
  int length;
  
  Rectangle(int w, int l) {
    width = w;
    length = l;
  }
  
  int area() {
    return width * length;
  }
}
 
//add class definitions above this line
```

Create two instances of the `Rectangle` class, and then calculate the combined area of the two rectangles.

```java
    //add code below this line

    Rectangle rect1 = new Rectangle(12, 27);
    Rectangle rect2 = new Rectangle(9, 3);
    int combinedArea = rect1.area() + rect2.area();
    System.out.println(combinedArea);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/StaticMethods.java java -cp code/mutability/ StaticMethods 1)

This works, but the combined area has to be calculated by the user. Since the combined area is related to the `Rectangle` class, a better solution would be to add this functionality to the class. Another type of method in Java is a static method. Static methods are most often used to add functionality (like calculating the combined area) to a class. Static methods use the `static` keyword in the method definition.

```java
//add class definitions below this line

class Rectangle {
  int width;
  int length;
  
  Rectangle(int w, int l) {
    width = w;
    length = l;
  }
  
  int area() {
    return width * length;
  }
  
  static int combinedArea(Rectangle r1, Rectangle r2) {
    return r1.area() + r2.area();
  }
}
 
//add class definitions above this line
```

Static methods are called in a unique way. The still use dot notation, but instead of using the instance name use the class name followed by the dot and method name.

```java
    //add code below this line

    Rectangle rect1 = new Rectangle(12, 27);
    Rectangle rect2 = new Rectangle(9, 3);
    System.out.println(Rectangle.combinedArea(rect1, rect2));

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/StaticMethods.java java -cp code/mutability/ StaticMethods 2)

|||challenge
## Try this variation:
Call the `combinedArea` method from the instance `rect1` with `rect1` and `rect2` as arguments.
```java
    System.out.println(rect.combinedArea(rect1, rect2));
```
<details>
  <summary><strong>Why does this work?</strong></summary>
  Like class methods, static methods can be called from the class itself or from an instance of a class.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/StaticMethods.java java -cp code/mutability/ StaticMethods 3)

