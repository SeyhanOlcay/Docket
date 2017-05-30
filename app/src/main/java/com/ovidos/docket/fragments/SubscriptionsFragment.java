package com.ovidos.docket.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ovidos.docket.R;
import com.ovidos.docket.core.fragment.BaseFragment;

/**
 * Created by omral on 30.05.2017.
 */

public class SubscriptionsFragment extends BaseFragment{

    public static SubscriptionsFragment newInstance() {
        return new SubscriptionsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriptions, container, false);

        return view;
    }
}
