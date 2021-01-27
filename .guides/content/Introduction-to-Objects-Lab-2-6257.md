----------

## Lab 2

Now that you have all of the information needed to make a post, you can turn that into visual output using the `Swing` library. `Swing` allows you to build simple graphical user interfaces with a minimal amount of code. The next lab is going to be an introduction to `Swing` and a few of its features.

<details>
  <summary><strong>What to learn more about <code>Swing</code>?</strong></summary>
  These labs will only cover a tiny fraction of what can be done with the <code>Swing</code> library. The full documentation for <code>Tkinter</code> can be found <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html">here</a>. This documentation is not very user-friendly. A more beginner-friendly way to learn about <code>Swing</code> is a video tutorial like this YouTube <a href="https://www.youtube.com/watch?v=ZDw18yUwz6I&list=PLywxFF6tce1-yXyp0qSPYPl2-Mdx7l0A-">playlist</a>.
</details>

### Main Window

`Swing`'s output is a window. There are three steps needed to get a window up and running. First, create a `JFrame` object and pass it a string that represents the text to appear in the title bar of the window. Second, set the size (in pixels) of the window. Finally, set the window visibility to `true`.

```java
    //add code below this line

    JFrame window = new JFrame("Hello");
    window.setSize(300, 300);
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
    window.setVisible(true);
    
    JLabel text = new JLabel("I am a label");
    window.add(text);

    //add code above this line
```

Other options for text `Labels`:
* Font - You can set the font family and size by creating a `Font` object. Use the `setFont` method to change the font for the label. The available fonts are DejaVuSerif, DejaVuSansMono, DejaVuSans. You can also set the font to `bold` as well. An example of the `font` option is: `font="DejaVuSeif 18 bold"`.
```java

```
* Justify - The `justify` option allows you to align text inside of a `Label`. The options are `"left"`, `"right"`, and `"center"`. An example of the `justify` option is: `justify="left"`.
* Background Color - Use the `bg` option to set the background color. Colors can be done with either CSS or hex colors. An example of the `bg` option is: `bg="blue"`.
* Text Color - Use the `fg` option (foreground) to set the color of the text. An example of the `fg` option is: `fg="red"`.
* Wrap Length - Widgets set their size based on its contents. While this can be helpful, this can also make getting the perfect layout difficult at times. The `wraplength` option tells `Tkinter` when to continue the text on the next line. This keeps the label widget from becoming too wide for your desired layout.

### Grid System

Adding widgets to the window is a two-step process. First define the widget, then place it in the window using the grid system. The grid system works by positioning widgets with a row and column number. Rows and columns start counting with 0. The sizes of rows and columns is dependent upon the size of the widget. Here is how to place the `my_label` widget in the top-left corner.

```python
my_label.grid(row=0, column=0)
```

{try it}(bash .guides/bg.sh python3 code/intro_objects/lab2.py 3)

The grid system can be a bit difficult to use. For instance, if you want to put a single label in location `row=1, column=1`, the label will appear in the top-left corner. Positioning is relative to other widgets.

### Image Label

Using an image in a label is also a two-step process. First create an image object for `Tkinter`, then attach the image to the label by replacing the `text` option with `image`. You still need to use `grid` to place the image in the window.

```python
feather_image = tkinter.PhotoImage(file="student_folder/img/feather.png")
image_label = tkinter.Label(window, image=feather_image)
image_label.grid(row=1, column=1)
```

{try it}(bash .guides/bg.sh python3 code/intro_objects/lab2.py 4)

|||challenge
## Explore `Tkinter`
* Try out various fonts and font sizes
* Position labels around the window with the grid system
* Create other image objects (`tkinter.PhotoImage`) and add more images to the window

|||

{try it}(bash .guides/bg.sh python3 code/intro_objects/lab2.py 5)


{Try it}(bash .guides/swing.sh javac code/introObjects/IntroSwing.java java -cp code/introObjects/ IntroSwing 1)