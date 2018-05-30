package com.biao.computer.commun.circledemo.mvp.contract;

/**
 * Created by biao on 16/4/1.
 */
public interface BaseView {
    void showLoading(String msg);
    void hideLoading();
    void showError(String errorMsg);


}
