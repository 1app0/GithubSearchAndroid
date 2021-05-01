package com.example.githubsearchandroid.ui.userInfo.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.githubsearchandroid.R;
import com.example.githubsearchandroid.ui.userInfo.UserViewModel;

public class TabContactFragment extends Fragment {
    private UserViewModel viewModel;
    private TextView usernameTextView;
    private TextView twitterUsernameTextView;
    private ImageView avatarImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_user_contact, container, false);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        usernameTextView = root.findViewById(R.id.userContact_usernameTextView);
        twitterUsernameTextView = root.findViewById(R.id.userContact_twitterTextView);
        avatarImageView = root.findViewById(R.id.userContact_avatarImg);

        viewModel.getSearchedUser().observe(getViewLifecycleOwner(), user -> {
            usernameTextView.setText(user.getName());
            Glide.with(this).load(user.getAvatar_url()).into(avatarImageView);
            twitterUsernameTextView.setText(user.getTwitter_username() != null ? "@" + user.getTwitter_username() : "@Someone");
        });

        return root;
    }
}
