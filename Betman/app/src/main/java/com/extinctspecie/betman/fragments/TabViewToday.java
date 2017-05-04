package com.extinctspecie.betman.fragments;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.extinctspecie.betman.LVAdapterTVBookmarked;
import com.extinctspecie.betman.LVAdapterTVToday;
import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.models.TodayItem;
import com.extinctspecie.betman.services.ITodayService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewToday extends Fragment {

    private TextView tvVs;
    private String TAG = this.getClass().getSimpleName();
    private List<TodayItem> todayItems;
    private ListView listView;
    private LVAdapterTVToday lvAdapterTVToday;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_view_today, container, false);

        listView = (ListView) view.findViewById(R.id.lvTVToday);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srlSwipeRefresh);

        populateListView(view);
        registerRefreshListener();

        return view;

    }

    private void registerRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.v(TAG,"Refresh was triggered");
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void populateListView(View view) {

        final LinearLayout linlaHeaderProgress = (LinearLayout) view.findViewById(R.id.linlaHeaderProgress);

        linlaHeaderProgress.setVisibility(View.VISIBLE);
        ITodayService.Factory.getInstance().getTodayItems().enqueue(new Callback<List<TodayItem>>() {
            @Override
            public void onResponse(Call<List<TodayItem>> call, Response<List<TodayItem>> response) {
                todayItems = response.body();


                lvAdapterTVToday = new LVAdapterTVToday(getActivity().getBaseContext(), todayItems);
                //set adapter
                listView.setAdapter(lvAdapterTVToday);

                //on long click bookmark the item
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                        if(!LVAdapterTVBookmarked.getItemList().contains(view))
                            LVAdapterTVBookmarked.addView(view);

                        Log.v(TAG,"added a new item");

                        return true;
                    }
                });

                //dismiss loading circle
                linlaHeaderProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<TodayItem>> call, Throwable t) {
                Log.v(TAG, "Failed to get today items");
                //popup for error
                linlaHeaderProgress.setVisibility(View.GONE);
            }
        });

    }

}
