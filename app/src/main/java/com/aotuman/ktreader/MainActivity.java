package com.aotuman.ktreader;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aotuman.ktreader.bean.User;
import com.aotuman.ktreader.viewmodel.UserProfileViewModel;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button =  findViewById(R.id.button);

        // 获取ViewModel实例
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);

        // 创建更新UI的观察者
        final Observer<User> userObserver = new Observer<User>() {
            @Override
            public void onChanged(@Nullable final User user) {
                // 更新UI
                textView.setText(user.getName());
            }
        };

        // 观察LiveData
        viewModel.getUser().observe(this, userObserver);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiveData<User> userLiveData = viewModel.getUser();
                User user = new User();
                user.setName("小红"+ new Random().nextInt(10));
                user.setAge(18);
                ((MutableLiveData<User>) userLiveData).setValue(user);
            }
        });
    }
}
