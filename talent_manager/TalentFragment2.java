package com.example.talent_manager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talent_manager.Evaluate_Listview.Evaluate;
import com.example.talent_manager.Evaluate_Listview.EvaluateDao;
import com.example.talent_manager.Evaluate_Listview.EvaluateDatabase;

import java.util.List;


public class TalentFragment2 extends Fragment {
    private EvaluateDao evaluateDao;
    RecyclerView talentrecyclerView2;
    TalentAdapter2 talentAdapter2;
    private TextView work, address, salary, year, education;
    private LiveData<List<Evaluate>> allEvalute;

    public TalentFragment2() {
        // Required empty public constructor
    }

    public LiveData<List<Evaluate>> getAllEvaluteLive() {
        return allEvalute;
    }

    public static TalentFragment2 newInstance(String param1, String param2) {
        TalentFragment2 fragment = new TalentFragment2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        return inflater.inflate(R.layout.fragment_talent2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        work = getView().findViewById(R.id.talent_work2);
        address = getView().findViewById(R.id.talent_address2);
        salary = getView().findViewById(R.id.talent_salary2);
        year = getView().findViewById(R.id.talent_year2);
        education = getView().findViewById(R.id.talent_education2);

        work.setText(getArguments().getString("work"));
        address.setText(getArguments().getString("address"));
        salary.setText(getArguments().getString("salary"));
        year.setText(getArguments().getString("year"));
        education.setText(getArguments().getString("education"));


        EvaluateDatabase evaluateDatabase = EvaluateDatabase.getDatabase(getContext());
        evaluateDao = evaluateDatabase.getEvaluateDao();


        if(evaluateDao.getCountEvaluate() == 0){
            String name[] = {"郭先生","翁先生","余先生","鲍先生","苏女士","张女士","李女士","张先生" };
            String sex[] = {"男","男","男","男","女","女","女","男"};
            int age[] = {30, 31, 32, 33, 34, 35, 36, 37};
            for (int i=0; i<8; i++){
                evaluateDao.InsertWorks(new Evaluate(name[i], sex[i], age[i]));
            }
        }


        talentrecyclerView2 = getView().findViewById(R.id.talent_recyclerView2);
        talentAdapter2 = new TalentAdapter2();
        talentrecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        talentrecyclerView2.setAdapter(talentAdapter2);

        evaluateDao.GetAllWorks().observe(getActivity(), new Observer<List<Evaluate>>() {
            @Override
            public void onChanged(List<Evaluate> Evaluates) {
//                int num = getArguments().getInt("num");
//                List<Evaluate> evaluates2=new ArrayList<Evaluate>();
//                for(int i=0;i<num;i++)
//                {
//                    evaluates2.add(Evaluates.get(i));
//                }
//                talentAdapter2.setAllEvalute(evaluates2,getArguments().getString("work"));
                talentAdapter2.setAllEvalute(Evaluates,getArguments().getString("work"), getArguments().getInt("num"));
                talentAdapter2.notifyDataSetChanged();
            }
        });



    }
    void insertEvaluate(Evaluate... Evaluates){
        new InsertAsyncTask(evaluateDao).execute(Evaluates);
    }


    static class InsertAsyncTask extends AsyncTask<Evaluate,Void,Void> {
        private EvaluateDao evaluateDao;
        public InsertAsyncTask(EvaluateDao evaluateDao){
            this.evaluateDao = evaluateDao;
        }
        @Override
        protected Void doInBackground(Evaluate... Evaluates) {
            evaluateDao.InsertWorks(Evaluates);
            return null;
        }
    }

    void deleteEvaluate(Evaluate... Evaluates){
        new DeleteAsyncTask(evaluateDao).execute(Evaluates);
    }


    static class DeleteAsyncTask extends AsyncTask<Evaluate,Void,Void> {
        private EvaluateDao evaluateDao;
        public DeleteAsyncTask(EvaluateDao evaluateDao){
            this.evaluateDao = evaluateDao;
        }
        @Override
        protected Void doInBackground(Evaluate... Evaluates) {
            evaluateDao.DeleteWorks(Evaluates);
            return null;
        }
    }
}