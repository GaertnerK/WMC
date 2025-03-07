package at.htlgkr.naughtyornice.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import at.htlgkr.naughtyornice.IOHandler;
import at.htlgkr.naughtyornice.Person;

public class LogicViewModel extends ViewModel {
    private List<Person> personList;

    public static int index = 0;
    public static int filter = 0;
    public static boolean edit = false;

    public LogicViewModel(){
        personList = new ArrayList<>();
    }

    public void addPerson(Person person){
        if (edit){
            personList.set(index, person);
        }else {
            personList.add(person);
        }
    }

    public List<Person> getPersonList(){
        return personList;
    }

    public void loadList(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context);
        TypeToken<List<Person>> typeToken = new TypeToken<List<Person>>(){};
        List<Person> unfilterdList = gson.fromJson(s, typeToken);
        if (filter == 1){
            personList = unfilterdList.stream().filter(person -> person.isBehavior()).collect(Collectors.toList());
        } else if (filter == 2) {
            personList = unfilterdList.stream().filter(person -> !person.isBehavior()).collect(Collectors.toList());
        }else {
            personList = unfilterdList;
        }
    }

    public void safeList(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(personList);
        IOHandler.write(context, s);
    }
}
