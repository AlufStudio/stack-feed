package com.tuyenmonkey.stackfeed.data.repository.datasource.question;

import com.tuyenmonkey.stackfeed.data.cache.QuestionCache;
import com.tuyenmonkey.stackfeed.data.entity.QuestionList;

import rx.Observable;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class CacheQuestionDataStore implements QuestionDataStore {

    private QuestionCache questionCache;

    public CacheQuestionDataStore(QuestionCache questionCache) {
        this.questionCache = questionCache;
    }

    @Override
    public Observable<QuestionList> getQuestions() {
        throw new UnsupportedOperationException("Operation is not available!!!");
    }
}
