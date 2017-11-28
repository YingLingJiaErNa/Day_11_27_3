package com.example.day_11_27_3.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.day_11_27_3.ui.MainActivity;

import java.util.List;

import static android.R.id.list;

/**
 * Created by 赵辉 on 2017/11/27.
 */

public class MyAdapter extends FragmentPagerAdapter {
    Context context; List<Fragment> list;
    public MyAdapter(FragmentManager fm, Context context, List<Fragment> list) {
        super(fm);
        this.context = context;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
