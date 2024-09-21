package at.htlgkr.tiktaktoe;

import java.util.Map;

public class Board {
    private String[][] field;

    public Board() {
        this.field = new String[3][3];
    }

    public String[][] getField() {
        return field;
    }
}
