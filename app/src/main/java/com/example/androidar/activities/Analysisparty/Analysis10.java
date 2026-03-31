package com.example.androidar.activities.Analysisparty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidar.R;

public class Analysis10 extends AppCompatActivity {

    private ImageButton leftButton10;
    private ImageButton rightButton10;

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
        setContentView(R.layout.activity_analysis10);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // 이전에 저장된 값을 불러와 변수에 할당 (없을 경우 초기값 0 사용)
        ModernScore = sharedPreferences.getInt("ModernScore", 0);
        SimpleScore = sharedPreferences.getInt("SimpleScore", 0);
        NorthEuropeScore = sharedPreferences.getInt("NorthEuropeScore", 0);
        NaturalScore = sharedPreferences.getInt("NaturalScore", 0);
        ClassicScore = sharedPreferences.getInt("ClassicScore", 0);
        VintageScore = sharedPreferences.getInt("VintageScore", 0);
        FrenchyScore = sharedPreferences.getInt("FrenchyScore", 0);

        leftButton10 = findViewById(R.id.analysisButtonLeft10);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        leftButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(100);

                NorthEuropeScore += 10;
                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("NortheuropeScore", NorthEuropeScore);
                editor.apply();

                navigateToNextActivity();

            }
        });
        rightButton10 = findViewById(R.id.analysisButtonRight10);

        rightButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(100);

                ClassicScore += 1;
                // 데이터 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("ClassicScore", ClassicScore);
                editor.apply();

                navigateToNextActivity();

            }
        });


    }

    // 다음 액티비티로 이동하고 가장 큰 점수를 기준으로 전환하는 메서드
    private void navigateToNextActivity() {
        Intent intent;
        int maxScore = Math.max(ModernScore, NaturalScore);
        maxScore = Math.max(maxScore, NorthEuropeScore);
        maxScore = Math.max(maxScore, ClassicScore);
        maxScore = Math.max(maxScore, VintageScore);
        maxScore = Math.max(maxScore, FrenchyScore);

        if (maxScore == ModernScore) {
            intent = new Intent(Analysis10.this, ResultModern.class);
        } else if (maxScore == NaturalScore) {
            intent = new Intent(Analysis10.this, ResultNatural.class);
        } else if (maxScore == NorthEuropeScore) {
            intent = new Intent(Analysis10.this, ResultNorthEurope.class);
        } else if (maxScore == ClassicScore) {
            intent = new Intent(Analysis10.this, ResultClassic.class);
        } else if (maxScore == VintageScore) {
            intent = new Intent(Analysis10.this, ResultVintage.class);
        } else {
            intent = new Intent(Analysis10.this, ResultFrenchy.class);
        }

        startActivity(intent);
    }
}
