package com.tuyenmonkey.stackfeed;

import android.app.Application;
import android.content.Context;

import com.tuyenmonkey.stackfeed.data.net.StackRestApi;
import com.tuyenmonkey.stackfeed.dependency.component.AppComponent;
import com.tuyenmonkey.stackfeed.dependency.component.DaggerAppComponent;
import com.tuyenmonkey.stackfeed.dependency.module.AppModule;
import com.tuyenmonkey.stackfeed.dependency.module.NetModule;

/**
 * Created by Tuyen Nguyen on 4/22/16.
 */
public class SfApp extends Application {

    private static Context context;
    private AppComponent appComponent;

    public static SfApp getApp() {
        return (SfApp)context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initializeInjector();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initializeInjector() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(StackRestApi.BASE_URL))
                .build();
    }
}
