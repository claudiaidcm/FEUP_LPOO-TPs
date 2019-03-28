public interface Client extends BarObserver {
    void wants(StringRecipe recipe, StringBar bar);
}
