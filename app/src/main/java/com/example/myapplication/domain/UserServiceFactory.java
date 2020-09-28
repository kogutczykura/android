package com.example.myapplication.domain;

import android.content.Context;

public class UserServiceFactory {
    private static UserService instance;

    public static UserService getInstance(Context context) {
        if(instance == null) {
            instance = new UserService(context);
        }
        return instance;
    }
}
