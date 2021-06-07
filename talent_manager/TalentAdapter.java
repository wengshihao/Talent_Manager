package com.example.talent_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TalentAdapter extends RecyclerView.Adapter<TalentAdapter.TalentViewHolder> {



    List<TalentEntity> allTalentEntity= new ArrayList<>();

    public void setAllTalentEntity(List<TalentEntity> allTalentEntity){
        this.allTalentEntity = allTalentEntity;
    }

    @NonNull
    @Override
    public TalentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater talentlayoutInflater = LayoutInflater.from(parent.getContext());
        View talentitemView = talentlayoutInflater.inflate(R.layout.talent_card,parent,false);




        return new TalentViewHolder(talentitemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TalentViewHolder holder, int position) {
        TalentEntity talentEntity = allTalentEntity.get(position);
        holder.talent_work.setText(talentEntity.getWork());
        holder.talent_year.setText(talentEntity.getYear());
        holder.talent_education.setText(talentEntity.getEducation());
        holder.talent_address.setText(talentEntity.getAddress());
        holder.talent_salary.setText(talentEntity.getSalary());
//        Random random = new Random();
//        int now = Math.abs(random.nextInt()%2) + 1;
//        holder.talent_Src = "ic_talent_man" + String.valueOf(now);
//        int Rid=holder.itemView.getResources().getIdentifier(holder.talent_Src,"drawable","com.example.talent_manager");
//        holder.talent_face.setBackgroundResource(Rid);
        int num = talentEntity.getNum();
        if(num>0)holder.talent_face.setBackgroundResource(R.drawable.ic_talent_man1);
        if(num>1)holder.talent_face2.setBackgroundResource(R.drawable.ic_talent_man2);
        if(num>2)holder.talent_face3.setBackgroundResource(R.drawable.ic_talent_man3);
        if(num>3)holder.talent_face4.setBackgroundResource(R.drawable.ic_talent_man4);
        if(num>4)holder.talent_face5.setBackgroundResource(R.drawable.ic_talent_man5);
        if(num>5)holder.talent_face5.setBackgroundResource(R.drawable.ic_talent_man6);




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle talentBundle = new Bundle();
                talentBundle.putString("company",talentEntity.getCompany());
                talentBundle.putString("work",talentEntity.getWork());
                talentBundle.putString("education",talentEntity.getEducation());
                talentBundle.putString("year",talentEntity.getYear());
                talentBundle.putString("salary",talentEntity.getSalary());
                talentBundle.putString("welfare",talentEntity.getWelfare());
                talentBundle.putString("demand",talentEntity.getDemand());
                talentBundle.putString("address",talentEntity.getAddress());
                talentBundle.putInt("ID", talentEntity.getId());
                talentBundle.putInt("num", talentEntity.getNum());
                NavController talentNavController = Navigation.findNavController(v);
                talentNavController.navigate(R.id.action_talentFragment_to_talentFragment2,talentBundle);
            }
        });

    }



    @Override
    public int getItemCount() {
        return allTalentEntity.size();
    }

    static class TalentViewHolder extends RecyclerView.ViewHolder{
        TextView talent_work, talent_address, talent_year, talent_education, talent_salary;
        String  talent_Src;
        ImageView talent_face, talent_face2, talent_face3, talent_face4, talent_face5, talent_face6;
        public TalentViewHolder(@NonNull View itemView){
            super(itemView);
            talent_salary = itemView.findViewById(R.id.talent_salary);
            talent_work = itemView.findViewById(R.id.talent_work);
            talent_address = itemView.findViewById(R.id.talent_address);
            talent_year = itemView.findViewById(R.id.talent_year);
            talent_education = itemView.findViewById(R.id.talent_education);
            talent_face = itemView.findViewById(R.id.talent_face);
            talent_face2 = itemView.findViewById(R.id.talent_face2);
            talent_face3 = itemView.findViewById(R.id.talent_face3);
            talent_face4 = itemView.findViewById(R.id.talent_face4);
            talent_face5 = itemView.findViewById(R.id.talent_face5);
            talent_face6 = itemView.findViewById(R.id.talent_face6);





        }

    }


}
