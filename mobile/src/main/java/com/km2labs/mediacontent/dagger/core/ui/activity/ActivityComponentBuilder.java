package com.km2labs.mediacontent.dagger.core.ui.activity;

public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityComponent> {
    ActivityComponentBuilder<M, C> activityModule(M activityModule);

    C build();
}