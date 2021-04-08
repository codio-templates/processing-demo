----------

## Exercise 5

You are going to write a program that simulates an online shopping cart. Create the composite class `ShoppingCart` in the `ShoppingCart.java` file, and create the component class `Item` in the `Item.java` file. The tables below indicate which attributes and methods your classes will need to create.

### The Shopping Cart Class
**Important**, the `ShoppingCart` class should initialize the attributes to either a 0 or an empty ArrayList. Your `ShoppingCart` class should have the following attributes:

|Attribute|Explanation|
|---------|-----------|
|`items`  |ArrayList of `Item` elements|
|`total`  |Total value (double) of all of the items in the shopping cart|

It should also have the following methods:

|Method|Explanation|
|------|-----------|
|`public ShoppingCart`|The constructor should not take any arguments|
|`addItem`|Add an item to the shopping cart and then calls the `calculateTotal` method|
|`calculateTotal`|Assigns the total value of the shopping cart to the `total` attribute|
|`getTotal`|Returns the total value of the shopping cart|
|`getNumItems`|Returns the number of items in the shopping cart|
|`toString`|Returns a human-readable string; see the Expected Output section for the format|

### The Item Class
**Important**, the `subtotal` attribute is not passed to the constructor. Initialize this attribute with a 0. Your `Item` class should have the following attributes:

|Attribute |Explanation|
|----------|-----------|
|`name`    |Name (string) of the item|
|`price`   |How much (double) the item costs|
|`quantity`|How many (int) items you have|
|`subtotal`|Value (double) of all of the items|

It should also have the following methods:

|Method|Explanation|
|------|-----------|
|`public Item`|The order of the parameters should be `name`, `price`, and then `quantity`|
|`calculateSubtotal`|Assigns the total value of the items to the `subtotal` attribute|
|`getSubtotal`|Returns the `subtotal` attribute|
|`toString`|Returns a human-readable string; see the Expected Output section for the format|

### Expected Output
You can check your work by opening the `Exercise5.java` file. Instantiate the three `Item` objects and a `ShoppingCart` object. Then add the items to the cart.

```java
    //add code below this line

    Item item1 = new Item("milk", 1.5, 1);
    Item item2 = new Item("apple", 0.75, 5);
    Item item3 = new Item("bread", 2.25, 2);
    ShoppingCart cart = new ShoppingCart();

    cart.addItem(item1);
    cart.addItem(item2);
    cart.addItem(item3);

    //add code above this line
```

Next, add some `print` statements to the `main` method to make sure you code is working as intended.

```java
    System.out.println(cart.getTotal());
    System.out.println(cart.getNumItems());
    System.out.println(cart);
```

You should see the following output:

```markdown
9.75
8
ShoppingCart[items=[Item[name=milk, price=1.5, quantity=1, subtotal=1.5], Item[name=apple, price=0.75, quantity=5, subtotal=3.75], Item[name=bread, price=2.25, quantity=2, subtotal=4.5]], total=9.75]
```

{Try it}(sh .guides/exercise4.sh javac code/advanced/exercise5/Exercise5.java code/advanced/exercise5/Item.java code/advanced/exercise5/ShoppingCart.java java -cp code/advanced/exercise5/ Exercise5 1)

{Check It!|assessment}(test-1581249114)
