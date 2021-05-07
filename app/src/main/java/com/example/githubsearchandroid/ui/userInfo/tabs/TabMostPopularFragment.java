 package com.example.githubsearchandroid.ui.userInfo.tabs;

import android.graphics.Color;
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
import com.example.githubsearchandroid.data.githubapi.githubdata.GithubRepo;
import com.example.githubsearchandroid.ui.userInfo.UserViewModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabMostPopularFragment extends Fragment {
    private BarChart barChart;
    private UserViewModel viewModel;
    private HashMap<String, Integer> map;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_barchart, container, false);

        map = new HashMap<>();
        barChart = root.findViewById(R.id.tab_user_mostPopular_barChart);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        viewModel.getSearchedRepos().observe(getViewLifecycleOwner(), repos -> {
            Collections.sort(repos);

            for (int i = 0; i < 3; i++) {
                String name = repos.get(i).getName();

                if (name == null) {
                    continue;
                }

                map.put(name, repos.get(i).getStargazers_count());
            }

            setupBarChart();
        });

        return root;
    }

    private void setupBarChart() {
        barChart.clear();

        ArrayList<String> xAxisLabel = new ArrayList<>();

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        int barXAxis = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Log.i("xkey", entry.getKey());
            xAxisLabel.add(entry.getKey());
            barEntries.add(new BarEntry(barXAxis, entry.getValue()));
            barXAxis++;
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "User's top 3 most popular repos");

        BarData barData = new BarData(barDataSet);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return xAxisLabel.get((int) value - 1);
            }
        });
        xAxis.setGranularity(1);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setScaleEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawAxisLine(false);
        barChart.getAxisRight().setDrawAxisLine(false);
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getDescription().setText("Stars per repo");

        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        barData.setBarWidth(0.9f);

        barChart.setData(barData);
    }
}
