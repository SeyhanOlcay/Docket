package com.ovidos.docket.adapters.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ovidos.docket.fragments.FavoritesFragment;
import com.ovidos.docket.fragments.NewsFragment;
import com.ovidos.docket.fragments.SettingsFragment;
import com.ovidos.docket.fragments.SubscriptionsFragment;
import com.ovidos.docket.fragments.VideosFragment;

/**
 * Created by omral on 30.05.2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    public static int NUM_ITEMS = 5;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewsFragment.newInstance();
            case 1:
                return FavoritesFragment.newInstance();
            case 2:
                return VideosFragment.newInstance();
            case 3:
                return SubscriptionsFragment.newInstance();
            case 4:
                return SettingsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
