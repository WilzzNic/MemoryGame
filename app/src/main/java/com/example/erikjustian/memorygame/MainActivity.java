package com.example.erikjustian.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected Button btneasy, btnmedium;
    private String receivedStat = null;
    private String strIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //test

//        if(savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().add(R.id.frame_container, new GameFragment(),
//                    GameFragment.class.getSimpleName()).commit();
//        }

        btneasy = (Button) findViewById(R.id.btneasy);
        btnmedium = (Button) findViewById(R.id.btnmedium);

        View.OnClickListener level = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button x = (Button) v;
                if (x == btneasy) {
                    String lvl = "Relax Mode";
                    Intent i = new Intent(MainActivity.this, medium.class);
                    i.putExtra("lvl", lvl);
//                    btneasy.setBackgroundColor(getResources().getColor(R.color.btneffect1));
                    startActivity(i);
                } else if (x == btnmedium) {
                    String lvl = "Challange Mode";
                    Intent i = new Intent(MainActivity.this, medium.class);
                    i.putExtra("lvl", lvl);
//                    btnmedium.setBackgroundColor(getResources().getColor(R.color.btneffect1));
                    startActivity(i);
                }

            }
        };

        btneasy.setOnClickListener(level);
        btnmedium.setOnClickListener(level);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


