package com.ascendant.dharmais.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.dharmais.Method.Destiny;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.R;
import com.ascendant.dharmais.ui.Utama.JadwalDokter.JadwalDokterActivity;

import java.util.ArrayList;
import java.util.List;

public class AdapterJadwal extends RecyclerView.Adapter<AdapterJadwal.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    public AdapterJadwal(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterJadwal.HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_jadwal,viewGroup,false);
        AdapterJadwal.HolderData holder = new AdapterJadwal.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterJadwal.HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        Destiny destiny = new Destiny();
        holderData.tvName.setText(dm.getNamadokter());
        holderData.tvSpesialis.setText(dm.getSpesialis());
        if (dm.getStatus().equals("1")){
            holderData.tvStatus.setText("Aktif");
        }else{
            holderData.tvStatus.setText("Tidak Aktif");
        }

        mManager = new GridLayoutManager(ctx,1);
        holderData.recyclerView.setLayoutManager(mManager);
        mItems=dm.getIsijadwal();
        mAdapter = new AdapterIsiJadwal(ctx,mItems);
        holderData.recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName,tvSpesialis,tvStatus;
        RecyclerView recyclerView;
        public HolderData(View v){
            super(v);
            tvName = itemView.findViewById(R.id.tvNamaDokter);
            tvSpesialis = itemView.findViewById(R.id.tvSpesialisDokter);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            recyclerView = itemView.findViewById(R.id.recycler);
        }
    }
}
