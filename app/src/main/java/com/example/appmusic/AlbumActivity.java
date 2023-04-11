package com.example.appmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.appmusic.model.Album;
import com.example.appmusic.model.AlbumAdapter;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity implements AlbumAdapter.AlbumCallBack {
    RecyclerView rvListC;
    ArrayList<Album> lstAlbum;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        rvListC = findViewById(R.id.rvList);
        LoadData();
        albumAdapter = new AlbumAdapter(lstAlbum, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListC.setAdapter(albumAdapter);
        rvListC.setLayoutManager(linearLayoutManager);
    }
    @Override
    public void onItemClick(String id){
        Intent i = new Intent(this, DetailAlbum.class);
        i.putExtra("albumId", id);
        startActivity(i);
    }


    void LoadData(){
        lstAlbum = new ArrayList<>();
        lstAlbum.add(new Album("1", "Album 1", "pl1.png"));
        lstAlbum.add(new Album("2", "Album 2", "pl2.png"));
        lstAlbum.add(new Album("3", "Album 3", "pl3.png"));
    }
}