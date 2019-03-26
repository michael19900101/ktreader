package com.aotuman.ktreader.repository;

import com.aotuman.ktreader.bean.User;

import androidx.lifecycle.MediatorLiveData;

public class UserRepository {

    private MediatorLiveData<User> mObservableUser;

    public UserRepository() {
        mObservableUser = new MediatorLiveData<>();
    }
}
