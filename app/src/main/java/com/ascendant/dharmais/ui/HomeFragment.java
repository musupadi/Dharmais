package com.ascendant.dharmais.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.ascendant.dharmais.API.ApiRequest;
import com.ascendant.dharmais.API.RetroServer;
import com.ascendant.dharmais.Adapter.AdapterBanner;
import com.ascendant.dharmais.Adapter.AdapterBerita;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.Model.ResponseModel;
import com.ascendant.dharmais.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    LinearLayout Selengkapnya;
    RecyclerView Berita;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    LottieAnimationView AHeader,ABerita,ASponsor,AProduk;
    LinearLayout LAHeader,LABerita,LASponsor,LAProduk;
    TextView TAHeader,TABerita,TASponsor,TAProduk;

    LinearLayout LArtikel,LBerita,LEvent;
    TextView TArtikel,TBerita,TEvent;
    //Slider
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private AdapterBanner adapterBanner;
    private Button btnBack, btnNext, btnPlay, btnPause, btnStop;
    private TextView[] mDots;
    private int CurrentPage;
    Button Tutup;
    int SizeBanner = 0;
    boolean forward;
    Dialog dialog;
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
        Berita = view.findViewById(R.id.recyclerBerita);
        LArtikel = view.findViewById(R.id.linearArtikel);
        LBerita = view.findViewById(R.id.linearBerita);
        LEvent = view.findViewById(R.id.linearEvent);
        TArtikel = view.findViewById(R.id.tvArtikel);
        TBerita = view.findViewById(R.id.tvBerita);
        TEvent = view.findViewById(R.id.tvEvent);
        //ANIM
        AHeader = view.findViewById(R.id.lottieHeader);
        LAHeader = view.findViewById(R.id.linearAHeader);
        TAHeader = view.findViewById(R.id.tvAHeader);
        //Slider
        mSlideViewPager = view.findViewById(R.id.SlideViewPager);
        mDotLayout = view.findViewById(R.id.dotSlayout);
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_menu_all);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.btn_rounded_white);
        Tutup = dialog.findViewById(R.id.btnTutup);
        Default();
        Berita();
        Header(0);
        AutoSlide();
        Selengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        Tutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });
        LBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Berita();
            }
        });
        LArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artikel();
            }
        });
        LEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event();
            }
        });
    }

    private void Default(){
        LArtikel.setBackgroundResource(R.drawable.rounded);
        LBerita.setBackgroundResource(R.drawable.rounded);
        LEvent.setBackgroundResource(R.drawable.rounded);
        TArtikel.setTextColor(Color.BLACK);
        TBerita.setTextColor(Color.BLACK);
        TEvent.setTextColor(Color.BLACK);
    }
    private void Artikel(){
        Default();
        LArtikel.setBackgroundResource(R.drawable.rounded_active);
        TArtikel.setTextColor(Color.WHITE);
        KabarBerita("Artikel");
    }
    private void Berita(){
        Default();
        LBerita.setBackgroundResource(R.drawable.rounded_active);
        TBerita.setTextColor(Color.WHITE);
        KabarBerita("News");
    }
    private void Event(){
        Default();
        LEvent.setBackgroundResource(R.drawable.rounded_active);
        TEvent.setTextColor(Color.WHITE);
        KabarBerita("Event");
    }
    private void KabarBerita(String kabar){
        mManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        Berita.setLayoutManager(mManager);
//        LABerita.setVisibility(View.VISIBLE);
//        TABerita.setVisibility(View.GONE);
//        ABerita.setAnimation("loading.json");
//        ABerita.playAnimation();
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.Berita(kabar);
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatus().equals("200")){
                        mItems=response.body().getData();
                        mAdapter = new AdapterBerita(getActivity(),mItems);
                        Berita.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(getActivity(), "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
//                    Toast.makeText(getActivity(), "Terjadi Kesalahan User akan Terlogout", Toast.LENGTH_SHORT).show();
////                    dbHelper.Logout();
//                    Intent intent = new Intent(getActivity(), LoginActivity.class);
//                    startActivity(intent);
//                    getActivity().finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
//                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Header(final int position){
        mManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
//        recycler.setLayoutManager(mManager);
        LAHeader.setVisibility(View.VISIBLE);
        TAHeader.setVisibility(View.GONE);
        AHeader.setAnimation("loading.json");
        AHeader.playAnimation();
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.Banner();
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    mItems=response.body().getData();
                    if (mItems.size()<1){
                        TAHeader.setVisibility(View.VISIBLE);
                        TAHeader.setText("Banner Belum Ada");
                        AHeader.setAnimation("notfound.json");
                        AHeader.playAnimation();
                    }else{
                        LAHeader.setVisibility(View.GONE);
                        adapterBanner = new AdapterBanner(getActivity(),mItems);
                        mSlideViewPager.setAdapter(adapterBanner);
                        SizeBanner = mItems.size();
                        addDotsIndicator(position);
                        mSlideViewPager.addOnPageChangeListener(viewList);
                    }
                }catch (Exception e){
                    Log.d("Zyarga : ",e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
//                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addDotsIndicator(int posistion) {
        try {
            mDots = new TextView[SizeBanner];
            mDotLayout.removeAllViews();
            for (int i = 0; i < mDots.length; i++) {
                mDots[i] = new TextView(getActivity());
                mDots[i].setText(Html.fromHtml("&#8226;"));
                mDots[i].setTextSize(35);
                mDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));

                mDotLayout.addView(mDots[i]);
            }
            if (mDots.length > 0) {
                mDots[posistion].setTextColor(getResources().getColor(R.color.colorGreen));
            }
        }catch (Exception e){

        }
    }
    ViewPager.OnPageChangeListener viewList = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            CurrentPage = i;

            if (CurrentPage == 0) {

            } else if (i == mDots.length - 1) {

            } else {

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
            AutoSlide();
        }
    };
    private void AutoSlide(){
        if(CurrentPage == 0) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    forward=true;
                    mSlideViewPager.setCurrentItem(CurrentPage + 1);
                }
            }, 5000);

        }else if(CurrentPage == mDots.length - 1) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    forward=false;
                    mSlideViewPager.setCurrentItem(CurrentPage - 1);
                }
            }, 5000);
        }else{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (forward){
                        mSlideViewPager.setCurrentItem(CurrentPage + 1);
                    }else{
                        mSlideViewPager.setCurrentItem(CurrentPage - 1);
                    }
                }
            }, 5000);
        }
    }
    //PagerEnd
}