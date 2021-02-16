import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

//add class definitions below this line

class Ball extends JPanel implements ActionListener {
  Color color;
  int xPosition;
  int yPosition;
  int diameter;
  int xVelocity;
  int yVelocity;
  Timer timer;
  
  Ball(Color c, int x, int y, int d) {
    color = c;
    xPosition = x;
    yPosition = y;
    diameter = d;
    xVelocity = 1;
    yVelocity = 3;
    timer = new Timer(20, this);
    timer.start();
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawBall(g2);
  }
  
  void drawBall(Graphics2D g2) {
    g2.setColor(color);
    g2.fillOval(xPosition, yPosition, diameter, diameter);
  }
  
  void moveBall() {
    xPosition += xVelocity;
    yPosition += yVelocity;
  }
  
  void changeColor() {
    int red = (int)(Math.random() * 256);
    int green = (int)(Math.random() * 256);
    int blue = (int)(Math.random() * 256);
    color = new Color(red, green, blue);
  }
  
  void bounce() {
    if (xPosition >= 350 - diameter || xPosition < 0) {
      xVelocity *= -1;
      changeColor();
    }
    
    if (yPosition >= 350 - diameter || yPosition < 0) {
      yVelocity *= -1;
      changeColor();
    }
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
//     moveBall();
//     bounce();
    if (xPosition >= 350 - diameter || xPosition < 0) {
      xVelocity *= -1;
      int red = (int)(Math.random() * 256);
      int green = (int)(Math.random() * 256);
      int blue = (int)(Math.random() * 256);
      color = new Color(red, green, blue);
    }
    xPosition += xVelocity;
    
    if (yPosition >= 350 - diameter || yPosition < 0) {
      yVelocity *= -1;
      int red = (int)(Math.random() * 256);
      int green = (int)(Math.random() * 256);
      int blue = (int)(Math.random() * 256);
      color = new Color(red, green, blue);
    }
    yPosition += yVelocity;
    repaint();
  }
}

//add class definitions above this line

public class Animation {  
  public static void main(String[] args) {
    
    //add code below this line
    
    JFrame frame = new JFrame("Bouncing Ball");
    frame.setSize(350, 350);
    
    Color ballColor = new Color(150, 50, 200);
    Ball ball = new Ball(ballColor, 0, 0, 40);
    frame.add(ball);
    
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //add code above this line
  }
}