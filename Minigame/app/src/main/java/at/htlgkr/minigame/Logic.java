package at.htlgkr.minigame;

import java.util.Arrays;
import java.util.Random;

public class Logic extends Words{
    Word word;

    public Logic(){
        word = new Word();
    }

    public Word getWord() {
        return word;
    }

    public void setWord(){
        Random random = new Random();
        String s = getOneWord(random.nextInt(85));
        word.setLetters(s.split(""));
    }

    public boolean checkWin(String[] letters){
        for (int i = 0; i < word.getLetters().length; i++){
            if (!word.getLetters()[i].equalsIgnoreCase(letters[i])){
                return false;
            }
        }
        return true;
    }

    public String[] checkWord(String[] letters){
        for (int i = 0; i < word.getLetters().length; i++) {
            if (word.getLetters()[i].equalsIgnoreCase(letters[i])){

            }else {
                for (int j = 0; j < word.getLetters().length; j++) {
                    if (word.getLetters()[j].equalsIgnoreCase(letters[i])){
                        letters[i] = "1";
                        break;
                    }
                }
                if (!letters[i].equalsIgnoreCase("1")) {
                    letters[i] = "";
                }
            }
        }
        return letters;
    }
}
