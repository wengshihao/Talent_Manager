package com.example.talent_manager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ChatViewModel extends AndroidViewModel {
    private ChatRepository chatRepository;
    public ChatViewModel(@NonNull Application application) {
        super(application);
        chatRepository=new ChatRepository(application);
    }

    public LiveData<List<Chat>> getAllchatsLive() {
        return chatRepository.getAllChatsLive();
    }
    void insertChats(Chat...chats){
        chatRepository.insertChats(chats);
    }
    void updateChats(Chat...chats){
        chatRepository.updateChats(chats);
    }
    void deleteChats(Chat...chats){
         chatRepository.deleteChats(chats);
    }
    void deleteAllChats(Chat...chats){
         chatRepository.deleteAllChats();
    }
}
