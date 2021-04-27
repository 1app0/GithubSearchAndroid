package com.example.githubsearchandroid.ui.userSearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.githubsearchandroid.R;

public class UserSearchFragment extends Fragment {
    private UserSearchViewmodel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserSearchViewmodel.class);
        View root = inflater.inflate(R.layout.fragment_user_search, container, false);
        return root;
    }
}
