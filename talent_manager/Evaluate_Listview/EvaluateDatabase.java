package com.example.talent_manager.Evaluate_Listview;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Evaluate.class},version = 4,exportSchema = false)
public abstract class EvaluateDatabase extends RoomDatabase {

    private static EvaluateDatabase INSTANCE;
    public static synchronized EvaluateDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EvaluateDatabase.class,"evaluate_database")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public abstract EvaluateDao getEvaluateDao();
}
