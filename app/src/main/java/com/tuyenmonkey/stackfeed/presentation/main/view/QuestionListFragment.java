package com.tuyenmonkey.stackfeed.presentation.main.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.tuyenmonkey.stackfeed.R;
import com.tuyenmonkey.stackfeed.SfApp;
import com.tuyenmonkey.stackfeed.base.BaseFragment;
import com.tuyenmonkey.stackfeed.databinding.FragmentQuestionListBinding;
import com.tuyenmonkey.stackfeed.dependency.module.QuestionModule;
import com.tuyenmonkey.stackfeed.presentation.main.adapter.QuestionAdapter;
import com.tuyenmonkey.stackfeed.presentation.main.viewmodel.QuestionListViewModel;
import com.tuyenmonkey.stackfeed.util.StateView;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class QuestionListFragment extends BaseFragment {

    private static final String TAG = QuestionListFragment.class.getSimpleName();

    @Inject
    QuestionListViewModel viewModel;

    private FragmentQuestionListBinding binding;
    private QuestionAdapter adapter;

    public static QuestionListFragment newInstance() {
        return new QuestionListFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_question_list;
    }

    @Override
    protected void initializeInjector() {
        SfApp.getApp().getAppComponent().plus(new QuestionModule()).inject(this);
    }

    @Override
    protected void bindViewModel(View view) {
        this.binding = DataBindingUtil.bind(view);
        this.binding.setViewModel(viewModel);
        this.binding.rvQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        updateStateView();
    }

    @Override
    protected void initializeFragment(Bundle savedInstanceState) {
        adapter = new QuestionAdapter(getContext());
        binding.rvQuestions.setAdapter(adapter);
        viewModel.loadQuestions();
    }

    @Override
    public void onDestroy() {
        viewModel.onDestroy();
        super.onDestroy();
    }

    private void updateStateView() {
        viewModel.getViewBehaviorObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<StateView>() {
                    @Override
                    public void call(StateView stateView) {
                        switch (stateView) {
                            case LOADING:
                                binding.paStateView.showLoading();
                                break;
                            case CONTENT:
                                binding.paStateView.showContent();
                                break;
                            case EMPTY:
                                binding.paStateView.showEmpty(ContextCompat.getDrawable(
                                        getContext(), R.mipmap.ic_launcher), "Empty", "Empty Description");
                                break;
                            case ERROR:
                                binding.paStateView.showError(ContextCompat.getDrawable(
                                        getContext(), R.mipmap.ic_launcher), "Error", "Error Description", "Button", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Log.e("TUYEN", "AC");
                                    }
                                });
                                break;
                            default:
                                break;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, throwable.getMessage());
                    }
                });
    }
}
