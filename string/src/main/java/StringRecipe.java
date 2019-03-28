import java.util.List;

public class StringRecipe {
    List<StringTransformer> transformers;

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void mix() {
        for (StringTransformer string : transformers) {
            string.execute();
        }
    }


}
