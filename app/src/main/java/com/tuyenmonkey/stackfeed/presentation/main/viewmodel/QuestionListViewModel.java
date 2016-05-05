package com.tuyenmonkey.stackfeed.presentation.main.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.tuyenmonkey.stackfeed.base.BaseViewModel;
import com.tuyenmonkey.stackfeed.data.entity.Question;
import com.tuyenmonkey.stackfeed.data.entity.QuestionList;
import com.tuyenmonkey.stackfeed.domain.interactor.question.GetQuestionListUseCase;
import com.tuyenmonkey.stackfeed.util.StateView;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

/**
 * Created by Tuyen Nguyen on 5/3/16.
 */
public class QuestionListViewModel extends BaseViewModel {

    private static final String TAG = QuestionListViewModel.class.getSimpleName();

    private GetQuestionListUseCase getQuestionListUseCase;
    private ObservableList<QuestionItemViewModel> questions = new ObservableArrayList<>();

    public QuestionListViewModel(GetQuestionListUseCase getQuestionListUseCase) {
        this.getQuestionListUseCase = getQuestionListUseCase;
    }

    public void loadQuestions() {
        viewBehavior.onNext(StateView.LOADING);
        getQuestionListUseCase.execute(new Action1<QuestionList>() {
            @Override
            public void call(QuestionList questionList) {
                if (questionList.getQuestions().isEmpty()) {
                    viewBehavior.onNext(StateView.EMPTY);
                } else {
                    viewBehavior.onNext(StateView.CONTENT);
                }
                questions.clear();
                List<QuestionItemViewModel> items = new ArrayList<>();
                for (Question q : questionList.getQuestions()) {
                    items.add(new QuestionItemViewModel(q));
                }

                questions.addAll(items);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                viewBehavior.onNext(StateView.ERROR);
                Log.e(TAG, throwable.getMessage());
            }
        });
    }

    public ObservableList getQuestions() {
        return this.questions;
    }

    public void onDestroy() {
        getQuestionListUseCase.unsubscribe();
    }
}
