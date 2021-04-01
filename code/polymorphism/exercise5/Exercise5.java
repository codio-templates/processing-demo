import java.util.ArrayList;
import java.io.*;

class Substitute {
  private String sourceFile;
  private String answerFile;
  private ArrayList<String[]> wordsList;
  private String wordsString;
  
  public Substitute(String source, String answer) {
    sourceFile = source;
    answerFile = answer;
    wordsList = new ArrayList<String[]>();
    wordsString = null;
  }
  
  public ArrayList<String[]> getWordsList() {
    return wordsList;
  }
  
  public String getWordsString() {
    return wordsString;
  }
  
  public String getAnswerFile() {
    return answerFile;
  }
  
  /**
   * Reads the text file stored in sourceFile and converts it to an
   * ArrayList of arrays of strings. Each array represents a sentence,
   * and element represents a word of the sentence. This ArrayList of
   * arrays of strings is stored in the attribute wordsList.
   */
  public void stringToList() {
    try {
      ArrayList<String> lines = new ArrayList<String>();
      BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        lines.add(currentLine);
        currentLine = reader.readLine();
      }
      reader.close();
      for (String line : lines) {
        wordsList.add(line.split(" "));
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  /**
   * Takes the ArrayList of arrays of strings and coverts it back into
   * a single string with newline characters. This string is stored
   * in the wordsString attribute.
   */
  public void listToString() {
    ArrayList<String> lines = new ArrayList<String>();
    for (String[] line : wordsList) {
      lines.add(String.join(" ", line));
    }
    wordsString = String.join("\n", lines);
  }
  
  /**
   * Calls stringToList. Then iterates through the ArrayList of arrays of
   * strings. If it is the fifth word, the element is replaces with
   * "HELLO". This method calls listToString and prints the results.
   */
  public void swapWords() {
    stringToList();
    for (String[] line : wordsList) {
      for (int i = 0; i < line.length; i++) {
        if ((i + 1) % 5 == 0) {
          line[i] = "HELLO";
        }
      }
    }
    listToString();
    System.out.println(wordsString);
  }
}

//add class definitions below this line



//add class definitions above this line

public class Exercise5 {  
  public static void main(String[] args) {
    String source = "/home/codio/workspace/code/polymorphism/exercise5/words.txt";
    String answer = "/home/codio/workspace/code/polymorphism/exercise5/answer.txt";
    
    //add code below this line


    
    //add code above this line
  }
}