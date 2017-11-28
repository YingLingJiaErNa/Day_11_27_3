package com.example.day_11_27_3;

import com.example.day_11_27_3.base.BaseModel;
import com.example.day_11_27_3.base.BasePresenter;
import com.example.day_11_27_3.base.BaseView;

import okhttp3.Callback;

/**
 * Created by 赵辉 on 2017/11/27.
 */

public interface ZiContract {

    interface View extends BaseView {
      void show(String ss);
    }

    interface Model extends BaseModel {
        void getDataFromNet(String url, Callbacks callbacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {
        abstract void getDataFromModel(String url);
        
    }
}