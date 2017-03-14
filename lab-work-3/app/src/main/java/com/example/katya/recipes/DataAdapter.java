package com.example.katya.recipes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class DataAdapter extends BaseAdapter{
    List<ItemDetails> itemDetails;
    private LayoutInflater lInflater;
    public DataAdapter(Context context,List<ItemDetails> itemDetails ){
        this.itemDetails = itemDetails;
        lInflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder ;

        if (convertView == null) {
            convertView = lInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtDescription = (TextView) convertView.findViewById(R.id.itemDescription);
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.imageView = (ImageView) convertView.findViewById(R.id.photo);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemDetails itemDetails1 = (ItemDetails) getItem(position);

        holder.txtDescription.setText(itemDetails1.getItemDescription());
        holder.txtName.setText(itemDetails1.getItemName());
        holder.imageView.setImageResource(itemDetails1.getImageNumber());

        return convertView;
    }
    @Override
    public int getCount() {
        return itemDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return itemDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;//itemDetails.indexOf(getItem(position))
    }
}
