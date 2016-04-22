package com.tuyenmonkey.stackfeed.data.cache;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class QuestionFileCache implements QuestionCache {

    @Override
    public boolean isExpired() {
        return true;
    }
}
