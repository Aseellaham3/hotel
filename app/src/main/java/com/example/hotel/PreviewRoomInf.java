package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PreviewRoomInf extends AppCompatActivity {
    String Cardname, Cardnum,phone, Address,Gender;
    String Checkin,Checkout,roomnum,roomtype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_room_inf);
        TextView textview=findViewById(R.id.textview1);



        Intent intent=getIntent();
        Cardname=intent.getStringExtra( "Cardname");
        Cardnum=intent.getStringExtra( "Cardnum");
        phone=intent.getStringExtra( "phone");
        Address=intent.getStringExtra( "Address");
        Gender=intent.getStringExtra( "Gender");
        Checkin=intent.getStringExtra( "Checkin");
        Checkout=intent.getStringExtra( "editCheckout");
        roomnum=intent.getStringExtra( "roomnum");
        roomtype=intent.getStringExtra( "roomtype");

        textview.setText(
                        "Cardname : "+Cardname+
                        "\nCardnumber : "+Cardnum+
                        "\nPhoneNo : "+phone+
                        "\nAddress : "+Address+
                        "\nGender : "+Gender+
                        "\nCheckin : "+Checkin+
                        "\nCheckout : "+Checkout+
                        "\nRoom of number : "+roomnum+
                        "\nRoom type : "+roomtype
        );





    }
}