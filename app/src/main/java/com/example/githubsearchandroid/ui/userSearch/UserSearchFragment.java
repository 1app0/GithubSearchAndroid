package com.example.githubsearchandroid.ui.userSearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.githubsearchandroid.R;

public class UserSearchFragment extends Fragment {
    private UserSearchViewmodel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserSearchViewmodel.class);
        View root = inflater.inflate(R.layout.fragment_user_search, container, false);
        Button button = root.findViewById(R.id.letsgo);
        button.setOnClickListener(v -> {
            NavDirections action = UserSearchFragmentDirections.actionNavigationHomeToNavigationUserInfo();
            Navigation.findNavController(v).navigate(action);
        });
        return root;
    }

}
