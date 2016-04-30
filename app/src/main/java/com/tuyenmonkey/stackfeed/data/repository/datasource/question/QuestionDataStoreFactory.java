package com.tuyenmonkey.stackfeed.data.repository.datasource.question;

import com.tuyenmonkey.stackfeed.data.cache.QuestionCache;
import com.tuyenmonkey.stackfeed.data.net.StackRestApi;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class QuestionDataStoreFactory {

    private StackRestApi restApi;
    private QuestionCache questionCache;

    public QuestionDataStoreFactory(StackRestApi stackRestApi, QuestionCache questionCache) {
        this.restApi = stackRestApi;
        this.questionCache = questionCache;
    }

    public QuestionDataStore createQuestionDataStore() {
        QuestionDataStore questionDataStore;

        questionDataStore = questionCache.isExpired()
                ? new CloudQuestionDataStore(restApi) : new CacheQuestionDataStore(questionCache);

        return questionDataStore;
    }
}
