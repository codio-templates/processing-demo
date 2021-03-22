----------

## Exercise 3

Create the class `Child` such that the following criteria are met:
* `Child` is a subclass of `Parent1` and `Parent2`
* Override `identify` so that it returns "This method is called from Child"
* Create the method `identify2` that invokes the `identify` method from `Parent2`. This **must** be done using the `super` keyword.

## Expected Output

Assume that `childObject` is an instance of the `Child` class. Then the following would be true:
* `childObject.identify()` would return `This method is called from Child`
* `childObject.identify2()` would return `This method is called from Parent2`

{Try it}(sh .guides/bg.sh javac code/inheritance/exercise3/Exercise3.java java -cp code/inheritance/exercise3/ Exercise3 1)