public class StringInverter implements StringTransformer{
    StringDrink text;

    StringInverter(StringDrink stringdrink) {
        text = stringdrink;
    }

    @Override
    public void execute() {
        StringBuffer tmp = new StringBuffer(text.getText());
        tmp = tmp.reverse();

        text.setText(tmp.toString());
    }
}
