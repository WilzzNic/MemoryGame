package com.example.erikjustian.memorygame;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class RetryFragment extends Fragment {
    private ImageButton btndenied, btnapprove;
    private String lvl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retry, container, false);
        btndenied = (ImageButton) view.findViewById(R.id.button);
        btnapprove = (ImageButton) view.findViewById(R.id.button2);

        lvl = ((RetryActivity) getActivity()).getIntent().getStringExtra("lvl");
        System.out.println(lvl);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btndenied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btndenied.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnapprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), medium.class);
                intent.putExtra("lvl", lvl);
                startActivity(intent);
            }
        });
    }
}
