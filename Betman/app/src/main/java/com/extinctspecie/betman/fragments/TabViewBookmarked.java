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
import com.extinctspecie.betman.LVAdapterTVToday;
import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.models.TodayItem;

import java.util.List;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewBookmarked extends Fragment
{
    private TextView tvVs;
    private String TAG = this.getClass().getSimpleName();
    private ListView listView;
    private static LVAdapterTVBookmarked lvAdapterTVBookmarked;

    //on destroy method will return to onCreateView instead of onCreate
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_view_bookmarked,container,false);

        listView = (ListView) view.findViewById(R.id.lvTVBookmarked);

        lvAdapterTVBookmarked = new LVAdapterTVBookmarked();

        listView.setAdapter(lvAdapterTVBookmarked);
        //populateListView(view);

        return view;
    }

    private void populateListView(View view)
    {
        if(LVAdapterTVBookmarked.getItemList().size() > 1)
        {
            lvAdapterTVBookmarked = new LVAdapterTVBookmarked();

        }
        else
        {
            Log.v(TAG,"Need to add items before setting the adapter");
        }
    }

    public static void addView(View view)
    {
        LVAdapterTVBookmarked.addView(view);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

               lvAdapterTVBookmarked.notifyDataSetChanged();

        } else {
        }
    }
}
