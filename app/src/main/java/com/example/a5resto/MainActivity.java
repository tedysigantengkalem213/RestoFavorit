package com.example.a5resto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.a5resto.databinding.ActivityMainBinding;

//NIM   ; 10120052
//NAMA  ; Eddy Rochman
//KELAS ; IF-2

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new InfomasiFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {


            switch (item.getItemId()){

                case R.id.informasi:
                    replaceFragment(new InfomasiFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.maps:
                    replaceFragment(new MapsFragment());
                    break;

            }

            return true;

        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}