package logic;

@FunctionalInterface
public interface OrderProcessor {
    void process(Order order);
}
