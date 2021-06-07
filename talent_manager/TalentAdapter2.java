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

import com.example.talent_manager.Evaluate_Listview.Evaluate;

import java.util.ArrayList;
import java.util.List;

public class TalentAdapter2 extends RecyclerView.Adapter<TalentAdapter2.TalentViewHolder2> {

    List<Evaluate> allEvalute = new ArrayList<>();
    String work;
    int num;

    public void setAllEvalute(List<Evaluate> allEvalute, String work, int num){
        this.allEvalute = allEvalute;
        this.work = work;
        this.num = num;
    }

    @NonNull
    @Override
    public TalentViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater talentlayoutInflater = LayoutInflater.from(parent.getContext());
        View talentitemView = talentlayoutInflater.inflate(R.layout.talent_card2,parent,false);


        return new TalentViewHolder2(talentitemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TalentViewHolder2 holder, int position) {
        Evaluate evaluate = allEvalute.get(position);
        holder.name.setText(evaluate.getName());
        holder.sex.setText(evaluate.getSex());
        int temp=evaluate.getAge();
        holder.age.setText(String.valueOf(temp));
        holder.apartment.setText(work);
        if(evaluate.getSex().equals("女"))
            holder.face.setBackgroundResource(R.drawable.ic_talent_man1);
        else
            holder.face.setBackgroundResource(R.drawable.ic_talent_man3);

        if(evaluate.getFlag() == 0){
            holder.flag.setAlpha(0);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluate.setFlag(0);
                notifyDataSetChanged();
                num--;
                Bundle talentBundle3 = new Bundle();
                talentBundle3.putString("name",evaluate.getName());
                talentBundle3.putString("sex",evaluate.getSex());
                talentBundle3.putString("apartment",work);
                talentBundle3.putString("evaluate",evaluate.getContent());
                talentBundle3.putString("age", String.valueOf(evaluate.getAge()));

                NavController talentNavController = Navigation.findNavController(v);
                talentNavController.navigate(R.id.action_talentFragment2_to_talentFragment3,talentBundle3);
            }
        });
    }

    @Override
    public int getItemCount() {
        return num;
    }

    static class TalentViewHolder2 extends RecyclerView.ViewHolder{
        private TextView name, age, sex, apartment;
        private ImageView face,flag;

        public TalentViewHolder2(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.talent_name);
            age = itemView.findViewById(R.id.talent_age);
            sex = itemView.findViewById(R.id.talent_sex);
            apartment = itemView.findViewById(R.id.talent_apartment);
            face = itemView.findViewById(R.id.talent_picture);
            flag = itemView.findViewById(R.id.talent_flag);
        }

    }


}
