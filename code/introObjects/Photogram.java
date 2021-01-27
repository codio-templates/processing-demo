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

    JFrame window = new JFrame("Photogram");
    window.setSize(800, 500);
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true); //this should be your last line of code

    //add code above this line
  }
}