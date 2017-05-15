package com.extinctspecie.betman.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.extinctspecie.betman.R;
import com.extinctspecie.betman.adapters.TabViewAdapterVIP;
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

public class TabViewVIP extends Fragment {
    private Button btnSub;
    private View tabVipView;
    private String TAG = this.getClass().getSimpleName();

    private IabHelper iabHelper;
    private String base64EncodedPublicKey;
    private final String SUB_SKU = "subscription_5_euro";
    static final int RC_VIP_SUB = 10001;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Get view
        tabVipView = inflater.inflate(R.layout.tab_view_vip, container, false);

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

        registerSubButton();


        return tabVipView;

    }

    private void setupIabHelper() {
        iabHelper = new IabHelper(getActivity().getApplicationContext(), base64EncodedPublicKey);
        iabHelper.enableDebugLogging(true);

        iabHelper.startSetup(onIabSetupFinishedListener);

    }

    private void registerSubButton() {

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (iabHelper != null) iabHelper.flagEndAsync();
                    iabHelper.launchPurchaseFlow(getActivity(), SUB_SKU, IabHelper.ITEM_TYPE_SUBS, null, RC_VIP_SUB, onIabPurchaseFinishedListener, "unique_payload");

                } catch (IabHelper.IabAsyncInProgressException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener = new IabHelper.OnIabSetupFinishedListener() {
        @Override
        public void onIabSetupFinished(IabResult result) {
            Log.v(TAG, "Setup finished.");
            if (!result.isSuccess()) {
                try {
                    throw new Exception("Billing setup failed.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
            if (iabHelper == null) {
                try {
                    throw new NullPointerException("Billing setup failed.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }

            // IAB is fully set up. Now, let's get an inventory of stuff we own.
            Log.d(TAG, "Setup successful. Querying inventory.");

            try {
                iabHelper.queryInventoryAsync(queryInventoryAsync);
            } catch (IabHelper.IabAsyncInProgressException e) {
                e.printStackTrace();
                Log.d(TAG, "Querying inventory throwed an exception.");
            }
        }
    };
    IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(TAG, "purchasing: " + result);
            if (!result.isSuccess()) {

                Log.d(TAG, "Error purchasing: " + result);
            }
            else if(result.isSuccess())
            {
                tabVipView.findViewById(R.id.noSubLayout).setVisibility(View.GONE);

                tabVipView.findViewById(R.id.subLayout).setVisibility(View.VISIBLE);
            }

            try {
                iabHelper.queryInventoryAsync(queryInventoryAsync);
            } catch (IabHelper.IabAsyncInProgressException e) {
                e.printStackTrace();
                Log.d(TAG, "Querying inventory throwed an exception.");
            }
        }
    };

    IabHelper.QueryInventoryFinishedListener queryInventoryAsync = new IabHelper.QueryInventoryFinishedListener() {
        @Override
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            if (inventory.hasPurchase(SUB_SKU)) {

                Log.v(TAG,"token" + inventory.getPurchase(SUB_SKU).getToken());
                Log.v(TAG,"package" + inventory.getPurchase(SUB_SKU).getPackageName());
                Log.v(TAG,"order id" + inventory.getPurchase(SUB_SKU).getOrderId());

                tabVipView.findViewById(R.id.noSubLayout).setVisibility(View.GONE);

                tabVipView.findViewById(R.id.subLayout).setVisibility(View.VISIBLE);

            }

        }
    };
    IabHelper.OnConsumeFinishedListener onConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
        @Override
        public void onConsumeFinished(Purchase purchase, IabResult result) {



            if (result.isSuccess()) {
                Log.d(TAG, "On Consume Finished True.");
            }
            else
                Log.v(TAG,result.toString());
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);

        // Pass on the activity result to the helper for handling
        if (!iabHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        }
        else {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }

    }

    private void displayShortToastMessage(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    private void displayLongToastMessage(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {

        if(iabHelper!=null)
            try {
                iabHelper.dispose();
            } catch (IabHelper.IabAsyncInProgressException e) {
                e.printStackTrace();
            }

        iabHelper = null;
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
