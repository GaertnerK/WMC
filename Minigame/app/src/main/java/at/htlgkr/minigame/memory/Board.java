package at.htlgkr.minigame.memory;

public class Board {
    private int[][] board;

    public Board() {
        this.board = new int[4][4];
    }

    public int[][] getBoard() {
        return board;
    }
}
