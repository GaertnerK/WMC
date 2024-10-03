package at.htlgkr.minigame;

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
        String s = getOneWord(random.nextInt(100));
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
            if (!word.getLetters()[i].contains(letters[i])) {
                letters[i] = "";
            }
        }
        return letters;
    }
}
