package com.tuyenmonkey.stackfeed.data.repository.datasource;

import com.tuyenmonkey.stackfeed.data.entity.QuestionList;
import com.tuyenmonkey.stackfeed.data.net.StackRestApi;

import rx.Observable;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class CloudQuestionDataStore implements QuestionDataStore {

    private StackRestApi restApi;

    public CloudQuestionDataStore(StackRestApi stackRestApi) {
        restApi = stackRestApi;
    }

    @Override
    public Observable<QuestionList> getQuestions() {
        return restApi.getQuestions();
    }
}
