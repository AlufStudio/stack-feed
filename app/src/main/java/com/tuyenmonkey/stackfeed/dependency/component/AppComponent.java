package com.tuyenmonkey.stackfeed.dependency.component;

import com.tuyenmonkey.stackfeed.dependency.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
}
