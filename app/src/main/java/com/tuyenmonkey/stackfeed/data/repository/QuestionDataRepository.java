package com.tuyenmonkey.stackfeed.data.repository;

import com.tuyenmonkey.stackfeed.data.entity.QuestionList;
import com.tuyenmonkey.stackfeed.data.repository.datasource.QuestionDataStore;

import rx.Observable;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class QuestionDataRepository implements QuestionRepository {

    private QuestionDataStore questionDataStore;

    public QuestionDataRepository(QuestionDataStore questionDataStore) {
        this.questionDataStore = questionDataStore;
    }

    @Override
    public Observable<QuestionList> getQuestions() {
        return questionDataStore.getQuestions();
    }
}
