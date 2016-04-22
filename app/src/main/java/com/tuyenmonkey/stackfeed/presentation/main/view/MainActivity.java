package com.tuyenmonkey.stackfeed.presentation.main.view;

import com.tuyenmonkey.stackfeed.R;
import com.tuyenmonkey.stackfeed.base.BaseActivity;
import com.tuyenmonkey.stackfeed.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindViewModel() {
        this.binding = (ActivityMainBinding)getViewDataBinding();
    }

    @Override
    protected void initializeActivity() {

    }
}
