----------

## Lab 3

Now that you have had a brief introduction to `Swing`, you are going to create a mockup of a post on Photogram using the information stored in the `Post` object created in Lab 1. Before beginning, remove all of the print statements in the `main` method.

### Setting up the Window

The first step is to setup the window for the app. Just as in Lab 2, you are going to create a window, give it a title, set the size, and choose a background color. This code should go after you instantiate the `post1` object.

```java
    Post post1 = new Post(username, userId, media, avatar,
                          commentButton, likes, caption,
                          comments, likeButton);

    JFrame window = new JFrame("Photogram");
    window.setSize(800, 500);
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true); //this should be your last line of code
```

It is important to know in advance what the layout of the app should be. This will influence how the window is created. The image below shows the general layout of Photogram.

![Photogram Layout](.guides/img/intro/photogram-layout.png)

It is important to note that the window has three columns. Column 0 will be as wide as the image; `Tkinter` does this automatically. We want column 2 to be twice as wide as column 1. This will ensure that the avatar and like icon will be positioned properly. Add the following two lines of code to make column 2 twice as wide as column 1. Running the program will show a large, white rectangle. These lines of code should go before `window.mainloop()`.

```python
window.grid_columnconfigure(1, weight=0)
window.grid_columnconfigure(2, weight=1)
```

{Try it}(bash .guides/swing.sh javac code/introObjects/Photogram.java java -cp code/introObjects/ Photogram 1)

<details>
  <summary><strong>Larger viewing area</strong></summary>
  Click the blue triangle icon to open the <code>Tkinter</code> project in a new tab. You can leave this tab open. Each time you click a <code>TRY IT</code> button, the tab will update with the latest version of your project.
</details>

### Add Photo Variables

Just like in Lab 2, you will need to create a `Tkinter` image object for each image, and then store them in a variable.

```python
photo = tkinter.PhotoImage(file=post1.media)
comment_button = tkinter.PhotoImage(file=post1.comment_button)
avatar = tkinter.PhotoImage(file=post1.avatar)
like_button = tkinter.PhotoImage(file=post1.like_button)
```

### Add Main Photo

Create the variable `image` to represent the large image on the left. Adding the image is going to be a two-step process: create the label and place the label. 

```python
# Big photo on the left
image = tkinter.Label(
	window,
	image=photo,
	bg="white")

image.grid(
	row=0,
	column=0,
	rowspan=10,
	stick="W")
```

There are a couple of things that were not covered in Lab 2. First, `rowspan=10` means that the main photo is going to span across ten rows. If you did not do this, row 1 would start below the main photo. In the layout image above, there is nothing below the main photo. `stick="W"` makes the main photo "sticky" to the "west" (left). If the `Tkinter` window were to be resized, the main photo would always remain to the far left.

{try it}(bash .guides/bg.sh python3 code/intro_objects/lab.py 2)
