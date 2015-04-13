package com.jasonrobinson.dagger2demo.dagger;

import com.jasonrobinson.dagger2demo.Clock;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestTimeModule {

    @Singleton
    @Provides
    Clock providesClock() {
        return Mockito.mock(Clock.class);
    }
}
