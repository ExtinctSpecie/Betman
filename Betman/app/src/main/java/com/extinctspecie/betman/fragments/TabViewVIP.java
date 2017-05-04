package com.extinctspecie.betman.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.extinctspecie.betman.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewVIP extends Fragment
{
    private TabViewAdapterVIP tabViewAdapterVIP;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.tab_view_vip,container,false);

        tabViewAdapterVIP = new TabViewAdapterVIP(getActivity().getSupportFragmentManager() , getActivity().getApplicationContext());

        viewPager = (ViewPager) view.findViewById(R.id.vpVIPTabContainer);

        viewPager.setAdapter(tabViewAdapterVIP);

        //test commit

        viewPager.setOffscreenPageLimit(2);

        viewPagerTab = (SmartTabLayout) view.findViewById(R.id.vipTabLayout);

        viewPagerTab.setViewPager(viewPager);

        return view;
    }
}
