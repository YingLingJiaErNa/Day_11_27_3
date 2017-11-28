package com.example.day_11_27_3.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.day_11_27_3.App;
import com.example.day_11_27_3.base.BaseFragment;

/**
 * Created by 赵辉 on 2017/11/27.
 */

public class FragmentBuilder {
    private static volatile FragmentBuilder fragmentBuilder;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fragment;

    private FragmentBuilder(){}
    public static FragmentBuilder getInstance() {
        if (fragmentBuilder == null) {
            synchronized (FragmentBuilder.class){
                fragmentBuilder = new FragmentBuilder();
            }
        }
        return fragmentBuilder;
    }

    public FragmentBuilder init(){
        manager = App.mActivity.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        return this;
    }
    public FragmentBuilder add(int containerId, Class<? extends BaseFragment> fragmentClass){
        String tag = fragmentClass.getSimpleName();
        fragment = manager.findFragmentByTag(tag);
        try {
            fragmentClass.newInstance();
            transaction.add(containerId,fragment,tag);
            transaction.addToBackStack(tag);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (App.mLastFragment == null) {
            transaction.hide(App.mLastFragment);
        }
        transaction.show(fragment);
        return this;
    }
    public void Builder(){
        App.mLastFragment = (BaseFragment) fragment;
        transaction.commit();
    }

}
