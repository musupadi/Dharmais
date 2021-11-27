package com.ascendant.dharmais.ui.Utama.JadwalDokter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ascendant.dharmais.API.ApiRequest;
import com.ascendant.dharmais.API.RetroServer;
import com.ascendant.dharmais.Adapter.AdapterJadwal;
import com.ascendant.dharmais.Adapter.AdapterSpesialis;
import com.ascendant.dharmais.Model.DataModel;
import com.ascendant.dharmais.Model.ResponseModel;
import com.ascendant.dharmais.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalDokterActivity extends AppCompatActivity {
    RelativeLayout Back;
    RecyclerView recyclerView;
    TextView Nama;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    String SPECIALIST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_dokter);
        Back = findViewById(R.id.relativeBack);
        recyclerView = findViewById(R.id.recycler);
        Nama = findViewById(R.id.tvNamaSpesialis);

        Intent intent = getIntent();
        SPECIALIST = intent.getExtras().getString("SPECIALIST");
        Nama.setText(SPECIALIST);
        Jadwal();
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
    private void Jadwal(){
        mManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.JadwalDokter(SPECIALIST);
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (response.body().getStatus().equals("200")){
                        mItems=response.body().getData();
                        mAdapter = new AdapterJadwal(JadwalDokterActivity.this,mItems);
                        recyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(JadwalDokterActivity.this, "Terjadi Kesalahan ", Toast.LENGTH_SHORT).show();
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
}