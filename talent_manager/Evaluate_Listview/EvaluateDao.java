package com.example.talent_manager.Evaluate_Listview;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EvaluateDao {
    @Insert
    void InsertWorks(Evaluate... evaluates);

    @Update
    void UpdateWorks(Evaluate... evaluates);

    @Delete
    void DeleteWorks(Evaluate... evaluates);

    @Query("Delete FROM Evaluate")
    void DeleteAll();

    @Query("SELECT * FROM Evaluate ORDER BY ID DESC")
    LiveData<List<Evaluate>> GetAllWorks();

    @Query("SELECT COUNT(*) FROM Evaluate")
    LiveData<Integer> GetCount();

    @Query("SELECT COUNT(*) FROM Evaluate")
    int getCountEvaluate();
}
