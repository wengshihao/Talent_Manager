package com.example.talent_manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class TalentFragment3 extends Fragment {

    TextView name,sex,age,apartment,evaluate;
    ImageView face;
    Button refuse, accept;

    public TalentFragment3() {
        // Required empty public constructor
    }


    public static TalentFragment3 newInstance(String param1, String param2) {
        TalentFragment3 fragment = new TalentFragment3();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_talent3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        name = getView().findViewById(R.id.talent_name3);
        sex = getView().findViewById(R.id.talent_sex3);
        age = getView().findViewById(R.id.talent_age3);
        apartment = getView().findViewById(R.id.tallent_apartment3);
        evaluate = getView().findViewById(R.id.talent_evaluate3);
        face = getView().findViewById(R.id.talent_picture3);
        refuse = getView().findViewById(R.id.talent_refuse3);
        accept = getView().findViewById(R.id.talent_accept3);

        name.setText(getArguments().getString("name"));
        sex.setText(getArguments().getString("sex"));
        age.setText(getArguments().getString("age"));
        apartment.setText(getArguments().getString("apartment"));
        evaluate.setText(getArguments().getString("evaluate"));

        if (getArguments().getString("sex").equals("男")){
            face.setBackgroundResource(R.drawable.ic_talent_man3);
        }
        else face.setBackgroundResource(R.drawable.ic_talent_man1);

        refuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController talentNavController = Navigation.findNavController(v);
                talentNavController.navigate(R.id.action_talentFragment3_to_talentFragment);
                Toast toast = Toast.makeText(getContext(),"拒绝成功",Toast.LENGTH_LONG);
                toast.setText("拒绝成功");
                toast.show();
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController talentNavController = Navigation.findNavController(v);
                talentNavController.navigate(R.id.action_talentFragment3_to_talentFragment);
                Toast toast = Toast.makeText(getContext(),"接受成功",Toast.LENGTH_LONG);
                toast.setText("接受成功");
                toast.show();
            }
        });

        Spinner spinner=getActivity().findViewById(R.id.talent_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    spinner.setSelection(0);

                    Bundle bundle = new Bundle();
                    bundle.putString("sex",getArguments().getString("sex"));

                    NavController talentNavController = Navigation.findNavController(getView());
                    talentNavController.navigate(R.id.action_talentFragment3_to_talentFragment4,bundle);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}