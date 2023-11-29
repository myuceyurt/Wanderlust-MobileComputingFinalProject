package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class PaymentScreen extends AppCompatActivity {
    private TextInputLayout cardholderName;
    private TextInputLayout cardNumber;
    private TextInputLayout cvv;
    private TextInputLayout expDate;
    private Button proceedButton;
    private ImageView forward;
    private ImageView back;
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);
        cardholderName = findViewById(R.id.cardholderName);
        cardNumber = findViewById(R.id.cardNum);
        cvv = findViewById(R.id.cvv);
        expDate = findViewById(R.id.expDate);
        proceedButton = findViewById(R.id.checkout);
        forward = findViewById(R.id.methodForward);
        back = findViewById(R.id.methodBack);
        viewFlipper = findViewById(R.id.view_flipper);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = cardholderName.getEditText().getText().toString();
                String num = cardNumber.getEditText().getText().toString();
                String cvvNum = cvv.getEditText().getText().toString();
                String date = expDate.getEditText().getText().toString();
                if(!name.equals("") && num.length() == 16 && cvvNum.length() == 3 && !date.equals("")){
                    Intent i = new Intent(PaymentScreen.this, ProceedActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(PaymentScreen.this, "Credentials invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(PaymentScreen.this, R.anim.slide_out_right);
                viewFlipper.setInAnimation(PaymentScreen.this, R.anim.slide_in_left);
                viewFlipper.showNext();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(PaymentScreen.this, R.anim.slide_out_left);
                viewFlipper.setInAnimation(PaymentScreen.this, R.anim.slide_in_right);
                viewFlipper.showPrevious();
            }
        });
    }
}