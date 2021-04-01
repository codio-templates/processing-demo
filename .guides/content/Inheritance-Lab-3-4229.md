----------

## Lab 3 - Drawing the Hexagon Object

{Launch Processing}(bash .guides/processing.sh)

|||info
## Open the File
You have to tell Processing the file you want to open. In the Processing window, click `File` then `Open...`. On the left towards the bottom of the list, click `workspace`. Double click on `code`, double click on `inheritance`, and double click on `InheritanceLab2`. Finally, open the `InheritanceLab2.pde` file. This file will be used for the animation.

|||

Create a method called `show` in the `Hexagon` class. We are going to use `beginShape` and `endShape` to draw the hexagon. Tell Processing not to fill the shape. Instead set the `stroke` (color of the line) and `strokeWeight` (line thickness). Since there are six vertices in a hexagon, create a for loop that runs six time. Each iteration will draw a vertex a given length from the center of the shape. Create the the loop but do not put anything inside of it just yet.

```java
  public void show() {
    beginShape();
    noFill();
    stroke(clr);
    strokeWeight(strokeW);
    for (int i = 0; i < vertices; i++) {
      
    }
    endShape(CLOSE);
  }
```

### Polar to Cartesian Transformation

The `Hexagon` class is designed to position the shape according to `xPosition` and `yPosition`. The six vertices radiate out from the center according to the `radius` attribute, and the spacing between each vertex is controlled by `angle`. Using angles and a distance from a central point to calculate a position is referred to as the polar coordinate system. The red lines show different angles and the black concentric circles represent a distance from the center. The intersection of the red line and black circle is a location.

![Polar Coordinates](.guides/img/inheritance/polar_system.png)

The problem is that the Processing window uses the Cartesian coordinate system. With a little bit of trigonometry, you can convert the polar coordinate system to the Cartesian coordinate system. The x- and y-coordinates for each point of the hexagon can be calculated with the following formulas.

```markdown
x = cosine(angle) * radius
y = sine(angle) * radius
```

These formulas need to be tweaked a bit for the `Hexagon` class. First, the above formulas assume you are setting a position relative to the origin point (the top-left corner of the window). Instead, we want to position each vertex in relation to the center of the hexagon. So offset the x-coordinate of the vertex with the x-position of the center of the hexagon. Similarly, offset the y-coordinate of the vertex with the y-position of the center of the hexagon. Since there are six vertices, use a for loop to calculate each vertex. Use local variables to calculate the x- and y-values and then draw a vertex.

```java
  public void show() {
    beginShape();
    noFill();
    stroke(clr);
    strokeWeight(strokeW);
    for (int i = 0; i < vertices; i++) {
      float x = cos(angle * i) * radius + xPosition;
      float y = sin(angle * i) * radius + yPosition;
      vertex(x, y);
    }
    endShape(CLOSE);
  }
```

### Test Your Code

To be sure that the `Hexagon` class works, we are going to add an object and draw it to the window. Before the `setup` method create a `Hexagon` object. Inside the `setup` method instantiate the object. We want it to be centered in the window, so set the x-position to `width/2` and the y-position to `height/2`. Give it a radius of `125`, a color of `(179, 55, 113)`, and a stroke weight of `3`. Finally go into the `draw` method and call the `show` method on the `Hexagon` object.

```java
Hexagon h;

void setup() {
  size(400, 400);
  h = new Hexagon(200, 200, 125, color(179, 55, 113), 3);
}

void draw() {
  background(55);
  h.show();
}
```

|||important
## Save Your Work
If Processing runs your code without any errors, be sure to save your work. This **will not** happen automatically. Click `File` and then `Save`, or press `Ctrl + S` on the keyboard to save your work.

|||

<details>
  <summary><strong>Code</strong></summary>
  Your code should produce the following output:
  <img src=".guides/img/inheritance/hexagon.jpg" />
  
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

    public void show() {
      beginShape();
      noFill();
      stroke(clr);
      strokeWeight(strokeW);
      for (int i = 0; i < vertices; i++) {
        float x = cos(angle * i) * radius + xPosition;
        float y = sin(angle * i) * radius + yPosition;
        vertex(x, y);
      }
      endShape(CLOSE);
    }
  }

  Hexagon h;

  void setup() {
    size(400, 400);
    h = new Hexagon(200, 200, 125, color(179, 55, 113), 3);
  }

  void draw() {
    background(55);
    h.show();
  }
  ```
</details>

|||challenge
## Try these variations:
* Instantiate the `Hexagon` object with the default constructor (no parameters). You should see part of a white hexagon in the top-left corner of the window.

<details>
  <summary><strong>Solution</strong></summary>
  
  ```java
  Hexagon h;

  void setup() {
    size(400, 400);
    h = new Hexagon();
  }

  void draw() {
    background(55);
    h.show();
  }
  ```
  
</details><br>

* Add more `Hexagon` objects to the window. Name them `hexagon2`, `hexagon3`, etc. and draw them to the window.

<details>
  <summary><strong>Solution</strong></summary>
  Here is one possible solution:
  
  ```java
  Hexagon h, h1, h2, h3;

  void setup() {
    size(400, 400);
    h = new Hexagon(300, 95, 45, color(12, 231, 88), 7);
    h1 = new Hexagon(104, 311, 115, color(102, 31, 248), 1);
    h2 = new Hexagon(184, 50, 205, color(192, 131, 221), 10);
    h3 = new Hexagon(348, 211, 215, color(1, 131, 255), 25);
  }

  void draw() {
    background(55);
    h.show();
    h1.show();
    h2.show();
    h3.show();
  }
  ```
  
</details>

|||

{Check It!|assessment}(multiple-choice-1112060896)
