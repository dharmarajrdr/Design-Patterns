
interface Text {

    public String getText();
}

class RawText implements Text {

    String text;

    public RawText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

// Decorator
interface Style extends Text {
    // Declare any style related behaviours here
}

class Bold implements Style {

    private Text text;

    public Bold(Text text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<b>" + this.text.getText() + "</b>";
    }
}

class Italic implements Style {

    private Text text;

    public Italic(Text text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<i>" + this.text.getText() + "</i>";
    }
}

class Underline implements Style {

    private Text text;

    public Underline(Text text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<u>" + this.text.getText() + "</u>";
    }
}

public class Solution {

    public static void main(String[] args) {

        Text text = new RawText("Hello world!");
        text = new Underline(text);
        text = new Italic(text);
        text = new Bold(text);

        System.out.println("Formatted text: " + text.getText());
    }
}
