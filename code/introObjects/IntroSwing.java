import javax.swing.*;
import java.awt.*;

public class IntroSwing {
  public static void main(String[] args) {
    
    //add code below this line

    JFrame window = new JFrame("Hello");
    window.setSize(300, 300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
    
    JLabel text = new JLabel("I am a label");
//     Font font = new Font("DejaVuSansMono", Font.BOLD,12);
//     text.setFont(font);
    window.add(text);

    //add code above this line
  }
}