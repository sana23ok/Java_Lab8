package src;

public class Flower{
    private int ID;
    private String Name;
    private String Type;
    private String Species;
    private String Subspecies;
    private double Price;
    private int quantity;
    private boolean blooms;

    public Flower(int ID, String name, String type, String species,
                  String subspecies, double price, int quantity, boolean blooms) {
        this.ID = ID;
        this.quantity = quantity;
        this.blooms = blooms;
        Name = name;
        Type = type;
        Species = species;
        Subspecies = subspecies;
        Price = price;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public void setSubspecies(String subspecies) {
        Subspecies = subspecies;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setBlooms(boolean blooms) {
        this.blooms = blooms;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBlooms() {
        return blooms;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getSpecies() {
        return Species;
    }

    public String getSubspecies() {
        return Subspecies;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-15s | %-15s | %-15s | %-15s | %-6.2f | %-9d | %-7b |",
                ID, Name, Type, Species, Subspecies, Price, quantity, blooms);
    }

}
