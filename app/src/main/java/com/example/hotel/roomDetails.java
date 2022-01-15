package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    TextView roomTypeTxtV, priceTxtV, roomNumTxtV, featureTxtV;
    Button bookRoomBT;
    int roomImage, roomNum;
    double price;
    String roomType,feature, rooms="";
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
        roomImage=(int)intent.getExtras().get("ImageToItemDetails");
        price=(double)intent.getExtras().get("PriceToItemDetails");
        roomType=intent.getExtras().getString("roomTypeToItemDetails");
        feature=intent.getExtras().getString("featureToItemDetails");
        nis_symbol2=findViewById(R.id.nis_symbol2);

        roomImageV=findViewById(R.id.room_image);
        roomTypeTxtV=findViewById(R.id.roomType);
        priceTxtV=findViewById(R.id.price_value);
        featureTxtV=findViewById(R.id.featureValue);
        roomNumTxtV=findViewById(R.id.roomNum);
        bookRoomBT=findViewById(R.id.bookRoom);


        roomImageV.setImageDrawable(ContextCompat.getDrawable(this,roomImage));
        roomTypeTxtV.setText(roomType);
        roomNumTxtV.setText(roomNum);
        featureTxtV.setText(feature);
        priceTxtV.setText(String.valueOf(price));

        nis_symbol2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.nis_symbol));
        setUpSharedPrefs();

    }
    private void setUpSharedPrefs(){
        sharedPreferences= getSharedPreferences(CARTPREFS,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }


    /*public void addToCartOnClick(View view) {
        itemQuantity=quantity_spinner.getSelectedItem().toString();

        editor.putInt("itemImageToItemAdded2",itemImage);
        editor.putFloat("itemPriceToItemAdded2", (float) itemPrice);
        editor.putString("itemNameToItemAdded2",itemName);
        editor.putString("itemQtyToItemAdded2",itemQuantity);
        Log.d("TAG", "itemQuantity: "+itemQuantity);
        item=new Item(itemName,itemPrice,Integer.parseInt(itemQuantity),itemImage);
        gson = new Gson();
        String previousItem=sharedPreferences.getString(CARTPREFS,"");
        items=previousItem+gson.toJson(item)+"#";
//        Log.d("TAG", "itemmm: "+item.toString());
        Log.d("TAG", "itemmm: "+items);
//        cartObject.itemArrayList.add(item);
//        Log.d("TAG", "addToCartOnClick: "+cartObject.toString());
//
//        String json = gson.toJson(cartObject);
//        Log.d("TAG", "addToCartOnClick: json"+json);
        editor.putString(CARTPREFS, items);
        editor.commit();

        intent=new Intent(this,ItemAdded.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("itemImageToItemAdded",itemImage);
        intent.putExtra("itemNameToItemAdded",itemName);
        intent.putExtra("itemPriceToItemAdded",itemPrice);
        intent.putExtra("itemQtyToItemAdded",itemQuantity);
        this.startActivity(intent);
    }
*/

}