package com.example.myapplication.domain;

import android.content.Context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class UserService extends BaseService {

    private List<User> users = new ArrayList<>();
    private User user;

    protected UserService(Context context) {
        super(context);
    }

    public void saveUser(User user) {
        this.users.add(user);
        this.save(users, "users");
    }

    public Optional<User> findByIdAndPassword(final String username, final String password) {
        if (username == null || password == null) {
            return Optional.empty();
        }

        this.users = (List<User>)this.load(new TypeReference<List<User>>() {}, "users");

        return this.users
                .stream()
                .filter(new Predicate<User>() {
                    @Override
                    public boolean test(User user) {
                        return username.equals(user.getPassword()) && password.equals(user.getPassword());
                    }
                })
                .findFirst();
    }
     public Optional<User> getCurrentlyLoginUser() {
        this.user = (User)this.load(new TypeReference<User>() {}, "currentLoggedUser");
        return Optional.ofNullable(this.user);
     }

     public void setCurrentlyLoginUser(User user) {
         save(user, "currentLoggedUser");
        this.user = user;
     }
}
