public class FerengiClient extends AlienClient {
    public OrderingStrategy createOrderingStrategy() {
        return new SmartStrategy();
    }
}
