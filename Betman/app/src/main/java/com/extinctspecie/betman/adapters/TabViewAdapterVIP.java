package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.extinctspecie.betman.fragments.TabViewVIPLive;
import com.extinctspecie.betman.fragments.TabViewVIPTips;

/**
 * Created by WorkSpace on 5/4/2017.
 */

public class TabViewAdapterVIP extends FragmentStatePagerAdapter
{
    private final int maxTabViews = 1;
    private final TabViewVIPTips tabViewVIPTips = new TabViewVIPTips();
    private final TabViewVIPLive tabViewVIPLive = new TabViewVIPLive();
    private Context context;

    public TabViewAdapterVIP(FragmentManager fm , Context context)
    {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return tabViewVIPTips;
//            case 1:
//                return tabViewVIPLive;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return maxTabViews;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tips";
//            case 1:
//                return "Live";
            default:
                return null;
        }

    }
}
