public abstract class AlienClient implements Client {
    private OrderingStrategy strategy;

    public AlienClient() {
        this.strategy = createOrderingStrategy();
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded((StringBar) bar);
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        strategy.wants(recipe, bar);
    }

    protected abstract  OrderingStrategy createOrderingStrategy();
}

