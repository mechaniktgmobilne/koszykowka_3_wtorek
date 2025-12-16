package com.example.koszykowka_3_wtorek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.koszykowka_3_wtorek.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;//klasa z bindowanymi widokami
    //dla pliku activity_main.xml ActivityMAinBinding

    PunktyViewModel punktyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        punktyViewModel = new ViewModelProvider(this)
                .get(PunktyViewModel.class);

       punktyViewModel.getPunkty().observe(this,
               new Observer<Integer>() {
                   @Override
                   public void onChanged(Integer integer) {
                       binding.textView.setText(""+integer);
                   }
               }
       );

        binding.button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punktyViewModel.addPunkty(1);

                    }
                }
        );
        binding.button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punktyViewModel.addPunkty(2);

                    }
                }
        );
        binding.button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punktyViewModel.addPunkty(3);

                    }
                }
        );
    }
}