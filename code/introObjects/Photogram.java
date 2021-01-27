import javax.swing.*;
import java.util.*; 

public class Photogram {
  public static void main(String[] args) {
    
    //add code below this line

    JFrame window = new JFrame("Hi");
    JPanel panel = new JPanel();
    JButton button = new JButton("Blah");
    panel.add(button);
    window.add(panel);
    window.setSize(300, 100);
    window.setVisible(true);

    //add code above this line
  }
}