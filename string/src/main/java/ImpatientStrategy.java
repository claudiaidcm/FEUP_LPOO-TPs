public class ImpatientStrategy implements OrderingStrategy {
    public void wants(StringRecipe recipe, StringBar bar) {
        recipe.mix();
    }

    public void happyHourStarted(StringBar bar) {

    }

    public void happyHourEnded(StringBar bar) {

    }
}


