package at.htlgkr.kiliangaertner.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import at.htlgkr.kiliangaertner.IOHandler;
import at.htlgkr.kiliangaertner.model.Answer;
import at.htlgkr.kiliangaertner.model.Profil;
import at.htlgkr.kiliangaertner.model.Question;

public class LogicViewModel extends ViewModel {
    private Profil profil;
    private Question[] questions;
    private int cookie;

    private int cookieIndex = 0;
    private int questionIndex = 0;
    private int QuizPoints = 0;

    private boolean quizFinished = false;
    public LogicViewModel() {
        profil = new Profil("", "");
        questions = new Question[3];
        questions[0] = new Question("Was ist deine Lieblingsfarbe?");
        questions[1] = new Question("Wann hörst du dein erstes Weihnachtslied? ");
        questions[2] = new Question("Welche Süßigkeiten magst du am liebsten?");
        questions[0].setAnswers(new Answer[]{
                new Answer("Glitzer!!!!", 3),
                new Answer("Rot", 1),
                new Answer("Grün", 1)
        });
        questions[1].setAnswers(new Answer[]{
                new Answer("November", 2),
                new Answer("Dezember", 1),
                new Answer("Oktober", 3)
        });
        questions[2].setAnswers(new Answer[]{
                new Answer("Kuchen", 1),
                new Answer("Weihnachtskekse", 3),
                new Answer("Schokolade", 2)
        });
        cookie = 0;
    }

    public boolean isQuizFinished() {
        return quizFinished;
    }

    public void setQuizFinished(boolean quizFinished) {
        this.quizFinished = quizFinished;
    }

    public int getQuizPoints() {
        return QuizPoints;
    }

    public void setQuizPoints(int quizPoints) {
        QuizPoints = quizPoints;
    }

    public Profil getProfil() {
        return profil;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public int getCookie() {
        return cookie;
    }

    public int getCookieIndex() {
        return cookieIndex;
    }

    public void setCookieIndex(int cookieIndex) {
        this.cookieIndex = cookieIndex;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public void setCookie(int cookie) {
        this.cookie = cookie;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void safeProfile(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(profil);
        IOHandler.write(context, s, "profile.json");
    }

    public void readProfile(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context, "profile.json");
        TypeToken<Profil> typeToken = new TypeToken<Profil>(){};
        profil = gson.fromJson(s, typeToken);
    }

    public void safeCookie(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(cookie);
        IOHandler.write(context, s, "cookie.json");
    }

    public void readCookie(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context, "cookie.json");
        TypeToken<Integer> typeToken = new TypeToken<Integer>(){};
        cookie = gson.fromJson(s, typeToken);
    }
}
