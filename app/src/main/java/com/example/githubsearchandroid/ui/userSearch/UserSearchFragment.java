package com.example.githubsearchandroid.ui.userSearch;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.githubsearchandroid.R;

public class UserSearchFragment extends Fragment {
    private UserSearchViewModel viewModel;
    private EditText searchField;
    private Button searchUser;

    private String username;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_search, container, false);

        searchUser = root.findViewById(R.id.search_user);
        searchField = root.findViewById(R.id.search_field);

        searchUser.setOnClickListener(v -> {
            username = searchField.getText().toString();

            NavDirections action = UserSearchFragmentDirections.actionNavigationHomeToNavigationUserInfo(username);
            Navigation.findNavController(v).navigate(action);

            searchField.setText("");
        });

        return root;
    }
}
