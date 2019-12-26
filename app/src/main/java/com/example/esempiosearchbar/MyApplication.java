package com.example.esempiosearchbar;

import android.app.Application;

import io.realm.Realm;

public class MyApplication extends Application {

    //Authentication variables
    Realm realm;

    public static final String INSTANCE_ADDRESS = "exerciseexchange.us1.cloud.realm.io";
    public static final String AUTH_URL = "https://" + INSTANCE_ADDRESS + "/auth";
    public static final String REALM_URL = "realms://" + INSTANCE_ADDRESS + "/Exercise_Exchange_2";
    public static final String username = "Gabriele";
    public static final String password = "password";
    public static final boolean createUser = false;


    @Override
    public void onCreate(){
        super.onCreate();

        realm.init(this);

    }
}