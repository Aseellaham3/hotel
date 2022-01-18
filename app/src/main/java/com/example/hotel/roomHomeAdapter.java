package com.example.hotel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import java.util.Arrays;


public class roomHomeAdapter extends RecyclerView.Adapter<roomHomeAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    private String[] roomTypes,feature , floor;
    private double[] roomPrices;
    private int[] roomImagesIDs , roomsNumber;



    public roomHomeAdapter( Context context, String[] roomTypes, double[] roomPrices,int[] roomImagesIDs, int[] roomsNumber) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.roomTypes = roomTypes;
        this.roomsNumber = roomsNumber;
        this.roomPrices = roomPrices;
        this.roomImagesIDs = roomImagesIDs;
    }
    public roomHomeAdapter( Context context, String[] roomTypes, double[] roomPrices,int[] roomImagesIDs,
                            int[] roomsNumber, String[] feature, String[] floor) {

        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.roomTypes = roomTypes;
        this.roomsNumber = roomsNumber;
        this.roomPrices = roomPrices;
        this.roomImagesIDs = roomImagesIDs;
        this.feature = feature;
        this.floor = floor;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.rooms,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.roomType.setText(roomTypes[position]);
        holder.roomPrice.setText(String.valueOf(roomPrices[position]));
        holder.roomNum.setText(String.valueOf(roomsNumber[position]));
        Drawable dr = ContextCompat.getDrawable(context, roomImagesIDs[position]);
        holder.roomImage.setImageDrawable(dr);
        holder.nis_symbol.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.nis_symbol));

       /* holder.viewDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, roomDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("roomTypesToItemDetails", roomTypes[position]);
                intent.putExtra("roomPricesToItemDetails",roomPrices[position]);
                intent.putExtra("roomsNumberToItemDetails",roomsNumber[position]);
                intent.putExtra("roomImagesIDsToItemDetails",roomImagesIDs[position]);


                context.startActivity(intent);
            }
        });*/

        holder.viewDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, sameRoomType.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("roomTypesToItemDetails", roomTypes[position]);
                intent.putExtra("roomPricesToItemDetails",roomPrices[position]);
                intent.putExtra("roomsNumberToItemDetails",roomsNumber[position]);
                intent.putExtra("roomImagesIDsToItemDetails",roomImagesIDs[position]);


                context.startActivity(intent);
            }
        });



    }



    @Override
    public int getItemCount() {
        return roomsNumber.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView roomType,roomPrice, roomNum;
        ImageView roomImage,nis_symbol;
        CardView cardView;
        Button viewDetails;


        public ViewHolder(@NonNull View roomView) {
            super(roomView);
            roomType=roomView.findViewById(R.id.roomType);
            roomPrice=roomView.findViewById(R.id.price_value);
            roomNum=roomView.findViewById(R.id.room_num_value);
            roomImage=roomView.findViewById(R.id.image);
            nis_symbol=roomView.findViewById(R.id.nis_symbol3);
            cardView = roomView.findViewById(R.id.cardView);
            viewDetails = roomView.findViewById(R.id.view_Details);


        }
    }
}
