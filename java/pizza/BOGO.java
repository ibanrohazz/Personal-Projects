
public class BOGO extends OrderDecorator {
    public BOGO( PizzaOrder order ) {
        super( order );
    }

    public double totalPrice() {
        return 0;
    }
}