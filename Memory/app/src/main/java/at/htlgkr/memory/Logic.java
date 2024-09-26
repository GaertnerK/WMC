package at.htlgkr.memory;

import java.util.Random;

public class Logic {
    private Board model;
    private int[] ids;

    public Logic(int[] ids) {
        this.model = new Board();
        this.ids = ids;
    }

    public Board getModel() {
        return model;
    }

    public void loadBoard(){
        Random random = new Random();
        int[] animalCounter = new int[8];
        for (int i = 0; i < model.getBoard().length; i++){
            for (int j = 0; j < model.getBoard()[i].length; j++) {
                boolean b = true;
                while (b){
                    int a = random.nextInt(8);
                    switch (a){
                        case 0:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[0];
                                animalCounter[a]++;
                                b = false;
                            }
                            break;
                        case 1:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[1];
                                b = false;
                                animalCounter[a]++;
                            }
                            break;
                        case 2:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[2];
                                b = false;
                                animalCounter[a]++;
                            }
                            break;
                        case 3:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[3];
                                b = false;
                                animalCounter[a]++;
                            }
                            break;
                        case 4:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[4];
                                b = false;
                                animalCounter[a]++;
                            }
                            break;
                        case 5:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[5];
                                b = false;
                                animalCounter[a]++;
                            }
                            break;
                        case 6:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[6];
                                b = false;
                                animalCounter[a]++;
                            }
                            break;
                        case 7:
                            if (animalCounter[a] != 2){
                                model.getBoard()[i][j] = ids[7];
                                b = false;
                                animalCounter[a]++;
                            }
                            break;
                        default: break;
                    }
                }
            }
        }
    }

    public int getId(int i, int j){
        return model.getBoard()[i][j];
    }
}
