package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {
    public void dublin(){
        Intent i = new Intent(MainScreen.this, DetailsScreen.class);
        String summary = "\n" +
                "Dublin, the capital and largest city of Ireland, is a vibrant and cosmopolitan city with a rich history and culture. It is known for its friendly people, its lively pubs, and its stunning architecture.\n" +
                "\n" +
                "The city is located on the east coast of Ireland, at the mouth of the River Liffey. It was founded by the Vikings in the 9th century and quickly became a major trading center. In the 17th and 18th centuries, Dublin was one of the wealthiest cities in Europe, and its Georgian architecture is still evident today.\n" +
                "\n" +
                "Dublin is home to many world-famous landmarks, including Trinity College, Dublin Castle, and the Guinness Storehouse. It is also a major center for arts and culture, and is home to many museums, theaters, and galleries.\n" +
                "\n" +
                "Dublin is a popular tourist destination, and visitors come to experience the city's unique atmosphere and culture. Visitors can explore the city's many historical landmarks, visit its museums and galleries, or simply enjoy the atmosphere of its bustling streets and squares.";
        String trailer = "SjQo4nAQSJ0";
        String url = "https://www.tripadvisor.ie/Attractions-g186605-Activities-Dublin_County_Dublin.html";
        String emergencyNumber = "999";
        String title = "Dublin - The city of wonders!";
        String maps = "geo:53.342933,-6.271676";
        i.putExtra("summary", summary);
        i.putExtra("trailer", trailer);
        i.putExtra("url", url);
        i.putExtra("emergency", emergencyNumber);
        i.putExtra("title", title);
        i.putExtra("location",maps);
        startActivity(i);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.logout){
            Intent i = new Intent(MainScreen.this, LoginScreen.class);
            startActivity(i);
        }

        else if(id == R.id.contact_email){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(Uri.parse("mailto:wanderlust.contact@gmail.com"))});
            startActivity(Intent.createChooser(emailIntent, "Send Email Using:"));    }

        else if(id == R.id.contact_sms){
            Uri uri = Uri.parse("smsto:123456");
            Intent msg = new Intent(Intent.ACTION_SENDTO, uri);
            msg.putExtra("sms_body", "");
            startActivity(Intent.createChooser(msg, "Send sms using: "));
        }

        return true;
    }
    public void amsterdam(){
        Intent i3 = new Intent(MainScreen.this, DetailsScreen.class);
        String summary3 = "\n" +
                "Amsterdam, the capital of the Netherlands, is a vibrant and cosmopolitan city with a rich history and culture. It is known for its canals, its museums, its liberal attitude, and its lively nightlife.\n" +
                "\n" +
                "The city was founded in the 12th century and quickly became a major trading center. In the 17th century, Amsterdam was the center of the Dutch Golden Age, a period of great prosperity and cultural achievement. Today, Amsterdam is a modern and multicultural city with a population of over 800,000 people.\n" +
                "\n" +
                "Amsterdam is a popular tourist destination, attracting millions of visitors each year. Visitors come to see the city's canals, its museums, and its historical landmarks. Some of the most popular tourist attractions include the Anne Frank House, the Van Gogh Museum, and the Rijksmuseum.\n" +
                "\n" +
                "Amsterdam is also known for its vibrant nightlife. The city has a wide range of bars, clubs, and restaurants to choose from. Amsterdam is also a popular destination for shopping, as it is home to a wide range of boutiques and department stores.\n" +
                "\n" +
                "In one paragraph, Amsterdam is a city of canals, culture, and contrasts. It is a city with a rich history and a modern outlook. Amsterdam is a city that has something to offer everyone.";
        String trailer3 = "Oxv6IRcuNaI";
        String url3 = "https://www.tripadvisor.ie/Attractions-g188590-Activities-Amsterdam_North_Holland_Province.html";
        String emergencyNumber3 = "112";
        String title = "Amsterdam - The city of wonders!";
        String maps = "geo:52.372697,4.893112";

        i3.putExtra("summary", summary3);
        i3.putExtra("trailer", trailer3);
        i3.putExtra("url", url3);
        i3.putExtra("emergency", emergencyNumber3);
        i3.putExtra("title", title);
        i3.putExtra("location", maps);
        startActivity(i3);
    }
    public void prague(){
        Intent i2 = new Intent(MainScreen.this, DetailsScreen.class);
        String summary2 = "\n" +
                "Prague, the capital of the Czech Republic, is one of the most beautiful and historic cities in Europe. It is known for its well-preserved medieval architecture, including Prague Castle, the Charles Bridge, and the Old Town Square. Prague is also a major cultural center, home to world-class museums, theaters, and opera houses.\n" +
                "\n" +
                "The city has a rich history, dating back to the 9th century. It has been the capital of Bohemia, the Holy Roman Empire, and Czechoslovakia. Prague has also been a center of learning and culture for centuries, and was home to many famous artists, writers, and composers, including Mozart, Kafka, and Dvořák.\n" +
                "\n" +
                "Today, Prague is a popular tourist destination, known for its stunning architecture, delicious food, and lively nightlife. Visitors can explore the city's many historical landmarks, visit its museums and galleries, or simply enjoy the atmosphere of its bustling streets and squares.\n" +
                "\n" +
                "In one paragraph, Prague is a city of fairytale beauty and endless charm. It is a city where history, culture, and modernity come together to create a truly unique experience.";
        String trailer2 = "lRPNqIpOVzs";
        String url2 = "https://www.tripadvisor.ie/Attractions-g274707-Activities-Prague_Bohemia.html";
        String emergencyNumber2 = "112";
        String title = "Prague - The city of wonders!";
        String maps = "geo:50.086025,14.414386";
        i2.putExtra("summary", summary2);
        i2.putExtra("trailer", trailer2);
        i2.putExtra("url", url2);
        i2.putExtra("emergency", emergencyNumber2);
        i2.putExtra("title", title);
        i2.putExtra("location", maps);
        startActivity(i2);
    }
    public void istanbul(){
        Intent i1 = new Intent(MainScreen.this, DetailsScreen.class);
        String title = "Istanbul - The city of wonders!";
        String summary1 = " Istanbul is a transcontinental metropolis in Eurasia, straddling the Bosphorus Strait between the Sea of Marmara and the Black Sea. It is the most populous city in Turkey and the country's economic, cultural, and historical center. Founded on the site of Byzantium during the Roman Empire and renamed Constantinople, it was the capital of the Eastern Roman (Byzantine) Empire, the Latin Empire, the Ottoman Empire, and the Republic of Turkey. Today, Istanbul is a vibrant and cosmopolitan city with a rich cultural heritage and a modern economy.  The city is home to many world-famous landmarks, including the Hagia Sophia, the Blue Mosque, the Topkapi Palace, and the Grand Bazaar. It is also a major center for education, research, and the arts. Istanbul is a popular tourist destination, known for its stunning architecture, delicious food, and lively nightlife.  In one paragraph, Istanbul is a city of contrasts, where ancient and modern meet, and East and West collide. It is a city of bustling bazaars and tranquil mosques, of towering skyscrapers and narrow cobblestone streets. It is a city of rich history and culture, and of endless possibilities.";
        String trailer1 = "7A1q7v4btbk";
        String url1 = "https://www.tripadvisor.ie/Attractions-g293974-Activities-Istanbul.html";
        String emergencyNumber1 = "155";
        String maps = "geo:41.025633,28.973410";
        i1.putExtra("title",title);
        i1.putExtra("summary", summary1);
        i1.putExtra("trailer", trailer1);
        i1.putExtra("url", url1);
        i1.putExtra("emergency", emergencyNumber1);
        i1.putExtra("location", maps);
        startActivity(i1);
    }
    private TextView usernameField;
    private EditText searchBar;
    private ImageView searchButton;
    private ImageView prague;
    private ImageView istanbul;
    private ImageView dublin;
    private ImageView amsterdam;
    private ImageView profilePicture;
    private SwitchCompat switchCompat;
    private boolean nightMode;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        String username = "NULL";

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Wanderlust");

        try{
            Bundle extras = getIntent().getExtras();
            username = extras.getString("username");
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }

        usernameField = findViewById(R.id.username);
        usernameField.setText(username);

        searchBar = findViewById(R.id.searchBar);
        searchButton = findViewById(R.id.searchButton);
        prague = findViewById(R.id.pragueImage);
        istanbul = findViewById(R.id.istanbulImage);
        dublin = findViewById(R.id.dublinImage);
        amsterdam = findViewById(R.id.amsterdamImage);
        profilePicture = findViewById(R.id.profilePicture);

        switchCompat = findViewById(R.id.switchMode);
        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("nightMode", false);

        if(nightMode){
            switchCompat.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nightMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode", false);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode", true);
                }
                editor.apply();
            }
        });

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Bitmap image = (Bitmap) extras.get("image");
            if (image != null) {
                profilePicture.setImageBitmap(image);
            }
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = searchBar.getText().toString().toLowerCase();
                switch (input){
                    case "istanbul":
                        istanbul();
                        break;
                    case "prague":
                        prague();
                        break;
                    case "amsterdam":
                        amsterdam();
                        break;
                    case "dublin":
                        dublin();
                        break;

                    default:
                        Toast.makeText(MainScreen.this, "Couldn't find!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        prague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prague();
            }
        });
        istanbul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istanbul();
            }
        });
        dublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dublin();
            }
        });
        amsterdam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amsterdam();
            }
        });
    }
}