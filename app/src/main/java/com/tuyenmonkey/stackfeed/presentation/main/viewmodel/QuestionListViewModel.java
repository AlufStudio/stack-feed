package com.tuyenmonkey.stackfeed.presentation.main.viewmodel;

import android.util.Log;

import com.tuyenmonkey.stackfeed.base.BaseViewModel;
import com.tuyenmonkey.stackfeed.data.entity.Question;
import com.tuyenmonkey.stackfeed.data.entity.QuestionList;
import com.tuyenmonkey.stackfeed.domain.interactor.question.GetQuestionListUseCase;

import rx.functions.Action1;

/**
 * Created by Tuyen Nguyen on 5/3/16.
 */
public class QuestionListViewModel extends BaseViewModel {

    private static final String TAG = QuestionListViewModel.class.getSimpleName();

    private GetQuestionListUseCase getQuestionListUseCase;

    public QuestionListViewModel(GetQuestionListUseCase getQuestionListUseCase) {
        this.getQuestionListUseCase = getQuestionListUseCase;
    }

    public void loadQuestions() {
        getQuestionListUseCase.execute(new Action1<QuestionList>() {
            @Override
            public void call(QuestionList questionList) {
                for (Question q : questionList.getQuestions()) {
                    Log.e(TAG, q.getTitle());
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });
    }

    public void onDestroy() {
        getQuestionListUseCase.unsubscribe();
    }
}
