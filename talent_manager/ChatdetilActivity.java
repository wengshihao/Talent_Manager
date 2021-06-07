package com.example.talent_manager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.githang.statusbar.StatusBarCompat;

public class ChatdetilActivity extends AppCompatActivity {

    TextView nametv,sextv,agetv,companytv,skilltv,jixiaotv,gangweitv,xinzitv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatdetil);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.barcolor), true);

        nametv=findViewById(R.id.detailname);
        sextv=findViewById(R.id.detailsex);
        agetv=findViewById(R.id.detailage);
        companytv=findViewById(R.id.detailcompany);
        skilltv=findViewById(R.id.detailskill);
        jixiaotv=findViewById(R.id.detailjixiao);
        gangweitv=findViewById(R.id.detailgangwei);
        xinzitv=findViewById(R.id.detilxinzi);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String sex=intent.getStringExtra("sex");
        String age=intent.getStringExtra("age");
        String company=intent.getStringExtra("company");
        String skill=intent.getStringExtra("skill");
        String gangwei=intent.getStringExtra("gangwei");
        String xinzi=intent.getStringExtra("xinzi");
        String pingjia=intent.getStringExtra("pingjia");

        nametv.setText(name);
        sextv.setText(sex);
        agetv.setText(age);
        gangweitv.setText(gangwei);
        companytv.setText("现就职于："+company);
        skilltv.setText(skill);
        //"绩效评价：在我公司期间绩效情况完成非常出色，能力十分突出，且工作勤恳不怕辛劳，在我公司属于出类拔萃的人才。")
        jixiaotv.setText(pingjia);
        xinzitv.setText(xinzi);

        Button button=findViewById(R.id.callbtn);
        Button button2=findViewById(R.id.onlinebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:123"));
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChatdetilActivity.this,ChatppActivity.class);
                startActivity(intent);
            }
        });
    }
}