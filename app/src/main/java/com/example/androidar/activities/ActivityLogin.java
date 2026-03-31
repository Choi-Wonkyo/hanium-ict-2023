package com.example.androidar.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidar.R;
import com.example.androidar.models.Login;
import com.example.androidar.network.ApiClient;
import com.example.androidar.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button emailLoginButton;
    private Button googleSignInButton;
    private Button kakaoLoginButton;

    private ProgressDialog progressDialog; // 전역 변수로 선언

    ApiInterface api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        setTheme(R.style.AppTheme); // AppTheme는 사용하는 테마에 따라 변경하세요.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        emailLoginButton = findViewById(R.id.email_login_button);
        googleSignInButton = findViewById(R.id.google_sign_in_button);

        emailLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 이메일 로그인 버튼 클릭 시 처리
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                api = ApiClient.getClient().create(ApiInterface.class);

                if (isValidEmail(email) && isValidPassword(password)) {
                    // 여기에서 로그인 로직을 구현하고 성공/실패에 따라 처리합니다.
                    // 로그인 성공 시 다음 화면으로 이동 등을 수행합니다.

                    ApiInterface.LoginRequestBody requestBody = new ApiInterface.LoginRequestBody(email, password);

                    Call<Login> call = api.login(requestBody);

                    call.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            if (response.isSuccessful()) {
                                Log.d("API", String.valueOf(response.body()));

                                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                                startActivity(intent);

                            } else {
                                Log.d("API", "API 호출 성공: ");
                            }
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Log.e("API", "API 호출 실패: " + t.getMessage());
                        }

                    });

                }
            }
        });

        //Button signInButton = findViewById(R.id.btn_sign_in);
        //signInButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Intent intent = new Intent(ActivityLogin.this, ActivitySignIn.class);
        //        startActivity(intent);
        //    }

        //});
    }

    // 이메일 유효성 검사
    private boolean isValidEmail(String email) {
        // 여기에서 이메일 유효성 검사를 수행합니다. 필요에 따라 구현합니다.
        return email.contains("@");
    }

    // 비밀번호 유효성 검사
    private boolean isValidPassword(String password) {
        // 여기에서 비밀번호 유효성 검사를 수행합니다. 필요에 따라 구현합니다.
        return password.length() >= 1;
    }
    private void hideLoadingIndicator() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}

