package com.example.talent_manager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ChatDao {
    @Insert
    void insertCharts(Chat...chats);

    @Update
    void updateCharts(Chat...chats);

    @Delete
    void deleteCharts(Chat...chats);

    @Query("DELETE FROM CHAT")
    void deleteAllCharts();

    @Query("SELECT * FROM CHAT ORDER BY ID DESC")
    //List<Chat> getAllCharts();
    LiveData<List<Chat>>getAllChartsLive();

    @Query("SELECT COUNT(*) FROM CHAT")
    int getchatcounts();
}
