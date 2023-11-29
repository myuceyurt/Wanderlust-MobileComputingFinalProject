package com.example.project1;

import static java.sql.Types.NULL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;


public class DetailsScreen extends AppCompatActivity {
    private YouTubePlayerView yt;
    private TextView sum;
    private TextView titleCity;
    private String title;
    private String trailer;
    private String summary;
    private String url;
    private String emergency;
    private String map;
    private Button btn;
    private ImageView location;
    private ImageView call;
    private String topPic;
    private ListView todoList;
    private ArrayList<String> todos;

    private int price = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        try{
            Bundle extras = getIntent().getExtras();
            title = extras.getString("title");
            summary = extras.getString("summary");
            trailer = extras.getString("trailer");
            url = extras.getString("url");
            emergency = extras.getString("emergency");
            map = extras.getString("location");
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        sum = findViewById(R.id.citySummary);
        yt = findViewById(R.id.youtube_player_view);
        titleCity = findViewById(R.id.citySlogan);
        location = findViewById(R.id.locationButton);
        call = findViewById(R.id.emergencyCall);
        todoList = findViewById(R.id.todoList);

        sum.setText(summary);
        titleCity.setText(title);
        if(title.equals("Prague - The city of wonders!")){
            todos = new ArrayList<>();
            todos.add("Explore the Old Town Square");
            todos.add("Visit the Charles Bridge");
            todos.add("Climb Prague Castle");
            todos.add("Take a walk through Wenceslas Square");
            todos.add("Try some traditional Czech food");
        } else if (title.equals("Istanbul - The city of wonders!")) {
            todos = new ArrayList<>();
            todos.add("Visit the Hagia Sophia");
            todos.add("Explore the Grand Bazaar");
            todos.add("Take a cruise on the Bosphorus River");
            todos.add("Visit the Blue Mosque");
            todos.add("See a performance at the Topkapi Palace");
        } else if (title.equals("Amsterdam - The city of wonders!")) {
            todos = new ArrayList<>();
            todos.add("Anne Frank House");
            todos.add("Van Gogh Museum");
            todos.add("Rijksmuseum");
            todos.add("Canal Cruise");
            todos.add("Vondelpark");
        }
        else{
            todos = new ArrayList<>();
            todos.add("Explore Dublin Castle");
            todos.add("Visit the Guinness Storehouse");
            todos.add("Wander through St. Stephen's Green");
            todos.add("Discover the Temple Bar district");
            todos.add("Pay your respects at Trinity College");
        }


        ArrayAdapter<String> todoAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                todos
        );

        todoList.setAdapter(todoAdapter);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = trailer;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        btn = findViewById(R.id.continueButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailsScreen.this, BuyingScreen.class);
                if(title.equals("Prague - The city of wonders!")){
                    topPic = "prague_last.png";


                } else if (title.equals("Istanbul - The city of wonders!")) {
                    topPic = "istanbul_last.png";
                } else if (title.equals("Amsterdam - The city of wonders!")) {
                    topPic = "amsterdam_last.png";
                }
                else{
                    topPic = "dublin_last.png";
                }
                i.putExtra("topPic",topPic);
                startActivity(i);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(map));
                startActivity(i);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + emergency));
                startActivity(i);
            }
        });



    }
}