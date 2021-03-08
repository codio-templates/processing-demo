//add class definitions below this line
    
class Watch {
  private String manufacturer;
  private String model;
  private int diameter;
  private int waterResistance;
  private String material;
  
  public Watch (String ma, String mo, int d, int wr, String mat) {
    manufacturer = ma;
    model = mo;
    diameter = d;
    waterResistance = wr;
    material = mat;
  }
  
  public String getManufacturer() {
    return manufacturer;
  }
  
  public void setManufacturer(String newManufacturer) {
    manufacturer = newManufacturer;
  }
  
  public String getModel() {
    return model;
  }
  
  public void setModel(String newModel) {
    model = newModel;
  }
  
  public int getDiameter() {
    return diameter;
  }
  
  public void setDiameter(int newDiameter) {
    diameter = newDiameter;
  }
  
  public int getWaterResistance() {
    return waterResistance;
  }
  
  public void setWaterResistance(int newWaterResistance) {
    waterResistance = newWaterResistance;
  }
  
  public String getMaterial() {
    return material;
  }
  
  public void setMaterial(String newMaterial) {
    material = newMaterial;
  }
  
  public String summary() {
    String summary = "";
    summary += "Manufacturer: " + capitalize(manufacturer) + "\n";
    summary += "Model: " + capitalize(model) + "\n";
    summary += "Diameter: " + diameter + " mm\n";
    summary += "Water Resistance: " + waterResistance + " m\n";
    summary += "Material: " + capitalize(material);
    return summary;
  }
  
  private String capitalize(String s) {
    String capitalizedString = "";
    capitalizedString += s.substring(0, 1).toUpperCase();
    capitalizedString += s.substring(1);
    return capitalizedString;
  }
}
  
//add class definitions above this line

public class CodingExercise2 {
  public static void main(String[] args) {
    
    //add code below this line

    Watch myWatch = new Watch("omega", "speedmaster", 42, 50, "steel");
    System.out.println(myWatch.summary());

    //add code above this line
  }
}