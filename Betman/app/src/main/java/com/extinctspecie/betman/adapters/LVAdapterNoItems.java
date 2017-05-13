package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Log;

/**
 * Created by WorkSpace on 5/13/2017.
 */

public class LVAdapterNoItems extends BaseAdapter {

    private String TAG = this.getClass().getSimpleName();
    private Context context;
    private LayoutInflater layoutInflater;
    public LVAdapterNoItems(Context context)
    {
        Log.v(TAG, "constructor called");

        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 1;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.no_items_available, null);
    }
}
