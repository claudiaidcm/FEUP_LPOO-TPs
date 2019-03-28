public class RomulanClient extends AlienClient {
    public OrderingStrategy createOrderingStrategy() {
        return new ImpatientStrategy();
    }
}
