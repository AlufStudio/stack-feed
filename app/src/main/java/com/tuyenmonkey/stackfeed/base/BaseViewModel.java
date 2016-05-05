package com.tuyenmonkey.stackfeed.base;

import android.databinding.BaseObservable;

import com.tuyenmonkey.stackfeed.util.StateView;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by Tuyen Nguyen on 5/3/16.
 */
public abstract class BaseViewModel extends BaseObservable {

    protected BehaviorSubject<StateView> viewBehavior = BehaviorSubject.create();

    public Observable<StateView> getViewBehaviorObservable() {
        return viewBehavior.asObservable();
    }
}
