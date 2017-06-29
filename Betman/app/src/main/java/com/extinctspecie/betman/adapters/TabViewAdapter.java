package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.fragments.TabViewHistory;
import com.extinctspecie.betman.fragments.TabViewNewsFeed;
import com.extinctspecie.betman.fragments.TabViewToday;
import com.extinctspecie.betman.fragments.TabViewVIP;
import com.extinctspecie.betman.fragments.TabViewVIPLive;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewAdapter extends FragmentStatePagerAdapter
{
    private final int maxTabViews = 4;
    private final TabViewNewsFeed tabViewNewsFeed = new TabViewNewsFeed();
    private final TabViewToday tabViewToday = new TabViewToday();
    private final TabViewVIP tabViewVIP = new TabViewVIP();

    private final TabViewHistory tabViewHistory = new TabViewHistory();
    private Context context;


    public TabViewAdapter(FragmentManager fm , Context context)
    {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position) {
            case 0:
                return tabViewNewsFeed;
            case 1:
                return tabViewToday;
            case 2:
                return tabViewVIP;
            case 3:
                return tabViewHistory;
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        Drawable myDrawable = null;

        switch (position) {
            case 0:
            {
                return "News";
            }
            case 1:
            {
                return "Free";
//                myDrawable = context.getResources().getDrawable(R.mipmap.ic_today_black_24dp);
//                break;
            }
            case 2:
            {
                return "VIP";
//                myDrawable = context.getResources().getDrawable(R.mipmap.ic_vip_black_24dp);
//                break;
            }
            case 3:
            {
                //myDrawable = context.getResources().getDrawable(R.mipmap.ic_history_black_24dp);
                return "History";
                //break;
            }
        }

//        SpannableStringBuilder sb = new SpannableStringBuilder("     "); // space added before text for convenience
//        myDrawable.setBounds(5, 5, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
//        ImageSpan span = new ImageSpan(myDrawable, DynamicDrawableSpan.ALIGN_BASELINE);
//        sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        return sb;

        return null;
    }

    @Override
    public int getCount()
    {
        return maxTabViews;
    }

    public TabViewToday getTabViewToday() {
        return tabViewToday;
    }

    public TabViewVIP getTabViewVIP() {
        return tabViewVIP;
    }
    public TabViewHistory getTabViewHistory() {
        return tabViewHistory;
    }
}
