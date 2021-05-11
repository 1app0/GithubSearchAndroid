    package com.example.githubsearchandroid.ui.userInfo.tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.githubsearchandroid.R;
import com.example.githubsearchandroid.data.FavData.FavUser;
import com.example.githubsearchandroid.ui.userInfo.UserViewModel;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

    public class TabInfoFragment extends Fragment {
    private UserViewModel viewModel;

    private TextView usernameView;
    private ImageView avatarView;
    private TextView nrRepos;
    private TextView nrFollowers;
    private TextView nrFollowing;
    private Button switchButton;

    private String username;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_user_info, container, false);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        usernameView = root.findViewById(R.id.userInfo_usernameTextView);
        avatarView = root.findViewById(R.id.userInfo_avatarImgView);
        nrRepos = root.findViewById(R.id.number_of_repos_textView);
        nrFollowers = root.findViewById(R.id.number_of_followers_textView);
        nrFollowing = root.findViewById(R.id.number_of_following_textView);
        switchButton = root.findViewById(R.id.switchButton);



        viewModel.getSearchedUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                username = user.getLogin();
                usernameView.setText(user.getName());
                nrRepos.setText(user.getNumberOfRepos() + " Repos");
                nrFollowers.setText(user.getNumberOfFollowers() + " Followers");
                nrFollowing.setText(user.getFollowing() + " Following");
                Glide.with(this).load(user.getAvatar_url()).into(avatarView);
                viewModel.searchRepos(user.getLogin());

                viewModel.getDbRef().orderByChild("body").equalTo(username)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    switchButton.setText("Unfavorite");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
            }
        });

        switchButton.setOnClickListener(v -> {
            viewModel.saveFavUser(username);
            switchButton.setText("Unfavorite");
            //TODO actually remove someone from favorite list
        });

        return root;
    }
}
