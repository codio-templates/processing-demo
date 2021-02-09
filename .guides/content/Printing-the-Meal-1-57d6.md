## Planning the Method

Before writing the method to print the meal, think about what you want the output should like. Imagine that a meal consists of the following courses:

* Drinks - water and coffee
* Appetizers - nothing served as an appetizer
* Main course - roast chicken, mashed potatoes, and salad.
* Dessert - chocolate cake

Change your code to reflect this meal. Also, add the `print_meal` method even though it has not yet been declared.

```java
    //add code below this line

    Meal dinner = new Meal();
    dinner.addDrink("water");
    dinner.addDrink("coffee");
    dinner.addCourse("roast chicken");
    dinner.addCourse("mashed potatoes");
    dinner.addCourse("salad");
    dinner.addDessert("chocolate cake");
    dinner.printMeal();
    
    //add code above this line
```

The `printMeal` class method is going to invoke the helper method `printCourse`. Call `printCourse` four times, passing it the ArrayList that represents the course as well as the name of the course.

```java
  void addDessert(String d) {
    dessert.add(d);
  }
  
  void printMeal() {
    printCourse(drinks, "drinks");
    printCourse(appetizers, "appetizers");
    printCourse(mainCourse, "main course");
    printCourse(dessert, "dessert");
  }
```

The `printCourse` method should be able to handle an empty ArrayList (nothing served), an ArrayList of length 1, an ArrayList of length 2, and an ArrayList of 3 or more elements. Each of these scenarios has specific requirements: Is the verb singular or plural? Do you need a comma-separated list or just the word `"and"`? Should a word be capitalized?

## Nothing was Served


Printing a message for an empty ArrayList becomes tricky because the sentence changes based on the course.

* No **drinks were** served with the meal.
* No **appetizers were** served with the meal.
* No **main course was** served with the meal.
* No **dessert was** served with the meal.

Create a string variable `verb` that will represent the text in bold above. Then ask if the `name` parameter matches each of the four courses: `"drinks"`, `"appetizers"`, `"main course"`, or `"dessert"`. When you have a match, set `verb` to the appropriate string (the bold text above).

```java
  void printMeal() {
    printCourse(drinks, "drinks");
    printCourse(appetizers, "appetizers");
    printCourse(mainCourse, "main course");
    printCourse(dessert, "dessert");
  }

  void printCourse(ArrayList<String> course, String name) {
    String verb = "";
    
    if (name.equals("drinks")) {
      verb = "drinks were";
    } else if (name.equals("appetizers")) {
      verb = "appetizers were";
    } else if (name.equals("main course")) {
      verb = "main course was";
    } else if (name.equals("dessert")) {
      verb = "dessert was";
    }
  }
```

Next determine if no items were served by asking if the size of `course` is 0. If so, print a sentence that tells the user that no items were served for that course. Be sure to incorporate the variable `verb` to provide the proper context.

```java
  void printCourse(ArrayList<String> course, String name) {
    String verb = "";
    
    if (name.equals("drinks")) {
      verb = "drinks were";
    } else if (name.equals("appetizers")) {
      verb = "appetizers were";
    } else if (name.equals("main course")) {
      verb = "main course was";
    } else if (name.equals("dessert")) {
      verb = "dessert was";
    }
    
    if (course.size() == 0) {
      System.out.println("No " + verb + " served with the meal.");
    }
  }
```

Running the code now should produce `"No appetizers were served with the meal."` since it is the only course that is an empty ArrayList.

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 4)

|||challenge
## Try this variation:
Use the comment symbol `//` to comment out all of the lines with a method that adds a course to the `dinner` object. Run the program. The output should be:

```
No drinks were served with the meal.
No appetizers were served with the meal.
No main course was served with the meal.
No dessert was served with the meal.
```

<details>
  <summary><strong>Code</strong></summary>
  
  ```java
    //add code below this line

    Meal dinner = new Meal();
    // dinner.addDrink("water");
    // dinner.addDrink("coffee");
    // dinner.addCourse("roast chicken");
    // dinner.addCourse("mashed potatoes");
    // dinner.addCourse("salad");
    // dinner.addDessert("chocolate cake");
    dinner.printMeal();
    
    //add code above this line
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 5)

{Check It!|assessment}(multiple-choice-1589623942)
