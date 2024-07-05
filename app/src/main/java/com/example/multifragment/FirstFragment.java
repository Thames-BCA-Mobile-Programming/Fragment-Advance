package com.example.multifragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {


    TextView textView;
    FragmentDataInterfacer fragmentDataInterfacer;

    Button button;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentDataInterfacer = (FragmentDataInterfacer) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        textView =v.findViewById(R.id.first_fragment_textView);
        button = v.findViewById(R.id.btn_first_fragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentDataInterfacer.sendDataToAcitvity("This is send from Fragment to acitvity");
            }
        });
        return  v;
    }


    public void receiveDataFromActivity(String data){
        textView.setText(data);
    }


}