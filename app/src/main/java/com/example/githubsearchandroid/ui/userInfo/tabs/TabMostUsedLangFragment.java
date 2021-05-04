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
import com.example.githubsearchandroid.ui.userInfo.UserFragment;
import com.example.githubsearchandroid.ui.userInfo.UserViewModel;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabMostUsedLangFragment extends Fragment {
    private PieChart pieChart;
    private UserViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_piechart, container, false);

        pieChart = root.findViewById(R.id.tab_user_languages_piechart);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        Log.i("heello", "hi");
        viewModel.getSearchedRepos().observe(getViewLifecycleOwner(), this::setupPieChart);

        return root;
    }

    private void setupPieChart(List<GithubRepo> githubRepos) {
        pieChart.clear();

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (GithubRepo repo : githubRepos) {
            String language = repo.getLanguage();

            if (language == null) {
                continue;
            }

            if (map.containsKey(language)) {
                map.put(language, map.get(language) + 1);
            } else {
                map.put(language, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pieEntries.add(new PieEntry(entry.getValue(), entry.getKey()));
        }


        PieDataSet dataSet = new PieDataSet(pieEntries, "");

        PieData data = new PieData((dataSet));

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDrawHoleEnabled(false);
        pieChart.animateY(1000, Easing.EaseInOutCubic);

        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLUE);

        Description description = new Description();
        description.setText("User's most used languages");
        description.setTextSize(15);
        pieChart.setDescription(description);

        pieChart.setData(data);
    }
}
