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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.talent_manager.Record_Listview.Record;

//import com.example.talent_manager.databinding.FragmentEvaluateDetailBinding;

public class EvaluateJix extends AppCompatActivity {


    private int position;
    private Record record;

    private ImageView imageView;


    private TextView GZJX;
    private TextView JHWCL;
    private TextView SKWCL;
    private TextView XSFYL;
    private TextView XKHKZ;
    private TextView SCXXSJ;
    private TextView CQ;
    private TextView KG;
    private TextView QJ;
    private TextView CDZT;


    //private MutableLiveData<String> name,date,apartment,content;

    //private Button button;
    //private RadioButton radioButton1,radioButton2;
    //private Evaluate evaluate = new Evaluate();
    private Spinner spinner;

    //FragmentEvaluateDetailBinding binding;




    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onCreate(Bundle savedInstanceState) {
        Log.e("TAfefdwfwefG", "hhhhhh");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN|
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_evaluate_jix);

        Intent intent = getIntent();
        record = (Record)intent.getSerializableExtra("data");

        GZJX = findViewById(R.id.eva_edit_name);
        JHWCL = findViewById(R.id.eva_edit_jhwcl);
        SKWCL = findViewById(R.id.eva_edit_date);
        XSFYL = findViewById(R.id.eva_edit_apartment);
        XKHKZ = findViewById(R.id.eva_edit_xkhkf);
        SCXXSJ = findViewById(R.id.eva_edit_scxxsj);
        CQ = findViewById(R.id.eva_edit_cq);
        KG = findViewById(R.id.eva_edit_kg);
        QJ = findViewById(R.id.eva_edit_qj);
        CDZT = findViewById(R.id.eva_edit_cdzt);
        imageView = findViewById(R.id.eva_edit_image1);

        GZJX.setText(record.getGZJX());
        JHWCL.setText(record.getJHWCL());
        SKWCL.setText(record.getSCXXSJ());
        XSFYL.setText(record.getXSFYL());
        XKHKZ.setText(record.getXKHKZ());
        SCXXSJ.setText(record.getSCXXSJ());
        CQ.setText(record.getCQ());
        KG.setText(record.getKG());
        QJ.setText(record.getQJ());
        CDZT.setText(record.getCDZT());

        byte[] in = record.getBitmap();
        Bitmap bmp = BitmapFactory.decodeByteArray(in, 0, in.length );
        imageView.setImageBitmap(bmp);





        spinner = findViewById(R.id.eva_edit_spinner2);
        spinner.setSelection(1);

        //Context context = spinner.getPopupContext();
        //spinner.get
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent();
                    intent = new Intent(EvaluateJix.this, EvaluateDetail.class );


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


    }

}