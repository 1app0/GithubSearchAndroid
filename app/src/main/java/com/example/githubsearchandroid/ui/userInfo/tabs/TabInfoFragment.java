    package com.example.githubsearchandroid.ui.userInfo.tabs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private String searchedGithubUsername;
    private final String username;
    private Boolean isFavorite;

    private DatabaseReference dbRef;

    public TabInfoFragment(String username) {
        this.username = username;
    }

    @SuppressLint("SetTextI18n")
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

        dbRef = viewModel.getDbRef();

        isFavorite = false;

        viewModel.searchUser(username);

        viewModel.getSearchedUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                searchedGithubUsername = user.getLogin();
                usernameView.setText(user.getName());
                nrRepos.setText(user.getNumberOfRepos() + " " + getString(R.string.tab_user_info_setText_repos));
                nrFollowers.setText(user.getNumberOfFollowers() + " " + getString(R.string.tab_user_info_setText_followers));
                nrFollowing.setText(user.getFollowing() + " " + getString(R.string.tab_user_info_setText_following));
                Glide.with(this).load(user.getAvatar_url()).into(avatarView);
                viewModel.searchRepos(user.getLogin());

                dbRef.orderByChild("body").equalTo(searchedGithubUsername)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    isFavorite = true;
                                    switchButton.setText(R.string.tab_user_info_unfavorite);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
            }
        });

        switchButton.setOnClickListener(v -> {
            if (isFavorite) {
                Query userQuery = dbRef.orderByChild("body").equalTo(searchedGithubUsername);
                userQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snap: snapshot.getChildren()) {
                            snap.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

                Toast.makeText(getContext(), searchedGithubUsername + " has been removed from favorites", Toast.LENGTH_SHORT).show();
                isFavorite = false;
                switchButton.setText(R.string.tab_user_info_favorite);
            } else {
                viewModel.saveFavUser(searchedGithubUsername);
                Toast.makeText(getContext(), searchedGithubUsername + " has been added to favorites", Toast.LENGTH_SHORT).show();
                isFavorite = true;
                switchButton.setText(R.string.tab_user_info_unfavorite);
            }
        });

        return root;
    }
}
