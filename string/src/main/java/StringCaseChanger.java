public class StringCaseChanger implements StringTransformer {
    StringDrink text;

    StringCaseChanger(StringDrink stringdrink) {
        text = stringdrink;
    }

    @Override
    public void execute() {
        StringBuilder tmp = new StringBuilder(text.getText());

        for (int i=0; i<tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (Character.isLowerCase(c))
               c = Character.toUpperCase(c);
            else
                c=Character.toLowerCase(c);

            tmp.setCharAt(i, c);

            text.setText(tmp.toString());
        }
    }


}
