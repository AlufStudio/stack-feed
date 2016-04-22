package com.tuyenmonkey.stackfeed.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public final class Owner {

    @SerializedName("reputation")
    private int reputation;

    @SerializedName("user_id")
    private long userId;

    @SerializedName("user_type")
    private String userType;

    @SerializedName("accept_rate")
    private int acceptRate;

    @SerializedName("profile_image")
    private String profileImage;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("link")
    private String link;

    public Owner() {}

    public int getReputation() {
        return reputation;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLink() {
        return link;
    }
}
