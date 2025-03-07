package com.example.notesapp.model;

import java.time.LocalDate;
import java.util.Date;

public class Note {
    private String title;
    private String description;
    private Date date;
    private boolean done;

    public Note(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public boolean isDone() {
        return done;
    }
}
