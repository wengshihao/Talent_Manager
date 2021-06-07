package com.example.talent_manager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Chat.class},version = 2,exportSchema = false)
public abstract class ChatDatabase extends RoomDatabase {
    private  static ChatDatabase INSTANCE;
    static ChatDatabase getDatabase(Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), ChatDatabase.class,"chat_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public abstract ChatDao getChatDao();
}
