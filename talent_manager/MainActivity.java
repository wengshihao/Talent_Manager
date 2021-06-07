package com.example.talent_manager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.barcolor), true);
        NavController navController= Navigation.findNavController(this,R.id.fragment);
        MotionLayout m1=findViewById(R.id.m1MotionLayout);
        MotionLayout m2=findViewById(R.id.m2MotionLayout);
        MotionLayout m3=findViewById(R.id.m3MotionLayout);
        MotionLayout m4=findViewById(R.id.m4MotionLayout);
        MotionLayout mplus=findViewById(R.id.plusMotionLayout);



        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.talentFragment);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.evaluateFragment);
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.chatFragment);
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.meFragment);
            }
        });

        mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.plusFragment);
            }
        });

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                m1.setProgress(0);
                m2.setProgress(0);
                m3.setProgress(0);
                m4.setProgress(0);
                mplus.setProgress(0);
                if (destination.getId()==R.id.talentFragment)
                {
                    m1.transitionToEnd();
                }
                if (destination.getId()==R.id.evaluateFragment)
                {
                    m2.transitionToEnd();
                }
                if (destination.getId()==R.id.chatFragment)
                {
                    m3.transitionToEnd();
                }
                if (destination.getId()==R.id.meFragment)
                {
                    m4.transitionToEnd();
                }
                if (destination.getId()==R.id.plusFragment)
                {
                    mplus.transitionToEnd();
                }
            }
        });

    }
}