package com.example.danfo;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("NSJtu9v2bOLmrnCMy7pupjcl8Q9Y5YTqM6pvnwg8")
                // if desired
                .clientKey("4oRyiLKfpCX7X2eAUePLdUzFKGQHycA5inBL8Ght")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
