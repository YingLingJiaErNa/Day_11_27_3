package com.example.day_11_27_3.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day_11_27_3.LoginFragment;
import com.example.day_11_27_3.R;
import com.example.day_11_27_3.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        list.add(new LoginFragment());
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),MainActivity.this,list);
        vp.setAdapter(myAdapter);
    }
}
