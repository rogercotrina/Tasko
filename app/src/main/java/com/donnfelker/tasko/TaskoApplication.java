package com.donnfelker.tasko;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public abstract class TaskoApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        // Configure Realm for the application
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("tasko.realm")
                .build();
        Realm.deleteRealm(realmConfiguration); // Clean slate
        Realm.setDefaultConfiguration(realmConfiguration); // Make this Realm the default
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
