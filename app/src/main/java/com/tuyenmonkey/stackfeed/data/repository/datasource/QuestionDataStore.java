package com.tuyenmonkey.stackfeed.data.repository.datasource;

import com.tuyenmonkey.stackfeed.data.entity.QuestionList;

import rx.Observable;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public interface QuestionDataStore {

    Observable<QuestionList> getQuestions();
}
