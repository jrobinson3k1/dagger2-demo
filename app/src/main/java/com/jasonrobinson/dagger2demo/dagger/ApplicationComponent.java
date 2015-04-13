package com.jasonrobinson.dagger2demo.dagger;

import dagger.Component;

@Component(modules = TimeModule.class)
public interface ApplicationComponent extends DemoComponent {
}
