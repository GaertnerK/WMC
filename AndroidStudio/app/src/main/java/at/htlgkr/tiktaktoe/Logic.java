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
            for (int j = 0; j < gameField.getField()[i].length; j++){
                if (gameField.getField()[j][i].equals("X")){
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
                if (gameField.getField()[j][i].equals("0")){
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

        String s1 = gameField.getField()[2][0];
        String s2 = gameField.getField()[1][1];
        String s3 = gameField.getField()[0][2];
        if (s1.equals("X") && s2.equals("X") && s3.equals("X")){
            return true;
        }

        String s4 = gameField.getField()[2][0];
        String s5 = gameField.getField()[1][1];
        String s6 = gameField.getField()[0][2];
        if (s4.equals("0") && s5.equals("0") && s6.equals("0")){
            return true;
        }

        return false;
    }
}
