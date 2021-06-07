package com.example.talent_manager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChatppActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter itemAdapter;
    final  static int LEFT=1;
    final  static int RIGHT=2;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatpp);

        initView();
        itemAdapter.addItem("您好，您现在可以\n跟我聊天了，聊天\n内容全程加密哦~",LEFT);
        recyclerView.smoothScrollToPosition(i);//移动到指定位置
        i++;
    }


    private void initView(){
        recyclerView= (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter=new ItemAdapter(this);
        recyclerView.setAdapter(itemAdapter);
    }



    public void rightClick(View v){
        //第一个参数指定发出内容，第二参数指定发出的是左还是右
        EditText editText=findViewById(R.id.chatppedt);
        String string=editText.getText().toString();
        itemAdapter.addItem(string,RIGHT);
        recyclerView.smoothScrollToPosition(i);//移动到指定位置
        i++;
    }
}