public class HumanClient implements Client{
    OrderingStrategy strategy;
    public HumanClient(OrderingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        strategy.wants(recipe, bar);
    }

    public void happyHourStarted(Bar bar) {

        strategy.happyHourStarted((StringBar) bar);

    }

    public void happyHourEnded(Bar bar) {

        strategy.happyHourEnded((StringBar) bar);

    }
}
