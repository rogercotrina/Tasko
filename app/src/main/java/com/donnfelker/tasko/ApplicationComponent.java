package com.donnfelker.tasko;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Single Application component, avoiding subscopes.
 * Created by rogercotrina on 1/16/18.
 */

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {
    void inject(TaskoApplication target);
    void inject(MainActivity target);
}
