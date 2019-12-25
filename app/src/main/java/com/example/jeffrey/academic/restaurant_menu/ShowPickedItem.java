package com.example.jeffrey.academic.restaurant_menu;

import android.hardware.camera2.CaptureRequest;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class ShowPickedItem extends AppCompatActivity {
     private TextView price;
     private TextView desc;
    private TextView titel;
    private Button addOrder;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_picked_item);
        price=findViewById(R.id.price_of_item);
        desc=findViewById(R.id.desc_of_item);
        titel=findViewById(R.id.title_of_item);
        addOrder=findViewById(R.id.add_item_to_list);//addOrderOnthelist();
        constraintLayout = findViewById(R.id.background_to_change);
        constraintLayout.setBackgroundResource(MenuActivity.pickedList.get(RecyclerAdapter.mikumI).getImegeItem());
       showTheItem();
        addOrderOnthelist();

    }

    private void showTheItem() {

        price.setText( "מחיר: "+String.valueOf(MenuActivity.pickedList.get(RecyclerAdapter.mikumI).getPrice()));
        desc.setText( "תיאור: "+String.valueOf(MenuActivity.pickedList.get(RecyclerAdapter.mikumI).getDesc()));
        titel.setText( "שם מנה: "+String.valueOf(MenuActivity.pickedList.get(RecyclerAdapter.mikumI).getName()));


    }


    public void addOrderOnthelist() {

        addOrder=findViewById(R.id.add_item_to_list);
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              MenuActivity.allOrder.add(MenuActivity.pickedList.get(RecyclerAdapter.mikumI));
            }
        });


    }
}
