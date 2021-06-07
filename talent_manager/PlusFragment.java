package com.example.talent_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class PlusFragment extends Fragment {

    EditText company, work, education, welfare, salary, year, demand;
    Button publish;
    private TalentDao talentDao;

    public PlusFragment() {
        // Required empty public constructor
    }
    public static PlusFragment newInstance(String param1, String param2) {
        PlusFragment fragment = new PlusFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_plus, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TalentDatabase talentDatabase = TalentDatabase.getDatabase(getActivity());
        talentDao = talentDatabase.getTalentDao();
        publish = getView().findViewById(R.id.plus_button_publish);
        company = getView().findViewById(R.id.plus_edittext_company);
        work = getView().findViewById(R.id.plus_edittext_work);
        education = getView().findViewById(R.id.plus_edittext_education);
        year = getView().findViewById(R.id.plus_edittext_year);
        salary = getView().findViewById(R.id.plus_edittext_salary);
        welfare = getView().findViewById(R.id.plus_edittext_welfare);
        demand = getView().findViewById(R.id.plus_edittext_demand);

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(company.length()==0){
                    Toast toast = Toast.makeText(getContext(),"请输入公司名称",Toast.LENGTH_LONG);
                    toast.show();
                    return ;
                }
                if(work.length()==0){
                    Toast toast = Toast.makeText(getContext(),"请输入招聘岗位",Toast.LENGTH_LONG);
                    toast.show();
                    return ;
                }
                if(education.length()==0){
                    Toast toast = Toast.makeText(getContext(),"请输入学历要求",Toast.LENGTH_LONG);
                    toast.show();
                    return ;
                }
                if(year.length()==0){
                    Toast toast = Toast.makeText(getContext(),"请输入工作经验",Toast.LENGTH_LONG);
                    toast.show();
                    return ;
                }
                if(salary.length()==0){
                    Toast toast = Toast.makeText(getContext(),"请输入薪资预期",Toast.LENGTH_LONG);
                    toast.show();
                    return ;
                }
                if(welfare.length()==0){
                    Toast toast = Toast.makeText(getContext(),"请输入工作福利",Toast.LENGTH_LONG);
                    toast.show();
                    return ;
                }
                if(demand.length()==0){
                    Toast toast = Toast.makeText(getContext(),"请输入工作要求",Toast.LENGTH_LONG);
                    toast.show();
                    return ;
                }
                talentDao.insert(new TalentEntity(work.getText().toString(),salary.getText().toString(),"北京 海淀区 中关村"
                        ,year.getText().toString(), education.getText().toString(),
                        demand.getText().toString(),welfare.getText().toString(), company.getText().toString(), 0));

                NavController NavController = Navigation.findNavController(v);
                NavController.navigate(R.id.action_plusFragment_to_talentFragment);
                Toast toast = Toast.makeText(getContext(),"发布成功",Toast.LENGTH_LONG);
                toast.setText("发布成功");
                toast.show();

            }
        });


    }
}