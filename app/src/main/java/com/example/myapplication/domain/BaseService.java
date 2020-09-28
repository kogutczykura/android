package com.example.myapplication.domain;

import android.content.Context;
import android.content.SharedPreferences;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class BaseService<T> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Context context;

    public BaseService(Context context) {
        this.context = context;
    }

    protected T load(TypeReference<T> typeReference, String key) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(UserService.class.getName(), Context.MODE_PRIVATE);
            String usersJson = sharedPreferences.getString(key, null);
            if(usersJson != null) {
                return objectMapper.readValue(
                        usersJson,
                        typeReference
                );
            }

            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load.", e);
        }
    }

    protected void save(T t, String key) {
        try {
            String usersJson = objectMapper.writeValueAsString(t);
            SharedPreferences sharedPreferences = context.getSharedPreferences(UserService.class.getName(), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, usersJson);
            editor.commit();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save.", e);
        }
    }
}
