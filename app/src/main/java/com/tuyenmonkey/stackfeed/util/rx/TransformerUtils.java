package com.tuyenmonkey.stackfeed.util.rx;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Tuyen Nguyen on 4/23/16.
 */
public class TransformerUtils {

    public static <T> Observable.Transformer<T, T> applySchedulers(final Scheduler mainScheduler,
                                                                   final Scheduler workerScheduler) {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(workerScheduler)
                        .observeOn(mainScheduler)
                        .unsubscribeOn(workerScheduler);
            }
        };
    }
}
