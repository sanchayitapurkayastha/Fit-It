package com.example.firebaselogin.fitit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListFragment extends Fragment {
    RecyclerView recyclerView;

    String[] price;
    int[] images;
    String[] size_arr;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        Bundle bundle = getArguments();
        String size = bundle.getString("SIZE");
        switch (size) {
            case "XXS":{
                price = new String[]{"500", "3000", "999"};
                images = new int[]{R.drawable.d1, R.drawable.d3, R.drawable.d4};
                size_arr = new String[] { "XXS","XXS","XXS"};
            }
            break;
            case "S":{
                price = new String[]{"500", "399" ,"3000", "999"};
                images = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4};
                size_arr = new String[] { "S","S","S","S"};
            }
            break;
            case "M":{
                price = new String[]{"500", "3000", "999","500", "3000", "999","499"};
                images = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7};
                size_arr = new String[] { "M","M","M","M","M","M","M"};
            }
            break;
            case "L":{
                price = new String[]{"500", "3000", "999","500", "3000", "999"};
                images = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6};
                size_arr = new String[] { "L","L","L", "L","L","L"};
            }
            break;
            case "XL":{
                price = new String[]{"500", "3000", "999"};
                images = new int[]{R.drawable.d5, R.drawable.d6, R.drawable.d7};
                size_arr = new String[] { "XL","XL","XL"};
            }
            break;
            case "XXL":{
                price = new String[]{"500"};
                images = new int[]{R.drawable.d7};
                size_arr = new String[] { "XXL"};
            }
        }

        ItemAdapter itemAdapter;
        itemAdapter = new ItemAdapter(getContext(),price, size_arr, images);
        recyclerView = recyclerView.findViewById(R.id.home_list_item);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return inflater.inflate(R.layout.fragment_itemlist, container, false);
    }
}

