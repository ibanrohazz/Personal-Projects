public class ExtraCheese extends OrderOption {
    public ExtraCheese( PizzaOrder order ) {
        super( order );
    }

    public String prepInstructions() {
        return order.prepInstructions() +
         "Add an additional 1/2\" layer of cheese";
    }  

    public double totalPrice() {
        return order.totalPrice() + 3;
    }
    
}
