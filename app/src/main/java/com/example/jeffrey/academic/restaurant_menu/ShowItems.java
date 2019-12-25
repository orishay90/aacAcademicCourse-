package com.example.jeffrey.academic.restaurant_menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

import static com.example.jeffrey.academic.restaurant_menu.RecyclerAdapter.pickedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowItems extends Fragment {

    public static String label;

    public ShowItems() {
        // Required empty public constructor
    }
    private void loadTheRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);

        RecyclerView recyclerView = getView().findViewById(R.id.resturant_recycler);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), MenuActivity.pickedList);
        recyclerView.setAdapter(adapter);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_items, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadTheRecycler();

    }
}
