package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.models.NewsFeedItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;

import java.util.List;

/**
 * Created by WorkSpace on 29-Jun-17.
 */

public class LVAdapterTVNewsFeed extends BaseAdapter {

    private String TAG = this.getClass().getSimpleName();
    private Context context;
    private List<NewsFeedItem> newsFeedItems;
    private LayoutInflater layoutInflater;
    private NewsFeedItem item;

    private RewardedVideoAd rewardedVideoAd;
    private Button btnShowad;

    public LVAdapterTVNewsFeed(Context context, List<NewsFeedItem> newsFeedItems) {
        this.context = context;
        this.newsFeedItems = newsFeedItems;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newsFeedItems.size();
    }

    @Override
    public Object getItem(int position) {
        return newsFeedItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();

            convertView = layoutInflater.inflate(R.layout.lv_adapter_tv_news_feed,null);

            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        item = newsFeedItems.get(position);

        viewHolder.tvTitle.setText(item.getTitle());
        viewHolder.tvDescription.setText(item.getDescription());
        String dateTime = item.getCreated_at().substring(0,10);
        dateTime = dateTime + "  " + item.getCreated_at().substring(11, 16);
        dateTime = dateTime.replace("-", "/");
        viewHolder.tvDate.setText(dateTime);

        return convertView;
    }
    static class ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        TextView tvDate;
    }
}
