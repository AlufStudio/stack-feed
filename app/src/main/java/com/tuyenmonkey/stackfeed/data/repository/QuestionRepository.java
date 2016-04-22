package com.tuyenmonkey.stackfeed.data.repository;

import com.tuyenmonkey.stackfeed.data.entity.QuestionList;

import rx.Observable;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public interface QuestionRepository {

    Observable<QuestionList> getQuestions();
}
