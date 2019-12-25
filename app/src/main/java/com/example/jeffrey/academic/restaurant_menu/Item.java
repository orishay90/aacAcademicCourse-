package com.example.jeffrey.academic.restaurant_menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Item {

    private String name;
    private String desc;
    private int price;
    private int imegeItem;
    private boolean order;


    public Item(int imegeItem, String desc, int price,String name ) {
        this.imegeItem = imegeItem;
        this.desc = desc;
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImegeItem() {
        return imegeItem;
    }

    public void setImegeItem(int imegeItem) {
        this.imegeItem = imegeItem;
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;

}
}

