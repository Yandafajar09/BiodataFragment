package com.example.biodatafragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomHomeNav = findViewById(R.id.bottomNavigationView);
        bottomHomeNav.setOnItemSelectedListener(botNavListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                    new TanggalLahirFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_home);

        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }

    }

    private NavigationBarView.OnItemSelectedListener botNavListener =
            item -> {
                Fragment selectedFragment = null;
                int title = R.string.title_tanggallahir;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new TanggalLahirFragment();
                        title = R.string.title_tanggallahir;
                        break;
                    case R.id.nav_help:
                        selectedFragment = new AlamatFragment();
                        title = R.string.title_alamat;
                        break;
                    case R.id.nav_info:
                        selectedFragment = new RiwayatPendidikanFragment();
                        title = R.string.title_Riwayat_pendidikan;
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        selectedFragment).commit();

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }

                return true;
            };
}

