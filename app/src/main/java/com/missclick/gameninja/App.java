package com.missclick.gameninja;

import android.app.Application;

import com.missclick.gameninja.dependencies.AppComponent;
import com.missclick.gameninja.dependencies.DaggerAppComponent;
import com.missclick.gameninja.dependencies.modules.AppModule;

public class App extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initializeDagger();
    }

    private AppComponent initializeDagger(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
