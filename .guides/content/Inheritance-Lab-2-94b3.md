----------

## Lab 2 - Creating the Parent Class

{Launch Processing}(bash .guides/processing.sh)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `inheritance`, and double click on `InheritanceLab2`. Finally, open the `InheritanceLab2.pde` file. This file will be used for the animation.

|||

This lab is all about inheritance, so we need to create a superclass from which we can inherit. We are going to create a class called `Hexagon` that draws a hexagon to window.

### The `Hexagon` Class

Start the `Hexagon` declaration before the `setup` method. These attributes will aid in the drawing of the shape.

```java
class Hexagon {
  private int xPosition;
  private int yPosition;
  private float radius;
  private int vertices;
  private float angle;
  private color clr;
  private float strokeW;
}
```

All of these attributes will need a getter method, but only the `angle` and `vertices` attributes need a setter method.

```java
  public float getRadius() {
    return radius;
  }
  
  public color getClr() {
    return clr;
  }
  
  public float getStrokeW() {
    return strokeW;
  }
  
  public int getVertices() {
    return vertices;
  }
  
  public void setVertices(int newVertices) {
    vertices = newVertices;
  }
  
  public float getAngle() {
    return angle;
  }
  
  public void setAngle(float newAngle) {
    angle = newAngle;
  }
  
  public int getXPosition() {
    return xPosition;
  }
  
  public int getYPosition() {
    return yPosition;
  }
```

Processing will throw an error if the superclass does not have a default constructor. That is, a constructor without any parameters. Create a constructor that initializes each attribute with a starting value.

```java
  public Hexagon() {
    xPosition = 0;
    yPosition = 0;
    radius = 50;
    vertices = 6;
    angle = TWO_PI / vertices;
    clr = color(255, 255, 255);
    strokeW = 1;
  }
```

<details>
  <summary><strong>Calculating the Angle Attribute</strong></summary>
  The <code>angle</code> attribute is measured in radians. A radian is a unit of measure for angles. One radian is about 57.3 degrees. The are exactly 2π radians in any circle. To calculate the angle for each vertex, divide 2π by the number of vertices. In Processing, 2π is represented by <code>TWO_PI</code>. The image below shows that the a radian (blue) has the same length as the radius (red).<img src=".guides/img/inheritance/Radian.png" />
</details>

Now create a constructor that takes several parameters. There is no need to pass the constructor a value for `vertices`. A hexagon should always have six vertices, we can set that value manually. The same is true for `angle`. Once we know the number of vertices, we can calculate the `angle` attribute.

```java
  public Hexagon(int x, int y, float r, color c, float sw) {
    xPosition = x;
    yPosition = y;
    radius = r;
    vertices = 6;
    angle = TWO_PI / vertices;
    clr = c;
    strokeW = sw;
  }
```

### Test Your Code

Before moving on, we need to test the `Hexagon` object to make sure both constructors work as expected. After the `Hexagon` class and before the `setup` method, create two `Hexagon` objects. In the `setup` method, initialize each object, one with the default constructor and the other with some arguments. Processing will create a dark gray window, but it will not draw anything to the screen.

```java
Hexagon h1;
Hexagon h2;

void setup() {
  size(400, 400);
  h1 = new Hexagon();
  h2 = new Hexagon(200, 200, 200, color(255, 0, 0), 3);
}

void draw() {
  background(55);
}
```

|||important
## Save Your Work
If Processing runs your code without any errors, be sure to save your work. This **will not** happen automatically. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

<details>
  <summary><strong>Code</strong></summary>
  
  ```java
  class Hexagon {
    private int xPosition;
    private int yPosition;
    private float radius;
    private int vertices;
    private float angle;
    private color clr;
    private float strokeW;

    public float getRadius() {
      return radius;
    }

    public color getClr() {
      return clr;
    }

    public float getStrokeW() {
      return strokeW;
    }

    public int getVertices() {
      return vertices;
    }

    public void setVertices(int newVertices) {
      vertices = newVertices;
    }

    public float getAngle() {
      return angle;
    }

    public void setAngle(float newAngle) {
      angle = newAngle;
    }

    public int getXPosition() {
      return xPosition;
    }

    public int getYPosition() {
      return yPosition;
    }

    public Hexagon() {
      xPosition = 0;
      yPosition = 0;
      radius = 50;
      vertices = 6;
      angle = TWO_PI / vertices;
      clr = color(255, 255, 255);
      strokeW = 1;
    }

    public Hexagon(int x, int y, float r, color c, float sw) {
      xPosition = x;
      yPosition = y;
      radius = r;
      vertices = 6;
      angle = TWO_PI / vertices;
      clr = c;
      strokeW = sw;
    }
  }

  Hexagon h1;
  Hexagon h2;

  void setup() {
    size(400, 400);
    h1 = new Hexagon();
    h2 = new Hexagon(200, 200, 200, color(255, 0, 0), 3);
  }

  void draw() {
    background(55);
  }
  ```
</details>

{Check It!|assessment}(multiple-choice-1306573375)
