package com.example.androidar.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidar.R;
import com.example.androidar.adapters.DetailAdapter;
import com.example.androidar.fragments.FragmentFurniture;
import com.example.androidar.models.Furniture;
import java.util.ArrayList;

public class FurnitureDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.furniture_details);

        // 인텐트에서 선택한 가구 정보 가져오기
        Intent intent = getIntent();
        if (intent != null) {

            Furniture furniture = (Furniture) intent.getSerializableExtra("selected_furniture");
            if (furniture != null) {
                // RecyclerView 설정
                RecyclerView recyclerView = findViewById(R.id.recyclerViewDetail);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

                // 가구 정보를 ArrayList에 추가 (여기에서는 하나의 가구 정보만 사용)
                ArrayList<Furniture> furnitureList = new ArrayList<>();
                furnitureList.add(furniture);

                // DetailAdapter를 사용하여 RecyclerView에 데이터 설정
                DetailAdapter detailAdapter = new DetailAdapter(furnitureList);
                recyclerView.setAdapter(detailAdapter);

                // back_tomenu 버튼 처리
                Button backToMenuButton = findViewById(R.id.back_tomenu);
                backToMenuButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        // FragmentFurniture 화면으로 전환
                        FragmentFurniture fragmentFurniture = new FragmentFurniture();
                        getSupportFragmentManager().beginTransaction()
                                .replace(android.R.id.content, fragmentFurniture)
                                .addToBackStack(null)
                                .commit();
                    }
                });
            }


        }
    }
}
