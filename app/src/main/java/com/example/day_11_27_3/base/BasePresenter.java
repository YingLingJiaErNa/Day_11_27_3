package com.example.day_11_27_3.base;

/**
 * Created by 赵辉 on 2017/11/27.
 */
public class BasePresenter<M, V> {
    public M myModel;
    public V myView;
    public void setVM(M m,V v){
        myModel = m;
        myView = v;
    }
}
