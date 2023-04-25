
public class RegularCrust implements PizzaOrder {
    private Size Size;

    @Override
    public String prepInstructions() {
        return "Stretch " + size + " wheat " + "dough onto " 
        + size + " pan. " + "Add sauce and 1/2\" layer of cheese.";
    }
    
    @override
    public String cookInstructions() {
        return "Place in oven. Bake at 450 " +       
        "degrees for 12 minutes.";  
    }

    @Override
    public double totalPrice() {
        return size.basePrice() + 2;
    }

    @Override
    public String toString() {
        return "Regular Crust Pizza: " + size + " " + totalPrice();
    }
}

