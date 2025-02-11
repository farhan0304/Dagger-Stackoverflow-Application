package com.example.distackoverflowapplication;

import android.app.Application;

import com.example.distackoverflowapplication.dependencyInjection.CompositionRoot;


public class MyApplication extends Application {

    CompositionRoot compositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}
