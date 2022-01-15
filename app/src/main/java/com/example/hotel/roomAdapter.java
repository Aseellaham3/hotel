package com.example.hotel;

import android.content.Context;
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
    private List<room> itemsList;


    public roomAdapter( Context context, List<room> itemsList) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.itemsList=itemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.rooms,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.room_type.setText(itemsList.get(position).getRoomType());
        holder.price.setText(String.valueOf(itemsList.get(position).getPrice()));
        Drawable dr= ContextCompat.getDrawable(context,itemsList.get(position).getImageID());
        holder.image.setImageDrawable(dr);
        holder.nis_symbol3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.nis_symbol));
        holder.nis_symbol4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.nis_symbol));
        holder.room_num.setText(String.valueOf(itemsList.get(position).getRoomNum()));

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView room_type,price,room_num,total_cart_value;
        ImageView image,nis_symbol3,nis_symbol4;
        CardView cardView;
        Button view_details;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            room_type=itemView.findViewById(R.id.roomType);
            price=itemView.findViewById(R.id.price_value);
            room_num=itemView.findViewById(R.id.room_num_value);
            image=itemView.findViewById(R.id.room_image);
            nis_symbol3=itemView.findViewById(R.id.nis_symbol3);
            nis_symbol4=itemView.findViewById(R.id.nis_symbol4);
            cardView = itemView.findViewById(R.id.cardView);
            view_details=itemView.findViewById(R.id.view_Details);

        }
    }
}
