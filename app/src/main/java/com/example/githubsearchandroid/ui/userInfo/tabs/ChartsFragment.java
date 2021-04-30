package com.example.githubsearchandroid.ui.userInfo.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.githubsearchandroid.R;

public class ChartsFragment extends Fragment {
    public static final String SECTION_NUMBER = "section_number";

    public static ChartsFragment newInstance(int index) {
        ChartsFragment fragment = new ChartsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_charts, container, false);
        return root;
    }
}
