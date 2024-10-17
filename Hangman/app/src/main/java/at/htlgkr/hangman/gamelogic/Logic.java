package at.htlgkr.hangman.gamelogic;

public class Logic {
    private String word;
    private String[] checkedWordArr;

    public Logic(String word){
        this.word = word;
        this.checkedWordArr = new String[word.length()];
    }

    public String checkLetter(String letter){
        String checkedWord = "";
        for (int i = 0; i < word.length(); i++){
            if (letter.charAt(0) == word.charAt(i)){
                checkedWordArr[i] = letter;
                checkedWord = checkedWord + letter;
            }else {
                if (checkedWordArr[i] == null) {
                    checkedWord = checkedWord + "";
                }else {
                    checkedWord = checkedWord + checkedWordArr[i];
                }
            }
        }
        return checkedWord;
    }
}