package com.example.firebaselogin.fitit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView mItemImage;
        public TextView mItemName,mItemSize,mItemPrice;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemImage=itemView.findViewById(R.id.itemImage);
            mItemName=itemView.findViewById(R.id.itemName1);
            mItemSize=itemView.findViewById(R.id.itemSize1);
            mItemPrice=itemView.findViewById(R.id.itemPrice1);

        }
    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_view,parent,false);
        ExampleViewHolder evh=new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        ExampleItem currentItem=mExampleList.get(position);
        holder.mItemImage.setImageResource(currentItem.getmImageResource());
        holder.mItemName.setText(currentItem.getmName());
        holder.mItemSize.setText(currentItem.getmSize());
        holder.mItemPrice.setText(currentItem.getmPrice());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}

