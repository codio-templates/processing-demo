----------

### Problem

In the IDE to the left, the class `MP3` is already defined. Use this class to do the following things:
* Create the class `Podcast` that inherits from `MP3`
* Override the `__init__` method such that the podcast has the following attributes:
  * `name` - a string that is the name of the podcast
  * `title` - a string that is the title of the episode
  * `length` - an integer that has the length of the podcast **in seconds**
  * `genre` - a string that is the genre of the podcast
  * `date` - a string that represents when the podcast was released to the public
 
### Expected Output
Declare an instance of the `Podcast` class as shown below.

```python
    //add code below this line
  
    Podcast p = new Podcast("Planet Money", "Hollywood's Black List", 1460, "economics", "10 July 2020");
  
    //add code above this line   
```

The table below shows the method calls (left) and the output (right). Your class will be expected to work with all of these method calls.

|Method Call|Return Value|
|:----------|:-----------|
|`p.displayName();`|`The name is Planet Money`|
|`p.displayTitle();`|`The title is Hollywood's Black List`|
|`p.displayLength();`|`The length is 24 minutes and 20 seconds`|
|`p.displayGenre();`|`The genre is economics`|
|`p.displayDate();`|`The date is 10 July 2020`|

{Try it}(sh .guides/bg.sh javac code/inheritance/labChallenge/LabChallenge.java java -cp code/inheritance/labChallenge/ LabChallenge 1)