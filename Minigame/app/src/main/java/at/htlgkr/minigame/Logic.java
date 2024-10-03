package at.htlgkr.minigame;

import java.util.Random;

public class Logic extends Words{
    Word word;
    String[] letters;

    public Logic(String[] letters){
        word = new Word();
        this.letters = letters;
    }

    public void setWord(){
        Random random = new Random();
        String s = getOneWord(random.nextInt(100));
        word.setLetters(s.split(""));
    }
}
