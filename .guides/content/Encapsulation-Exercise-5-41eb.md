----------

## Exercise 5

Create the class `SodaMachine` which sells soda. Assume that this machine only takes bills and that each can of soda costs $2. The class has the following attributes:

* `sodas` - array of strings that represents the types of soda sold. They are, `"coke"`, `"pepsi"`, `"sprite"`, and `"dr. pepper"`.
* `cokeInventory` - integer representing how many cans of Coke are in the machine. Start with 20.
* `pepsiInventory` - integer representing how many cans of Pepsi are in the machine. Start with 20.
* `spriteInventory` - integer representing how many cans of Sprite are in the machine. Start with 20.
* `drPepperInventory` - integer representing how many cans of Dr. Pepper are in the machine. Start with 20.
* `money` - double representing how much money is in the machine. Start with $10.

Each attribute should have a getter and a setter. In addition, there should be the public methods `totalInventory` and `buySoda`. `totalInventory` returns the total number of cans in the machine. The `buySoda` method takes a string that represents the type of soda to purchase and the amount of money inserted in the machine. The `buySoda` method should add the value of the money of inserted to the `money` attribute, make change if necessary, and update the inventory. It also needs to provide the following data validation:

* Validate that the soda is sold by the machine; provide a message to the user.
* Validate that the user inserted enough money; provide a message to the user.
* Validate that the amount entered is a positive number; provide a message to the user.

### Expected Output

### Important
The constructor does not have any parameters. Use the Java convention for naming getters and setters. The setter method for `sodas` needs an index and the name of the new soda.

{Try it}(sh .guides/bg.sh javac code/encapsulation/exercises/CodingExercise5.java java -cp code/encapsulation/exercises/ CodingExercise5 1)