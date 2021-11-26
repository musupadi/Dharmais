package com.ascendant.dharmais.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.dharmais.Method.Destiny;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterBerita(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterBerita.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_berita,viewGroup,false);
        AdapterBerita.HolderData holder = new AdapterBerita.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterBerita.HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        Destiny destiny = new Destiny();
        Glide.with(ctx)
                .load(destiny.BASE_URL()+dm.getImage())
                .apply(new RequestOptions().override(350, 550))
                .into(holderData.imgPhoto);
        holderData.tvName.setText(destiny.LimitCharacter(dm.getTitle(),40));
        holderData.tvDeskripsi.setText(destiny.SmallDescription(destiny.FilterTextToJava(dm.getDescription())));
        holderData.tvTanggal.setText(dm.getDate());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName,tvDeskripsi,tvTanggal;
        public HolderData(View v){
            super(v);
            imgPhoto = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvNamaBerita);
            tvDeskripsi = itemView.findViewById(R.id.tvDeskripsi);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
        }
    }
}

