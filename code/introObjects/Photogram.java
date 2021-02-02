import javax.swing.*;
import java.awt.*;
import java.util.*; 

//add class definitions below this line

class Post {
  String username;
  int userId;
  String media;
  String avatar;
  String commentButton;
  int likes;
  String caption;
  ArrayList<String> comments;
  String likeButton;

  public Post (String un, int ui, String m,
               String a, String cb, int l,
               String ca, ArrayList<String> co,
               String lb) {
    username = un;
    userId = ui;
    media = m;
    avatar = a;
    commentButton = cb;
    caption = ca;
    likes = l;
    comments = co;
    likeButton = lb;
  }
}

//add class definitions above this line

public class Photogram {
  public static void main(String[] args) {

    //add code below this line
    String username = "Sally_17";
    int userId = 112010;
    String media = "studentFolder/photogram/waterfall.png";
    String avatar = "studentFolder/photogram/avatarIcon.png";
    String commentButton = "studentFolder/photogram/addComment.png";
    String caption = "First time at Yosemite. It has surpassed all of my expectations.";
    int likes = 23;
    ArrayList<String> comments = new ArrayList<String>();
    comments.add("Beautiful!");
    comments.add("I wish I was there too.");
    comments.add("Is that Nevada Falls?");
    comments.add("Love it!");
    comments.add("Can't wait for the Halfdome pictures");
    comments.add("More pics please");
    String likeButton = "studentFolder/photogram/likesIcon.png";

    Post post1 = new Post(username, userId, media, avatar,
                          commentButton, likes, caption,
                          comments, likeButton);

    // create window
    JFrame window = new JFrame("Photogram");
    window.setSize(1000, 500);
    window.setLayout(new GridLayout(1, 2, 0, 10));
    
    // create panels
    JPanel imagePanel = new JPanel();
    JPanel infoPanel = new JPanel(new GridLayout(5, 1));
    JPanel userPanel = new JPanel(new FlowLayout(3, 0, 5));
    JPanel likesPanel = new JPanel(new FlowLayout(3, 0, 5));
    JPanel commentPanel = new JPanel(new GridLayout(0, 1));
    
    // create waterfall image
    ImageIcon image = new ImageIcon(post1.media);
    JLabel imageLabel = new JLabel(image);
    imagePanel.add(imageLabel);
    
    // create avatar image
    ImageIcon avatarImage = new ImageIcon(post1.avatar);
    JLabel avatarIcon = new JLabel(avatarImage, JLabel.LEFT);
//     avatarIcon.setPreferredSize(new Dimension(50, 50));
    userPanel.add(avatarIcon);
    
    // create username text
    JLabel usernameLabel = new JLabel(post1.username, JLabel.LEFT);
//     usernameLabel.setPreferredSize(new Dimension(250, 50));
    userPanel.add(usernameLabel);
    infoPanel.add(userPanel);
    
    // create caption text
    JLabel captionLabel = new JLabel(post1.caption, JLabel.LEFT);
//     captionLabel.setPreferredSize(new Dimension(300, 50));
    infoPanel.add(captionLabel);
    
    // create "+" image
    ImageIcon commentButtonImage = new ImageIcon(post1.commentButton);
    JLabel commentButtonLabel = new JLabel(commentButtonImage);
//     commentButtonLabel.setPreferredSize(new Dimension(300, 50));
    infoPanel.add(commentButtonLabel);
    
    // create user comments
    for (String comment : post1.comments) {
      commentPanel.add(new JLabel(comment, JLabel.LEFT));
    }
//     commentPanel.setPreferredSize(new Dimension(300, 200));
    infoPanel.add(commentPanel);
    
    // create heart image
    ImageIcon likesImage = new ImageIcon(post1.likeButton);
    JLabel likesIconLabel = new JLabel(likesImage, JLabel.LEFT);
//     likesIconLabel.setPreferredSize(new Dimension(50, 50));
    likesPanel.add(likesIconLabel);
    
    // create number of likes
    JLabel likesCountLabel = new JLabel(String.valueOf(post1.likes), JLabel.LEFT);
//     likesCountLabel.setPreferredSize(new Dimension(250, 50));
    likesPanel.add(likesCountLabel);
    infoPanel.add(likesPanel);
    
    window.add(imagePanel);
    window.add(infoPanel);
//     window.pack();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    //add code above this line
  }
}