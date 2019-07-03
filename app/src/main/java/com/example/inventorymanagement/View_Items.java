package com.example.inventorymanagement;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class View_Items extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__items);

        setTitle("View Items");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.viewItems_toolbar);
        myToolbar.setTitleTextColor(0xFFFFFFFF);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_buttons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_AddItem:
                Intent add= new Intent(getBaseContext(),Add_Items.class);
                startActivity(add);
                return true;

            case R.id.action_UpdateItem:
                Intent update= new Intent(getBaseContext(),Update_Items.class);
                startActivity(update);
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }
}
