package com.ascendant.dharmais.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.dharmais.Method.Destiny;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AdapterTestimoni extends RecyclerView.Adapter<AdapterTestimoni.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterTestimoni(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterTestimoni.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_testimoni,viewGroup,false);
        AdapterTestimoni.HolderData holder = new AdapterTestimoni.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterTestimoni.HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        Destiny destiny = new Destiny();
        holderData.tvName.setText(destiny.LimitCharacter(dm.getNama(),40));
        holderData.tvDeskripsi.setText(dm.getPesan());
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
            tvName = itemView.findViewById(R.id.tvNama);
            tvDeskripsi = itemView.findViewById(R.id.tvPesan);
        }
    }
}


