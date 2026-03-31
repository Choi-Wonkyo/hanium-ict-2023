package com.example.androidar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;
import com.example.androidar.R;
import com.example.androidar.fragments.FragmentFurniture;
import com.example.androidar.fragments.FragmentStore;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FurnitureMain extends AppCompatActivity {

    private Button buttonFurniture;
    private Button buttonStore;

    private FragmentFurniture fragmentA;
    private FragmentStore fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);

        fragmentA = new FragmentFurniture();
        fragmentB = new FragmentStore();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 아래 주석 추가
        if (savedInstanceState == null) {
            // 초기 액티비티 실행 시에만 프래그먼트 A를 추가
            fragmentTransaction.add(R.id.fragmentFrame, fragmentA);
            fragmentTransaction.commit();
        }

        buttonFurniture = findViewById(R.id.buttonFurniture);
        buttonStore = findViewById(R.id.buttonStore);

        buttonFurniture.setOnClickListener(v -> {
            FragmentTransaction ft1 = fragmentManager.beginTransaction();
            ft1.replace(R.id.fragmentFrame, fragmentA);
            ft1.commit();
        });

        buttonStore.setOnClickListener(v -> {
            FragmentTransaction ft2 = fragmentManager.beginTransaction();
            ft2.replace(R.id.fragmentFrame, fragmentB);
            ft2.commit();
        });

        // 아이템 데이터 생성
        // TODO: itemData에 선택한 선택 요소에 따른 아이템 데이터 추가

    }


}
