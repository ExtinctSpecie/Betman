package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.extinctspecie.betman.models.HistoryItem;
import com.extinctspecie.betman.models.TodayItem;

import java.util.List;

/**
 * Created by WorkSpace on 5/4/2017.
 */

public class LVAdapterTVHistory extends BaseAdapter
{

    private Context context;
    private List<HistoryItem> historyItems;
    private LayoutInflater layoutInflater;
    private HistoryItem item ;

    public LVAdapterTVHistory(Context context , List<HistoryItem> historyItems)
    {
        this.historyItems = historyItems;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
