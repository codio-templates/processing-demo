----------

## Lab 3

Now that you have had a brief introduction to `Swing`, you are going to create a mockup of a post on Photogram using the information stored in the `Post` object created in Lab 1. Before beginning, remove all of the print statements in the `main` method.

### Setting up the Window

The first step is to setup the window for the app. Just as in Lab 2, you are going to create a window, give it a title and set the size. In addition, set the layout to `FlowLayout`. This means panels added to the window will be added left to right.

```java
    Post post1 = new Post(username, userId, media, avatar,
                          commentButton, likes, caption,
                          comments, likeButton);

    // create window
    JFrame window = new JFrame("Photogram");
    window.setSize(800, 500);
    window.setLayout(new FlowLayout(3));
    
    // add panels to window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
```

It is important to know in advance what the layout of the app should be. This will influence how the window is created. The image below shows the general layout of Photogram. 

![Photogram Layout](.guides/img/intro/photogram-layout.png)

### Add Panels

This project uses several panels to contain information. In some cases, there will be panels inside other panels. Create the following panels. The `infoPanel` uses a `GridLayout` which means content will be added vertically. The `infoPanel` has 10 rows (the size of the `comments` ArrayList plus 4) and 1 column. The panels with a `FlowLayout` will add content horizontally. The arguments for `FlowLayout` mean that the components will be aligned to the left (the `3`), have a vertical gap of 0 pixels, and a horizontal gap of 5 pixels.

```java
    // create window
    JFrame window = new JFrame("Photogram");
    window.setSize(800, 500);
    window.setLayout(new FlowLayout(3));
    
    // create panels
    JPanel imagePanel = new JPanel();
    JPanel infoPanel = new JPanel(new GridLayout(comments.size()+4, 1));
    JPanel userPanel = new JPanel(new FlowLayout(3, 0, 5));
    JPanel likesPanel = new JPanel(new FlowLayout(3, 0, 5));
```

Be sure that `imagePanel` and `infoPanel` are added to the window. The panels for the user and likes will be added later. Running the program produces a window that is 800 pixels by 500 pixels. You cannot see the panels. Be sure to close the window before running the code again.

```java
    // add panels to window
    window.add(imagePanel);
    window.add(infoPanel);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 1)

<details>
  <summary><strong>Larger viewing area</strong></summary>
  Click the blue triangle icon to open the <code>Swing</code> project in a new tab. You can leave this tab open. Each time you click a <code>TRY IT</code> button, the tab will update with the latest version of your project.
</details>

### Create Fonts

This project uses two different fonts. Both of them will be from the `SansSerif` family, and they will both be size 14. However, one will be `BOLD` while the other is `PLAIN`. 

```java
    // create panels
    JPanel imagePanel = new JPanel();
    JPanel infoPanel = new JPanel(new GridLayout(comments.size()+4, 1));
    JPanel userPanel = new JPanel(new FlowLayout(3, 0, 5));
    JPanel likesPanel = new JPanel(new FlowLayout(3, 0, 5));
    
    // create fonts
    Font boldFont = new Font("SansSerif", Font.BOLD, 14);
    Font plainFont = new Font("SansSerif", Font.PLAIN, 14);
```

Running the program should produce no visible changes. However, you want to make sure your code runs before moving on the next page.

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 2)

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
      JPanel infoPanel = new JPanel(new GridLayout(comments.size()+4, 1));
      JPanel userPanel = new JPanel(new FlowLayout(3, 0, 5));
      JPanel likesPanel = new JPanel(new FlowLayout(3, 0, 5));

      // create fonts
      Font boldFont = new Font("SansSerif", Font.BOLD, 14);
      Font plainFont = new Font("SansSerif", Font.PLAIN, 14);

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

{Check It!|assessment}(multiple-choice-808538143)
