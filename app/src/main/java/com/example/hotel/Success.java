package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);


    }
    public void viewRoom(View view){
        Intent intent = new Intent(this, roomsPage.class);
        startActivity(intent);
    }
    public void exit(View v) {
        finish();
        System.exit(0);
    }

    public void forder(View view){
        Intent intent = new Intent(this, order.class);
        startActivity(intent);
    }
}