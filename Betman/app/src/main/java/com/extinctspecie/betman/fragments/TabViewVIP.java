package com.extinctspecie.betman.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
    private static boolean sub = false;
    private Button btnSub;
    ViewGroup container;
    View tabVipView;
    View subFalseLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        // Get view
        tabVipView = inflater.inflate(R.layout.tab_view_vip,container,false);

        /////
        // Init views
        /////
        btnSub = (Button) tabVipView.findViewById(R.id.btnSub);
        viewPager = (ViewPager) tabVipView.findViewById(R.id.vpVIPTabContainer);
        viewPagerTab = (SmartTabLayout) tabVipView.findViewById(R.id.vipTabLayout);


        // Create and set a new adapter for sub-tabs
        tabViewAdapterVIP = new TabViewAdapterVIP(getActivity().getSupportFragmentManager(), getActivity().getApplicationContext());
        viewPager.setAdapter(tabViewAdapterVIP);
        viewPager.setOffscreenPageLimit(2);
        viewPagerTab.setViewPager(viewPager);


        registerSubButton();

        return tabVipView;

    }

    private void registerSubButton() {

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                tabVipView.findViewById(R.id.noSubLayout).setVisibility(View.GONE);
                tabVipView.findViewById(R.id.subLayout).setVisibility(View.VISIBLE);
            }
        });


    }

}
