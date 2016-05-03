package com.tuyenmonkey.stackfeed.dependency.module;

import com.tuyenmonkey.stackfeed.data.cache.QuestionCache;
import com.tuyenmonkey.stackfeed.data.cache.QuestionFileCache;
import com.tuyenmonkey.stackfeed.data.net.StackRestApi;
import com.tuyenmonkey.stackfeed.data.repository.QuestionDataRepository;
import com.tuyenmonkey.stackfeed.data.repository.QuestionRepository;
import com.tuyenmonkey.stackfeed.data.repository.datasource.question.QuestionDataStore;
import com.tuyenmonkey.stackfeed.data.repository.datasource.question.QuestionDataStoreFactory;
import com.tuyenmonkey.stackfeed.dependency.ViewScope;
import com.tuyenmonkey.stackfeed.domain.interactor.question.GetQuestionListUseCase;
import com.tuyenmonkey.stackfeed.presentation.main.viewmodel.QuestionListViewModel;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Tuyen Nguyen on 4/30/16.
 */
@Module
public class QuestionModule {

    @ViewScope
    @Provides
    StackRestApi provideStackRestApi(Retrofit retrofit) {
        return retrofit.create(StackRestApi.class);
    }

    @ViewScope
    @Provides
    QuestionCache provideQuestionCache() {
        return new QuestionFileCache();
    }

    @ViewScope
    @Provides
    QuestionDataStore provideQuestionDataStore(StackRestApi restApi, QuestionCache questionCache) {
        QuestionDataStoreFactory factory = new QuestionDataStoreFactory(restApi, questionCache);
        return factory.createQuestionDataStore();
    }

    @ViewScope
    @Provides
    QuestionRepository provideQuestionRepository(QuestionDataStore dataStore) {
        return new QuestionDataRepository(dataStore);
    }

    @ViewScope
    @Provides
    GetQuestionListUseCase provideGetQuestionListUseCase(QuestionRepository questionRepository) {
        return new GetQuestionListUseCase(AndroidSchedulers.mainThread(), Schedulers.io(), questionRepository);
    }

    @ViewScope
    @Provides
    QuestionListViewModel provideQuestionListViewModel(GetQuestionListUseCase getQuestionListUseCase) {
        return new QuestionListViewModel(getQuestionListUseCase);
    }
}
