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

    // create components
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.NONE;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    
    GridBagLayout gbl = new GridBagLayout();
    
    JFrame window = new JFrame("Photogram");
    JPanel info = new JPanel(gbl);
    info.setPreferredSize(new Dimension(800, 500));
    
//     gbc = updateConstraints(gbc, 0, 0, 10, 10);
    JLabel image = makeImage(post1.media);
    info.add(image, gbc);
    
//     gbc = updateConstraints(gbc, 1, 0, 1, 1);
    JLabel avatarIcon = makeImage(post1.avatar);
    info.add(avatarIcon, gbc);
    
//     gbc = updateConstraints(gbc, 2, 0, 5, 1);
    JLabel usernameLabel = makeText(post1.username);
    info.add(usernameLabel, gbc);
    
//     gbc = updateConstraints(gbc, 1, 1, 6, 1);
    JLabel captionLabel = makeText(post1.caption);
    info.add(captionLabel, gbc);
    
//     gbc = updateConstraints(gbc, 1, 2, 6, 1);
    JLabel commentButtonLabel = makeImage(post1.commentButton);
    info.add(commentButtonLabel, gbc);
    
    JPanel commentPanel = new JPanel(new GridLayout(6, 1));
    for (String comment : post1.comments) {
      commentPanel.add(makeText(comment));
    }
//     gbc = updateConstraints(gbc, 1, 3, 6, 6);
    info.add(commentPanel, gbc);
    
//     gbc = updateConstraints(gbc, 1, 4, 1, 1);
    JLabel likesIconLabel = makeImage(post1.likeButton);
    info.add(likesIconLabel, gbc);
    
//     gbc = updateConstraints(gbc, 2, 4, 5, 1);
    JLabel likesCountLabel = makeLikes(post1.likes);
    info.add(likesCountLabel, gbc);
    
    window.add(info);
    window.pack();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    //add code above this line
  }
  
  //add method definitions below this line
  
  public static GridBagConstraints updateConstraints(GridBagConstraints gbc, int x, int y, int width, int height) {
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = width;
    gbc.gridheight = height;
    
    return gbc;
  }
  
  public static JLabel makeText(String txt) {
    JLabel text = new JLabel(txt);
    
    return text;
  }
  
  public static JLabel makeLikes(int likeCounts) {
    JLabel likes = new JLabel(String.valueOf(likeCounts));
    
    return likes;
  }
  
  public static JLabel makeImage(String img) {
    ImageIcon image = new ImageIcon(img);
    JLabel imageLabel = new JLabel(image);
    
    return imageLabel;
  }
  
  //add method definitions above this line
}