package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class roomDetails extends AppCompatActivity {
    Intent intent;
    ImageView roomImageV, nis_symbol2;
    TextView roomTypeTxtV, priceTxtV, roomNumTxtV, featureTxtV ,floorTxtV;
    Button bookRoomBT;
    int roomImage, roomNum;
    double price;
    String roomType,feature, floor, rooms="";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    Gson gson;
    public static final String CARTPREFS = "cartPrefs" ;
    room room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_details_layout);

        intent=getIntent();

        roomImage=(int)intent.getExtras().get("roomImagesIDsToItemDetails");
        price=(double)intent.getExtras().get("roomPricesToItemDetails");
        roomType=intent.getExtras().getString("roomTypesToItemDetails");
        roomNum=(int)intent.getExtras().get("roomsNumberToItemDetails");
       // feature=intent.getExtras().getString("featureToRoomDetails");
      //  floor=intent.getExtras().getString("floorToRoomDetails");

        nis_symbol2=findViewById(R.id.nis_symbol2);

        roomImageV=findViewById(R.id.room_image);
        roomTypeTxtV=findViewById(R.id.room_Type);
        priceTxtV=findViewById(R.id.price_preview);
        featureTxtV=findViewById(R.id.featureValue);
        roomNumTxtV=findViewById(R.id.room_num_value);
        bookRoomBT=findViewById(R.id.bookRoom);
        floorTxtV=findViewById(R.id.floor_value);



        roomImageV.setImageDrawable(ContextCompat.getDrawable(this,roomImage));
        roomTypeTxtV.setText(roomType);
        roomNumTxtV.setText(String.valueOf(roomNum));
        featureTxtV.setText(feature);
        floorTxtV.setText(String.valueOf(floor));
        priceTxtV.setText(String.valueOf(price));

        nis_symbol2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.nis_symbol));
        setUpSharedPrefs();

    }

    private void setUpSharedPrefs(){
        sharedPreferences= getSharedPreferences(CARTPREFS,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void bookOnClick(View view) {
        Intent n= new Intent( this,customerinfo.class);
        startActivity(n);
    }


  /*  public void bookOnClick(View view) {

        editor.putInt("roomImageToRoomBooked",roomImage);
        editor.putFloat("PriceToRoomBooked", (float) price);
        editor.putString("roomTypeToRoomBooked",roomType);
        editor.putString("featureToRoomBooked",feature);
        editor.putInt("roomNumToRoomBooked",roomNum);
        editor.putString("floorToRoomBooked",floor);
        gson = new Gson();
        room=new room(roomType,price, feature,roomNum,roomImage,floor);

        String previousItem=sharedPreferences.getString(CARTPREFS,"");
        rooms =previousItem+gson.toJson(rooms)+"#";
//        Log.d("TAG", "itemmm: "+item.toString());
        Log.d("TAG", "itemmm: "+rooms);
//        cartObject.itemArrayList.add(item);
//        Log.d("TAG", "addToCartOnClick: "+cartObject.toString());
//
//        String json = gson.toJson(cartObject);
//        Log.d("TAG", "addToCartOnClick: json"+json);
        editor.putString(CARTPREFS, rooms);
        editor.commit();

       // intent=new Intent(this,ItemAdded.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("itemImageToItemAdded",roomImage);
        intent.putExtra("itemNameToItemAdded",roomType);
        intent.putExtra("itemPriceToItemAdded",price);
        this.startActivity(intent);
    }

*/
}