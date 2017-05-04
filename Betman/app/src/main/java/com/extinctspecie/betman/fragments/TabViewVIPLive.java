package com.extinctspecie.betman.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.extinctspecie.betman.LVAdapterTVBookmarked;
import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Log;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewVIPLive extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_view_vip_live,container,false);
        return  view;
    }
}
