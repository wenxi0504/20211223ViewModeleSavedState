package com.example.a20211223viewmodelesavedstate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.a20211223viewmodelesavedstate.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;
    final static String KEY_NUMBER="my_number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel= new ViewModelProvider(this).get(MyViewModel.class);
        if(savedInstanceState !=null)
        {
            myViewModel.getNumber().setValue(savedInstanceState.getInt(KEY_NUMBER));

        }
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUMBER,myViewModel.getNumber().getValue());
    }
}