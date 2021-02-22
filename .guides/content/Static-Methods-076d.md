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

This works, but the combined area has to be calculated by the user. Since the combined area is related to the `Rectangle` class, a better solution would be to add this functionality to the class. Another type of method in Java is a static method. Static methods use the `static` keyword in the method definition.

Static methods are most often used to add functionality to the whole class and not just an instance of the class. A good rule of thumb is to use a static method when none of the attributes of an instance are changed. In the example below, the attributes for the `r1` and `r2` object do not change. So a static method is a better choice than an instance method.

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
Create the static method `describe` for the `Rectangle` class that prints a description of the rectangle.

<details>
  <summary><strong>Code</strong></summary>
  
  ```java
  static void describe(Rectangle r) {
    System.out.println("The rectangle has width of " + r.width + " and a length of" + r.length + ".");
  }
  ```
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/StaticMethods.java java -cp code/mutability/ StaticMethods 3)

{Check It!|assessment}(multiple-choice-571453302)
