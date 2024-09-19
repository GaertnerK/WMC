package at.htlgkr.tiktaktoe;

public class Logic {
    private Board gameField;
    private boolean player;

    public Logic() {
        this.gameField = new Board();
        this.player = true;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer() {
        if (player == true){
            player = false;
        }else {
            player = true;
        }
    }

    public boolean setButton(int buttonNbr){
        int counter = 0;
        for (int i = 0; i < gameField.getField().length; i++){
            for (int j = 0; j < gameField.getField()[i].length; j++){
                if (counter == buttonNbr){
                    if (gameField.getField()[i][j] == false)
                }
            }
        }
        return false;
    }
}
