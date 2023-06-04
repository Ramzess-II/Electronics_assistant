package com.example.electronics_assistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.example.electronics_assistant.fragment.CalculateFragment;
import com.example.electronics_assistant.fragment.HomeFragment;
import com.example.electronics_assistant.fragment.InfoFragment;
import com.example.electronics_assistant.fragment.ListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find_view ();
        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.list:
                    replaceFragment(new ListFragment());
                    break;
                case R.id.calculate:
                    replaceFragment(new CalculateFragment());
                    break;
                case R.id.info:
                    replaceFragment(new InfoFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment,fragment);
        fragmentTransaction.commit();
    }

    private void find_view (){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //bottomNavigationView.setItemTextColor(ContextCompat.getColorStateList(this, R.color.purple_500));
        //bottomNavigationView.setItemIconTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
        frameLayout = findViewById(R.id.main_fragment);
        toolbar = findViewById(R.id.toolbar);
    }
}