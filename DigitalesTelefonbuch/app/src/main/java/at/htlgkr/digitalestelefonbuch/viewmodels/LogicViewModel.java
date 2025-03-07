package at.htlgkr.digitalestelefonbuch.viewmodels;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import at.htlgkr.digitalestelefonbuch.Contact;
import at.htlgkr.digitalestelefonbuch.IOHandler;

public class LogicViewModel extends ViewModel {
    private List<Contact> contacts;

    public boolean favourites = false;
    public int index = 0;

    public LogicViewModel() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void safeList(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(contacts);
        IOHandler.write(context, s);
    }

    public void readList(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context);
        TypeToken<List<Contact>> typeToken = new TypeToken<List<Contact>>(){};
        contacts = gson.fromJson(s, typeToken);
    }
}
