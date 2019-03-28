import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class test {
        @Test
        public void stringDrink() {
            StringDrink drink = new StringDrink("ABCD");
            assertEquals("ABCD", drink.getText());
            drink.setText("DCBA");
            assertEquals("DCBA", drink.getText());
        }

        @Test
        public void stringInverter() {
            StringDrink drink = new StringDrink("ABCD");
            StringInverter si = new StringInverter(drink);
            si.execute();
            assertEquals("DCBA", drink.getText());
        }

        @Test
        public void stringCaseChanger() {
            StringDrink drink = new StringDrink("aBcD");
            StringCaseChanger cc = new StringCaseChanger(drink);
            cc.execute();
            assertEquals("AbCd", drink.getText());
        }

        @Test
        public void stringReplacer() {
            StringDrink drink = new StringDrink("ABCDABCD");
            StringReplacer sr = new StringReplacer(drink, 'A', 'X');
            sr.execute();
            assertEquals("XBCDXBCD", drink.getText());
        }

        @Test
        public void stringRecipe() {
            StringDrink drink = new StringDrink( "AbCd-aBcD");

            StringInverter si = new StringInverter(drink);
            StringCaseChanger cc = new StringCaseChanger(drink);
            StringReplacer sr = new StringReplacer(drink, 'A', 'X');

            List<StringTransformer> transformers = new ArrayList<>();
            transformers.add(si);
            transformers.add(cc);
            transformers.add(sr);

            StringRecipe recipe = new StringRecipe(transformers);
            recipe.mix();

            assertEquals("dCbX-DcBa", drink.getText());
        }

    @Test
    public void tranformerGroup() {
        StringDrink drink = new StringDrink( "AbCd-aBcD");

        StringInverter si = new StringInverter(drink);
        StringCaseChanger cc = new StringCaseChanger(drink);

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);

        StringTransformerGroup tg = new StringTransformerGroup(transformers);
        tg.execute();

        assertEquals("dCbA-DcBa", drink.getText());
    }

    @Test
    public void tranformerComposite() {
        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter(drink);
        StringCaseChanger cc = new StringCaseChanger(drink);
        StringReplacer sr = new StringReplacer(drink, 'A', 'X');

        List<StringTransformer> transformers1 = new ArrayList<>();
        transformers1.add(si);
        transformers1.add(cc);
        StringTransformerGroup tg1 = new StringTransformerGroup(transformers1);

        List<StringTransformer> transformers2 = new ArrayList<>();
        transformers2.add(sr);
        transformers2.add(cc);
        StringTransformerGroup tg2 = new StringTransformerGroup(transformers2);

        List<StringTransformer> transformers3 = new ArrayList<>();
        transformers3.add(tg1);
        transformers3.add(tg2);

        StringRecipe recipe = new StringRecipe(transformers3);
        recipe.mix();

        assertEquals("DcBx-dCbA", drink.getText());
    }

    @Test
    public void happyHour() {
        Bar bar = new StringBar();
        assertFalse(bar.isHappyHour());

        bar.startHappyHour();
        assertTrue(bar.isHappyHour());

        bar.endHappyHour();
        assertFalse(bar.isHappyHour());
    }

    @Test
    public void addObserver() {
        Bar bar = new StringBar();

        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);

        Mockito.verify(clientMock, Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);

        bar.startHappyHour();
        Mockito.verify(clientMock, Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);

        bar.endHappyHour();
        Mockito.verify(clientMock, Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.times(1)).happyHourStarted(bar);
    }

    @Test
    public void removeObserver() {
        Bar bar = new StringBar();

        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);
        bar.removeObserver(clientMock);

        bar.startHappyHour();
        bar.endHappyHour();

        Mockito.verify(clientMock, Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock, Mockito.never()).happyHourEnded(bar);
    }

   private StringRecipe getRecipe(StringDrink drink) {
        StringInverter si = new StringInverter(drink);
        StringCaseChanger cc = new StringCaseChanger(drink);
        StringReplacer sr = new StringReplacer(drink, 'A', 'X');

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);

        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }

    @Test
    public void orderStringRecipe() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe(drink);

        stringBar.order(recipe);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void impatientStrategy() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe(drink);

        ImpatientStrategy strategy = new ImpatientStrategy();
        HumanClient client = new HumanClient(strategy);

        // Recipe is ordered immediately
        client.wants(recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartOpened() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe(drink);

        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);

        // Recipe is ordered immediately as happy hour was already under way
        stringBar.startHappyHour();
        client.wants(recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartClosed() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe(drink);

        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);
        stringBar.addObserver(client); // this is important!

        client.wants(recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());

        // Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void ferengiAlreadyOpened() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe(drink);

        FerengiClient client = new FerengiClient();

        // Recipe is ordered immediately
        stringBar.startHappyHour();
        client.wants(recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void ferengiStartClosed() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe(drink);

        FerengiClient client = new FerengiClient();
        stringBar.addObserver(client); // this is important!

        client.wants(recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());

        // Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void romulan() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe(drink);

        RomulanClient client = new RomulanClient();

        // Recipe is ordered immediately
        client.wants(recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }
}
