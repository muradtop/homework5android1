package com.example.homework5android1.fragments.second_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.homework5android1.R;
import com.example.homework5android1.fragments.first_fragments.FirstFragment;


public class SecondFragment extends Fragment {
    EditText etInput;
    Button btnData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etInput = view.findViewById(R.id.et_input);
        btnData = view.findViewById(R.id.btn_data);
        listeners();
        getData();


    }

    private void getData() {
            if (getArguments() != null) {
                String s = getArguments().getString("key0");
                etInput.setText(s);
            }
        }

    private void listeners() {
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etInput.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("key",title);
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment,firstFragment).commit();

            }
        });

    }

}