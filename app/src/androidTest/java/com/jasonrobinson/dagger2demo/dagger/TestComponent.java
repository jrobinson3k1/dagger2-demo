package com.jasonrobinson.dagger2demo.dagger;

import com.jasonrobinson.dagger2demo.ui.MainActivityTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestTimeModule.class)
public interface TestComponent extends DemoComponent {
    void inject(MainActivityTest obj);
}
