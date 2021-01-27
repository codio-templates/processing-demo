----------

## Lab 1

The previous coding examples for objects have revolved around the `Actor` object. Using a real-world example makes the concept of classes a little easier to understand. But the `Actor` class does not accurately reflect how objects are used in programming. The following pages show how object could be used by a social network like Instagram. Imagine there exists a social network called Photogram that allows you to share, like, and comment on photos. Your feed is comprised of a series of posts containing information like the username, media(image or video), a message, likes, and a list of comments. We are going to create a `Post` object to reflect this.

<details>
  <summary><strong>Is this how Instagram really works?</strong></summary>No, not really. This is just an approximation. Facebook undoubtedly uses a more complex and robust system to store, manage, and display Instagram posts.
</details>

### Components of a Post

It is always a good idea to think about all the various pieces of information that need to be stored in an object. It is also important to think about how that information should be represented. Let's say you have 100 followers. You could represent that as a string, `"100"`. But storing the follower count as an int is a better idea. If you gain a follower, you cannot say `"100" + 1`. You would have to typecast `"100"` as an int, add the new follower, and then typecast the new follower count back to a string. Storing this information as an int is much easier. Here are the elements that make up a post for Photogram:
* Username - The user who creates the post should be stored as a string.
* Id - Some social networks let you change your username. To avoid confusion about usernames, an unique id number is used to refer to each user on a social network. This should be stored as an int.
* Media - Each post has an image or video to display. Media files are often stored elsewhere on a server. The object should store the path to the media file so it can be retrieved and shown to the public. This information should be stored as a string.
* Avatar - The user's avatar should appear next to their post. The object should store the path to an avatar as a string.
* Comment Button - Each post has a button so viewers can add their comment. The object should store the path to this button as a string. **Note**, this will not be a working button.
* Caption - The caption that accompanies the media file should be stored as a string.
* Likes - The number of times people have liked a post should be stored as an int.
* Comments - Comments should be stored as a string. However, each post can have a multitude of comments. So this information should be stored as an ArrayList of strings.
* Like Button - Heart-shaped icon views could click to like a post. This will be stored as a string.

### Defining the Post Class

Now that you know all of the attributes needed to create a post for Photogram, you can define the `Post` class and its constructor.

```java
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
```

Now, declare an instance of the `Post` class with some information. For the sake of readability, each of the parameters will be assigned to a variable. Then, the variables will be passed to the object for instantiation. The elements of the ArrayList are added one at a time. **Note** there is an actual image file that will be used, so be sure the file path is correct.

```java
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
    
    //add code above this line
```

|||challenge
## Check your work
Print each attribute of `post1` to see that everything is working as expected.

|||

<details>
  <summary><strong>Code</strong></summary>
  
  ```java
  import javax.swing.*;
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

  public class LabIntro {
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

      System.out.println(post1.username);
      System.out.println(post1.userId);
      System.out.println(post1.media);
      System.out.println(post1.avatar);
      System.out.println(post1.commentButton);
      System.out.println(post1.caption);
      System.out.println(post1.likes);
      System.out.println(post1.comments);
      System.out.println(post1.likeButton);

      //add code above this line
    }
  }
  ```
</details><br>

{Try it}(sh .guides/bg.sh javac code/introObjects/LabIntro.java java -cp code/introObjects/ LabIntro 1)
  
{Check It!|assessment}(multiple-choice-3387365333)
