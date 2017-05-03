package com.extinctspecie.betman;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.extinctspecie.betman.helpers.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WorkSpace on 5/3/2017.
 */

public class LVAdapterTVBookmarked extends BaseAdapter
{
    private static List<View> itemList;


    public LVAdapterTVBookmarked()
    {
        itemList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        Log.v("ADAPTER","getting item size : " + itemList.size());
        return itemList.get(i);
    }
    public static void addView(View view)
    {
        itemList.add(view);
    }
    public static List<View> getItemList()
    {
        return itemList;
    }


}
