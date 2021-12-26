package com.example.homework5android1.fragments.first_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.homework5android1.R;
import com.example.homework5android1.fragments.second_fragments.SecondFragment;


public class FirstFragment extends Fragment {

Button btnOpen;
TextView tvBlank;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnOpen = view.findViewById(R.id.btn_open);
        tvBlank = view.findViewById(R.id.tv_blank);
        listeners();
        getData();
    }

    private void listeners() {
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,secondFragment).commit();

            }
        });
        tvBlank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = tvBlank.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("key0", string);
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, secondFragment).commit();
            }
        });
    }
    private void getData() {
        if (getArguments() != null){
            String s = getArguments().getString("key");
            tvBlank.setText(s);

        }
    }
}