----------

## List of Objects

You may find yourself needing several instances of a class. Keeping these objects in an ArrayList is a good way to organize your code. It also simplifies interacting with the objects because you can iterate through the ArrayList as opposed to manipulating each object separately.

The first thing you need to do is to create a class. We are going to make a class to represent the apps on your smartphone.

```java
// Define the App class

class App {
  private String name;
  private String description;
  private String category;
  
  public App(String n, String d, String c) {
    name = n;
    description = d;
    category = c;
  }
  
  public display() {
    System.out.println(String.format("%s is a(n) %s app that is %s.", name, category, description));
  }
}
```

Next, we need to create a list with objects of the `App` class as each element. To speed this up, we are going to read from a CSV file that has the information for the `name`, `description`, and `category` attributes.

<details>
  <summary><strong>Why use a CSV file?</strong></summary>
  This page is about manipulating a list of objects. Instead of manually creating several objects, we are going to read information from the <code>apps.csv</code> file and use it to create several objects in a simple loop. 
  
  ```markdown
  name,description,category
  Gmail,the official app for Google's email service,communication
  FeedWrangler,used to read websites with an RSS feed,internet
  Apollo,used to read Reddit,social media
  Instagram,the offical app for Facebook's Instagram service,social media
  Overcast,used to manage and listen to podcasts,audio
  Slack,the official app for Slack's email replacement,communication
  YouTube,the official app for Google's video service,video
  FireFox,used to browse the web,internet
  OverDrive,used to checkout ebooks from the library,ebooks
  Authenticator,used for two-factor authentication,internet
  ```
  
</details><br>

Make sure that you are altering the `ListOfObjects.java` file. Start by creating an ArrayList of type `App` and a variable that has the path to the CSV file. Then read the file and skip the header row. Iterate through each row of the CSV file. Add a new `App` object to the list. The first element is the name of the app, the second element is the description, and the third element is the category. Finally, print the ArrayList.

```java
    //add code below this line
    
    ArrayList<App> apps = new ArrayList<App>();
    String path = "code/advanced/app.csv";
    
    try {
      CSVReader reader = new CSVReader(new FileReader(path));
      reader.skip(1);
      for (String[] row : reader) {
        apps.add(new App(row[0], row[1], row[2]));
      }
      reader.close();
      System.out.println(apps);
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Finished reading a CSV");
    }
    
    //add code above this line
```

{Try it}(sh .guides/multipleFileCSV.sh ListOfObjects App 1)

<details>
  <summary><strong>Explaining the Output</strong></summary>
  The output from the above print statement is an ArrayList of elements that look something like this:
  
  ```markdown
  App@378bf509
  ```
  
  This is how Java represents an object. Each element is an <code>App</code> object. The <code>@</code> symbol and numbers is the location in memory where the object is stored (your memory locations will be different). If you see 10 of these, then your code is working properly.
  
</details>

## Interacting with the Objects

Now that there is a list of objects, we can manipulate each object by iterating through the list. We no longer need the print statement in our program. Replace it with a for loop. On each iteration, call the `display` method.

```java
    //add code below this line
    
    ArrayList<App> apps = new ArrayList<App>();
    String path = "code/advanced/app.csv";
    
    try {
      CSVReader reader = new CSVReader(new FileReader(path));
      reader.skip(1);
      for (String[] row : reader) {
        apps.add(new App(row[0], row[1], row[2]));
      }
      reader.close();
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Finished reading a CSV");
    }
    
    for (App app : apps) {
      app.display();
    }
    
    //add code above this line
```

{Try it}(sh .guides/multipleFileCSV.sh ListOfObjects App 2)

|||challenge
## Try these variations:
* Call the `display` method on only the third app.
  
  <details>
    <summary><strong>Solution</strong></summary>
    Normally, you would use a variable when instantiating an object. In this case, however, objects need to be referenced by the index in a list. Indexes start counting at 0, so the third element would be <code>.get(2)</code>:
    
    ```java
      //add code below this line
    
      ArrayList<App> apps = new ArrayList<App>();
      String path = "code/advanced/app.csv";

      try {
        CSVReader reader = new CSVReader(new FileReader(path));
        reader.skip(1);
        for (String[] row : reader) {
          apps.add(new App(row[0], row[1], row[2]));
        }
        reader.close();
      } catch (Exception e) {
        System.out.println(e);
      } finally {
        System.out.println("Finished reading a CSV");
      }
  
      apps.get(2).display();

      //add code above this line
    ```
  </details>
  
* Call the `display` method for all objects that are have "social media" as the `category` attribute.
  
  <details>
    <summary><strong>Solution</strong></summary>
    Iterate over the list and use a conditional to determine if the <code>category</code> attribute is "social media". If true, call the <code>display</code> method.
    
    ```java
      //add code below this line
    
      ArrayList<App> apps = new ArrayList<App>();
      String path = "code/advanced/app.csv";

      try {
        CSVReader reader = new CSVReader(new FileReader(path));
        reader.skip(1);
        for (String[] row : reader) {
          apps.add(new App(row[0], row[1], row[2]));
        }
        reader.close();
      } catch (Exception e) {
        System.out.println(e);
      } finally {
        System.out.println("Finished reading a CSV");
      }
  
      for (App app : apps) {
        if (app.getCategory().equals("social media")) {
          app.display();
        }
      }

      //add code above this line
    ```
    
  </details>

|||

{Try it}(sh .guides/multipleFileCSV.sh ListOfObjects App 3)
    
{Check It!|assessment}(parsons-puzzle-3265767851)
