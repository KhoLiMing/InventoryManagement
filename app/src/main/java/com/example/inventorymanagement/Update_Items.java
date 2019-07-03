package com.example.inventorymanagement;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Update_Items extends AppCompatActivity {

    public int sum = 0;
    String sumy;
    ArrayList<Integer> itemList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__items);


        TextView name = (TextView) findViewById(R.id.Updatename);
        TextView weight = (TextView) findViewById(R.id.Updateweight);

        //editable
        EditText threshold = (EditText) findViewById(R.id.Updatethreshold);
        EditText location = (EditText) findViewById(R.id.Updatelocation);
        EditText quantity = (EditText) findViewById(R.id.Updatequantity);

        Button Editbutton = (Button) findViewById(R.id.UpdateItem);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_update_toolbar);
        myToolbar.setTitleTextColor(0xFFFFFFFF);

        setTitle("Update Items");

        checkbackbutton();

//        ActionBar ab = getSupportActionBar();
//        ab.setDisplayHomeAsUpEnabled(true);


//        if (myToolbar != null) {
//            // you can safely invoke methods on the Toolbar
//            setSupportActionBar(myToolbar);
//
//        } else {
//            // Toolbar is null, handle it
//        }




        Editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText[] ets= new EditText[3];
                ets[0]=threshold;
                ets[1]=location;
                ets[2]=quantity;

                for(EditText et :ets){
                    if(et.getText().toString().isEmpty()){
                        et.setError("This field is mandatory");
                        itemList.add(2);
                    }
                    else {
                        itemList.add(0);
                    }
                }
                if(validtext(sum) == 6){

                    Intent mainpage = new Intent(getBaseContext(), WelcomePage.class);
                    startActivity(mainpage);
                }
            }


        });

    }

    public Integer validtext(int sum) {
        for (int i = 0; i < itemList.size(); i++) {

            sum = sum + itemList.get(i);
            sumy = String.valueOf(sum);
            Log.d("value", sumy);
        }

        if (sum > 6) {
            itemList.clear();
        }

        return sum;

    }

    public void checkbackbutton() {
        boolean allow = false;
        try {
            ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);
            allow = true;

        } catch (NullPointerException nnp) {
            allow = false;

        }
    }
}

