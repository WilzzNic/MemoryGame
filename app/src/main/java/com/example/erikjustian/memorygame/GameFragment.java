package com.example.erikjustian.memorygame;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16,
            btna, btnb;

    private TextView txturn, txtScore;

    private String msg, lvl;
    private int a;
    private int turn;

    private ArrayList<String> isi;
    private String colorStr;
    private Boolean klik = true;
    private Boolean multi = false;
    private int score = 0;
    private int point = 5;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout4x4, container, false);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btn8 = (Button) view.findViewById(R.id.btn8);
        btn9 = (Button) view.findViewById(R.id.btn9);
        btn10 = (Button) view.findViewById(R.id.btn10);
        btn11 = (Button) view.findViewById(R.id.btn11);
        btn12 = (Button) view.findViewById(R.id.btn12);
        btn13 = (Button) view.findViewById(R.id.btn13);
        btn14 = (Button) view.findViewById(R.id.btn14);
        btn15 = (Button) view.findViewById(R.id.btn15);
        btn16 = (Button) view.findViewById(R.id.btn16);
        txturn = (TextView) view.findViewById(R.id.txtTurn);
        txtScore = (TextView) view.findViewById(R.id.txtScore);
        lvl = ((medium) getActivity()).getIntent().getStringExtra("lvl");

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shuffle();
        System.out.println(isi);

        ((medium) getActivity()).getSupportActionBar().setSubtitle(lvl);

        //gameplay choice rules
        if (getActivity().getClass().getSimpleName().equals("medium")) {
//            System.out.println(lvl);
            switch (lvl) {
                case "Relax Mode":
                    turn = 0;
                    a = 1;
                    break;
                case "Challange Mode":
                    turn = 2;
                    a = -1;
                    break;
            }
        }
        txturn.setText(turn + "");
        txtScore.setText(score + "");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(1, btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(2, btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(3, btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(4, btn4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(5, btn5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(6, btn6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(7, btn7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(8, btn8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(9, btn9);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(10, btn10);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(11, btn11);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(12, btn12);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(13, btn13);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(14, btn14);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(15, btn15);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(16, btn16);
            }
        });
    }

    protected void check(int no, Button btncek) {
        if (klik) {
            btna = btncek;
            btna.setClickable(false);
            btna.setBackgroundResource(R.color.card_open);
            btna.setText(isi.get(no - 1));
            klik = false;
//            frame.setVisibility(View.GONE);
//            getSupportFragmentManager().beginTransaction().add(R.id.root_container, new RetryFragment(),
//                    RetryFragment.class.getSimpleName()).addToBackStack(null).commit();
            //untuk set tombol ke btna
        } else {
            //set btnb dan setclickable false
            btnb = btncek;
            btnb.setClickable(false);
            btnb.setBackgroundResource(R.color.card_open);
            btnb.setText(isi.get(no - 1));
            // dibawah untuk delay sebelum di cocokkan
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);// ini fungsi untuk disable semua touch
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after ...
                    //ini untuk cek apakah tombol a = b
                    if ( btna.getText().equals(btnb.getText()) ) {
                        //score count
                        if (multi == true) {
                            point *= 2;
                            score += point;
                        } else {
                            point = 5;
                            score += point;
                        }
                        btna.setBackgroundResource(R.color.card);
                        btnb.setBackgroundResource(R.color.card);
                        btna = null;
                        btnb = null;
                        klik = true;
                        turn = turn + a;
                        multi = true;
                        checkwin();
                    } else {
                        //ini kalau tidak sama kartu akan tertutup textnya di hilangkan btna dan b di null kan dan klik dikembalikan ke true
                        btna.setText("");
                        btnb.setText("");
                        btna.setBackgroundResource(R.color.card_closed);
                        btnb.setBackgroundResource(R.color.card_closed);
                        btna.setClickable(true);
                        btnb.setClickable(true);
                        btna = null;
                        btnb = null;
                        klik = true;
                        turn = turn + a;
                        multi = false;
                        checkwin();
                    }
                    txturn.setText(turn + "");
                    txtScore.setText(score + "");
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);//fungsi untuk enable touch
                }
            }, 500);
        }
    } //check cards end here

    protected void shuffle() {
        isi = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.easy)));
        Collections.shuffle(isi);
    }

    protected void checkwin() {
        //noinspection ResourceType
        colorStr = getResources().getString(R.color.card_open);
        int clr = Color.parseColor(colorStr);
        System.out.println(clr);

        // getbackgroundcolor
        int c1 = ((ColorDrawable) btn1.getBackground()).getColor();
        int c2 = ((ColorDrawable) btn2.getBackground()).getColor();
        int c3 = ((ColorDrawable) btn3.getBackground()).getColor();
        int c4 = ((ColorDrawable) btn4.getBackground()).getColor();
        int c5 = ((ColorDrawable) btn5.getBackground()).getColor();
        int c6 = ((ColorDrawable) btn6.getBackground()).getColor();
        int c7 = ((ColorDrawable) btn7.getBackground()).getColor();
        int c8 = ((ColorDrawable) btn8.getBackground()).getColor();
        int c9 = ((ColorDrawable) btn9.getBackground()).getColor();
        int c10 = ((ColorDrawable) btn10.getBackground()).getColor();
        int c11 = ((ColorDrawable) btn11.getBackground()).getColor();
        int c12 = ((ColorDrawable) btn12.getBackground()).getColor();
        int c13 = ((ColorDrawable) btn13.getBackground()).getColor();
        int c14 = ((ColorDrawable) btn14.getBackground()).getColor();
        int c15 = ((ColorDrawable) btn15.getBackground()).getColor();
        int c16 = ((ColorDrawable) btn16.getBackground()).getColor();

        if (c1 == -6381922 && c2 == -6381922 && c3 == -6381922 && c4 == -6381922 && c5 == -6381922 &&
            c6 == -6381922 && c7 == -6381922 && c8 == -6381922 && c9 == -6381922 && c10 == -6381922 &&
            c11 == -6381922 && c12 == -6381922 && c13 == -6381922 && c14 == -6381922 && c15 == -6381922 && c16 == -6381922 && turn >= 0) {
            message();
            String result = Integer.toString(score);
            Intent intent = new Intent(getActivity(), RetryActivity.class);
            intent.putExtra("Status", msg);
            intent.putExtra("lvl", lvl);
            intent.putExtra("result", result);
            startActivity(intent);

        } else if (turn <= 0) {
            msg = "GAME OVER";
            String result = Integer.toString(score);
            Intent intent = new Intent(getActivity(), RetryActivity.class);
            intent.putExtra("Status", msg);
            intent.putExtra("lvl", lvl);
            intent.putExtra("result", result);
            startActivity(intent);
        }

    } // end of checkwin

    protected void message() {
        switch (lvl) {
            case "Relax Mode":
                if (turn >= 14)
                    msg = "GOOD GAME";
                else if (turn < 14)
                    if (score == 1275)
                        msg = "PERFECT!";
                    else if (score < 1275 && score >= 600)
                        msg = "AWESOME";
                    else if (score < 600 && score >= 100)
                        msg = "GREAT JOB";
                    else
                        msg = "GOOD GAME";
                break;

            case "Challange Mode":
                if (turn >= 2)
                    if (score == 1275)
                        msg = "PERFECT!";
                    else if (score < 1275 && score >= 600)
                        msg = "AWESOME";
                    else if (score < 600 && score >= 100)
                        msg = "GREAT JOB";
                    else
                        msg = "GOOD GAME";
                else
                    msg = "GOOD GAME";
                break;
        }
    } //end of message
}
//            -----Popup Window-----
//            LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//            View customView = inflater.inflate(R.layout.popup_completed, null);
//            popupWindow = new PopupWindow(customView, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);