package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sameRoomType extends AppCompatActivity {
    RecyclerView recyclerView;
    roomAdapter adapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.same_room_type);


        recyclerView = findViewById(R.id.sameRoom);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
       /* String[] roomType =new String[room.rooms.length];
        String[] feature =new String[room.rooms.length];
        String[] floor =new String[room.rooms.length];
        double[] price=new double[room.rooms.length];
        int[] imagedId =new int[room.rooms.length];
        int[] roomNum =new int[room.rooms.length];
        for (int i=0;i<roomType.length;i++){*/

           // roomType[i]=room.rooms[i].getRoomType();
            //price[i]=room.rooms[i].getPrice();
            //imagedId[i]=room.rooms[i].getImageID();
            //roomNum[i]=room.rooms[i].getRoomNum();
            String[] roomType =new String[room.rooms.length];
            String[] feature = new String[10];
            String[] floor = new String[10];
            double[] price= new double[10];
            int[] imagedId = new int[10];
            int[] roomNum = new int[10];
            intent=getIntent();

        for (int i=0;i<roomType.length;i++){
            imagedId[i] = (int) intent.getExtras().get("roomImagesIDsToItemDetails");
            price[i]= (double) intent.getExtras().get("roomPricesToItemDetails");
            roomType[i]=intent.getExtras().getString("roomTypesToItemDetails");
            roomNum[i]= (int) intent.getExtras().get("roomsNumberToItemDetails");
            feature[i]=  intent.getExtras().getString("featureToRoomDetails");
            floor[i]=  intent.getExtras().getString("floorToRoomDetails");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new roomAdapter(getApplicationContext() ,roomType, price, imagedId, roomNum, feature,floor);
        recyclerView.setAdapter(adapter);
    }


}