package com.example.day_11_27_3.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.day_11_27_3.App;
import com.example.day_11_27_3.utils.TUtil;

/**
 * Created by 赵辉 on 2017/11/27.
 */

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    private P mPresenter;
    private M myModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.mActivity = this;
        setContentView(getLayoutId());
        init();
    }

    private void init() {
        mPresenter = TUtil.getT(this, 0);
        myModel = TUtil.getT(this,1);
        if (this instanceof BaseView) {

        }
        initView();
    }
    protected abstract void initView();
    protected abstract int getLayoutId();
}
