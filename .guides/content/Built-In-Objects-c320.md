----------

## The String Object

You have already been using built-in Java objects. Strings are an example of a Java object.

```java
    //add code below this line

    String s = new String("I am a string");
    System.out.println(s.getClass());

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/BuiltIn.java java -cp code/introObjects/ BuiltIn 1)

|||challenge
## Try these variations:
Explore some of the methods associated with the string class.
* Add the line of code `System.out.println(s.isEmpty());`
* Add the line of code `System.out.println(s.getBytes());`
* Add the line of code `System.out.println(s.endsWith("g"));`

|||

{Try it}(sh .guides/bg.sh javac code/introObjects/BuiltIn.java java -cp code/introObjects/ BuiltIn 3)

Java says that the class of `s` is `java.lang.String` (which is a string). Add the following code and run the program again.

```java
    //add code below this line

    String s = new String("I am a string");
    System.out.println(s.getClass());
    
    Method[] methods = s.getClass().getDeclaredMethods();
    for (Method m : methods) {
      System.out.println("Method name: " + m + "\n");
    }

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/introObjects/BuiltIn.java java -cp code/introObjects/ BuiltIn 2)

The variable `methods` is an array of all methods associated with the `String` class. If you look carefully at the output, you may be confused by the information on the screen. However, a few things, like `toUpperCase` and `toLowerCase`, may seem familiar. Methods will be covered in a later lesson, but it is important to understand that a string is not a simple collection of characters. Because a string is a class, it is a powerful way of collecting and modifying data.

## Vocabulary

In the text above, the words "class" and "object" are used in an almost interchangeable manner. There are many similarities between classes and objects, but there is also an important difference. Working with objects has a lot of specialized vocabulary. 

**Classes** - Classes are a collection of data and the actions that can modify the data. Programming is a very abstract task. Classes were created to give users a mental model of how to think about data in a more concrete way. Classes act as the blueprint. They tell Java what data is collected and how it can be modified.

**Objects** - Objects are constructed according to the blueprint that is the class. In the code above, the variable `s` is a string object. It is not the class. The string class tells Java that `s` has methods like `length`, `concat`, and `replace`. When a programmer wants to use a class, they create an object.

**Instance** - Another way that programmers talk about objects is to say that an object is an instance of a particular class. For example, `s` is an instance of the `String` class.

**Instantiation** - Instantiation is the process where an object is created according to blueprint of the class. The phrase "define a variable" means to create a variable. The variable is given a name and a value. Once it has been defined, you can use the variable. With objects, you use the phrase "instantiate an object". That means to create an object, give it a name, store any data, and define the actions the object can perform.

![Class vs Object](.guides/img/intro/java_class_v_object.png)

{Check It!|assessment}(fill-in-the-blanks-3985050060)
