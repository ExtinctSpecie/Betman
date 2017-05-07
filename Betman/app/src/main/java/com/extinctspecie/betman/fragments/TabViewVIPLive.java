package com.extinctspecie.betman.fragments;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.adapters.LVAdapterTVVIPLive;
import com.extinctspecie.betman.helpers.InternetConnectionDetector;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.models.VIPLiveItem;
import com.extinctspecie.betman.services.IVIPLiveService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewVIPLive extends Fragment {
    private TextView tvVs;
    private String TAG = this.getClass().getSimpleName();
    private ListView listView;
    private LVAdapterTVVIPLive lvAdapterTVVIPLive;
    private List<VIPLiveItem> vipLiveItems;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_view_vip_live, container, false);

        listView = (ListView) view.findViewById(R.id.lvTVVIPLive);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.tvVIPLiveSwipeRefresh);


        listView.setAdapter(lvAdapterTVVIPLive);

        populateListView(view);

        registerRefreshListener();

        return view;
    }

    private void registerRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.v(TAG, "Refresh was triggered");
                populateListView(getView());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void populateListView(View view) {
        final LinearLayout tvTodayProgress = (LinearLayout) view.findViewById(R.id.tvVIPLiveLoadingProgress);

        tvTodayProgress.setVisibility(View.VISIBLE);


        IVIPLiveService.Factory.getInstance().getVIPLiveItems().enqueue(new Callback<List<VIPLiveItem>>() {
            @Override
            public void onResponse(Call<List<VIPLiveItem>> call, Response<List<VIPLiveItem>> response) {
                vipLiveItems = response.body();

                if (vipLiveItems.size() > 0) {
                    lvAdapterTVVIPLive = new LVAdapterTVVIPLive(getActivity().getBaseContext(), vipLiveItems);
                    //set adapter
                    listView.setAdapter(lvAdapterTVVIPLive);
                }

                //dismiss loading circle
                tvTodayProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<VIPLiveItem>> call, Throwable t) {
                Log.v(TAG, "Failed to get today items");
                //popup for error
                tvTodayProgress.setVisibility(View.GONE);
            }
        });


    }
}
