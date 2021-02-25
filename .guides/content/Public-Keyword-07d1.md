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

## Public Methods

Unlike attributes, you are encouraged to have public methods. If all of your methods are private, it would be impossible to interact with the object. The constructor is a special kind of method, and this too should be public.

```java
//add class definitions below this line
    
class Phone {
  public String model;
  public int storage;
  public int megapixels;
  
  public Phone(String mo, int st, int me) {
    model = mo;
    storage = st;
    megapixels = me;
  }
}
  
//add class definitions above this line
```

{Try it}(sh .guides/bg.sh javac code/encapsulation/PublicKeyword.java java -cp code/encapsulation/ PublicKeyword 2)

<details>
  <summary><strong>Is using the public keyword the same as using no keyword?</strong></summary>
  Prior to learning about encapsulation, no access modifiers were used for constructors, methods, or attributes. In this case, Java assumes the <code>default</code> access modifier. With the <code>default</code> keyword, you could modify the object any way you wanted. Similarly, you can modify the object any way you want with the <code>public</code> keyword. Does this mean that <code>default</code> and <code>public</code> are the same? No. However, you will not notice a difference until you start working with packages, something we have not yet done. 
</details>