package com.extinctspecie.betman.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.helpers.Log;
import com.extinctspecie.betman.util.IabHelper;
import com.extinctspecie.betman.util.IabResult;
import com.extinctspecie.betman.util.Inventory;
import com.extinctspecie.betman.util.Purchase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by WorkSpace on 5/1/2017.
 */

public class TabViewVIP extends Fragment implements RewardedVideoAdListener
{
    private Button btnSub;
    private View tabVipView;
    private String TAG = this.getClass().getSimpleName();

    private IabHelper iabHelper;
    private String base64EncodedPublicKey;

    RewardedVideoAd rewardedVideoAd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        // Get view
        tabVipView = inflater.inflate(R.layout.tab_view_vip,container,false);

        /////
        // Init views
        /////
        btnSub = (Button) tabVipView.findViewById(R.id.btnSub);
        ViewPager viewPager = (ViewPager) tabVipView.findViewById(R.id.vpVIPTabContainer);
        SmartTabLayout viewPagerTab = (SmartTabLayout) tabVipView.findViewById(R.id.vipTabLayout);


        // Create and set a new adapter for sub-tabs
        TabViewAdapterVIP tabViewAdapterVIP = new TabViewAdapterVIP(getActivity().getSupportFragmentManager(), getActivity().getApplicationContext());
        viewPager.setAdapter(tabViewAdapterVIP);
        viewPager.setOffscreenPageLimit(2);
        viewPagerTab.setViewPager(viewPager);

        base64EncodedPublicKey = getResources().getString(R.string.googlePlayPublicKey);
        setupIabHelper();

        loadAd();
        registerSubButton();


        return tabVipView;

    }

    private void setupIabHelper()
    {
        iabHelper = new IabHelper(getActivity().getApplicationContext(),base64EncodedPublicKey);
        iabHelper.enableDebugLogging(true);

        iabHelper.startSetup(onIabSetupFinishedListener);

    }

    private void registerSubButton() {

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(rewardedVideoAd.isLoaded())
                    rewardedVideoAd.show();
                tabVipView.findViewById(R.id.noSubLayout).setVisibility(View.GONE);
                tabVipView.findViewById(R.id.subLayout).setVisibility(View.VISIBLE);
            }
        });


    }

    private void loadAd() {

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getActivity());

        rewardedVideoAd.setRewardedVideoAdListener(this);


        if(!rewardedVideoAd.isLoaded())
        {
            rewardedVideoAd.loadAd("ca-app-pub-5589078228018183/9750162554",new AdRequest.Builder().build());
            Log.v(TAG,"ad was loaded");
        }

    }

    IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase purchase)
        {

        }
    };
    IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener = new IabHelper.OnIabSetupFinishedListener() {
        @Override
        public void onIabSetupFinished(IabResult result)
        {
            Log.v(TAG, "Setup finished.");
            if(!result.isSuccess())
            {
                Log.d(TAG, "Billing setup failed.");
            }
            if (iabHelper == null)
            {
                return;
            }

            // IAB is fully set up. Now, let's get an inventory of stuff we own.
            Log.d(TAG, "Setup successful. Querying inventory.");

            try
            {
                iabHelper.queryInventoryAsync(queryInventoryAsync);
            }
            catch (IabHelper.IabAsyncInProgressException e)
            {
                e.printStackTrace();
                Log.d(TAG, "Querying inventory throwed an exception.");
            }
        }
    };
    IabHelper.QueryInventoryFinishedListener queryInventoryAsync = new IabHelper.QueryInventoryFinishedListener() {
        @Override
        public void onQueryInventoryFinished(IabResult result, Inventory inventory)
        {

        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRewardedVideoAdLoaded() {

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

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }
}
