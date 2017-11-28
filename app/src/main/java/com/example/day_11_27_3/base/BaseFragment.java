package com.example.day_11_27_3.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day_11_27_3.utils.TUtil;

/**
 * Created by 赵辉 on 2017/11/27.
 */

public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends Fragment {

    public P myPresenter;
    public M myModel;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    public void initData(){
        myPresenter = TUtil.getT(this,0);
        myModel = TUtil.getT(this,1);
        if (this instanceof  BaseView) {
            myPresenter.setVM(myModel,this);
        }
        initView(view);
    };
    protected abstract void initView(View view);
    protected abstract int getLayoutId();
}
