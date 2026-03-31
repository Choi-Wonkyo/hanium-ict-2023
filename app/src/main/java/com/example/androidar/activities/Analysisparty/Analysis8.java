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

public class Analysis8 extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    private Button emailLoginButton;
    private ImageButton leftButton8;
    private ImageButton rightButton8;

    private int ModernScore;
    private int SimpleScore;
    private int NorthEuropeScore;
    private int NaturalScore;
    private int ClassicScore;
    private int VintageScore;

    private  int FrenchyScore;


    private ProgressDialog progressDialog; // 전역 변수로 선언

    private Vibrator vibrator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis8);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // 이전에 저장된 값을 불러와 변수에 할당 (없을 경우 초기값 0 사용)
        ModernScore = sharedPreferences.getInt("ModernScore", 0);
        SimpleScore = sharedPreferences.getInt("SimpleScore", 0);
        NorthEuropeScore = sharedPreferences.getInt("NorthEuropeScore", 0);
        NaturalScore = sharedPreferences.getInt("NaturalScore", 0);
        ClassicScore = sharedPreferences.getInt("ClassicScore", 0);
        VintageScore = sharedPreferences.getInt("VintageScore", 0);
        FrenchyScore = sharedPreferences.getInt("FrenchyScore", 0);

        leftButton8 = findViewById(R.id.analysisButtonLeft8);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        leftButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(100);

                SimpleScore += 1;
                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("SimpleScore", SimpleScore);
                editor.apply();

                Intent intent = new Intent(Analysis8.this, Analysis9.class);

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
        rightButton8 = findViewById(R.id.analysisButtonRight8);

        rightButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(100);

                FrenchyScore += 3;
                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("FrenchyScore", FrenchyScore);
                editor.apply();

                Intent intent = new Intent(Analysis8.this, Analysis9.class);

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