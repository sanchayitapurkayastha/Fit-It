package com.example.firebaselogin.fitit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListFragment extends Fragment {
    RecyclerView recyclerView;

    String[] price = {"Rs. 569", "Rs. 4588", "Rs. 8970", "Rs. 1999", "Rs. 169", "Rs. 123", "Rs. 458", "Rs. 897", "Rs. 794", "Rs. 169"};
    String[] size = {"M","S","L","M","XL","S","S","L","S","M"};
    int[] images = {R.drawable.dress, R.drawable.pant, R.drawable.shirt,
            R.drawable.kurta, R.drawable.shirt, R.drawable.shirt,
            R.drawable.dress, R.drawable.dress, R.drawable.dress,
            R.drawable.shirt};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ItemAdapter itemAdapter;
        itemAdapter = new ItemAdapter(getContext(),price, size, images);
        recyclerView = recyclerView.findViewById(R.id.home_list_item);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return inflater.inflate(R.layout.fragment_itemlist, container, false);
    }
}

