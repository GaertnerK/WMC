package at.htlgkr.memory;

public class Model {
    private String[][] board;

    public Model() {
        this.board = new String[4][4];
    }

    public String[][] getBoard() {
        return board;
    }
}
