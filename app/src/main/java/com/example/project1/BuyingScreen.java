package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BuyingScreen extends AppCompatActivity {
    private String topPic;
    private ImageView topPicture;
    private TextView priceView;
    private RadioButton fiveStar;
    private RadioButton fourStar;
    private RadioButton threeStar;
    private RadioButton business;
    private RadioButton economy;
    private CheckBox insurance;
    private CheckBox rental;
    private CheckBox tour;
    private Button button;
    private int price = 0;
    private CalendarView checkinCalendarView;
    private CalendarView checkoutCalendarView;
    private int checkInDay;
    private int prevCheckInDay;
    private int checkOutDay;
    private boolean selectedBefore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying_screen);

        try {
            Bundle extras = getIntent().getExtras();
            topPic = extras.getString("topPic");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        topPicture = findViewById(R.id.topPicture);
        fiveStar = findViewById(R.id.five_star);
        fourStar = findViewById(R.id.four_star);
        threeStar = findViewById(R.id.three_star);
        business = findViewById(R.id.business);
        economy = findViewById(R.id.economy);
        insurance = findViewById(R.id.insurance);
        rental = findViewById(R.id.rental);
        tour = findViewById(R.id.tour);
        priceView = findViewById(R.id.priceView);
        button = findViewById(R.id.button);
        checkinCalendarView = findViewById(R.id.checkinCalendarView);
        checkoutCalendarView = findViewById(R.id.checkoutCalendarView);

        if (topPic.equals("amsterdam_last.png")) {
            topPicture.setImageResource(R.drawable.amsterdam_last);
        } else if (topPic.equals("prague_last.png")) {
            topPicture.setImageResource(R.drawable.prague_last);
        } else if (topPic.equals("istanbul_last.png")) {
            topPicture.setImageResource(R.drawable.istanbul_last);
        } else {
            topPicture.setImageResource(R.drawable.dublin_last);
        }
        fiveStar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 1500;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 1500;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        fourStar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 1000;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 1000;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        threeStar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 500;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 500;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        business.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 300;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 300;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        economy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 150;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 150;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        insurance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 100;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 100;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        rental.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 75;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 75;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        tour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price += 10;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
                else{
                    price -= 10;
                    priceView.setText(Integer.toString(price) + " EUR per night.");
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BuyingScreen.this, PaymentScreen.class);
                startActivity(i);
            }
        });
        checkinCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if(selectedBefore){
                    prevCheckInDay = checkInDay;
                    checkInDay = dayOfMonth;
                }
                else{
                    checkInDay = dayOfMonth;
                    prevCheckInDay = checkInDay;
                }
            }
        });
        checkoutCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if(selectedBefore){
                   price /= checkOutDay-prevCheckInDay;
                }
                checkOutDay = dayOfMonth;
                price *= checkOutDay-checkInDay;
                priceView.setText("Total: " + Integer.toString(price) + " EUR");
                selectedBefore = true;
            }
        });
    }
}
