public interface OrderingStrategy {
    void wants(StringRecipe recipe, StringBar bar);
    void happyHourStarted(StringBar bar);
    void happyHourEnded(StringBar bar);

}
