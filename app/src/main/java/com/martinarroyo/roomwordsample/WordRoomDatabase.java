package com.martinarroyo.roomwordsample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class},version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao(); // Include the data access objects

    private static volatile WordRoomDatabase INSTANCE;

    // Make the database a singleton
    static WordRoomDatabase getDatabase(final Context context){
        // If the database hasn't been instantiated already, do so
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if(INSTANCE == null){
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),WordRoomDatabase.class,"word_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
