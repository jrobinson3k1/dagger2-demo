package com.jasonrobinson.dagger2demo.dagger;

import com.jasonrobinson.dagger2demo.Clock;

import dagger.Module;
import dagger.Provides;

@Module
public class TimeModule {

    @Provides
    Clock providesClock() {
        return new Clock();
    }
}
