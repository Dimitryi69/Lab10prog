package com.example.lab10;

import android.app.Application;

import androidx.room.Room;

import com.example.lab10.Room.Contact;
import com.example.lab10.Room.ContactDatabase;

public class App extends Application {
    public static App instance;
    private ContactDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, ContactDatabase.class, "cdb").allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }
    public ContactDatabase getDatabase() {
        return database;
    }
}
