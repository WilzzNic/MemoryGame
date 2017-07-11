package com.example.erikjustian.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RetryActivity extends AppCompatActivity {
    private TextView player_stat;
    private String receivedStat = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retry);

        player_stat = (TextView) findViewById(R.id.player_stat);
        receivedStat = getIntent().getStringExtra("Status");
        player_stat.setText(receivedStat);

//        if(receivedStat.equals("Lose")){
            getSupportFragmentManager().beginTransaction().add(R.id.frame_retry, new RetryFragment()
            , RetryFragment.class.getSimpleName()).commit();
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
