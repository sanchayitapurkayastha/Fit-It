package com.example.firebaselogin.fitit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Intent intent = getIntent();
        String size = intent.getStringExtra("SIZE");

        ArrayList<ExampleItem> exampleList=new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.d1,"Short Dress 1", size ,"Rs 200"));
        exampleList.add(new ExampleItem(R.drawable.d2,"Short Dress 2", size ,"Rs 450"));
        exampleList.add(new ExampleItem(R.drawable.d3,"Short Dress 3", size ,"Rs 700"));
        exampleList.add(new ExampleItem(R.drawable.d8,"Short Dress 4", size ,"Rs 900"));
        exampleList.add(new ExampleItem(R.drawable.d5,"Short Dress 5", size ,"Rs 350"));
        exampleList.add(new ExampleItem(R.drawable.d6,"Short Dress 6", size ,"Rs 800"));
        exampleList.add(new ExampleItem(R.drawable.d7," Black Short Dress", size ,"Rs 400"));
        exampleList.add(new ExampleItem(R.drawable.d8,"Short Dress 8", size ,"Rs 750"));

        mRecycleView=findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new ExampleAdapter(exampleList);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
    }
}