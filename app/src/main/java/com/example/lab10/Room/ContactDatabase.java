package com.example.lab10.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDao getContactDao();
}
