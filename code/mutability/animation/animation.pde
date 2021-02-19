//add class definitions below this line

class Ball {
  float xPosition;
  float yPosition;
  color ballColor;
  int radius;
  float xVelocity;
  float yVelocity;

  Ball(float x, float y) {
    xPosition = x;
    yPosition = y;
    ballColor = color(255, 255, 255);
    radius = 20;
    xVelocity = 1;
    yVelocity = 2;
  }
  
  void updateBall() {
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
  ball.updateBall();
}
