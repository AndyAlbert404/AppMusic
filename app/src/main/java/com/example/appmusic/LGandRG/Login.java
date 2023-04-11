package com.example.appmusic.LGandRG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appmusic.AlbumActivity;
import com.example.appmusic.R;
import com.example.appmusic.model.User;
import com.google.gson.Gson;

import java.io.Serializable;

public class Login extends AppCompatActivity {
    private Button btLoginC, btRegisterC;
    private EditText edUsernameC, edPasswordC;
    SharedPreferences.Editor editor;
    private final Gson gson = new Gson();
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        anhxa();
        taosukien();
    }
    private void anhxa()
    {
        btLoginC = findViewById(R.id.btLogin);
        btRegisterC = findViewById(R.id.btRegister);
        edUsernameC = findViewById(R.id.edUsernameL);
        edPasswordC = findViewById(R.id.edPasswordL);
    }
    private void taosukien()
    {
        btLoginC.setOnClickListener(v -> checkUserLogin());
        btRegisterC.setOnClickListener(funRegister());
    }
    private void checkUserLogin() {
        String userPref = sharedPreferences.getString(Utils.KEY_USER, null);
        User user = gson.fromJson(userPref, User.class);
        if (user == null){
            return;
        }
        boolean isValid = edUsernameC.getText().toString().trim().equals(user.getUsername()) && edPasswordC.getText().toString().trim().equals(user.getPassword());
        if (isValid){
            Intent intent = new Intent(this, AlbumActivity.class);
            //
            Bundle bundle = new Bundle();
            //
            bundle.putSerializable(Utils.KEY_USER_PROFILE, (Serializable) user);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };
    @NonNull
    private View.OnClickListener funRegister(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        };
    }
}