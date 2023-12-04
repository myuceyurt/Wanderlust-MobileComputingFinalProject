package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterScreen extends AppCompatActivity {

    private CardView register;
    private EditText email;
    private EditText passwd;
    private EditText username;
    private EditText age;
    FirebaseFirestore db;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        register = findViewById(R.id.cardview_register);
        email = findViewById(R.id.register_email);
        passwd = findViewById(R.id.register_passwd);
        username = findViewById(R.id.register_username);
        age = findViewById(R.id.register_age);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = email.getText().toString();
                String userPasswd = passwd.getText().toString();
                String userName = username.getText().toString();
                String userAge = age.getText().toString();

                if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userPasswd)) {
                    Toast.makeText(RegisterScreen.this, "Please fill all the gaps!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(userEmail, userPasswd)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
//                                    Toast.makeText(RegisterScreen.this, "Registration successful.",
//                                            Toast.LENGTH_SHORT).show();

                                    Map<String,Object> user = new HashMap<>();
                                    user.put("email", userEmail);
                                    user.put("passwd", userPasswd);
                                    user.put("username", userName);
                                    user.put("age", userAge);

                                    db.collection("user").
                                            add(user)
                                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                        @Override
                                                        public void onSuccess(DocumentReference documentReference) {
                                                            Toast.makeText(RegisterScreen.this, "YAS", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(RegisterScreen.this, "Failed", Toast.LENGTH_SHORT).show();
                                                }
                                            });


                                    FirebaseAuth.getInstance().signOut();
                                    Intent i = new Intent(RegisterScreen.this, LoginScreen.class);
                                    startActivity(i);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterScreen.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}
