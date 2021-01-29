----------

## Lab 2

Now that you have all of the information needed to make a post, you can turn that into visual output using the `Swing` library. `Swing` allows you to build simple graphical user interfaces with a minimal amount of code. The next lab is going to be an introduction to `Swing` and a few of its features.

<details>
  <summary><strong>What to learn more about <code>Swing</code>?</strong></summary>
  These labs will only cover a tiny fraction of what can be done with the <code>Swing</code> library. The full documentation for <code>Tkinter</code> can be found <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html">here</a>. This documentation is not very user-friendly. A more beginner-friendly way to learn about <code>Swing</code> is a video tutorial like this YouTube <a href="https://www.youtube.com/watch?v=ZDw18yUwz6I&list=PLywxFF6tce1-yXyp0qSPYPl2-Mdx7l0A-">playlist</a>.
</details>

### Main Window

`Swing`'s output is a window. There are four steps needed to get a window up and running. First, create a `JFrame` object and pass it a string that represents the text to appear in the title bar of the window. Second, set the size (in pixels) of the window. Three, tell Java to stop the program when you close the window. Finally, set the window visibility to `true`.

```java
    //add code below this line

    JFrame window = new JFrame("Hello");
    window.setSize(300, 300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    //add code above this line
```

{Try it}(bash .guides/swing.sh javac code/introObjects/IntroSwing.java java -cp code/introObjects/ IntroSwing 1)

That is really all it takes to get a window up and running. You can adjust the title and size by changing the arguments with `setSize` and when initializing the `window` object.

### Label Widget - Text

A `JLabel` is an element that can contain text, and image, or both. Labels are going to be the building block for these labs.

![Swing Label](.guides/img/intro/swing_label.png)

Create a text label for your window. Be sure to add the label to the `window` object so that it appears on the screen.

```java
    //add code below this line

    JFrame window = new JFrame("Hello");
    window.setSize(300, 300);
    
    JLabel text = new JLabel("I am a label");
    window.add(text);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    //add code above this line
```

Other options for text `Labels`:
* Font - You can set the font family and size by creating a `Font` object. The available fonts are `Monospaced`, `Serif`, `SansSerif`, `Dialog`, `DialogInput`. You can also set the font to `BOLD`, `ITALIC`, or `PLAIN` as well. Use the `setFont` method to change the font for the label.
```java
    JLabel text = new JLabel("I am a label");
    Font font = new Font("Serif", Font.BOLD, 24);
    text.setFont(font);
    window.add(text);
```
* Justify - You can justify text in a label when creating a `JLabel` object. The three options are `LEFT`, `CENTER`, and `RIGHT`.
```java
    JLabel text = new JLabel("I am a label", JLabel.CENTER);
```
* Background Color - Before you can set the background color of a label, you must first make the background opaque. Then you can select a color. Here is a [list of colors](https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html) you can use.
```java
    text.setOpaque(true);
    text.setBackground(Color.blue);
```
* Text Color - The `setForeground` method is used to set the color of a label's text. Use the same colors in the link above.
```java
    text.setForeground(Color.red);
```

{Try it}(bash .guides/swing.sh javac code/introObjects/IntroSwing.java java -cp code/introObjects/ IntroSwing 2)

### Grid System

Adding elements to the window is a two-step process. First define the element, then place it in the window using the grid system. Use the `setLayout` method to make a grid. The `Grid` object takes two arguments, the number of rows and the number of columns. The order in which you add the labels to `window` determines the position. Java places the elements from left to right and top to bottom.

```java
    //add code below this line

    JFrame window = new JFrame("Hello");
    window.setSize(300, 300);
    window.setLayout(new GridLayout(2, 2));
    
    JLabel text1 = new JLabel("One", JLabel.CENTER);
    JLabel text2 = new JLabel("Two", JLabel.CENTER);
    JLabel text3 = new JLabel("Three", JLabel.CENTER);
    JLabel text4 = new JLabel("Four", JLabel.CENTER);
    
    window.add(text1);
    window.add(text2);
    window.add(text3);
    window.add(text4);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    //add code above this line
```

{Try it}(bash .guides/swing.sh javac code/introObjects/IntroSwing.java java -cp code/introObjects/ IntroSwing 3)

|||challenge
## Try this variation:
Change the order in which the text labels are added to the window.
```java
    window.add(text4);
    window.add(text2);
    window.add(text1);
    window.add(text3);
```

|||

{Try it}(bash .guides/swing.sh javac code/introObjects/IntroSwing.java java -cp code/introObjects/ IntroSwing 4)

### Image Label

Using an image in a label is also a two-step process. First create an image object for `Tkinter`, then attach the image to the label by replacing the `text` option with `image`. You still need to use `grid` to place the image in the window.

```java
    //add code below this line

    JFrame window = new JFrame("Hello");
    window.setSize(300, 300);
    
    ImageIcon feather = new ImageIcon("studentFolder/feather.png");
    JLabel image = new JLabel(feather);
    window.add(image);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    //add code above this line
```

{Try it}(bash .guides/swing.sh javac code/introObjects/IntroSwing.java java -cp code/introObjects/ IntroSwing 5)

|||challenge
## Explore `Swing`
* Try out various fonts and font sizes
* Experiment with different colors
* Position labels around the window with the grid system

|||

{Try it}(bash .guides/swing.sh javac code/introObjects/IntroSwing.java java -cp code/introObjects/ IntroSwing 6)

{Check It!|assessment}(multiple-choice-568683216)
