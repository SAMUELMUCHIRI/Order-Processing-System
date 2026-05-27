import logic.*;



public class Main {
    public static void main(String[] args) {
        System.out.println("Creating Three objects , one with exceptions \n");
        Order orderOne = new Order("OD001" ,"Cup", 10 , OrderStatus.PENDING);
        Order orderTwo = new Order("OD002","chair",4,OrderStatus.PENDING);
        Order orderThree ;
        try
        {
            orderThree = new Order("OD003", "padlock",-1,OrderStatus.SHIPPED);

        } catch (InvalidOrderException e) {
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Invalid values for Order");
        }

        OrderProcessor proccessValidOrder = (order) -> {
                System.out.println("Processing order "+ order.getOrderId() +" for "+ order.getQuantity()+" x "+order.getProduct());
                order.setStatus(OrderStatus.CONFIRMED);
            };

        OrderProcessor cancelOrder = (Order order) -> {
            System.out.println("Cancelling  order "+ order.getOrderId() +" for "+ order.getQuantity()+" x "+order.getProduct() );
            System.out.println("Reason : Out of stock");
            order.setStatus(OrderStatus.CANCELLED);
        };
        System.out.println("Processing valid orders \n");
        proccessValidOrder.process(orderOne);
        proccessValidOrder.process(orderTwo);

        System.out.println("\nCancelling an order \n");
        cancelOrder.process(orderOne);


    }
}
