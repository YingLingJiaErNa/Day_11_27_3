package com.example.day_11_27_3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day_11_27_3.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment<ZiPresenter,ZiModel> implements ZiContract.View{

    @Override
    protected void initView(View view) {
        myPresenter.getDataFromModel("http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void show(String ss) {
        Log.e("TAG",ss);
    }
}
