package com.example.talent_manager.Record_Listview;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Record.class},version = 3,exportSchema = false)
public abstract class RecordDatabase extends RoomDatabase {

    private static RecordDatabase INSTANCE;
    public static synchronized RecordDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RecordDatabase.class,"record_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public abstract RecordDao getRecordDao();

}
