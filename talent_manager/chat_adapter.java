package com.example.talent_manager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class chat_adapter extends RecyclerView.Adapter<chat_adapter.chatViewHolder> {

    List<Chat>allChats=new ArrayList<>();
    private Context context;
    public void setAllChats(List<Chat> allChats) {
        this.allChats = allChats;
    }
    public chat_adapter() {
    }

    public chat_adapter(Context context) {
        this.context=context;
    }
    @NonNull
    @Override
    public chatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.chat_card,parent,false);
        return new chatViewHolder(itemView);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull chatViewHolder holder, int position) {
        Chat chat=allChats.get(position);
        holder.name.setText(chat.getName());
        holder.age.setText(chat.getAge());
        holder.sex.setText(chat.getSex());
        holder.skill.setText(chat.getSkill());
        holder.company.setText(chat.getCompany());
        holder.head.setImageResource(R.drawable.ic_talent_man1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ChatdetilActivity.class);
                intent.putExtra("name",chat.getName());
                intent.putExtra("sex",chat.getSex());
                intent.putExtra("age",chat.getAge());
                intent.putExtra("skill",chat.getSkill());
                intent.putExtra("company",chat.getCompany());
                intent.putExtra("gangwei",chat.getGangwei());
                intent.putExtra("xinzi",chat.getXinzi());
                intent.putExtra("pingjia",chat.getPingjia());
                context.startActivity(intent);

            }
        });
    }






    @Override
    public int getItemCount() {
        return allChats.size();
    }

    static class chatViewHolder extends RecyclerView.ViewHolder{
        TextView name,sex,age,skill,company;
        ImageView head;
        public chatViewHolder(@NonNull View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.nametv);
            sex=itemView.findViewById(R.id.sextv);
            age=itemView.findViewById(R.id.agetv);
            skill=itemView.findViewById(R.id.skilltv);
            company=itemView.findViewById(R.id.companytv);
            head=itemView.findViewById(R.id.headiv);


        }

    }

}
