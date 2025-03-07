package at.htlgkr.wmc1plfuebung.viewmodels;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import at.htlgkr.wmc1plfuebung.IOHandler;

public class LogicViewModel extends ViewModel {
    private String name;
    private List<String> wishes;
    private Boolean[] candles;
    private String letter;

    public LogicViewModel() {
        this.name = "";
        this.wishes = new ArrayList<>();
        this.candles = new Boolean[]{false, false, false, false};
        this.letter = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWishes() {
        return wishes;
    }

    public Boolean[] getCandles() {
        return candles;
    }

    public String getLetter() {
        return letter;
    }

    public void setWishes(List<String> wishes) {
        this.wishes = wishes;
    }

    public void setCandles(Boolean[] candles) {
        this.candles = candles;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void safeCandles(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(candles);
        IOHandler.write(context, s, "candles.json");
    }

    public void readCandles(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context, "candles.json");
        TypeToken<Boolean[]> typeToken = new TypeToken<Boolean[]>(){};
        candles = gson.fromJson(s, typeToken);
    }

    public void safeWishes(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(wishes);
        IOHandler.write(context, s, "wishes.json");
    }

    public void readWishes(Context context){

        Gson gson = new Gson();
        String s = IOHandler.read(context, "wishes.json");
        TypeToken<List<String>> typeToken = new TypeToken<List<String>>(){};
        wishes = gson.fromJson(s, typeToken);
    }

    public void safeLetter(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(letter);
        IOHandler.write(context, s, "letter.json");
    }

    public void readLetter(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context, "letter.json");
        TypeToken<String> typeToken = new TypeToken<String>(){};
        letter = gson.fromJson(s, typeToken);
    }
}
