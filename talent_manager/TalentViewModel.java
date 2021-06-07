package com.example.talent_manager;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TalentViewModel extends AndroidViewModel {
    private TalentDao talentDao;
    private LiveData<List<TalentEntity>> allTalentEntityLive;

    public TalentViewModel(@NonNull Application application){
        super(application);
        TalentDatabase talentDatabase = TalentDatabase.getDatabase(application);
        talentDao = talentDatabase.getTalentDao();

        allTalentEntityLive = talentDao.getAllTalentEntity();
        if(talentDao.getCountTalentEntity()==0){
            String[] work = {"人事经理","财务总监","审计主管"};
            String[] salary = {"25-35k","23-35k","25-30k"};
            String[] address = {"北京 海淀区 中关村","北京 海淀区 中关村","北京 海淀区 清河"};
            String[] year = {"3-5年","3年以上","经验不限"};
            String[] education ={"本科","本科","本科"};
            String[] demand = {"无","无","无"};
            String[] welfare = {"无","无","无"};
            String[] company = {"腾讯", "阿里", "字节跳动"};
            int[] num = {2, 3, 5};
            for(int i=0; i<work.length;i++){
                insertTalentEntity(new TalentEntity(work[i],salary[i],address[i],year[i],
                        education[i],demand[i],welfare[i], company[i],num[i]));
            }
        }
    }

    public LiveData<List<TalentEntity>> getAllTalentEntityLive() {
        return allTalentEntityLive;
    }

    void insertTalentEntity(TalentEntity... talentEntities){
        new InsertAsyncTask(talentDao).execute(talentEntities);
    }

    void clear(){
        new ClearAsyncTask(talentDao).execute();
    }


    static class InsertAsyncTask extends AsyncTask<TalentEntity,Void,Void> {
        private TalentDao talentDao;
        public InsertAsyncTask(TalentDao talentDao){
            this.talentDao = talentDao;
        }
        @Override
        protected Void doInBackground(TalentEntity... talentEntities) {
            talentDao.insert(talentEntities);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<TalentEntity,Void,Void> {
        private TalentDao talentDao;
        public ClearAsyncTask(TalentDao talentDao){
            this.talentDao = talentDao;
        }
        @Override
        protected Void doInBackground(TalentEntity... talentEntities) {
            talentDao.deleteAllTalentEntity();
            return null;
        }
    }


}
