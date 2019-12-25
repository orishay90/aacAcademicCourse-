package com.example.jeffrey.academic.restaurant_menu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class    RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public static ArrayList<Item>pickedList;
    private Context mContext ;
    public static int mikumI;



    public RecyclerAdapter(Context context,ArrayList<Item>pickedList){
        this.pickedList=pickedList;
        this.mContext=context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.resturant_item,viewGroup,false));
    }

    @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(pickedList.get(i).getName());
        //viewHolder.desc.setText(pickedList.get(i).getDesc());
        viewHolder.price.setText(String.valueOf(pickedList.get(i).getPrice()));
        viewHolder.imageView.setImageResource(pickedList.get(i).getImegeItem());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mikumI=i;
              mContext.startActivity(new Intent(mContext, ShowPickedItem.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return pickedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private ImageView imageView;
        private TextView price;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.name_of_item_resturant);
            price=itemView.findViewById(R.id.price_of_resturant_item);
            imageView=itemView.findViewById(R.id.image_item_resturant);


        }
    }
}
