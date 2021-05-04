package com.example.githubsearchandroid.ui.userInfo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.githubsearchandroid.R;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;
import com.example.githubsearchandroid.ui.userInfo.tabs.ViewAdapter;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserFragment extends Fragment {
    private UserViewModel viewModel;
    private TextView textView;
    private ImageView imgView;
    private PieChart pieChart;

    private ViewAdapter adapter;
    private ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);

        /*textView = root.findViewById(R.id.githubUserName);
        imgView = root.findViewById(R.id.githubUserAvatar);
        pieChart = root.findViewById(R.id.pieChart);*/

        viewModel.getSearchedUser().observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                /*textView.setText(user.getName());
                Glide.with(this).load(user.getAvatar_url()).into(imgView);
                viewModel.searchRepos(user.getLogin());*/
            }
        });

        //viewModel.getSearchedRepos().observe(getViewLifecycleOwner(), this::setUpPieChart);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        adapter = new ViewAdapter(this);
        viewPager2 = view.findViewById(R.id.view_pager);
        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.tab_title_user);
                    break;
                case 1:
                    tab.setText(R.string.tab_title_language);
                    break;
                case 2:
                    tab.setText(R.string.tab_title_hype);
                    break;
                case 3:
                    tab.setText(R.string.tab_title_stars);
                    break;
                case 4:
                    tab.setText(R.string.tab_title_forks);
                    break;
            }
                }
        ).attach();
    }
}
