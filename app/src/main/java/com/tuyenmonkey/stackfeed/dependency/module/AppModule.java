package com.tuyenmonkey.stackfeed.dependency.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
@Module
public class AppModule {

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return this.context;
    }
}
