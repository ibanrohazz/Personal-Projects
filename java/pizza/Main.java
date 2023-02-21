public class Main {
    
    public static void main(String[] args) {
        PizzaOrder order = new WheatCrust( Size.LARGE );
        
        // order = new ExtraCheese( order );
        // order = new Pepperoni( order );
        // order = new Coupon( order );
    
        // PizzaOrder second = new RegularCrust( size.SMALL );
        // second = new Anchovies( order );
        // second = new BOGO( second );

        println( order.toString() );
    }
}
