package com.example.a5resto;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;


//NIM   ; 10120052
//NAMA  ; Eddy Rochman
//KELAS ; IF-2

public class ViewPager extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<viewpagerItem> viewpagerItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        viewPager2 = findViewById(R.id.viewpager);
        int[] images = {R.drawable.i1,R.drawable.i2,R.drawable.i3};
        String[] heading = {"5Resto","Menampilkan Restoran Terdekat","Selamat Datang"};
        String[] desc = {getString(R.string.i1_desc),
                getString(R.string.i2_desc),
                getString(R.string.i3_desc)};

        viewpagerItemArrayList = new ArrayList<>();

        for (int i =0; i< images.length ; i++){

            viewpagerItem viewpagerItem = new viewpagerItem(images[i],heading[i],desc[i]);
            viewpagerItemArrayList.add(viewpagerItem);

        }

        VPAdapter vPadapter = new VPAdapter(ViewPager.this, viewpagerItemArrayList);

        viewPager2.setAdapter(vPadapter);

        viewPager2.setClipToPadding(false);

        viewPager2.setClipChildren(false);

        viewPager2.setOffscreenPageLimit(2);

        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

    }
}