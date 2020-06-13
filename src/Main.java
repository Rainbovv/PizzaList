public class Main {
    public static void main(String[] args) {
        Pizza simplePizza = new Pizza("thick","halite","olive")
                                        .with("cheese")
                                        .with("tomato")
                                        .with("mushrooms")
                                        .with("meat")
                                        .without("tomato")
                                        .without("thick");

        System.out.println( "Is pizza complete? " + simplePizza.isComplete() );
        System.out.println( simplePizza );
    }
}
