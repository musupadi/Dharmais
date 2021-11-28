package com.ascendant.dharmais;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.ascendant.dharmais.databinding.ActivityUtamaBinding;

public class UtamaActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityUtamaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUtamaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarUtama.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_cancer_wound,
                R.id.nav_deteksi_dini,R.id.nav_diklit,R.id.nav_farmasi,
                R.id.nav_hbcr,R.id.nav_info_rksd,R.id.nav_informasi_medis,R.id.nav_informasi_publik,
                R.id.nav_instalasi_layanan_eksekutif,R.id.nav_keperawatan,R.id.nav_kinerja,R.id.nav_instalasi_layanan_eksekutif,
                R.id.nav_keperawatan,R.id.nav_kinerja,R.id.nav_layanan_perawatan_unggulan,R.id.nav_litbang,R.id.nav_microsurgery,
                R.id.nav_palliative,R.id.nav_pbcr_dki_jakarta,R.id.nav_pbcr_jakarta_barat,R.id.nav_pbcr_nasional,R.id.nav_pelayanan,
                R.id.nav_pelayanan_unggulan,R.id.nav_pendidikan,R.id.nav_penelitian,R.id.nav_prinsip_dan_metode,R.id.nav_rawat_inap,
                R.id.nav_srikandi,R.id.nav_stem_cell_transplation)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_utama);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.utama, menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_utama);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}