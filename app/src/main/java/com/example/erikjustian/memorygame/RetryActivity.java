package com.example.erikjustian.memorygame;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RetryActivity extends AppCompatActivity {
    private TextView player_stat, txtResult;
    private String receivedStat = null;
    private String result;


    //for the back button to function
    @Override
    public boolean onSupportNavigateUp() {
        finish(); //finish this activity
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retry);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Memory Game");

        player_stat = (TextView) findViewById(R.id.player_stat);
        txtResult = (TextView) findViewById(R.id.txtResult);

        receivedStat = getIntent().getStringExtra("Status");
        result = getIntent().getStringExtra("result");
        System.out.println(result);
        player_stat.setText(receivedStat);
        txtResult.setText(result);

//        if(receivedStat.equals("Lose")){
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(R.id.frame_retry, new RetryFragment(), RetryFragment.class.getSimpleName())
                .commit();
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(RetryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
