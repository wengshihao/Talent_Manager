package com.example.talent_manager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TalentEntity.class}, version = 2, exportSchema = false)
public abstract class TalentDatabase extends RoomDatabase {
    private static TalentDatabase INSTANCE;
    static TalentDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TalentDatabase.class, "Talent_Database")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

    public abstract TalentDao getTalentDao();
}
