----------

## Exercise 5

The `Substitute` class reads a text file and replaces every fifth word with the string `HELLO`. 

<details>
  <summary><strong>Substitute Class Output</strong></summary>
  To see the output from the superclass, add the following code to your program and run it. The source file is four sentences. Each sentence is on its own line in the text file. The word <code>HELLO</code> will appear as the fifth word for each sentence.
  
  ```java
      //add code below this line

      Substitute s = new Substitute(source, answer);
      s.swapWords();

      //add code above this line
  ```
  
</details><br>

Create the class `Stars` which is a subclass of `Substitute`. Then override the `swapWords` method so that in each sentence every third word is replaced by a series of `*`. If the word has three letters then it should be replaced with `***`. The number of `*` should match the number of characters in the word. Write the new string to `answerFile`.

### Important

Keep the following things in mind as you write your code. Changes should only be made to the `Stars` class; do not alter the `source` and `answer` variables or the code for the `Substitute` class.

* The `sourceFile` attribute represents the file you will read.
* The `answerFile` attribute represents the file to which you will write your new text.
* The `stringToList` method converts the string (the text file) into an ArrayList of arrays of strings. Each inner array represents a sentence. The elements of each inner array are the words that make up that sentence.
* The `listToString` method converts the ArrayList of arrays of strings list back into a string.
* When you override the `swapWords` method, be sure to start with `stringToList` and use `listToString` before writing to the file.
* The text used for this activity are the first four sentences of Jane Austen's [*Pride and Prejudice*](http://www.gutenberg.org/files/1342/1342-h/1342-h.htm).

{Try it}(sh .guides/bg.sh javac code/polymorphism/exercise5/Exercise5.java java -cp code/polymorphism/exercise5/ Exercise5 1)

[See your answer](open_file code/polymorphism/exercise5/answer.txt)

<details>
  <summary><strong>Expected output</strong></summary>
  The <code>answer_file</code> should look like the text below.
  
  ```markdown
  It is * truth universally ************* that a ****** man in ********** of a **** fortune, must ** in want ** a wife.
However little ***** the feelings ** views of **** a man *** be on *** first entering * neighbourhood, this ***** is so **** fixed in *** minds of *** surrounding families, **** he is ********** the rightful ******** of some *** or other ** their daughters.
“My dear *** Bennet,” said *** lady to *** one day, ***** you heard **** Netherfield Park ** let at ******
Mr. Bennet ******* that he *** not.
  ```
</details><br>

{Check It!|assessment}(test-1537667893)
