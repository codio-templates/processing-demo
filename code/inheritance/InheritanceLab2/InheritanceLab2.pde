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
  
  public void draw() {
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

class Polygon extends Hexagon {
  private float grow;
  
  public Polygon(int x, int y, float r, color c, float sw, int v) {
    super(x, y, r, c, sw);
    grow = 0;
    setVertices(v);
    setAngle(TWO_PI / getVertices());
  }
  
  public float calculateLength() {
    grow += 0.01;
    float length = sin(grow) * getRadius();
    return length;
  }
  
  public void draw() {
    beginShape();
    noFill();
    stroke(getClr());
    strokeWeight(getStrokeW());
    float length = calculateLength();
    for (int i = 0; i < getVertices(); i++) {
      float x = cos(getAngle() * i) * length + getXPosition();
      float y = sin(getAngle() * i) * length + getYPosition();
      vertex(x, y);
    }
    endShape(CLOSE);
  }
}

Polygon p;

void setup() {
  size(400, 400);
  p = new Polygon(200, 200, 200, color(255, 0, 0), 3, 7);
}

void draw() {
  background(0);
  p.draw();
}