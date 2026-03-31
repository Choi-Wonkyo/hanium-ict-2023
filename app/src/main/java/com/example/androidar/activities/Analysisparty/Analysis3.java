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

public class Analysis3 extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    private Button emailLoginButton;
    private ImageButton leftButton3;
    private ImageButton rightButton3;

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
        setContentView(R.layout.activity_analysis3);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // 이전에 저장된 값을 불러와 변수에 할당 (없을 경우 초기값 0 사용)
        Intent intent = getIntent();
        ModernScore = sharedPreferences.getInt("ModernScore", 0);
        SimpleScore = sharedPreferences.getInt("SimpleScore", 0);
        NorthEuropeScore = sharedPreferences.getInt("NorthEuropeScore", 0);
        NaturalScore = sharedPreferences.getInt("NaturalScore", 0);
        ClassicScore = sharedPreferences.getInt("ClassicScore", 0);
        VintageScore = sharedPreferences.getInt("VintageScore", 0);
        FrenchyScore = sharedPreferences.getInt("FrenchyScore", 0);

        leftButton3 = findViewById(R.id.analysisButtonLeft3);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        leftButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(100);

                SimpleScore += 1;
                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("ModernScore", ModernScore);
                editor.apply();

                Intent intent = new Intent(Analysis3.this, Analysis4.class);

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
        rightButton3 = findViewById(R.id.analysisButtonRight3);

        rightButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(100);

                NorthEuropeScore += 3;
                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("NorthEuropeScore", NorthEuropeScore);
                editor.apply();

                Intent intent = new Intent(Analysis3.this, Analysis4.class);

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
