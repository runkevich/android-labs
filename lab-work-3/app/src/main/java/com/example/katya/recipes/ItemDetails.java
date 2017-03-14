package com.example.katya.recipes;

import android.os.Parcel;
import android.os.Parcelable;


public class ItemDetails implements Parcelable {

    private int imageNumber;
    private String itemName;
    private String itemDescription;

    public ItemDetails(int imageNumber, String itemName, String itemDescription) {
        this.imageNumber = imageNumber;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public int getImageNumber(){
        return imageNumber;
    }

    public int setImageNumber(int imageNumber){
        return imageNumber;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String toString() {
        return itemName + "\n" + itemDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imageNumber);
        dest.writeString(this.itemName);
        dest.writeString(this.itemDescription);
    }

    protected ItemDetails(Parcel in) {

        this.imageNumber = in.readInt();
        this.itemName = in.readString();
        this.itemDescription = in.readString();
    }

    public static final Parcelable.Creator<ItemDetails> CREATOR = new Parcelable.Creator<ItemDetails>() {
        @Override
        public ItemDetails createFromParcel(Parcel source) {
            return new ItemDetails(source);
        }

        @Override
        public ItemDetails[] newArray(int size) {
            return new ItemDetails[size];
        }
    };

}