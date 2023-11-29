package com.example.project1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class RegisterScreen extends AppCompatActivity {

    private CardView register;
    private Bitmap imageBitmap;
    private EditText username;
    private EditText passwd;
    private SharedPreferences sp_dp;
    private Button btnCapture;
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    private ImageView profile_photo;
    private ActivityResultLauncher<Intent> cameraLauncher;

    public RegisterScreen() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        register = findViewById(R.id.cardview_register);
        username = findViewById(R.id.register_username);
        passwd = findViewById(R.id.register_passwd);
        btnCapture = findViewById(R.id.snapButton);
        profile_photo = findViewById(R.id.profile_picture);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                } catch (ActivityNotFoundException e) {
                    // display error state to the user
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp_dp = getApplicationContext().getSharedPreferences("register_store.txt", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp_dp.edit();
                String usr = username.getText().toString();
                String paswd = passwd.getText().toString();
                editor.putString("username_saved", usr);
                editor.putString("password_saved", paswd);
                editor.commit();

                Toast.makeText(RegisterScreen.this, "Registeration Successful!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(RegisterScreen.this, LoginScreen.class);
                i.putExtra("image",imageBitmap);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            profile_photo.setImageBitmap(imageBitmap);
        }
    }
}