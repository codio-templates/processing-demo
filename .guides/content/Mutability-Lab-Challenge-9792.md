----------

Copy and paste the `Zoo` class below into the code editor. 

```java
//add class definitions below this line

class Zoo {
  int bigCats;
  int primates;
  int reptiles;
  int birds;
  
  Zoo(int bc, int p, int r, int b) {
    bigCats = bc;
    primates = p;
    reptiles = r;
    birds = b;
  }
}
//add class definitions above this line
```

Add the following methods to the class:
* `totalAnimals` - returns the total number of animals
* `totalMammals` - returns the number of mammals
* `mostAnimals` - returns the name with the most animals in the zoo

### Expected Output

If the following code is added to your program:

```java
    //add code below this line
    
    Zoo myZoo = new Zoo(10, 30, 90, 120);
    System.out.println(myZoo.totalAnimals());
    System.out.println(myZoo.totalMammals());
    System.out.println(myZoo.mostAnimals());

    //add code above this line
```

Then the output would be:

```
250
40
birds
```

{Try it}(sh .guides/bg.sh javac code/mutability/labChallenge/LabChallenge.java java -cp code/mutability/labChallenge/ LabChallenge 1)

{Check It!|assessment}(test-83966248)
