
public class Coupon extends OrderOption {
    private double discount;

    public Coupon( PizzaOrder order ) {
        super( order );
    }

    public double totalPrice() {
        return super.order.totalPrice() * discount;
    }
}
