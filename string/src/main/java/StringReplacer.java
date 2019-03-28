public class StringReplacer implements StringTransformer{
    StringDrink text;
    char oldChar;
    char newChar;

    StringReplacer(StringDrink stringdrink, char o, char n) {
        text = stringdrink;
        oldChar = o;
        newChar = n;
    }

    @Override
    public void execute() {
        text.setText(text.getText().replace(oldChar, newChar));
    }
}
