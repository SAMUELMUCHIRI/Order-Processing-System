package logic;

public class Order {
    private String orderId , product ;
    private int quantity ;
    private OrderStatus status ;

    public Order(String orderId , String product , int quantity , OrderStatus status)
    {
        if(quantity < 1)
        {
            throw new InvalidOrderException("Quantity cant be zero or negative");
        }
        else {
            this.quantity = quantity ;
        }
        this.orderId = orderId ;
        this.product = product ;
        this.status = status ;
    }

    public String getOrderId()
    {
        return orderId ;
    }
    public String getProduct()
    {
        return product;
    }
    public  int getQuantity()
    {
        return quantity;
    }
    public OrderStatus getStatus()
    {
        return status;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status ;
    }

    @Override
    public String toString()
    {
        return "\n \tOrderId : "+orderId+"\n \tProduct : "+product+"\n \t Quantity : "+quantity+"\n \tStatus : "+status;
    }
}
