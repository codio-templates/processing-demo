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
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    
    GridBagLayout gbl = new GridBagLayout();
    
    JFrame window = new JFrame("Photogram");
    window.setSize(800, 500);
    window.setLayout(gbl);
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 5;
    gbc.gridheight = 1;
    JLabel image = makeImage(post1);
    gbl.setConstraints(image, gbc);
    window.add(image);
    
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    JLabel avatarIcon = makeAvatar(post1);
    gbl.setConstraints(avatarIcon, gbc);
    window.add(avatarIcon);
    
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    JLabel usernameLabel = makeUserName(post1);
    gbl.setConstraints(usernameLabel, gbc);
    window.add(usernameLabel);
    
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    JLabel captionLabel = makeCaption(post1);
    gbl.setConstraints(captionLabel, gbc);
    window.add(captionLabel);
    
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    JLabel commentButtonLabel = makeCommentButton(post1);
    gbl.setConstraints(commentButtonLabel, gbc);
    window.add(commentButtonLabel);
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    //add code above this line
  }
  
  //add method definitions below this line
  
  public static JLabel makeImage(Post post) {
    ImageIcon image = new ImageIcon(post.media);
    JLabel imageLabel = new JLabel(image);
    
    return imageLabel;
  }
  
  public static JLabel makeAvatar(Post post) {
    ImageIcon avatarIcon = new ImageIcon(post.avatar);
    JLabel avatarLabel = new JLabel(avatarIcon);
        
    return avatarLabel;
  }
  
  public static JLabel makeUserName(Post post) {
    JLabel usernameLabel = new JLabel(post.username);
    Font font = new Font("SanSerif", Font.BOLD, 24);
    usernameLabel.setFont(font);
    
    return usernameLabel;
  }
  
  public static JLabel makeCaption(Post post) {
    JLabel captionLabel = new JLabel(post.caption);
    
    return captionLabel;
  }
  
  public static JLabel makeCommentButton(Post post) {
    ImageIcon commentIcon = new ImageIcon(post.commentButton);
    JLabel commentIconLabel = new JLabel(commentIcon);
    
    return commentIconLabel;
  }
  
  
  //add method definitions above this line
}