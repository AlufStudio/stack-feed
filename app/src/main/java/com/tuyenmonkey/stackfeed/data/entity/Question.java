package com.tuyenmonkey.stackfeed.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public final class Question {

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("is_answered")
    private boolean isAnswered;

    @SerializedName("view_count")
    private int viewCount;

    @SerializedName("score")
    private int score;

    @SerializedName("last_activity_date")
    private long lastActivityDate;

    @SerializedName("creation_date")
    private long creationDate;

    @SerializedName("last_edit_date")
    private long lastEditDate;

    @SerializedName("question_id")
    private long questionId;

    @SerializedName("link")
    private String link;

    @SerializedName("title")
    private String title;

    public Question() {}

    public List<String> getTags() {
        return tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getScore() {
        return score;
    }

    public long getLastActivityDate() {
        return lastActivityDate;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public long getLastEditDate() {
        return lastEditDate;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }
}
