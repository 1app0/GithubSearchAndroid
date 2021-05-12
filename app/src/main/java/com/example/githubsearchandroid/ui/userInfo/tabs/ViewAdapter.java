package com.example.githubsearchandroid.ui.userInfo.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewAdapter extends FragmentStateAdapter {
    private String username;

    public ViewAdapter(Fragment fragment, String username) {
        super(fragment);
        this.username = username;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new TabInfoFragment(username);
            case 1:
                return new TabContactFragment();
            case 2:
                return new TabMostUsedLangFragment();
            case 3:
                return new TabMostPopularFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
