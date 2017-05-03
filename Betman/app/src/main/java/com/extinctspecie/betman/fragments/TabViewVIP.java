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

public class TabViewVIP extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_view_vip,container,false);
    }
}
