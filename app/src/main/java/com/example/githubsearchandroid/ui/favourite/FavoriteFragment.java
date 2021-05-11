package com.example.githubsearchandroid.ui.favourite;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.githubsearchandroid.R;
import com.example.githubsearchandroid.data.FavData.FavUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {
    private FavoriteViewModel viewModel;
    private List<FavUser> favUserList;
    private DatabaseReference dbRef;

    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            favUserList.clear();

            for (DataSnapshot snap: snapshot.getChildren()) {
                FavUser favUser = snap.getValue(FavUser.class);
                Log.i("favUserList", favUser.getBody());
                favUserList.add(favUser);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favourite, container, false);

        favUserList = new ArrayList<>();
        dbRef = viewModel.getDbRef();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        dbRef.addValueEventListener(listener);
    }

    @Override
    public void onPause() {
        super.onPause();
        dbRef.removeEventListener(listener);
    }
}
