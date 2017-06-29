package com.extinctspecie.betman;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.crashlytics.android.Crashlytics;
import com.extinctspecie.betman.adapters.TabViewAdapter;
import com.extinctspecie.betman.helpers.Fonts;
import com.extinctspecie.betman.helpers.InternetConnectionDetector;
import com.extinctspecie.betman.helpers.Log;
import com.kobakei.ratethisapp.RateThisApp;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.onesignal.OneSignal;

import io.fabric.sdk.android.Fabric;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TabViewAdapter tabViewAdapter;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        Log.v(TAG,"main activity on create method called");
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            if (InternetConnectionDetector.hasActiveInternetConnection(this)) {
                OneSignal.startInit(this)
                        .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                        .unsubscribeWhenNotificationsAreDisabled(true)
                        .init();
                setContentView(R.layout.activity_main);
                showRateDialog();


                initializeCustomFonts();

                tabViewAdapter = new TabViewAdapter(getSupportFragmentManager(), getApplicationContext());

                viewPager = (ViewPager) findViewById(R.id.container);
                viewPager.setAdapter(tabViewAdapter);
                viewPager.setOffscreenPageLimit(4);
                viewPagerTab = (SmartTabLayout) findViewById(R.id.tabsLayout);
                viewPagerTab.setViewPager(viewPager);


               // savedInstanceState.putParcelable("TabAdapter",tabViewAdapter);


            } else {

                setContentView(R.layout.activity_main_no_internet);
                noInternetConnectionPopup();
            }

        }
    }

    private void initializeCustomFonts() {
        Fonts.initializeFonts(getBaseContext());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!(viewPager.getCurrentItem() == 0)) {
            viewPager.setCurrentItem(0);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit the app?")
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();


            alert.show();
            alert.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            alert.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.RED);
        }
    }


    private void showRateDialog() {
        // Set custom criteria (optional)
        RateThisApp.init(new RateThisApp.Config(3, 3));
        // Monitor launch times and interval from installation
        RateThisApp.onCreate(this);
        // Show a dialog if criteria is satisfied
        RateThisApp.showRateDialogIfNeeded(this);
    }

    public void noInternetConnectionPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Network connection error , please connect to the internet and try again.")
                .setCancelable(true)
                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        restartSelf();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

        alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                restartSelf();
            }
        });
    }

    private void restartSelf() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 500, // half of a second
                PendingIntent.getActivity(this, 0, getIntent(), PendingIntent.FLAG_ONE_SHOT
                        | PendingIntent.FLAG_CANCEL_CURRENT));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);


        super.onActivityResult(requestCode, resultCode, data);

        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
