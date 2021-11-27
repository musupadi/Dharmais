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

public class AdapterIsiJadwal extends RecyclerView.Adapter<AdapterIsiJadwal.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterIsiJadwal(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterIsiJadwal.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_isi_jadwal,viewGroup,false);
        AdapterIsiJadwal.HolderData holder = new AdapterIsiJadwal.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterIsiJadwal.HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        holderData.Jam.setText(dm.getJam());
        holderData.Hari.setText(dm.getHari());
        holderData.Lokasi.setText(dm.getLokasi());
    }

    @Override
    public int getItemCount() {
        try {
            return mList.size();
        }catch (Exception e){
            return 0;
        }
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView Jam,Hari,Lokasi;
        public HolderData(View v){
            super(v);
            Jam = itemView.findViewById(R.id.tvJam);
            Hari = itemView.findViewById(R.id.tvHari);
            Lokasi = itemView.findViewById(R.id.tvLokasi);
        }
    }
}
