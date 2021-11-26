package com.ascendant.dharmais.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.ascendant.dharmais.API.ApiRequest;
import com.ascendant.dharmais.API.RetroServer;
import com.ascendant.dharmais.Adapter.AdapterBanner;
import com.ascendant.dharmais.Adapter.AdapterBerita;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.Model.ResponseModel;
import com.ascendant.dharmais.R;
import com.ascendant.dharmais.databinding.FragmentHomeBinding;
import com.ascendant.dharmais.ui.AboutUsFragment;
import com.ascendant.dharmais.ui.FeedbackFragment;
import com.ascendant.dharmais.ui.FragmentUtama;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
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
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_exit);
        No = dialog.findViewById(R.id.btnTidak);
        Yes = dialog.findViewById(R.id.btnYa);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rounded_corner);
        imageHome = view.findViewById(R.id.ivHome);
        textHome = view.findViewById(R.id.tvHome);
        imageFeedback = view.findViewById(R.id.ivFeedback);
        textFeedback = view.findViewById(R.id.tvFeedback);
        imageAbout = view.findViewById(R.id.ivAbout);
        textAbout = view.findViewById(R.id.tvAbout);
        linearHome = view.findViewById(R.id.linearHome);
        linearFeedback = view.findViewById(R.id.linearFeedback);
        linearAbout = view.findViewById(R.id.linearAbout);
        Home();
        OnCLick();
    }
    private void OnCLick(){
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
                getActivity().finish();
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
        fragment = new FragmentUtama();
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
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.Container,fragment);
            ft.commit();
        }
    }
}