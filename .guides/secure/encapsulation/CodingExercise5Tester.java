import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.io.*;

public class CodingExercise5Tester {
  SodaMachine testMachine;
  ArrayList<String> code = new ArrayList<String>();
  
  @Before
  public void setup() {
    testMachine = new SodaMachine();
    String path = "code/encapsulation/exercises/CodingExercise5.java";
    
    // read student file into ArrayList
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String currentLine = reader.readLine();
      while(currentLine != null) {
        code.add(currentLine);
        currentLine = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  @Test
  public void checkSodaGetter() {
    String[] sodas = {"coke", "pepsi", "sprite", "dr. pepper"};
    assertEquals(sodas, testMachine.getSodas());
  }
  
  @Test
  public void checkSodaSetter() {
    String[] sodas = {"coke", "pepsi", "sprite", "diet coke"};
    testMachine.setSodas(3, "diet coke");
    assertEquals(sodas, testMachine.getSodas());
  }
  
  @Test
  public void checkCokeInventoryGetter() {
    assertEquals(20, testMachine.getCokeInventory());
  }
  
  @Test
  public void checkCokeInventorySetter() {
    testMachine.setCokeInventory(3);
    assertEquals(3, testMachine.getCokeInventory());
  }
  
  @Test
  public void checkPepsiInventoryGetter() {
    assertEquals(20, testMachine.getPepsiInventory());
  }
  
  @Test
  public void checkPepsiInventorySetter() {
    testMachine.setPepsiInventory(7);
    assertEquals(7, testMachine.getPepsiInventory());
  }
  
  @Test
  public void checkSpriteInventoryGetter() {
    assertEquals(20, testMachine.getSpriteInventory());
  }
  
  @Test
  public void checkSpriteInventorySetter() {
    testMachine.setSpriteInventory(30);
    assertEquals(30, testMachine.getSpriteInventory());
  }
  
  @Test
  public void checkDrPepperInventoryGetter() {
    assertEquals(20, testMachine.getDrPepperInventory());
  }
  
  @Test
  public void checkDrPepperInventorySetter() {
    testMachine.setDrPepperInventory(24);
    assertEquals(24, testMachine.getDrPepperInventory());
  }
  
  @Test
  public void checkMoneyGetter() {
    assertEquals(10, testMachine.getMoney());
  }
  
  @Test
  public void checkMoneySetter() {
    testMachine.setMoney(309);
    assertEquals(309, testMachine.getMoney());
  }
  
  @Test 
  public void checkPrivateSodas() {
    String attribute = "private String[] sodas";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateCokeInventory() {
    String attribute = "private int cokeInventory";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivatePepsiInventory() {
    String attribute = "private int pepsiInventory";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateSpriteInventory() {
    String attribute = "private int spriteInventory";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateDrPepperInventory() {
    String attribute = "private int drPepperInventory";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test 
  public void checkPrivateMoney() {
    String attribute = "private int money";
    boolean hasPrivateAttribute = false;
    
    // find attribute declaration
    for (String line : code) {
      if (line.contains(attribute)) {
        hasPrivateAttribute = true;
      }
    }
    
    assertTrue(hasPrivateAttribute);
  }
  
  @Test
  public void checkBuySoda() {
    SodaMachine machine = new SodaMachine();
    machine.buySoda("coke", 4);
    machine.buySoda("pepsi", 4);
    machine.buySoda("sprite", 4);
    machine.buySoda("dr. pepper", 4);
    
    assertEquals(18, machine.getMoney());
    assertEquals(19, machine.getCokeInventory());
    assertEquals(19, machine.getSpriteInventory());
    assertEquals(19, machine.getPepsiInventory());
    assertEquals(19, machine.getDrPepperInventory());
  }
  
  @Test
  public void checkWrongSoda() {
    SodaMachine machine = new SodaMachine();
    machine.buySoda("orange crush", 4);
    
    assertEquals(10, machine.getMoney());
    assertEquals(20, machine.getCokeInventory());
    assertEquals(20, machine.getSpriteInventory());
    assertEquals(20, machine.getPepsiInventory());
    assertEquals(20, machine.getDrPepperInventory());
  }
  
  @Test
  public void checkInvalidMoney() {
    SodaMachine machine = new SodaMachine();
    machine.buySoda("coke", 1);
    
    assertEquals(10, machine.getMoney());
    assertEquals(20, machine.getCokeInventory());
  }
  
  @Test
  public void checkSodaAmount() {
    SodaMachine machine = new SodaMachine();
    machine.setCokeInventory(0);
    machine.buySoda("coke", 4);
    
    assertEquals(10, machine.getMoney());
    assertEquals(0, machine.getCokeInventory());
  }

}