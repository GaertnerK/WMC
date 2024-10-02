package at.htlgkr.memory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Logic {
    private Board model;
    private List<Integer> ids;
    private int[] swCard;

    public Logic(List<Integer> ids) {
        this.model = new Board();
        this.ids = ids;
        swCard = new int[2];
    }

    public Board getModel() {
        return model;
    }

    public void loadBoard(){
        int counter = 0;
        ids.addAll(ids);
        Collections.shuffle(ids);
        for (int i = 0; i < model.getBoard().length; i++){
            for (int j = 0; j < model.getBoard()[i].length; j++){
                model.getBoard()[i][j] = ids.get(counter);
                counter++;
            }
        }
    }

    public boolean checkCard(int id){
        if (swCard[0] == 0){
            swCard[0] = id;
            return false;
        } else if (swCard[1] == 0) {
            swCard[1] = id;
            if (swCard[0] == swCard[1]){
                return true;
            }
        }
        return false;
    }

    public void resetSwCard(){
        swCard = new int[2];
    }

    public int getId(int i, int j){
        return model.getBoard()[i][j];
    }
}
