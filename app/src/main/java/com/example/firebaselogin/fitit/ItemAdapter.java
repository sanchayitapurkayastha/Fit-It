package com.example.firebaselogin.fitit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    String[] data1;
    String[] data2;
    int[] images;
    Context context;
    public ItemAdapter(Context ct, String[] price, String[] size, int[] img){
        context = ct;
        data1 = price;
        data2 = size;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.items_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemPrice.setText(data1[position]);
        holder.itemSize.setText(data2[position]);
        holder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView itemPrice, itemSize;
        ImageView itemImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemPrice = itemView.findViewById(R.id.price);
            itemSize = itemView.findViewById(R.id.itemSize);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}