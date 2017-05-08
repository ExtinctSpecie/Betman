package com.extinctspecie.betman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.helpers.Information;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.models.TodayItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.List;


/**
 * Created by WorkSpace on 5/1/2017.
 */
// LVAdapterTVToday stands for
// List View Adapter For Tab View Today
public class LVAdapterTVToday extends BaseAdapter implements RewardedVideoAdListener {

    private String TAG = this.getClass().getSimpleName();
    private Context context;
    private List<TodayItem> todayItems;
    private LayoutInflater layoutInflater;
    private TodayItem item;

    private RewardedVideoAd rewardedVideoAd;
    private Button btnShowad;
    private View adView;

    public LVAdapterTVToday(Context context, List<TodayItem> todayItems) {

        Log.v(TAG, "constructor called");
        this.todayItems = todayItems;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        adView = layoutInflater.inflate(R.layout.lv_item_ad_display, null);
        btnShowad = (Button) adView.findViewById(R.id.btnShowAd);
        loadAd();
    }


    @Override
    public int getCount() {
        return todayItems.size();
    }

    @Override
    public Object getItem(int position) {
        return todayItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {


        if ((position == todayItems.size() - 1) && !Information.isAdShown()) {

            //view = adView;

            if (!rewardedVideoAd.isLoaded()) {
                adView.setVisibility(View.GONE);
                loadAd();
            }


            Log.v(TAG, "ad view is set up");

            return adView;


        } else {
            final ViewHolder viewHolder;


            if (view == null || Information.isAdShown()) {
                TextView tvTemp;
                viewHolder = new ViewHolder();
                view = layoutInflater.inflate(R.layout.lv_adapter_tv_today, null);
                viewHolder.tvTeamOne = (TextView) view.findViewById(R.id.tvTeamOne);
                viewHolder.tvTeamOne.setTypeface(Fonts.getSFDiegoSans());

                viewHolder.tvTeamTwo = (TextView) view.findViewById(R.id.tvTeamTwo);
                viewHolder.tvTeamTwo.setTypeface(Fonts.getSFDiegoSans());

                tvTemp = (TextView) view.findViewById(R.id.tvVSHelper);
                tvTemp.setTypeface(Fonts.getSFDiegoSans());

                viewHolder.tvPrediction = (TextView) view.findViewById((R.id.tvPrediction));
                viewHolder.tvPrediction.setTypeface(Fonts.getSFDiegoSans());

                viewHolder.tvOdd = (TextView) view.findViewById((R.id.tvOdd));
                viewHolder.tvOdd.setTypeface(Fonts.getSFDiegoSans());

                viewHolder.tvTime = (TextView) view.findViewById(R.id.tvTime);
                viewHolder.tvTime.setTypeface(Fonts.getSFDiegoSans());

                //tvTemp = (TextView) view.findViewById(R.id.tvOddSymbol);
                //tvTemp.setTypeface(Fonts.getSFDiegoSans());

                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            item = todayItems.get(position);


            viewHolder.tvTeamOne.setText(item.getTeamOne());

            viewHolder.tvTeamTwo.setText(item.getTeamTwo());

            viewHolder.tvPrediction.setText(item.getPrediction());

            viewHolder.tvOdd.setText(item.getOdd());

            viewHolder.tvTime.setText(item.getTimeOfGame().substring(11, 16));

            return view;
        }

    }


    public void updateData(List<TodayItem> newTodayItems) {
        todayItems = newTodayItems;
    }

    private void loadAd() {

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context);

        rewardedVideoAd.setRewardedVideoAdListener(this);


        if (!rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.loadAd("ca-app-pub-5589078228018183/9750162554", new AdRequest.Builder().build());
        }

    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Log.v(TAG, "Ad was loaded");
        adView.setVisibility(View.VISIBLE);
        if (btnShowad != null)
            btnShowad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rewardedVideoAd.show();
                }
            });
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

        Log.v(TAG, "Ad reward");
        Information.setAdShown(true);
        Log.v(TAG,String.valueOf(Information.isAdShown()));

        notifyDataSetChanged();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        loadAd();
    }

    static class ViewHolder {
        TextView tvTeamOne;
        TextView tvTeamTwo;
        TextView tvTime;
        TextView tvPrediction;
        TextView tvOdd;
    }
}
