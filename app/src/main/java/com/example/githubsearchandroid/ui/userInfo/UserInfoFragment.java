package com.example.githubsearchandroid.ui.userInfo;

import android.graphics.Color;
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
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.githubsearchandroid.R;
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;
import com.example.githubsearchandroid.ui.userInfo.tabs.SectionsPagerAdapter;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class UserInfoFragment extends Fragment {
    private UserInfoViewModel viewModel;
    private TextView textView;
    private ImageView imgView;
    private PieChart pieChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserInfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_info, container, false);
        //tabs setup
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getChildFragmentManager());
        ViewPager viewPager = root.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = root.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

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

        viewModel.getSearchedRepos().observe(getViewLifecycleOwner(), this::setUpPieChart);

        return root;
    }

    public void setUpPieChart(List<GithubRepo> githubRepos) {
        pieChart.clear();

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        for (GithubRepo repo : githubRepos) {
            if (repo.getLanguage() != null) {
                pieEntries.add(new PieEntry(1, repo.getLanguage()));
            }
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Letters");

        PieData data = new PieData((dataSet));

        pieChart.setData(data);
    }
}
