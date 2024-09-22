package at.htlgkr.tiktaktoe;

import android.util.Log;

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

    public String setButton(int buttonNbr , String buttonText){
        int counter = 1;
        for (int i = 0; i < gameField.getField().length; i++){
            for (int j = 0; j < gameField.getField()[i].length; j++){
                if (counter == buttonNbr){
                    if (gameField.getField()[i][j] == ""){
                        if (isPlayer()){
                            setPlayer();
                            gameField.getField()[i][j] = "X";
                            return "X";
                        }else {
                            setPlayer();
                            gameField.getField()[i][j] = "0";
                            return "0";
                        }
                    }else {
                        Log.i("FIELD_INFO", "Feld ist bereits vergeben");
                        if (buttonText.equals("X")){
                            return "X";
                        }else {
                            return "0";
                        }
                    }
                }
                counter++;
            }
        }
        return "";
    }

    public boolean win(){
        int counter = 0;
        for (int i = 0; i < gameField.getField().length; i++){
            for (int j = 0; j < gameField.getField()[i].length; j++){
                if (gameField.getField()[i][j].equals("X")){
                    counter++;
                }
            }
            if (counter == 3){
                return true;
            }
            counter = 0;
        }

        for (int i = 0; i < gameField.getField().length; i++){
            for (int j = 0; j < gameField.getField()[i].length; j++){
                if (gameField.getField()[i][j].equals("0")){
                    counter++;
                }
            }
            if (counter == 3){
                return true;
            }
            counter = 0;
        }

        for (int i = 0; i < gameField.getField().length; i++){
            if (gameField.getField()[i][i].equals("X")){
                counter++;
            }
        }
        if (counter == 3){
            return true;
        }
        counter = 0;

        for (int i = 0; i < gameField.getField().length; i++){
            if (gameField.getField()[i][i].equals("0")){
                counter++;
            }
        }
        if (counter == 3){
            return true;
        }
        counter = 0;

        for (int i = 0; i < gameField.getField().length; i++){
            for (int j = 2; j >= 0; j--){
                if (gameField.getField()[j][j].equals("X")){
                    counter++;
                }
            }
            if (counter == 3){
                return true;
            }
            counter = 0;
        }

        for (int i = 0; i < gameField.getField().length; i++){
            for (int j = 2; j >= 0; j--){
                if (gameField.getField()[j][j].equals("0")){
                    counter++;
                }
            }
            if (counter == 3){
                return true;
            }
            counter = 0;
        }

        return false;
    }
}
