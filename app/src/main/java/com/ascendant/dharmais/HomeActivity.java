package com.ascendant.dharmais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ascendant.dharmais.ui.AboutUsFragment;
import com.ascendant.dharmais.ui.FeedbackFragment;
import com.ascendant.dharmais.ui.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    ImageView imageHome,imageFeedback,imageAbout;
    TextView textHome,textFeedback,textAbout;
    LinearLayout linearHome,linearFeedback,linearAbout;
    Fragment fragment;
    String Count;
    String Lang;
    Context context;

    Dialog dialog;
    Button No,Yes;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_exit);
        No = dialog.findViewById(R.id.btnTidak);
        Yes = dialog.findViewById(R.id.btnYa);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_corner);
        Declaration();
        Home();
        OnCLick();
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            dialog.show();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    private void OnCLick(){
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
                finish();
                System.exit(0);
            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
        linearHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });
        linearFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Feedback();
            }
        });
        linearAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                About();
            }
        });
    }
    private void Declaration(){
        imageHome = findViewById(R.id.ivHome);
        textHome = findViewById(R.id.tvHome);
        imageFeedback = findViewById(R.id.ivFeedback);
        textFeedback = findViewById(R.id.tvFeedback);
        imageAbout = findViewById(R.id.ivAbout);
        textAbout = findViewById(R.id.tvAbout);
        linearHome = findViewById(R.id.linearHome);
        linearFeedback = findViewById(R.id.linearFeedback);
        linearAbout = findViewById(R.id.linearAbout);
    }
    private void Default(){
        linearHome.setBackgroundResource(R.drawable.rounded);
        linearFeedback.setBackgroundResource(R.drawable.rounded);
        linearAbout.setBackgroundResource(R.drawable.rounded);
        imageHome.setImageResource(R.drawable.home);
        imageAbout.setImageResource(R.drawable.about);
        imageFeedback.setImageResource(R.drawable.feedback);
        textHome.setTextColor(Color.BLACK);
        textAbout.setTextColor(Color.BLACK);
        textFeedback.setTextColor(Color.BLACK);
    }
    private void Home(){
        Default();
        linearHome.setBackgroundResource(R.drawable.rounded_active);
        imageHome.setImageResource(R.drawable.home_active);
        textHome.setTextColor(Color.WHITE);
        fragment = new HomeFragment();
        ChangeFragment(fragment);
    }
    private void About(){
        Default();
        linearAbout.setBackgroundResource(R.drawable.rounded_active);
        imageAbout.setImageResource(R.drawable.about_active);
        textAbout.setTextColor(Color.WHITE);
        fragment = new AboutUsFragment();
        ChangeFragment(fragment);
    }
    private void Feedback(){
        Default();
        linearFeedback.setBackgroundResource(R.drawable.rounded_active);
        imageFeedback.setImageResource(R.drawable.feedback_active);
        textFeedback.setTextColor(Color.WHITE);
        fragment = new FeedbackFragment();
        ChangeFragment(fragment);
    }
    private void ChangeFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.Container,fragment);
            ft.commit();
        }
    }
}