package com.ovidos.docket.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.ovidos.docket.R;
import com.ovidos.docket.adapters.pager.PagerAdapter;
import com.ovidos.docket.core.activity.BaseActivity;
import com.ovidos.docket.ui.NonSwipeableViewPager;
import com.ovidos.docket.utils.Keyboard;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements AHBottomNavigation.OnTabSelectedListener{

    @BindView(R.id.viewPager)
    NonSwipeableViewPager mViewPager;
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation mBottomNavigation;

    private AHNotification notification;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        setUpBottomBar();
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }

    void setUpBottomBar() {
        AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation);
        navigationAdapter.setupWithBottomNavigation(mBottomNavigation);
        notification = new AHNotification.Builder()
                .setText(" ")
                .build();
        mBottomNavigation.setNotificationMarginLeft(20, 20);
        mBottomNavigation.setAccentColor(ContextCompat.getColor(mContext, R.color.black_title));
        mBottomNavigation.setInactiveColor(ContextCompat.getColor(mContext, R.color.black_title_50));
        mBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        mBottomNavigation.setOnTabSelectedListener(this);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {

        if (!wasSelected) {
            mViewPager.setCurrentItem(position, false);
        }
        Keyboard.hideSoftKeyboard(this);

        return true;
    }
}