package com.tuyenmonkey.stackfeed.domain.interactor.question;

import com.tuyenmonkey.stackfeed.data.repository.QuestionRepository;
import com.tuyenmonkey.stackfeed.domain.interactor.UseCase;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class GetQuestionListUseCase extends UseCase {

    private final QuestionRepository questionRepository;

    public GetQuestionListUseCase(Scheduler mainScheduler, Scheduler workerScheduler,
                                  QuestionRepository questionRepository) {
        super(mainScheduler, workerScheduler);
        this.questionRepository = questionRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.questionRepository.getQuestions();
    }
}
