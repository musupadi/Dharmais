package com.ascendant.dharmais.ui.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ascendant.dharmais.Method.Destiny;
import com.ascendant.dharmais.R;
import com.bumptech.glide.Glide;

public class DetailPageActivity extends AppCompatActivity {
    String TITLE,GAMBAR,PERMALINK,WEB;
    TextView NamaTitle,Title,Permalink;
    ImageView Gambar;
    WebView web;
    Destiny destiny;
    int LimitText = 50;
    RelativeLayout Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        Back = findViewById(R.id.relativeBack);
        destiny = new Destiny();
        Intent intent = getIntent();
        TITLE = intent.getExtras().getString("TITLE");
        GAMBAR = intent.getExtras().getString("GAMBAR");
        PERMALINK = intent.getExtras().getString("PERMALINK");
        WEB = intent.getExtras().getString("WEB");

        NamaTitle = findViewById(R.id.tvNamaTItle);
        Title = findViewById(R.id.tvTitle);
        Permalink = findViewById(R.id.tvPermalink);
        Gambar = findViewById(R.id.ivImage);
        web = findViewById(R.id.web);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        NamaTitle.setText(TITLE);
        Title.setText(TITLE);
        Permalink.setText(PERMALINK);
        Glide.with(this)
                .load(destiny.BASE_URL()+GAMBAR)
                .into(Gambar);
        web.loadData(WEB,"text/html","UTF-8");
    }
}