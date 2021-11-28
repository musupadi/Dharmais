package com.ascendant.dharmais.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.dharmais.ui.pages.DetailPageActivity;
import com.ascendant.dharmais.Method.Destiny;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterPage extends RecyclerView.Adapter<AdapterPage.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterPage(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterPage.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_page,viewGroup,false);
        AdapterPage.HolderData holder = new AdapterPage.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterPage.HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        Destiny destiny = new Destiny();
        holderData.tvTitle.setText(dm.getTitle());
        holderData.tvPermalink.setText(dm.getPermalink());
        Glide.with(ctx)
                .load(destiny.BASE_URL()+dm.getImage())
                .into(holderData.imgPhoto);
        holderData.Description.loadData(dm.getDescription(),"text/html","UTF-8");
        holderData.Baca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx, DetailPageActivity.class);
                i.putExtra("TITLE", dm.getTitle());
                i.putExtra("GAMBAR", dm.getImage());
                i.putExtra("PERMALINK", dm.getPermalink());
                i.putExtra("WEB", dm.getDescription());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvTitle,tvPermalink;
        WebView Description;
        LinearLayout Baca;
        public HolderData(View v){
            super(v);
            imgPhoto = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPermalink = itemView.findViewById(R.id.tvPermalink);
            Description = itemView.findViewById(R.id.web);
            Baca = itemView.findViewById(R.id.linearBaca);
        }
    }
}
