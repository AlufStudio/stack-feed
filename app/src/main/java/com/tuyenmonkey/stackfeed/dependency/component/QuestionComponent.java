package com.tuyenmonkey.stackfeed.dependency.component;

import com.tuyenmonkey.stackfeed.dependency.ViewScope;
import com.tuyenmonkey.stackfeed.dependency.module.QuestionModule;
import com.tuyenmonkey.stackfeed.presentation.main.view.QuestionListFragment;

import dagger.Subcomponent;

/**
 * Created by Tuyen Nguyen on 4/30/16.
 */
@ViewScope
@Subcomponent(modules = QuestionModule.class)
public interface QuestionComponent {

    void inject(QuestionListFragment questionListFragment);
}
