----------

## More on Class Methods and Objects

Changes to objects should happen exclusively through class methods. This makes your code easier to organize and easier for others to understand. Imagine you are going to create a class that keeps track of a meal. In this case, a meal can be thought of as all of the drinks, appetizers, courses, and desserts served. Each one of these categories will become an instance variable. Assign each attribute an ArrayList of strings.

```java
//add class definitions below this line

class Meal {
  ArrayList<String> drinks = new ArrayList<String>();
  ArrayList<String> appetizers = new ArrayList<String>();
  ArrayList<String> mainCourse = new ArrayList<String>();
  ArrayList<String> desserts = new ArrayList<String>();
}
 
//add class definitions above this line
```

Next, add a class method to add a drink to the `Meal` object. Use the `.add` method to add an element to the list. So `drinks.add(d)` adds the drink `d` to the ArrayList `drinks`.

```java
//add class definitions below this line

class Meal {
  ArrayList<String> drinks = new ArrayList<String>();
  ArrayList<String> appetizers = new ArrayList<String>();
  ArrayList<String> mainCourse = new ArrayList<String>();
  ArrayList<String> desserts = new ArrayList<String>();

  void addDrink(String d) {
    drinks.add(d);
  }
}
 
//add class definitions above this line
```

Create a `Meal` object and test your code to make sure it is working as expected. Remember to indent `add_drink` so that it is a part of the `Meal` class.

```java
    //add code below this line

    Meal dinner = new Meal();
    dinner.addDrink("water");
    System.out.println(dinner.drinks);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 1)

Now create the `addAppetizer` method to the class. Like the method above, `addAppetizer` accepts a string as a parameter and adds it to the `appetizers` attribute. 

```java
  void addDrink(String d) {
    drinks.add(d);
  }

  void addAppetizer(String a) {
    appetizers.add(a);
  }
```

Add `"bruschetta"` to the `dinner` object and print it.

```java
    //add code below this line

    Meal dinner = new Meal();
    dinner.addDrink("water");
    System.out.println(dinner.drinks);
    dinner.addAppetizer("bruschetta");
    System.out.println(dinner.appetizers);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 2)

|||challenge
## Create the following methods:
* `addCourse` - accepts a string which represents a course and adds it to the meal.
* `addDessert` - accepts a string which represents a dessert and adds it to the meal.

Test your code using `"roast chicken"` as a main course and `"chocolate cake"` as a dessert. Then print out each course of the meal.
<details>
  <summary><strong>Meal code</strong></summary>
  
  ```java
  import java.util.ArrayList;

  //add class definitions below this line

  class Meal {
    ArrayList<String> drinks = new ArrayList<String>();
    ArrayList<String> appetizers = new ArrayList<String>();
    ArrayList<String> mainCourse = new ArrayList<String>();
    ArrayList<String> desserts = new ArrayList<String>();

    void addDrink(String d) {
      drinks.add(d);
    }

    void addAppetizer(String a) {
      appetizers.add(a);
    }
  
    void addCourse(String c) {
      mainCourse.add(c);
    }
  
    void addDessert(String d) {
      desserts.add(d);
    }
  }

  //add class definitions above this line

  public class MoreMethods {  
    public static void main(String[] args) {

      //add code below this line

      Meal dinner = new Meal();
      dinner.addDrink("water");
      dinner.addAppetizer("bruschetta");
      dinner.addCourse("roast chicken");
      dinner.addDessert("chocolate cake");
  
      System.out.println(dinner.drinks);
      System.out.println(dinner.appetizers);
      System.out.println(dinner.mainCourse);
      System.out.println(dinner.desserts);

      //add code above this line
    }
  }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/mutability/MoreMethods.java java -cp code/mutability/ MoreMethods 3)

{Check It!|assessment}(parsons-puzzle-2540601199)
