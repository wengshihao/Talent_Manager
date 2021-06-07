package com.example.talent_manager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TalentDao {
    @Insert
    void insert(TalentEntity... talentEntities);
    @Update
    void update(TalentEntity... talentEntities);
    @Delete
    void delete(TalentEntity... talentEntities);
    @Query("DELETE FROM TalentEntity")
    void deleteAllTalentEntity();
    @Query("SELECT * FROM TalentEntity ORDER BY ID DESC")
    LiveData<List<TalentEntity>> getAllTalentEntity();
    @Query("SELECT COUNT(*) FROM TalentEntity")
    int getCountTalentEntity();

}
