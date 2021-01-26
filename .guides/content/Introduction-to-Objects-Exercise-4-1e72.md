----------

## Exercise 4

Define the class `Observation` which will help record observational data from a scientific outpost in Antarctica. The class should have a constructor that accepts parameters for `date`, `temperature`, `elevation`, and `penguins`. There should also be an attribute for `precipitation`. Since Antarctica is a desert, `precipitation` should **default** to 0.

* `date`- String with the date of the observation, e.g. `"October 26, 2019"`
* `temperature` - Double with the temperature in Celsius, e.g. `-47`
* `elevation` - Double with elevation in meters, e.g. `329.4`
* `penguins` - Integer representing the number of penguins observed, e.g. `3`
* `precipitation`- Double with precipitation in centimeters, defaults to `0`

Test your code with print statements and the `TRY IT` button below before submitting your work.

{Try it}(sh .guides/bg.sh javac code/introObjects/Exercise4.java java -cp code/introObjects/ Exercise4 1)

{Check It!|assessment}(test-2663969036)
