package com.example.hotel;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class roomAdapter extends RecyclerView.Adapter<roomAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    private List<room> roomList;

    private String[] roomTypes, features , floorsRoom;
    private double[] roomPrices;
    private int[] roomImagesIDs , roomsNumber;

    public roomAdapter( Context context, String[] roomTypes, double[] roomPrices,int[] roomImagesIDs, int[] roomsNumber, String[] features,  String[] floorsRoom) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.roomTypes = roomTypes;
        this.roomsNumber = roomsNumber;
        this.roomPrices = roomPrices;
        this.roomImagesIDs = roomImagesIDs;
        this.features = features;
        this.floorsRoom = floorsRoom;

    }

    public roomAdapter( Context context, List<room> roomList) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.roomList = roomList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.rooms_type,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.room_type.setText(roomList.get(position).getRoomType());
        holder.price.setText(String.valueOf(roomList.get(position).getPrice()));
        Drawable dr= ContextCompat.getDrawable(context,roomList.get(position).getImageID() );


        holder.image.setImageDrawable(dr);
        holder.nis_symbol.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.nis_symbol));
        holder.room_num.setText(String.valueOf(roomList.get(position).getRoomNum()));
        holder.feature.setText(String.valueOf(roomList.get(position).getFeature()));
        holder.floor.setText(String.valueOf(roomList.get(position).getFloor()));
        holder.bookRoomBT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               //to do
            }
        });


    }

    @Override
    public int getItemCount() {

        return roomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView room_type,price,room_num,feature,floor;
        ImageView image,nis_symbol;
        Button bookRoomBT;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            room_type=itemView.findViewById(R.id.roomType);
            price=itemView.findViewById(R.id.price_value);
            room_num=itemView.findViewById(R.id.room_num_value);
            feature=itemView.findViewById(R.id.featureValue);
            image=itemView.findViewById(R.id.room_image);
            nis_symbol=itemView.findViewById(R.id.nis_symbol3);
            bookRoomBT=itemView.findViewById(R.id.bookRoom);
            floor = itemView.findViewById(R.id.floor_value);


            Intent intent = new Intent(context, sameRoomType.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("featureToRoomDetails", String.valueOf(feature));
            intent.putExtra("floorToRoomDetails", String.valueOf(feature));
            context.startActivity(intent);

        }
    }
}
