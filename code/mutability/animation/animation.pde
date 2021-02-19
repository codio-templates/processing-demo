//add class definitions below this line

class Ball {
  float xPosition;
  float yPosition;
  color ballColor;
  int radius;

  Ball(float x, float y) {
    xPosition = x;
    yPosition = y;
    ballColor = color(255, 255, 255);
    radius = 20;
  }
  
  void drawBall() {
    noStroke();
    fill(ballColor);
    circle(xPosition, yPosition, radius * 2);
  }
}

//add class definitions above this line

Ball ball;

void setup() {
  size(400, 400);
  ball = new Ball(50, 50);
}

void draw() {
  ball.drawBall();
}
