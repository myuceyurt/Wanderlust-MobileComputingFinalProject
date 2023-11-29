package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class LoginScreen extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button signIn;
    private Button register;
    private SharedPreferences sp_dp;
    private Bitmap imageBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            imageBitmap = (Bitmap) extras.get("image");
        }

        name = findViewById(R.id.et_name);
        password = findViewById(R.id.et_password);
        signIn = findViewById(R.id.btn_sign_in);
        register = findViewById(R.id.btn_register);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String passwd = password.getText().toString();
                sp_dp = getApplicationContext().getSharedPreferences("register_store.txt", MODE_PRIVATE);
                sp_dp = getApplicationContext().getSharedPreferences("register_store.txt", MODE_PRIVATE);
                String registeredName = sp_dp.getString("username_saved",null);
                String registeredPassword = sp_dp.getString("password_saved",null);

                if(registeredName.equals(username) && passwd.equals(registeredPassword)){
                    MediaPlayer mp = MediaPlayer.create(LoginScreen.this, R.raw.login_sound);
                    mp.setVolume(5.0f,5.0f);
                    mp.start();
                    Intent i = new Intent(LoginScreen.this, MainScreen.class);
                    i.putExtra("username",username);
                    i.putExtra("image", imageBitmap);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginScreen.this, "No account found!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginScreen.this, RegisterScreen.class);
                i.putExtra("image", imageBitmap);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}