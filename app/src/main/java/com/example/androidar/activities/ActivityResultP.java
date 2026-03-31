package com.example.androidar.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.androidar.R;
import com.example.androidar.activities.Analysisparty.Analysis1;

import java.io.File;

public class ActivityResultP extends AppCompatActivity {

    private ImageView resultImageView;
    private TextView resultText1;
    private TextView resultText2;
    private TextView resultText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultp);

        resultImageView = findViewById(R.id.resultImageView);
        resultText1 = findViewById(R.id.resultText1);
        resultText2 = findViewById(R.id.resultText2);
        resultText3 = findViewById(R.id.resultText3);

        // Intent에서 이미지 경로 받아오기
        String imagePath = getIntent().getStringExtra("image_uri");
        // 분석 결과에 따라 사진 및 텍스트 설정
        String analysisResult = getIntent().getStringExtra("analysis_category");
        String analysisScore = getIntent().getStringExtra("analysis_score");
        String analysisStyle = getIntent().getStringExtra("analysis_style");

        resultText2.setText("score: " + analysisScore);
        resultText3.setText("style: " + analysisStyle);

        // 이미지 경로가 있다면 해당 이미지를 ImageView에 표시
        if (imagePath != null) {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                resultImageView.setImageBitmap(bitmap);
                resultImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        }



        if (analysisResult != null && analysisResult.equals("Living_room")) {
//            resultImageView.setImageResource(R.drawable.handsome1); // 거실 사진으로 변경
            resultText1.setText("분석 결과: 거실");

        } else if (analysisResult != null &&analysisResult.equals("Bathroom")) {
//            resultImageView.setImageResource(R.drawable.handsome2); // 화장실 사진으로 변경
            resultText1.setText("분석 결과: 화장실");

        } else if (analysisResult != null && analysisResult.equals("Inner_room")) {
//            resultImageView.setImageResource(R.drawable.handsome1); // 안방 사진으로 변경
            resultText1.setText("분석 결과: 안방");

        } else if (analysisResult != null && analysisResult.equals("Veranda")) {
//            resultImageView.setImageResource(R.drawable.handsome1); // 베란다 사진으로 변경
            resultText1.setText("분석 결과: 베란다");

        } else if (analysisResult != null && analysisResult.equals("Kitchen")) {
//            resultImageView.setImageResource(R.drawable.handsome1); // 주방 사진으로 변경
            resultText1.setText("분석 결과: 주방");

        } else if (analysisResult != null && analysisResult.equals("Library")) {
//            resultImageView.setImageResource(R.drawable.handsome3); //서재 사진으로 변경
            resultText1.setText("분석 결과: 서재");
        } else {
            resultText1.setText("분석 결과: NONE");
        }
        // 다른 장소에 대한 분석 결과에 대한 처리도 추가하세요.


        Button HomeButton = findViewById(R.id.back_tohome);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityResultP.this, ActivityMain.class);
                startActivity(intent);
            }
        });

        Button AgainButton = findViewById(R.id.again);
        AgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityResultP.this, AI.class);
                startActivity(intent);
            }
        });
    }


}
