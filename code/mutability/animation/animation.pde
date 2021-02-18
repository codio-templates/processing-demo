class Ball {
  float xPosition;
  float yPosition;
  color ballColor;
  int radius;
  float xVelocity;
  float yVelocity;
  
  Ball(int x, int y, int r) {
    xPosition = x;
    yPosition = y;
    radius = r;
    ballColor = color(255, 255, 255);
    xVelocity = random(-1, 1) + 1;
    yVelocity = random(-1, 1) + 1;
  }
  
  void drawBall() {
    noStroke();
    fill(ballColor);
    circle(xPosition, yPosition, radius);
  }
  
  void moveBall() {
    xPosition += xVelocity;
    yPosition += yVelocity;
  }
  
  void bounceBall() {
    if (xPosition > width || xPosition < 0) {
      xVelocity *= -1;
      changeColor();
    }
    if (yPosition > height || yPosition < 0) {
      yVelocity *= -1;
      changeColor();
    }
  }
  void changeColor() {
    int red = floor(random(256));
    int green = floor(random(256));
    int blue = floor(random(256));
    ballColor = color(red, green, blue);
  }
}

Ball ball;

void setup() {
  size(400, 400);
  ball = new Ball(50, 50, 40);
}

void draw() {
  background(0, 0, 0);
  ball.drawBall();
  ball.moveBall();
  ball.bounceBall();
}
