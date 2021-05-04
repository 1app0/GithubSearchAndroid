package com.example.githubsearchandroid.ui.userInfo.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewAdapter extends FragmentStateAdapter {

    public ViewAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new TabContactFragment();
        } else if (position == 2) {
            return new MostUsedLanguagesFragment();
        }
        return new TabInfoFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
