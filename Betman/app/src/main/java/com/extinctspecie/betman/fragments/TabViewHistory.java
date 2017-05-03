package com.extinctspecie.betman.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.extinctspecie.betman.R;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewHistory extends Fragment
{
    //on destroy method will return to onCreateView instead of onCreate
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_view_history,container,false);

        return view;
    }
}
