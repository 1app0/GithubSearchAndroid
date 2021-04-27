package com.example.githubsearchandroid.ui.userInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.githubsearchandroid.R;

public class UserInfoFragment extends Fragment {
    private UserInfoViewmodel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserInfoViewmodel.class);
        View root = inflater.inflate(R.layout.fragment_user_info, container, false);
        return root;
    }
}
