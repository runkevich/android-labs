package com.example.katya.recipes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Катя on 28.11.2016.
 */
public class CookingDescription extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_recipe);
        Intent intent = getIntent();
        ItemDetails itemDetails = intent.getParcelableExtra("Property");

    }
}
