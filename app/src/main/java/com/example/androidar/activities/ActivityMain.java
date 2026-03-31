package com.example.androidar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.androidar.activities.Analysisparty.Analysis1;
import com.example.androidar.adapters.PhotoAdapter;
import com.example.androidar.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity {

    private ViewPager2 viewPager;
    private PhotoAdapter adapter; // PhotoAdapter는 실제 구현 필요
    private Handler handler = new Handler();
    private Runnable update;

    private int currentPage = 0;
    private static final int NUM_PAGES = 3; // 총 페이지 개수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        List<Integer> photoList = new ArrayList<>();
        photoList.add(R.drawable.main1); // res/drawable 디렉터리에 있는 사진 리소스 ID 추가
        photoList.add(R.drawable.main1);
        photoList.add(R.drawable.main1);
//        photoList.add(R.drawable.handsome2);
//        photoList.add(R.drawable.handsome3);
        adapter = new PhotoAdapter(photoList); // PhotoAdapter는 실제 구현 필요
        viewPager.setAdapter(adapter);

        update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == NUM_PAGES - 1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);

                handler.postDelayed(update, 4000);
            }

        };

        // 3초마다 페이지 전환 실행
        handler.postDelayed(update, 4000);


        // AR 버튼을 눌렀을 때 Activity_AR로 전환하는 코드
        Button ArButton = findViewById(R.id.buttonAR);
        ArButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, AR.class);
                intent.putExtra("modelResourceId", R.raw.sofa );
                startActivity(intent);
            }
        });

        // 성향분석 버튼을 눌렀을 때 Activity_Analysis로 전환하는 코드
        Button AnalyzeButton = findViewById(R.id.buttonAnalysis);
        AnalyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, Analysis1.class);
                startActivity(intent);
            }
        });

        // 가구리스트 버튼을 눌렀을 때 Activity_Furniture로 전환하는 코드
        Button FurnitureListButton = findViewById(R.id.buttonList);
        FurnitureListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, FurnitureMain.class);
                startActivity(intent);
            }
        });

        // 커뮤니티 버튼을 눌렀을 때 Activity_Community로 전환하는 코드
        Button CommunityButton = findViewById(R.id.buttonCommunity);
        CommunityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, Community.class);
                startActivity(intent);
            }
        });

        // 공지사항 버튼을 눌렀을 때 Activity_Announcement로 전환하는 코드
        Button AnnouncementButton = findViewById(R.id.buttonAnnouncement);
        AnnouncementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, Announcement.class);
                startActivity(intent);
            }
        });

        // 문의하기 버튼을 눌렀을 때 Activity_Contact로 전환하는 코드
        Button ContactButton = findViewById(R.id.buttonContact);
        ContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, Contact.class);
                startActivity(intent);
            }
        });

        // AI 추천 버튼을 눌렀을 때 AI로 전환하는 코드
        Button RecommendationButton = findViewById(R.id.buttonRecommendation);
        RecommendationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, AI.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(update);
    }

}

