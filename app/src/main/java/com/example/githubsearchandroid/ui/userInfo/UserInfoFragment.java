package com.example.githubsearchandroid.ui.userInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.githubsearchandroid.R;

public class UserInfoFragment extends Fragment {
    private UserInfoViewModel viewModel;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserInfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_info, container, false);

        textView = root.findViewById(R.id.textView2);

        viewModel.getSearchedUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                textView.setText(user.getName());
            }
        });

        return root;
    }
}
