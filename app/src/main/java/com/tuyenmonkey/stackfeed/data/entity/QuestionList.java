package com.tuyenmonkey.stackfeed.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public final class QuestionList {

    @SerializedName("items")
    private List<Question> questions;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("quota_max")
    private int quotaMax;

    @SerializedName("quota_remaining")
    private int quotaRemaining;

    public QuestionList() {}

    public List<Question> getQuestions() {
        return questions;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public int getQuotaRemaining() {
        return quotaRemaining;
    }
}
