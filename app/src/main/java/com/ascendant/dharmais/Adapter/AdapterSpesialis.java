package com.ascendant.dharmais.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.dharmais.Method.Destiny;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.R;
import com.ascendant.dharmais.ui.Utama.JadwalDokter.JadwalDokterActivity;

import java.util.List;

public class AdapterSpesialis extends RecyclerView.Adapter<AdapterSpesialis.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterSpesialis(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterSpesialis.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_spesialis,viewGroup,false);
        AdapterSpesialis.HolderData holder = new AdapterSpesialis.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterSpesialis.HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        Destiny destiny = new Destiny();
        holderData.tvName.setText(destiny.LimitCharacter(dm.getSpesialis(),100));
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx, JadwalDokterActivity.class);
                i.putExtra("SPECIALIST", dm.getSpesialis());
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
        TextView tvName;
        CardView card;
        public HolderData(View v){
            super(v);
            tvName = itemView.findViewById(R.id.tvNama);
            card = itemView.findViewById(R.id.card_view);
        }
    }
}
