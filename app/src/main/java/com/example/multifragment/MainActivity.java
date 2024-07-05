package com.example.multifragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentDataInterfacer {

    FirstFragment oneFragment;
    SecondFragment twoFragment;
    Button button;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button = findViewById(R.id.send_data_to_fragment);
        textView = findViewById(R.id.tv1);
        if (savedInstanceState == null) {
            oneFragment = new FirstFragment();
            twoFragment = new SecondFragment();

            // This is for adding multiple fragment to activity
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.add(R.id.first_fragment_view_holder, oneFragment);
            fragmentTransaction.add(R.id.second_fragment_view_holder, twoFragment);
            fragmentTransaction.commit();

            // This is for adding just single fragment
//            getSupportFragmentManager().beginTransaction().ad().commit();

        }
        // Register context menu


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                oneFragment.receiveDataFromActivity("THIS IS SENT FROM ACITIVTY TO FRAGMENT FIRST");

//                twoFragment.receivedData("===THis is Sent from Acitivt to Second Farmgent =====");

                showPopupMenu(v);
            }
        });

    }

    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.context_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    // Option 1 action
                    default:
                        return true;
                }
            }
        });
        popup.show();
    }

    @Override
    public void sendDataToAcitvity(String value) {
        textView.setText(value);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "" + item.getItemId(), Toast.LENGTH_SHORT).show();
        return true;
    }
}