package com.example.firebaselogin.fitit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GiftListFragment extends Fragment {
    RecyclerView recyclerView;
    String[] price = {"500", "3000", "999","500", "3000", "999","499"};
    int[] images = {R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7};
    String[] size_arr = {"XXS, XS, M, L", "S, M, L", "XXS, XS, M, L", "XXS, XS, M, L", "M, L, XL", "M, L, XL", "M, L, XL, XXL"};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ItemAdapter itemAdapter;
        itemAdapter = new ItemAdapter(getContext(),price, size_arr, images);
        recyclerView = recyclerView.findViewById(R.id.home_list_item);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return inflater.inflate(R.layout.fragment_giftitemlist, container, false);
    }
}
