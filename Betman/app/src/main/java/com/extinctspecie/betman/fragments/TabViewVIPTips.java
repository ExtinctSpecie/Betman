package com.extinctspecie.betman.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.extinctspecie.betman.adapters.LVAdapterTVToday;
import com.extinctspecie.betman.adapters.LVAdapterTVVIPTips;
import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.models.TodayItem;
import com.extinctspecie.betman.models.VIPTipsItem;
import com.extinctspecie.betman.services.ITodayService;
import com.extinctspecie.betman.services.IVIPTipsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WorkSpace on 5/4/2017.
 */

public class TabViewVIPTips extends Fragment
{
    private TextView tvVs;
    private String TAG = this.getClass().getSimpleName();
    private ListView listView;
    private LVAdapterTVVIPTips lvAdapterTVVIPTips;
    private List<VIPTipsItem> vipTipsItems;
    private SwipeRefreshLayout swipeRefreshLayout;

    //on destroy method will return to onCreateView instead of onCreate
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_view_vip_tips,container,false);

        listView = (ListView) view.findViewById(R.id.lvTVVIPTips);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.tvVIPTipsSwipeRefresh);


        listView.setAdapter(lvAdapterTVVIPTips);

        populateListView(view);

        registerRefreshListener();

        return view;
    }
    private void registerRefreshListener()
    {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.v(TAG, "Refresh was triggered");
                populateListView(getView());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void populateListView(View view)
    {
        final LinearLayout tvTodayProgress = (LinearLayout) view.findViewById(R.id.tvVIPTipsLoadingProgress);

        tvTodayProgress.setVisibility(View.VISIBLE);

        IVIPTipsService.Factory.getInstance().getVIPTipsItems().enqueue(new Callback<List<VIPTipsItem>>() {
            @Override
            public void onResponse(Call<List<VIPTipsItem>> call, Response<List<VIPTipsItem>> response) {
                vipTipsItems = response.body();

                if(vipTipsItems.size() > 0)
                {
                    lvAdapterTVVIPTips = new LVAdapterTVVIPTips(getActivity().getBaseContext(),vipTipsItems);
                    //set adapter
                    listView.setAdapter(lvAdapterTVVIPTips);
                }

                //dismiss loading circle
                tvTodayProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<VIPTipsItem>> call, Throwable t) {
                Log.v(TAG, "Failed to get today items");
                //popup for error
                tvTodayProgress.setVisibility(View.GONE);
            }
        });


    }


}
