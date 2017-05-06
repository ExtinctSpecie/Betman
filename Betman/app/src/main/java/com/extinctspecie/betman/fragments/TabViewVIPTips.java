package com.extinctspecie.betman.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.extinctspecie.betman.adapters.LVAdapterTVVIPTips;
import com.extinctspecie.betman.R;

/**
 * Created by WorkSpace on 5/4/2017.
 */

public class TabViewVIPTips extends Fragment
{
    private TextView tvVs;
    private String TAG = this.getClass().getSimpleName();
    private ListView listView;
    private static LVAdapterTVVIPTips lvAdapterTVVIPTips;

    //on destroy method will return to onCreateView instead of onCreate
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_view_vip_tips,container,false);

        listView = (ListView) view.findViewById(R.id.lvTVBookmarked);

        lvAdapterTVVIPTips = new LVAdapterTVVIPTips();

        listView.setAdapter(lvAdapterTVVIPTips);
        //populateListView(tabVipView);

        return view;
    }


}
