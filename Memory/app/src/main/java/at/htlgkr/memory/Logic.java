package at.htlgkr.memory;

import java.util.Random;

public class Logic {
    private Model model;

    public Logic() {
        this.model = new Model();
    }

    public Model getModel() {
        return model;
    }

    public void loadBoard(){
        Random random = new Random();
        int[] animalCounter = new int[8];
        for (int i = 0; i < model.getBoard().length; i++){
            for (int j = 0; j < model.getBoard()[i].length; j++) {
                boolean b = true;
                while (b){
                    int a = random.nextInt(8) + 1;
                    switch (a){
                        case 1:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "dog";
                                b = false;
                            }
                            break;
                        case 2:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "bird";
                                b = false;
                            }
                            break;
                        case 3:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "cat";
                                b = false;
                            }
                            break;
                        case 4:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "ant";
                                b = false;
                            }
                            break;
                        case 5:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "hamster";
                                b = false;
                            }
                            break;
                        case 6:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "mouse";
                                b = false;
                            }
                            break;
                        case 7:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "rabbit";
                                b = false;
                            }
                            break;
                        case 8:
                            if (animalCounter[i] != 2){
                                model.getBoard()[i][j] = "spider";
                                b = false;
                            }
                            break;
                    }
                }
            }
        }
    }
}
