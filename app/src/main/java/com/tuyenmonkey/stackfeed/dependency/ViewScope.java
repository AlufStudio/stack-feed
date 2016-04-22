package com.tuyenmonkey.stackfeed.dependency;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
@Scope
@Retention(RUNTIME)
public @interface ViewScope {}
