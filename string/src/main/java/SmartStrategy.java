import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {

        List<StringRecipe> recipes = new ArrayList<>();

        @Override
        public void wants(StringRecipe recipe, StringBar bar) {

            if(bar.isHappyHour())
                recipe.mix();
            else
            {
                this.recipes.add(recipe);
            }
        }

        @Override
        public void happyHourStarted(StringBar bar) {

            for(StringRecipe recipe : recipes)
            {
                bar.order(recipe);
            }
        }

        @Override
        public void happyHourEnded(StringBar bar) {

        }
    }

