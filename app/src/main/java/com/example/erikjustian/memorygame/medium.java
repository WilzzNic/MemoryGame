package com.example.erikjustian.memorygame;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class medium extends AppCompatActivity {

    //for the back button to function
    @Override
    public boolean onSupportNavigateUp() {
        finish(); //finish this activity

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //set the back button to appear on this activity
        getSupportActionBar().setTitle("Memory Game");

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .add(R.id.frame_container, new GameFragment(), GameFragment.class.getSimpleName())
                    .commit();
        }

    }
}
