package com.example.talent_manager;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.talent_manager.Record_Listview.Record;
import com.example.talent_manager.Record_Listview.RecordDao;
import com.example.talent_manager.Record_Listview.RecordDatabase;

import java.util.List;

public class EvaluateViewModel extends AndroidViewModel {
    private RecordDao recordDao;
    private RecordDatabase recordDatabase;
    private LiveData<List<Record>>allRecordLive = null;
    private LiveData<Integer> count;
    public EvaluateViewModel(Application application) {
        super(application);

        recordDatabase = RecordDatabase.getDatabase(application);
        //searchDatabase.getSearchDao().

        recordDao = recordDatabase.getRecordDao();

        allRecordLive = recordDao.GetAllWorks();

        count = recordDao.GetCount();
    }

    public LiveData<Integer> getCount() {
        return count;
    }

    public RecordDatabase getRecordDatabase() {
        return recordDatabase;
    }

    public void setRecordDatabase(RecordDatabase searchDatabase) {
        this.recordDatabase = searchDatabase;
    }

    public LiveData<List<Record>> getAllRecordLive() {
        return allRecordLive;
    }

    public void setAllSearchLive(LiveData<List<Record>> allRecordLive) {
        this.allRecordLive = allRecordLive;
    }

    public RecordDao getRecordDao() {
        return recordDao;
    }

    public void setRecordDao(RecordDao searchDao) {
        this.recordDao = searchDao;
    }

    void insertRecords(Record... records){
        new InsertAsyncTask(recordDao).execute(records);
    }
    void updateRecords(Record... records){
        new UpdateAsyncTask(recordDao).execute(records);
    }
    void deleteRecords(Record... records){
        new DeleteAsyncTask(recordDao).execute(records);
    }
    void deleteAllWorksRecords(){
        new DeleteAllAsyncTask(recordDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<Record,Void,Void> {
        private RecordDao recordDao;

        public InsertAsyncTask(RecordDao recordDao) {
            this.recordDao = recordDao;
        }


        protected Void doInBackground(Record... records) {
            recordDao.InsertWorks(records);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Record,Void,Void> {
        private RecordDao recordDao;

        public UpdateAsyncTask(RecordDao recordDao) {
            this.recordDao = recordDao;
        }


        protected Void doInBackground(Record... records) {
            recordDao.UpdateWorks(records);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Record,Void,Void> {
        private RecordDao recordDao;

        public DeleteAsyncTask(RecordDao recordDao) {
            this.recordDao = recordDao;
        }


        protected Void doInBackground(Record... records) {
            recordDao.DeleteWorks(records);
            return null;
        }
    }
/*
    static class GetAllWorksAsyncTask extends AsyncTask<Search,Void,Void> {
        private SearchDao searchDao;

        public GetAllWorksAsyncTask(SearchDao searchDao) {
            this.searchDao = searchDao;
        }

        @Override
        protected Void doInBackground(Search... searches) {
            return SearchDao.GetAllWorks(searches);
            //return null;
        }
    }*/

    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void> {
        private RecordDao recordDao;

        public DeleteAllAsyncTask(RecordDao recordDao) {
            this.recordDao = recordDao;
        }


        protected Void doInBackground(Void... voids) {
            recordDao.DeleteAll();
            return null;
        }
    }

    // TODO: Implement the ViewModel
}