package com.example.inventorymanagement;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;


import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;

import org.bson.Document;

import java.util.ArrayList;




public  class Add_Items extends AppCompatActivity {
    EditText name, threshold, quantity, location, weight;
    boolean appending = false;
    Button addItem;
    public int sum = 0;
    String sumy;
    ArrayList<Integer> itemList = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__items);

        name = findViewById(R.id.name);
        threshold = findViewById(R.id.threshold);
        weight = findViewById(R.id.weight);
        quantity = findViewById(R.id.quantity);
        location = findViewById(R.id.location);

        addItem = findViewById(R.id.AddItem);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(0xFFFFFFFF);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);



        addItem.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                EditText[] ets = new EditText[5];
                ets[0] = name;
                ets[1] = location;
                ets[2] = threshold;
                ets[3] = weight;
                ets[4] = quantity;

                for (EditText et : ets) {

                    if (et.getText().toString().isEmpty() == true) {
                        et.setError("This field is mandatory!");

                        itemList.add(0);
                    } else {
                        itemList.add(2);

                    }
                }

                if(weight.getText().toString().isEmpty()==false){
                    String weightinput = weight.getText().toString();
                    int weig = Integer.parseInt(weightinput);
                    if (weig > 5000) {
                        itemList.add(2);
                        weight.setError("The weight cannot be 0 or more than 5000");
                    }
                    else{
                        itemList.add(0);
                    }
                }


                if(validtext(sum) == 10){

                    Intent mainpage = new Intent(getBaseContext(), Update_Items.class);
                    startActivity(mainpage);
                }
//                Intent update= new Intent(getBaseContext(),Update_Items.class);
//                startActivity(update);
            }


        });


    }


    public Integer validtext(int sum) {
        for (int i = 0; i < itemList.size(); i++) {

            sum = sum + itemList.get(i);
            sumy = String.valueOf(sum);
            Log.d("value", sumy);
        }

        if (sum > 10) {
            itemList.clear();
        }

        return sum;

    }


    public boolean validateweight() {
        try {


            String weightinput= weight.getText().toString();
            int weig = Integer.parseInt(weightinput);
            if (weig > 5000) {
                weight.setError("The weight cannot be 0 or more than 5000");

            }
        } catch (NumberFormatException nfe) {

            return false;
        }
        return true;


    }
}