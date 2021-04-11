----------

## Importing a User-Defined Class

You may have noticed that writing your own classes adds many lines of code before your the logic of your program even begins. To better organize your code, define classes in a separate file. Then import the module into your program so you can use the class.

Make sure you are in the file for defining the class (look at the comments at the top of the files). Start by creating a simple `Employee` class.

<details>
  <summary><strong>Switching Between Files</strong></summary>
  Notice that the IDE on the left now has more than one file. Click on the tabs on the top to switch between the files.

  ![Switching Files](.guides/img/advanced/switch_tabs.gif)
  
</details><br>

```java
// This file is the class definition

class Employee {
  private String name;
  private String title;
  
  public Employee(String n, String t) {
    name = n;
    title = t;
  }
  
  public void display() {
    System.out.println("Employee: " + name);
    System.out.println("Title: " + title);
  }
}
```

Now go to the file for your program (look at the comments at the top of the files). Instantiate an `Employee` object with two strings as arguments. Then call the `display` method. 

```java
    //add code below this line

    Employee e = new Employee("Calvin", "CEO");
    e.display();
    
    //add code above this line
```

{Try it}(sh .guides/multipleFiles.sh javac code/advanced/ImportingClasses.java code/advanced/ClassDefinition.java java -cp code/advanced/ ImportingClasses 1)

## How Does This Work?

You may have noticed that the file that implements the `Employee` object did not use the `import` keyword. How does Java know to look in the `ClassDefinition.java` file to find the class definition for `Employee`? Java has a two-step process to run a program. First you compile it. This turns the source code (the code you wrote) and compiles (transforms) it to byte code. The next step is to run the byte code on the Java Virtual Machine. All of this is hidden behind the `TRY IT` buttons.

If compile two (or more) files that are in the same folder, Java now knows about all of the classes in all of the files. You do not need an `import` statement because the compilation process has already informed Java of all of the classes.

The terminal command `javac` means to compile Java source code. Give this command the path to each of the Java files `ImportingClasses.java` and `ClassDefinition.java`. Notice how both Java files are in the same folder. These files **must** be in the same folder. Copy and paste the command below into the terminal and press `Enter` on the keyboard. This is the point where Java would return any error messages. If Java does not do anything, then the compilation process was successful.

```bash
javac code/advanced/ImportingClasses.java code/advanced/ClassDefinition.java
```

Once the byte code has been made, go ahead and run the program. The command to run a Java program is `java`. The parameter `-cp` stands for class path. This is the folder in which the Java program lives. Finally `ImportingClasses` is the actual program (the file with the `main` method). This command will produce the output from your program.

```bash
java -cp code/advanced/ ImportingClasses
```

The rest of this module will continue to use the `TRY IT` button, it is important to understand how Java can use multiple files for a single program.

{Check It!|assessment}(multiple-choice-1696965695)
