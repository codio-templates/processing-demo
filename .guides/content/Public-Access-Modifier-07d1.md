----------

## Public Attributes

While Java allows you to make instance attributes public, this is not encouraged. In fact, encapsulation asks that all attributes remain private. Java itself, however, allows for public attributes. The following class has three attributes and all of them are public.

```java
//add class definitions below this line
    
class Phone {
  public String model;
  public int storage;
  public int megapixels;
  
  Phone(String mo, int st, int me) {
    model = mo;
    storage = st;
    megapixels = me;
  }
}
  
//add class definitions above this line
```

Instantiate a `Phone` object and manipulate the different attributes.

```java
    //add code below this line

    Phone myPhone = new Phone("iPhone", 256, 12);
    System.out.println(myPhone.model);
    myPhone.storage = 64;
    System.out.println(myPhone.storage);
    System.out.println(myPhone.megapixels + 10);

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/PublicKeyword.java java -cp code/encapsulation/ PublicKeyword 1)

When an attribute is public, a user can do whatever they want to it. This can become problematic. In the code above, the phone's storage was reduced by 75%. This should not happen. Encapsulation limits what and how information is modified. By hiding data you can ensure that users only manipulate the class in an approved manner.

<details>
  <summary><strong>Do <code>public</code> and <code>default</code> mean the same thing?</strong></summary>
  Prior to learning about encapsulation, we used the <code>default</code> access modifier. We could modify the object any way we wanted. Similarly, we can modify the object any way you want with the <code>public</code> access modifier. Does this mean that <code>default</code> and <code>public</code> are the same? No. However, you will not notice a difference until you start working with packages, something we have not yet done. Elements with the <code>default</code> access modifier are only accessible in the same package. 
</details>

## Public Methods

Since all attributes should be private, we will use this access modifier for the following code sample. Unlike attributes, you are encouraged to have public methods. If all of your methods are private, it would be impossible to interact with the object. The constructor is a special kind of method, and this too should be public.

```java
//add class definitions below this line
    
class Phone {
  private String model;
  private int storage;
  private int megapixels;
  
  public Phone(String mo, int st, int me) {
    model = mo;
    storage = st;
    megapixels = me;
  }
}
  
//add class definitions above this line
```

The real benefit of a public method is that they can access private attributes. Public methods are the gateway to dealing with private data. Create the public method `describe` that prints a description of the `Phone` object.

```java
//add class definitions below this line
    
class Phone {
  private String model;
  private int storage;
  private int megapixels;
  
  public Phone(String mo, int st, int me) {
    model = mo;
    storage = st;
    megapixels = me;
  }
  
  public void describe() {
    System.out.println("My " + storage + " gig " + model + " has a " + megapixels + " megapixel camera.");
  }
}
  
//add class definitions above this line
```

Instantiate a `Phone` object and call the `describe` method.

```java
    //add code below this line

    Phone myPhone = new Phone("iPhone", 256, 12);
    myPhone.describe();

    //add code above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/PublicKeyword.java java -cp code/encapsulation/ PublicKeyword 2)

|||challenge
## Try this variation
* Change the constructor access modifier to `private`.

<details>
  <summary><strong>Why does this not work?</strong></summary>
  The constructor is a special kind of method that is automatically called when the <code>new</code> keyword is used. Once the constructor is private, it cannot be called outside the class. That is why Java throws an error message. The only way a private constructor can work is if a class is declared inside another class. The outer class can call the inner constructor even if it is private.
</details>

|||

{Try it}(sh .guides/bg.sh javac code/encapsulation/PublicKeyword.java java -cp code/encapsulation/ PublicKeyword 3)

{Check It!|assessment}(multiple-choice-4197611854)
