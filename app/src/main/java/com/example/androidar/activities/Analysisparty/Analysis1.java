package com.example.androidar.activities.Analysisparty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidar.R;

public class Analysis1 extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    private Button emailLoginButton;
    private ImageButton leftButton1;
    private ImageButton rightButton1;

    // 점수 변수
    private int ModernScore = 0;
    private int SimpleScore = 0;
    private int NorthEuropeScore = 0;
    private int NaturalScore = 0;
    private int ClassicScore = 0;
    private int VintageScore = 0;
    private  int FrenchyScore = 0;

    private ProgressDialog progressDialog; // 전역 변수로 선언

    private Vibrator vibrator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis1);


        // SharedPreferences 초기화
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 이전에 저장된 값을 불러와 변수에 할당 (없을 경우 초기값 0 사용)
        ModernScore = 0;
        SimpleScore = 0;
        NorthEuropeScore = 0;
        NaturalScore = 0;
        ClassicScore = 0;
        VintageScore = 0;
        FrenchyScore = 0;

        // SharedPreferences를 사용하여 초기화된 값을 저장
        editor.putInt("ModernScore", ModernScore);
        editor.putInt("SimpleScore", SimpleScore);
        editor.putInt("NorthEuropeScore", NorthEuropeScore);
        editor.putInt("NaturalScore", NaturalScore);
        editor.putInt("ClassicScore", ClassicScore);
        editor.putInt("VintageScore", VintageScore);
        editor.putInt("FrenchyScore", FrenchyScore);
        editor.apply();

        leftButton1 = findViewById(R.id.analysisButtonLeft1);
        rightButton1 = findViewById(R.id.analysisButtonRight1);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        leftButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);

                // 왼쪽 버튼 클릭 시 모던에 2점 추가
                ModernScore += 2;

                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("ModernScore", ModernScore);
                editor.apply();


                // 다음 액티비티로 이동
                Intent intent = new Intent(Analysis1.this, Analysis2.class);
                intent.putExtra("ModernScore", ModernScore);
                intent.putExtra("SimpleScore", SimpleScore);
                intent.putExtra("NorthEuropeScore", NorthEuropeScore);
                intent.putExtra("NaturalScore", NaturalScore);
                intent.putExtra("ClassicScore", ClassicScore);
                intent.putExtra("VintageScore", VintageScore);
                intent.putExtra("FrenchyScore", FrenchyScore);

                startActivity(intent);
            }
        });

        rightButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);

                // 오른쪽 버튼 클릭 시 심플 1점 추가
                SimpleScore += 1;
                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("SimpleScore", SimpleScore);
                editor.apply();

                // 다음 액티비티로 이동
                Intent intent = new Intent(Analysis1.this, Analysis2.class);

                intent.putExtra("ModernScore", ModernScore);
                intent.putExtra("SimpleScore", SimpleScore);
                intent.putExtra("NorthEuropeScore", NorthEuropeScore);
                intent.putExtra("NaturalScore", NaturalScore);
                intent.putExtra("ClassicScore", ClassicScore);
                intent.putExtra("VintageScore", VintageScore);
                intent.putExtra("FrenchyScore", FrenchyScore);

                startActivity(intent);
            }
        });
    }
}

