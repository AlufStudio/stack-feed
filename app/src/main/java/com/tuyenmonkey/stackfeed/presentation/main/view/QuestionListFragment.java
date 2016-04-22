package com.tuyenmonkey.stackfeed.presentation.main.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.tuyenmonkey.stackfeed.R;
import com.tuyenmonkey.stackfeed.base.BaseFragment;
import com.tuyenmonkey.stackfeed.databinding.FragmentQuestionListBinding;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class QuestionListFragment extends BaseFragment {

    private static final String TAG = QuestionListFragment.class.getSimpleName();

    private FragmentQuestionListBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_question_list;
    }

    @Override
    protected void initializeInjector() {

    }

    @Override
    protected void bindViewModel(View view) {
        this.binding = DataBindingUtil.bind(view);
    }

    @Override
    protected void initializeFragment(Bundle savedInstanceState) {

    }
}
