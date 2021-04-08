package com.example.firebaselogin.fitit;

public class ExampleItem {

    private int mImageResource;
    private String mName,mSize,mPrice;

    public ExampleItem(int mImageResource, String mName, String mSize, String mPrice) {
        this.mImageResource = mImageResource;
        this.mName = mName;
        this.mSize = mSize;
        this.mPrice = mPrice;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmName() {
        return mName;
    }

    public String getmSize() {
        return mSize;
    }

    public String getmPrice() {
        return mPrice;
    }
}
