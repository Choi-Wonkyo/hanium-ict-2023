package com.example.androidar.activities.Analysisparty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidar.R;
import com.example.androidar.activities.ActivityMain;

public class ResultFrenchy extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    private Button emailLoginButton;
    private Button analysisButtonFrenchy;

    private ProgressDialog progressDialog; // 전역 변수로 선언

    private Vibrator vibrator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_frenchy);

        analysisButtonFrenchy = findViewById(R.id.analysis_button_2);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        analysisButtonFrenchy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibrator.vibrate(100);

                Intent intent = new Intent(ResultFrenchy.this, ActivityMain.class);
                startActivity(intent);

            }
        });
    }

}
