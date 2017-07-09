package com.example.erikjustian.memorygame;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,
            btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,
            btna,btnb;

    private ArrayList<String> isi;
    private String colorStr;
    private Boolean klik = true;
    private int score = 0;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_fragment, container, false);
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
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Memory Game");
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shuffle();
        System.out.println(isi);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(1,btn1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(2,btn2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(3,btn3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(4,btn4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(5,btn5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(6,btn6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(7,btn7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(8,btn8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(9,btn9);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(10,btn10);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(11,btn11);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(12,btn12);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(13,btn13);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(14,btn14);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(15,btn15);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(16,btn16);
            }
        });

    }

    protected void check(int no,Button btncek){
        if (klik){
            btna=btncek;
            btna.setClickable(false);
            btna.setBackgroundResource(R.color.card_open);
            btna.setText(isi.get(no-1));
            klik=false;
//            frame.setVisibility(View.GONE);
//            getSupportFragmentManager().beginTransaction().add(R.id.root_container, new RetryFragment(),
//                    RetryFragment.class.getSimpleName()).addToBackStack(null).commit();
            //untuk set tombol ke btna
        }
        else{
            //set btnb dan setclickable false
            btnb=btncek;
            btnb.setClickable(false);
            btnb.setBackgroundResource(R.color.card_open);
            btnb.setText(isi.get(no-1));
            // dibawah untuk delay sebelum di cocokkan
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);// ini fungsi untuk disable semua touch
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    if (btna.getText().equals(btnb.getText()))
                    {//ini untuk cek apakah tombol a=b
                        btna.setBackgroundResource(R.color.card);
                        btnb.setBackgroundResource(R.color.card);
                        btna=null;
                        btnb=null;
                        score++;
                        klik=true;
                        checkwin();
                    }else{
                        //ini kalau tidak sama kartu akan tertutup textnya di hilangkan btna dan b di null kan dan klik dikembalikan ke true
                        btna.setText("");
                        btnb.setText("");
                        btna.setBackgroundResource(R.color.card_closed);
                        btnb.setBackgroundResource(R.color.card_closed);
                        btna.setClickable(true);
                        btnb.setClickable(true);
                        btna=null;
                        btnb=null;
                        klik=true;

                    }
                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);//fungsi untuk enable touch
                }
            }, 1000);

        }
    }

    protected void shuffle(){
        isi = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.easy)));
        Collections.shuffle(isi);
    }

    protected void checkwin(){
        //noinspection ResourceType
        colorStr= getResources().getString(R.color.card_open);
        int clr = Color.parseColor(colorStr);
        System.out.println(clr);

        ColorDrawable btnbg1 = (ColorDrawable) btn1.getBackground();
        int cId1 = btnbg1.getColor();
        ColorDrawable btnbg2 = (ColorDrawable) btn2.getBackground();
        int cId2 = btnbg2.getColor();
        ColorDrawable btnbg3 = (ColorDrawable) btn3.getBackground();
        int cId3 = btnbg3.getColor();
        ColorDrawable btnbg4 = (ColorDrawable) btn4.getBackground();
        int cId4 = btnbg4.getColor();
        ColorDrawable btnbg5 = (ColorDrawable) btn5.getBackground();
        int cId5 = btnbg5.getColor();
        ColorDrawable btnbg6 = (ColorDrawable) btn6.getBackground();
        int cId6 = btnbg6.getColor();
        ColorDrawable btnbg7 = (ColorDrawable) btn7.getBackground();
        int cId7 = btnbg7.getColor();
        ColorDrawable btnbg8 = (ColorDrawable) btn8.getBackground();
        int cId8 = btnbg8.getColor();
        ColorDrawable btnbg9 = (ColorDrawable) btn9.getBackground();
        int cId9 = btnbg9.getColor();
        ColorDrawable btnbg10 = (ColorDrawable) btn10.getBackground();
        int cId10 = btnbg10.getColor();
        ColorDrawable btnbg11 = (ColorDrawable) btn11.getBackground();
        int cId11 = btnbg11.getColor();
        ColorDrawable btnbg12 = (ColorDrawable) btn12.getBackground();
        int cId12 = btnbg12.getColor();
        ColorDrawable btnbg13 = (ColorDrawable) btn13.getBackground();
        int cId13 = btnbg13.getColor();
        ColorDrawable btnbg14 = (ColorDrawable) btn14.getBackground();
        int cId14 = btnbg14.getColor();
        ColorDrawable btnbg15 = (ColorDrawable) btn15.getBackground();
        int cId15 = btnbg15.getColor();
        ColorDrawable btnbg16 = (ColorDrawable) btn16.getBackground();
        int cId16 = btnbg16.getColor();

        // -65536 => color of R.color.card_open
        // -16776961 => color of R.color.card
        if(cId1 == -16776961 && cId2 == -16776961 && cId3 == -16776961 && cId4 == -16776961 && cId5 == -16776961 &&
                cId6 == -16776961 && cId7 == -16776961 && cId8 == -16776961 && cId9 == -16776961 && cId10 == -16776961 &&
                cId11 == -16776961 && cId12 == -16776961 && cId13 == -16776961 && cId14 == -16776961 && cId15 == -16776961 && cId16 == -16776961){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new RetryFragment(),
                    RetryFragment.class.getSimpleName()).addToBackStack(null).commit();

//            -----Popup Window-----
//            LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//            View customView = inflater.inflate(R.layout.popup_completed, null);
//            popupWindow = new PopupWindow(customView, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);
        }
    }
}
