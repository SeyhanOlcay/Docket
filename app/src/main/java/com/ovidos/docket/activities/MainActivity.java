package com.ovidos.docket.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.ovidos.docket.R;
import com.ovidos.docket.core.activity.BaseActivity;
import com.ovidos.docket.utils.Keyboard;
import com.ovidos.docket.utils.Prefs;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements AHBottomNavigation.OnTabSelectedListener{

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
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
    }

    void setUpBottomBar() {
        AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation);
        navigationAdapter.setupWithBottomNavigation(mBottomNavigation);
        notification = new AHNotification.Builder()
                .setText(" ")
                .build();
        if (Prefs.getNotificationStatus(mContext))
            mBottomNavigation.setNotification(notification, 2);
        mBottomNavigation.setNotificationMarginLeft(20, 20);
        //mBottomNavigation.setNotificationBackground(ContextCompat.getDrawable(mContext, R.drawable.ic_ticket_status_closed));
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
        if (position == 2){
            mBottomNavigation.setNotification("", 2);
            Prefs.setNotificationStatus(mContext, false);
        }

        Keyboard.hideSoftKeyboard(this);

        return true;
    }
}