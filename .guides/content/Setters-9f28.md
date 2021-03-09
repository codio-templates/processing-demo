----------

## Setters

Setters are the compliment to getters in that they allow you to set the value of a private attribute. Setter methods are also called mutators. Use the `Phone` class from the previous page.

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
  
  public int getStorage() {
    return storage;
  }
  
  public int getMegapixels() {
    return megapixels;
  }
}
  
//add class definitions above this line
```

Add the `setModel` method to the `Phone` class. As this is a setter method, start the name with `set` followed by the name of the attribute. Setters do not return anything, so their type is `void`. Finally, setters have a parameter — the new value for the attribute.

```java
  public void setModel(String newModel) {
    model = newModel;
  }
```

Now that you are implementing both getters and setters, you should now be able to access and modify private attributes.

```java
    //add code below this line

    Phone myPhone = new Phone("iPhone", 256, 12);
    System.out.println(myPhone.getModel());
    myPhone.setModel("Pixel 5");
    System.out.println(myPhone.getModel());

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/Setters.java java -cp code/encapsulation/ Setters 1)

|||challenge
## Try this variation:
Create setters for the `storage` and `megapixels` attributes.

<details>
  <summary><strong>Possible Solution</strong></summary>
  
  ```java
  public void setStorage(int newStorage) {
    storage = newStorage;
  }
  
  public void setMegapixels(int newMegapixels) {
    megapixels = newMegapixels;
  }
  ```
  
</details>

|||

{Try it}(sh .guides/bg.sh javac code/encapsulation/Setters.java java -cp code/encapsulation/ Setters 2)

## Comparing Getters and Setters

Getters and setters have a lot in common. Their names are similar, they have the same number of lines of code, etc. However, getters and setters also differ in a few important ways. The table below highlights these similarities and differences.

|Category|Getters|Setters|
|:-------|:-----:|:-----:|
|Has `public` keyword|X|X|
|Has `private` keyword|-|-|
|Has `return` statement|X|-|
|Has `void` type|-|X|
|Performs only 1 task|X|X|
|Has parameter|-|X|

{Check It!|assessment}(parsons-puzzle-3781411493)
