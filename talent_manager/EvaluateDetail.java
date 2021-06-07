package com.example.talent_manager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.talent_manager.Record_Listview.Record;

//import com.example.talent_manager.databinding.FragmentEvaluateDetailBinding;

public class EvaluateDetail extends AppCompatActivity{

    private ImageView imageView;
    private int position;

    private TextView name_textView;
    private TextView date_textView;
    private TextView apartment_textView;
    private EditText content_textView;
    private TextView sex_textView;
    private Spinner spinner;
    private Button button;

    //private MutableLiveData<String> name,date,apartment,content;


    private Record record = new Record();


    //FragmentEvaluateDetailBinding binding;




    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onCreate(Bundle savedInstanceState) {
        Log.e("TAfefdwfwefG", "hhhhhh");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN|
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_evaluate_detail);
        Intent intent = getIntent();
        record = (Record)intent.getSerializableExtra("data");
        //Log.e("dbwhjdbcwljcbhwlcbw",intent.getStringExtra("bdweh"));

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");



        imageView = findViewById(R.id.eva_edit_image1);
        name_textView = findViewById(R.id.eva_edit_name);
        name_textView.setFocusable(false);name_textView.setFocusableInTouchMode(false);

        date_textView = findViewById(R.id.eva_edit_date);
        date_textView.setFocusable(false);date_textView.setFocusableInTouchMode(false);

        apartment_textView = findViewById(R.id.eva_edit_apartment);
        apartment_textView.setFocusable(false);apartment_textView.setFocusableInTouchMode(false);

        content_textView = findViewById(R.id.eva_edit_evaluate);
        content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);


        sex_textView = findViewById(R.id.eva_edit_sex);
        sex_textView.setFocusable(false);sex_textView.setFocusableInTouchMode(false);

        spinner = findViewById(R.id.eva_edit_spinner2);
        spinner.setSelection(0);
        button = findViewById(R.id.eva_edit_button);
        button.setText("修  改");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("修  改")){
                    button.setText("保  存");
                    content_textView.setFocusableInTouchMode(true);content_textView.setFocusable(true);content_textView.requestFocus();
                }
                else{
                    Toast.makeText(getApplicationContext(),"保存成功", Toast.LENGTH_SHORT).show();
                    record.setContent(content_textView.getText().toString());
                    button.setText("修  改");
                    content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);
                }
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    Intent intent = new Intent();
                    intent = new Intent(EvaluateDetail.this, EvaluateJix.class);

                    Log.e("feefff","bcuwcbuhcbwcuwcb");

                    Bundle bundleObject = new Bundle();
                    bundleObject.putSerializable("data", record);
                    intent.putExtra("position",position);

                    intent.putExtras(bundleObject);

                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //button = findViewById(R.id.eva_edit_change);

        /*name_textView.setFocusable(false);name_textView.setFocusableInTouchMode(false);
        date_textView.setFocusable(false);date_textView.setFocusableInTouchMode(false);
        apartment_textView.setFocusable(false);apartment_textView.setFocusableInTouchMode(false);
        content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);
        radioButton1.setEnabled(false);
        radioButton2.setEnabled(false);*/

        position=intent.getIntExtra("position",0);

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");

        byte[] in = record.getBitmap();
        Bitmap bmp = BitmapFactory.decodeByteArray(in, 0, in.length );
        imageView.setImageBitmap(bmp);


        //name_textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        name_textView.setText(record.getName());
        date_textView.setText(record.getDate());
        apartment_textView.setText(record.getApartment());
        sex_textView.setText(record.getSex());

        content_textView.setText(record.getContent());
        /*evaluate.setName(intent.getStringExtra("name"));
        evaluate.setDate(intent.getStringExtra("date"));
        evaluate.setApartment(intent.getStringExtra("apartment"));
        evaluate.setContent(intent.getStringExtra("content"));
        evaluate.setSex(intent.getStringExtra("sex"));*/

        //Log.e("TAfefdwfwefG", intent.getStringExtra("sex"));


        //button.getText()

        //Log.e("TAfefdwfwefG", "hhhhkjfvefwfwfwefhhh");
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("修改")){
                    button.setText("保存");
                    radioButton1.setEnabled(true);
                    radioButton2.setEnabled(true);
                    name_textView.setFocusableInTouchMode(true);name_textView.setFocusable(true);name_textView.requestFocus();
                    date_textView.setFocusableInTouchMode(true);date_textView.setFocusable(true);date_textView.requestFocus();
                    apartment_textView.setFocusableInTouchMode(true);apartment_textView.setFocusable(true);apartment_textView.requestFocus();
                    content_textView.setFocusableInTouchMode(true);content_textView.setFocusable(true);content_textView.requestFocus();
                }
                else{
                    Toast.makeText(getApplicationContext(),"保存成功", Toast.LENGTH_SHORT).show();
                    button.setText("修改");
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    name_textView.setFocusable(false);name_textView.setFocusableInTouchMode(false);
                    date_textView.setFocusable(false);date_textView.setFocusableInTouchMode(false);
                    apartment_textView.setFocusable(false);apartment_textView.setFocusableInTouchMode(false);
                    content_textView.setFocusable(false);content_textView.setFocusableInTouchMode(false);

                    if(radioButton1.isChecked()){
                        evaluate.setSex("男");
                    }else{
                        evaluate.setSex("女");
                    }



                }

            }
        });*/

        record.setName(name_textView.getText().toString());
        record.setContent(content_textView.getText().toString());
        record.setDate(date_textView.getText().toString());
        record.setApartment(apartment_textView.getText().toString());


        //intent.putExtra("image", filter_lists.get(position).getBitmap());
        /*
        intent.putExtra("content", evaluate.getContent());
        intent.putExtra("name", evaluate.getName());
        intent.putExtra("sex", evaluate.getSex());
        intent.putExtra("date", evaluate.getDate());
        intent.putExtra("apartment", evaluate.getApartment());*/
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent = new Intent(this, EvaluateDetail.class);


        Bundle bundleObject = new Bundle();
        bundleObject.putSerializable("data", record);
        intent.putExtra("position",position);

        intent.putExtras(bundleObject);

        setResult(position,intent);
        finish();
    }
/*
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((view.getId() == R.id.textView10 && canVerticalScroll(content_textView))) {

            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    private boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() -editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if(scrollDifference == 0) {
            return false;
        }

        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }*/
}