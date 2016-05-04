package com.tuyenmonkey.stackfeed.presentation.main.viewmodel;

import com.tuyenmonkey.stackfeed.base.BaseViewModel;
import com.tuyenmonkey.stackfeed.data.entity.Question;

import java.util.Date;

/**
 * Created by Tuyen Nguyen on 5/3/16.
 */
public class QuestionItemViewModel extends BaseViewModel {

    private Question question;

    public QuestionItemViewModel(Question question) {
        this.question = question;
    }

    public String getTitle() {
        return question.getTitle();
    }

    public String getCreationDate() {
        Date date = new Date(this.question.getCreationDate() * 1000);
        return date.toString();
    }
}
