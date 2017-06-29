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

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.adapters.LVAdapterNoItems;
import com.extinctspecie.betman.adapters.LVAdapterTVNewsFeed;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.models.NewsFeedItem;
import com.extinctspecie.betman.services.INewsFeedService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WorkSpace on 29-Jun-17.
 */

public class TabViewNewsFeed extends Fragment {

    private String TAG = this.getClass().getSimpleName();
    private List<NewsFeedItem> newsFeedItems;
    private ListView listView;
    private LVAdapterTVNewsFeed lvAdapterTVNewsFeed;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_view_news_feed, container, false);
        listView = (ListView) view.findViewById(R.id.lvTVNewsFeed);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.tvNewsFeedSwipeRefresh);

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
        final LinearLayout tvNewsFeedProgress = (LinearLayout) view.findViewById(R.id.tvNewsFeedLoadingProgress);
        tvNewsFeedProgress.setVisibility(View.VISIBLE);

        INewsFeedService.Factory.getInstance().getNewsFeedItems().enqueue(new Callback<List<NewsFeedItem>>() {
            @Override
            public void onResponse(Call<List<NewsFeedItem>> call, Response<List<NewsFeedItem>> response) {

                try
                {
                    newsFeedItems = response.body();

                    if(newsFeedItems.size() > 0)
                    {
                        lvAdapterTVNewsFeed = new LVAdapterTVNewsFeed(getActivity().getBaseContext() , newsFeedItems);
                        listView.setAdapter(lvAdapterTVNewsFeed);
                    }
                    else
                    {
                        listView.setAdapter(new LVAdapterNoItems(getActivity().getBaseContext()));
                    }
                    tvNewsFeedProgress.setVisibility(View.GONE);
                }
                catch (NullPointerException e)
                {
                    e.printStackTrace();
                    tvNewsFeedProgress.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<List<NewsFeedItem>> call, Throwable t) {
                Log.v(TAG, "Failed to get news items");
                //popup for error
                tvNewsFeedProgress.setVisibility(View.GONE);
            }
        });

    }
}
