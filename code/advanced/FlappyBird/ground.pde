class Ground {
  private PImage ground;
  private int xPos;
  
  public Ground() {
    ground = loadImage("ground.png");
    xPos = 0;
  }
  
  public void show() {
    image(ground, xPos, 650); // show first ground
    image(ground, xPos + 470, 650); // show second ground
  }
  
  public void update() {
    xPos -= 1;
    if (xPos <= -470) {
      xPos = 0;
    }
  }
}