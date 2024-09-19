package at.htlgkr.tiktaktoe;

public class Board {
    private boolean[][] field;

    public Board() {
        this.field = new boolean[3][3];
    }

    public boolean[][] getField() {
        return field;
    }
}
