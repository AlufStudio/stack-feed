package com.tuyenmonkey.stackfeed.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        bindViewModel();
        initializeActivity(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    protected void initializeInjector() {}

    protected abstract void bindViewModel();

    public ViewDataBinding getViewDataBinding() {
        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        ButterKnife.bind(this);

        return viewDataBinding;
    }

    protected abstract void initializeActivity(Bundle savedInstanceState);

    public void addFragment(int resId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(resId, fragment).commit();
    }

    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
