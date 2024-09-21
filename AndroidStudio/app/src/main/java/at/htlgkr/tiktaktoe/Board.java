package at.htlgkr.tiktaktoe;

import java.util.Map;

public class Board {
    private String[][] field;

    public Board() {
        this.field = new String[3][3];
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                field[i][j] = "";
            }
        }
    }

    public String[][] getField() {
        return field;
    }
}
