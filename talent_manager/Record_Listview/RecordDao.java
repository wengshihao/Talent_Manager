package com.example.talent_manager.Record_Listview;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecordDao {
    @Insert
    void InsertWorks(Record... records);

    @Update
    void UpdateWorks(Record... records);

    @Delete
    void DeleteWorks(Record... records);

    @Query("Delete FROM Record")
    void DeleteAll();

    @Query("SELECT * FROM Record ORDER BY ID DESC")
    LiveData<List<Record>> GetAllWorks();

    @Query("SELECT COUNT(*) FROM Record")
    LiveData<Integer> GetCount();
}
