package com.jasonrobinson.dagger2demo;

import android.app.Application;

import com.jasonrobinson.dagger2demo.dagger.DaggerApplicationComponent;
import com.jasonrobinson.dagger2demo.dagger.DemoComponent;

public class DemoApplication extends Application {

    private DemoComponent mDemoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mDemoComponent == null) {
            mDemoComponent = DaggerApplicationComponent.create();
        }
    }

    public DemoComponent component() {
        return mDemoComponent;
    }

    public void setComponent(DemoComponent demoComponent) {
        mDemoComponent = demoComponent;
    }
}
