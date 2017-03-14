package com.example.katya.recipes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView description = (TextView) findViewById(R.id.textView1);
        ArrayList<ItemDetails> recipe =  getIntent().getParcelableArrayListExtra("description");
        description.setText(recipe.get(0).toString());

    }
}
