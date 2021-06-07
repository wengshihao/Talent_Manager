package com.example.talent_manager;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ChatRepository {
    private LiveData<List<Chat>>allChatsLive;
    private ChatDao chatDao;
    public ChatRepository(Context context) {
        ChatDatabase chatDatabase= ChatDatabase.getDatabase(context.getApplicationContext());
        chatDao=chatDatabase.getChatDao();
        allChatsLive=chatDao.getAllChartsLive();
    }
    void insertChats(Chat...chats){
        new InsertAsyncTask(chatDao).execute(chats);
    }
    void updateChats(Chat...chats){
        new UpdateAsyncTask(chatDao).execute(chats);
    }
    void deleteChats(Chat...chats){
        new DeleteAsyncTask(chatDao).execute(chats);
    }
    void deleteAllChats(Chat...chats){
        new DeleteAllAsyncTask(chatDao).execute();
    }
    public LiveData<List<Chat>> getAllChatsLive() {
        return allChatsLive;
    }
    static class InsertAsyncTask extends AsyncTask<Chat,Void,Void> {
        private ChatDao chatDao;

        public InsertAsyncTask(ChatDao chatDao) {
            this.chatDao = chatDao;
        }

        @Override
        protected Void doInBackground(Chat... chats) {
            chatDao.insertCharts(chats);
            return null;
        }
    }
    static class UpdateAsyncTask extends AsyncTask<Chat,Void,Void>{
        private ChatDao chatDao;

        public UpdateAsyncTask(ChatDao chatDao) {
            this.chatDao = chatDao;
        }

        @Override
        protected Void doInBackground(Chat... chats) {
            chatDao.updateCharts(chats);
            return null;
        }
    }
    static class DeleteAsyncTask extends AsyncTask<Chat,Void,Void>{
        private ChatDao chatDao;

        public DeleteAsyncTask(ChatDao chatDao) {
            this.chatDao = chatDao;
        }

        @Override
        protected Void doInBackground(Chat... chats) {
            chatDao.deleteCharts(chats);
            return null;
        }
    }
    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private ChatDao chatDao;
        public DeleteAllAsyncTask(ChatDao chatDao) {
            this.chatDao = chatDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            chatDao.deleteAllCharts();
            return null;
        }
    }
}
