package at.htlgkr.minigame;

public class Word {
    String[] letters;

    public Word(){
        letters = new String[5];
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }
}
