package com.tuyenmonkey.stackfeed.data.net;

import com.tuyenmonkey.stackfeed.data.entity.QuestionList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public interface StackRestApi {

    String BASE_URL = "https://api.stackexchange.com/2.2/";

    @GET("questions?order=desc&sort=activity&site=stackoverflow")
    Observable<QuestionList> getQuestions();
}
