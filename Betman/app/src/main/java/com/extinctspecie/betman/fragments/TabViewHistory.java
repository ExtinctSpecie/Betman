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

import com.extinctspecie.betman.LVAdapterTVHistory;
import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.models.HistoryItem;
import com.extinctspecie.betman.services.IHistoryService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewHistory extends Fragment
{


    private TextView tvVs;
    private String TAG = this.getClass().getSimpleName();
    private List<HistoryItem> historyItems;
    private ListView listView;
    private LVAdapterTVHistory lvAdapterHistory;
    private SwipeRefreshLayout swipeRefreshLayout;

    //on destroy method will return to onCreateView instead of onCreate
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_view_history,container,false);
        listView = (ListView) view.findViewById(R.id.lvTVHistory);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.tvHistorySwipeRefresh);

        populateListView(view);
        registerRefreshListener();
        return view;
    }
    private void registerRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.v(TAG,"Refresh was triggered");
                populateListView(getView());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void populateListView(View view) {

        final LinearLayout tvHistoryProgress = (LinearLayout) view.findViewById(R.id.tvHistoryLoadingProgress);

        tvHistoryProgress.setVisibility(View.VISIBLE);
        IHistoryService.Factory.getInstance().getHistoryItems().enqueue(new Callback<List<HistoryItem>>() {
            @Override
            public void onResponse(Call<List<HistoryItem>> call, Response<List<HistoryItem>> response) {
                historyItems = response.body();


                lvAdapterHistory = new LVAdapterTVHistory(getActivity().getBaseContext(), historyItems);
                //set adapter
                listView.setAdapter(lvAdapterHistory);

                //dismiss loading circle
                tvHistoryProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<HistoryItem>> call, Throwable t) {
                Log.v(TAG, "Failed to get today items");
                //popup for error
                tvHistoryProgress.setVisibility(View.GONE);
            }
        });

    }

}
