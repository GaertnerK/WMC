package at.htlgkr.quizmaster;

public class Item {
    public static final String FILENAME = "items.csv";

    private String title;
    private String[] hints;

    public Item(String title, String[] hints) {
        this.title = title;
        this.hints = hints;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getHints() {
        return hints;
    }

    public void setHints(String[] hints) {
        this.hints = hints;
    }
}
