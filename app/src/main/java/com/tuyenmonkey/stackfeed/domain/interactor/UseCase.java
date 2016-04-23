package com.tuyenmonkey.stackfeed.domain.interactor;

import com.tuyenmonkey.stackfeed.util.rx.TransformerUtils;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public abstract class UseCase {

    private final Scheduler mainScheduler;
    private final Scheduler workerScheduler;
    private Subscription subscription = Subscriptions.empty();

    public UseCase(Scheduler mainScheduler, Scheduler workerScheduler) {
        this.mainScheduler = mainScheduler;
        this.workerScheduler = workerScheduler;
    }

    protected abstract Observable buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(Action1 successAction, Action1<Throwable> errorAction) {
        this.subscription = buildUseCaseObservable()
                .compose(TransformerUtils.applySchedulers(mainScheduler, workerScheduler))
                .subscribe(successAction, errorAction);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
