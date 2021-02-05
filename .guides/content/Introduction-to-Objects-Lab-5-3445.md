----------

## Lab 5

We will finish up by adding the components for the comment button, the comments, the like icon, and the number of likes.

### Add the Comment Button

Just as with the other images, create a `ImageIcon` object with the string in the `post1.commentButton` attribute. Add the image to a `JLabel`, and then add the label to `infoPanel`.

```java
    // create caption text
    String txt = post1.caption;
    String html = "<html><body style='width: %1spx'>%1s";
    JLabel captionLabel = new JLabel(String.format(html, 200, txt), JLabel.LEFT);
    captionLabel.setFont(plainFont);
    infoPanel.add(captionLabel);
    
    // create "+" image
    ImageIcon commentButtonImage = new ImageIcon(post1.commentButton);
    JLabel commentButtonLabel = new JLabel(commentButtonImage);
    infoPanel.add(commentButtonLabel);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 7)

### Add the Comments

The comments are stored in an ArrayList in the `comments` attribute of `post1`. Iterate over the ArrayList. Create a new `JLabel` for each comment and then add it to `infoPanel`.

```java
    // create "+" image
    ImageIcon commentButtonImage = new ImageIcon(post1.commentButton);
    JLabel commentButtonLabel = new JLabel(commentButtonImage);
    infoPanel.add(commentButtonLabel);
    
    // create user comments
    for (String comment : post1.comments) {
      JLabel commentLabel = new JLabel(comment, JLabel.LEFT);
      commentLabel.setFont(plainFont);
      infoPanel.add(commentLabel);
    }
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 8)

### Add the Like Icon

Like the avatar and the username, the like icon and the number of likes will be side-by-side. To do this, these components will first go into the `likesPanel`, which will then be added to the `infoPanel`. **Note**, you will not see the heart icon because the `likesPanel` has not yet been added to the `infoPanel`.

```java
    // create user comments
    for (String comment : post1.comments) {
      JLabel commentLabel = new JLabel(comment, JLabel.LEFT);
      commentLabel.setFont(plainFont);
      infoPanel.add(commentLabel);
    }
    
    // create heart image
    ImageIcon likesImage = new ImageIcon(post1.likeButton);
    JLabel likesIconLabel = new JLabel(likesImage, JLabel.LEFT);
    likesPanel.add(likesIconLabel);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 9)

### Add the Likes

The attribute `likes` is an integer. In order to add this value to a `JLabel`, you need to convert it to a string with the `String.valueOf` method. Set the font to plain. Then add the label to `likesPanel` and the `likesPanel` to the `infoPanel`.

```java
    // create heart image
    ImageIcon likesImage = new ImageIcon(post1.likeButton);
    JLabel likesIconLabel = new JLabel(likesImage, JLabel.LEFT);
    likesPanel.add(likesIconLabel);
    
    // create number of likes
    JLabel likesCountLabel = new JLabel(String.valueOf(post1.likes), JLabel.LEFT);
    likesCountLabel.setFont(plainFont);
    likesPanel.add(likesCountLabel);
    infoPanel.add(likesPanel);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 10)

### Fix the Spacing

Finally, we want the information in the `infoPanel` to be "pushed up" so it aligns with the top of the waterfall image. To do this, we are going to add more rows to the `infoPanel`. When declaring `infoPanel`, add 7 to the size of the `comments` ArrayList.

```java
    // create panels
    JPanel imagePanel = new JPanel();
    JPanel infoPanel = new JPanel(new GridLayout(comments.size()+7, 1));
    JPanel userPanel = new JPanel(new FlowLayout(3, 0, 5));
    JPanel likesPanel = new JPanel(new FlowLayout(3, 0, 5));
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 11)

<details>
  <summary><strong>Code</strong></summary>
  Your code should look like this:
  
  ```java
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
      window.setSize(800, 500);
      window.setLayout(new FlowLayout(3));

      // create panels
      JPanel imagePanel = new JPanel();
      JPanel infoPanel = new JPanel(new GridLayout(comments.size()+7, 1));
      JPanel userPanel = new JPanel(new FlowLayout(3, 0, 5));
      JPanel likesPanel = new JPanel(new FlowLayout(3, 0, 5));

      // create fonts
      Font boldFont = new Font("SansSerif", Font.BOLD, 14);
      Font plainFont = new Font("SansSerif", Font.PLAIN, 14);

      // create waterfall image
      ImageIcon image = new ImageIcon(post1.media);
      JLabel imageLabel = new JLabel(image);
      imagePanel.add(imageLabel);

      // create avatar image
      ImageIcon avatarImage = new ImageIcon(post1.avatar);
      JLabel avatarIcon = new JLabel(avatarImage, JLabel.LEFT);
      userPanel.add(avatarIcon);

      // create username text
      JLabel usernameLabel = new JLabel(post1.username, JLabel.LEFT);
      usernameLabel.setFont(boldFont);
      userPanel.add(usernameLabel);
      infoPanel.add(userPanel);

      // create caption text
      String txt = post1.caption;
      String html = "<html><body style='width: %1spx'>%1s";
      JLabel captionLabel = new JLabel(String.format(html, 200, txt), JLabel.LEFT);
      captionLabel.setFont(plainFont);
      infoPanel.add(captionLabel);

      // create "+" image
      ImageIcon commentButtonImage = new ImageIcon(post1.commentButton);
      JLabel commentButtonLabel = new JLabel(commentButtonImage);
      infoPanel.add(commentButtonLabel);

      // create user comments
      for (String comment : post1.comments) {
        JLabel commentLabel = new JLabel(comment, JLabel.LEFT);
        commentLabel.setFont(plainFont);
        infoPanel.add(commentLabel);
      }

      // create heart image
      ImageIcon likesImage = new ImageIcon(post1.likeButton);
      JLabel likesIconLabel = new JLabel(likesImage, JLabel.LEFT);
      likesPanel.add(likesIconLabel);

      // create number of likes
      JLabel likesCountLabel = new JLabel(String.valueOf(post1.likes), JLabel.LEFT);
      likesCountLabel.setFont(plainFont);
      likesPanel.add(likesCountLabel);
      infoPanel.add(likesPanel);

      // add panels to window
      window.add(imagePanel);
      window.add(infoPanel);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);

      //add code above this line
    }
  }
  ```
</details>
  
{Check It!|assessment}(multiple-choice-761353538)
