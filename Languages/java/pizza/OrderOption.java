public abstract class OrderOption implements PizzaOrder {
    protected PizzaOrder order;

    public OrderOption( PizzaOrder order ) {
        this.order = order;
    }

    public String prepInstructions() {
        return order.prepInstructions();
    }

    public String cookInstructions() {
        return order.cookInstructions();
    }

    public double totalPrice() {
        return order.totalPrice();
    }
}