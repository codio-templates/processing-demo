----------

## Exercise 5

Use the superclasses to the left to help you solve this problem. The first parent is the `Person` class with some very generic information. The second class, `CardHolder`, is the class for a credit card holder. Create the child class `PlantinumClient`. This class inherits all of the attributes of both parent classes. In addition, the child class has the attributes `cash_back` and `rewards`. `cash_back` should be set to 0.02 and `rewards` should be set to `0`. Override the `process_sale` method so that 2% of each sale is added to `rewards`.

## Expected Output

Declare an instance of the `PlatinumClient` class as shown below.

```python
platinum = PlatinumClient("Sarah", "101 Main Street", 123364)
```

Your class should be able to execute the code below in the stated order and produce the given return values.

|Order|Code|Return Value|
|:----|:---|:-----------|
|1|`platinum.process_sale(100)`|N/A|
|2|`print(platinum.rewards)`|`2`|
|3|`print(platinum.balance)`|`100`|
|4|`platinum.make_payment(50)`|N/A|
|5|`print(platinum.balance)`|`50`|
|6|`print(platinum.get_info())`|`Sarah lives at 101 Main Street.`|

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise5/Exercise5.java java -cp code/inheritance/exercise5/ Exercise5 1)