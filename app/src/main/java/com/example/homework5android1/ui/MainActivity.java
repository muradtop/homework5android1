package com.example.homework5android1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.homework5android1.R;
import com.example.homework5android1.fragments.first_fragments.FirstFragment;
import com.example.homework5android1.fragments.second_fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment,new FirstFragment()).commit();
        }
    }
}