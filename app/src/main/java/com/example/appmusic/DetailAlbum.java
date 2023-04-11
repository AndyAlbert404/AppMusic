package com.example.appmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailAlbum extends AppCompatActivity {
    TextView tvDetailC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_album);
        tvDetailC = findViewById(R.id.tvDetail);

        String id = getIntent().getStringExtra("albumId");
        tvDetailC.setText(id);
    }
}