package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class roomsPage extends AppCompatActivity {
    RecyclerView recyclerView;
    roomHomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rooms_page);


        recyclerView = findViewById(R.id.rooms);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        String[] roomType =new String[room.rooms.length];
        double[] price=new double[room.rooms.length];
        int[] imagedId =new int[room.rooms.length];
        int[] roomNum =new int[room.rooms.length];
        for (int i=0;i<roomType.length;i++){
            roomType[i]=room.rooms[i].getRoomType();
            price[i]=room.rooms[i].getPrice();
            imagedId[i]=room.rooms[i].getImageID();
            roomNum[i]=room.rooms[i].getRoomNum();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new roomHomeAdapter(getApplicationContext(),roomType,price,imagedId, roomNum);
        recyclerView.setAdapter(adapter);
    }


}