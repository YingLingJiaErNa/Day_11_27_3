package com.example.day_11_27_3;

/**
* Created by TMVPHelper on 2017/11/27
*/
public class ZiPresenter extends ZiContract.Presenter{

    @Override
    void getDataFromModel(String url) {
        myModel.getDataFromNet(url, new Callbacks() {
            @Override
            public void succ(String succ) {
                myView.show(succ);
            }
        });
    }
}