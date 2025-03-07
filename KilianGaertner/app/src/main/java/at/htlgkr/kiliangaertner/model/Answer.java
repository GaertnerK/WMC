package at.htlgkr.kiliangaertner.model;

public class Answer {
    private String answer;
    private int points;

    public static String[] answers = new String[]{"Glitzer!!!,3", "Rot,1", "Grün,1", "November,2", "Dezember,1", "Oktober,3", "Kuchen,1", "Weihnachtskekse,3", "Schokolade,2"};
    public Answer(String answer, int points) {
        this.answer = answer;
        this.points = points;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
