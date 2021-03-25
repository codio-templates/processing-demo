----------
## Getters
While all attributes are private, that does not mean that the user will not need to access the values of these attributes. A public method can be used to access an attribute. This type of method has a special name, a getter (also called an accessor). The whole purpose of a getter is to return an attribute. These methods get their name because the method always start with `get` followed by the attribute name.

```java
//add class definitions below this line
    
class Phone {
  private String model;
  private int storage;
  private int megapixels;
  
  public Phone(String mo, int s, int me) {
    model = mo;
    storage = s;
    megapixels = me;
  }
  
  public String getModel() {
    return model;
  }
}
  
//add class definitions above this line
```

The method `getModel` is an example of a getter. They are very simple, straightforward methods that do only one thing — return a private attribute. Getters can be treated just as you would treat the attribute (except for changing its value).

```java
    //add code below this line

    Phone myPhone = new Phone("iPhone", 256, 12);
    System.out.println(myPhone.getModel());
    System.out.println(myPhone.getModel().toUpperCase());
    System.out.println(myPhone.getModel().startsWith("b"));
    System.out.println(myPhone.getModel().indexOf("n"));

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/Getters.java java -cp code/encapsulation/ Getters 1)

|||challenge
## Try this variation:
Create getters for the `storage` and `megapixels` attributes.

<details>
  <summary><strong>Possible Solution</strong></summary>
  
  ```java
  public int getStorage() {
    return storage;
  }
  
  public int getMegapixels() {
    return megapixels;
  }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/encapsulation/Getters.java java -cp code/encapsulation/ Getters 2)

## Benefits of Getters

Using a getter is the same thing as accessing a public attribute. Why not make the attribute public? That would mean writing less code. Is that not a good thing? A public attribute makes no distinction between accessing its value and changing its value. If you can access it, you can change it (or vice versa). Using a getter with a private attribute makes this distinction clear; you can access the value, but you cannot change it.

```java
    //add code below this line

    Phone myPhone = new Phone("iPhone", 256, 12);
    System.out.println(myPhone.getModel());
    myPhone.model = "Pixel 5";

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/Getters.java java -cp code/encapsulation/ Getters 3)

The code above generates an error because an instance cannot alter a private attribute. Using a getter allows limited access to an attribute, which is preferable to the full access a public access modifier allows.

{Check It!|assessment}(parsons-puzzle-1957726401)
