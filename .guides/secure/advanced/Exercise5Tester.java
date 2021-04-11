import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class Exercise5Tester {
  
  ShoppingCart cart;
  
  @Before
  public void setup() {
    cart = new ShoppingCart();
    Item item1 = new Item("laptop", 1200, 1);
    Item item2 = new Item("monitor", 250, 2);
    Item item3 = new Item("keyboard", 50, 1);
    Item item4 = new Item("mouse", 15, 1);
    
    cart.addItem(item1);
    cart.addItem(item2);
    cart.addItem(item3);
    cart.addItem(item4);
  }
  
  @Test
  public void checkToString() {
    String expected = "ShoppingCart[items=[Item[name=laptop, price=1200.0, quantity=1, subtotal=1200.0], Item[name=monitor, price=250.0, quantity=2, subtotal=500.0], Item[name=keyboard, price=50.0, quantity=1, subtotal=50.0], Item[name=mouse, price=15.0, quantity=1, subtotal=15.0]], total=1765.0]";
    String actual = cart.toString();
    String feedback = "String representation did not match.";
    assertEquals(actual, expected, actual);
  }
  
  @Test
  public void checkTotal() {
    double expected = 1765;
    double actual = cart.getTotal();
    String feedback = "Total amount did not match.";
    assertEquals(feedback, expected, actual, 0.01);
  }
  
  @Test
  public void checkNumItems() {
    int expected = 5;
    int actual = cart.getNumItems();
    String feedback = "Number of items did not match.";
    assertEquals(feedback, expected, actual);
  }
  
}