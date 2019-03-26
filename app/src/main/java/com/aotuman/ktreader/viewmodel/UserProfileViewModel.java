package com.aotuman.ktreader.viewmodel;

import com.aotuman.ktreader.bean.User;
import com.aotuman.ktreader.repository.UserRepository;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {
    private String userId;
//    private User user;

    //初始化传递uid进来
    public void init(String userId) {
        this.userId = userId;
    }
    //提供完整的用户信息
//    public User getUser() {
//        return user;
//    }

    private UserRepository userRepository;

    public UserProfileViewModel() {
        user = new MediatorLiveData<>();
    }

    private MutableLiveData<User> user;

    public MutableLiveData<User> getUser() {
        return user;
    }
}