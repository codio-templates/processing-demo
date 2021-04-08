import java.util.*;

class ShoppingCart {
  private ArrayList<Item> items;
  private double total;
  
  public ShoppingCart() {
    items = new ArrayList<Item>();
    total = 0;
  }
  
  public void addItem(Item item) {
    items.add(item);
    calculateTotal();
  }
  
  private void calculateTotal() {
    total = 0;
    for (Item i : items) {
      i.calculateSubtotal();
      total += i.getSubtotal();
    }
  }
  
  public double getTotal() {
    return total;
  }
  
  public int getNumItems() {
    int numItems = 0;
    for (Item i : items) {
      numItems += i.getQuantity();
    }
    return numItems;
  }
  
  public ArrayList<Item> getItems() {
    return items;
  }
  
  public String toString() {
    return getClass().getName() + "[items=" + items + ", total=" + total + "]";
  }
}