package com.example.katya.recipes;

/**
 * Created by Катя on 15.11.2016.
 */
public class ItemDetails {
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
    }}