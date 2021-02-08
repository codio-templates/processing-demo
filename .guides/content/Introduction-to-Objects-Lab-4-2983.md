----------

## Lab 4

In this lab, you will add the main image, an avatar, the username, and a caption to the app. All of these components will follow a two-step process: create the component and then add it to a panel.

### Add the Main Image

To add an image, you first need to make an `ImageIcon` object. Use the string stored in the `post1.media` attribute to tell Java where to find the image. Then add the image object to a `JLabel` object. Finally, add the label to the `imagePanel`.

```java
    // create fonts
    Font boldFont = new Font("SansSerif", Font.BOLD, 14);
    Font plainFont = new Font("SansSerif", Font.PLAIN, 14);

    // create waterfall image
    ImageIcon image = new ImageIcon(post1.media);
    JLabel imageLabel = new JLabel(image);
    imagePanel.add(imageLabel);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 3)

### Add the Avatar

Remember, the avatar and username both go in the `userPanel`, not the `imagePanel`. Just like the main image, create an `ImageIcon` object with the string in the `post1.avatar` attribute. Add the image to a `JLabel`. Add the `avatarIcon` to the `userPanel`. **Note**, you will not see the avatar because the `userPanel` has not yet been added to `infoPanel`.

```java
    // create waterfall image
    ImageIcon image = new ImageIcon(post1.media);
    JLabel imageLabel = new JLabel(image);
    imagePanel.add(imageLabel);

    // create avatar image
    ImageIcon avatarImage = new ImageIcon(post1.avatar);
    JLabel avatarIcon = new JLabel(avatarImage, JLabel.LEFT);
    userPanel.add(avatarIcon);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 4)

### Add the Username

Create a `JLabel` object with the string found in the `post1.username` attribute. Use `JLabel.LEFT` to tell Java that the text should be aligned to the far left of the label. We also want to use a bold font for the username. Use the `setFont` method and the `boldFont` object to make the text appear in bold. Add `usernameLabel` to `userPanel`, and then add `userPanel` to `infoPanel`.

```java
    // create avatar image
    ImageIcon avatarImage = new ImageIcon(post1.avatar);
    JLabel avatarIcon = new JLabel(avatarImage, JLabel.LEFT);
    userPanel.add(avatarIcon);

    // create username text
    JLabel usernameLabel = new JLabel(post1.username, JLabel.LEFT);
    usernameLabel.setFont(boldFont);
    userPanel.add(usernameLabel);
    infoPanel.add(userPanel);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 5)

### Add the Caption

The caption will be a bit different than the username. The caption is a long sentence, so we need to have word wrapping. To do this, treat the caption as HTML. Create a string variable for the `post1.caption` attribute. Then create the `html` variable. The text `%1spx` is used to tell Java how "wide" the text can be before going to the next line. The `%1s` tells Java what text is to be applied to the HTML formatting. The `captionLabel` uses `String.format` to set the width of the caption to 200 pixels, and the contents of the `txt` variable will be treated as HTML. Use a plain font for the caption, and add it to `infoPanel`.

```java
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
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 6)

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

    Post (String un, int ui, String m,
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
      JPanel infoPanel = new JPanel(new GridLayout(comments.size()+4, 1));
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
  
{Check It!|assessment}(fill-in-the-blanks-144652727)
