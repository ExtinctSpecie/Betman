package com.extinctspecie.betman;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.extinctspecie.betman.adapters.TabViewAdapter;
import com.extinctspecie.betman.helpers.Fonts;
import com.kobakei.ratethisapp.RateThisApp;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.onesignal.OneSignal;

public class MainActivity extends AppCompatActivity {


    private TabViewAdapter tabViewAdapter;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        setContentView(R.layout.activity_main);

        showRateDialog();

        initializeCustomFonts();

        tabViewAdapter = new TabViewAdapter(getSupportFragmentManager() , getApplicationContext());

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(tabViewAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPagerTab = (SmartTabLayout) findViewById(R.id.tabsLayout);
        viewPagerTab.setViewPager(viewPager);


    }

    private void showRateDialog() {
        // Set custom criteria (optional)
        RateThisApp.init(new RateThisApp.Config(3, 3));
        // Monitor launch times and interval from installation
        RateThisApp.onCreate(this);
        // Show a dialog if criteria is satisfied
        RateThisApp.showRateDialogIfNeeded(this);
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
        if(!(viewPager.getCurrentItem() == 0)){
            viewPager.setCurrentItem(0);
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit the app?")
                    .setCancelable(false)
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

    //
//
//
//    private void setupToolbar()
//    {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("Betman");
//        toolbar.setLogo(R.mipmap.ic_logo_24dp);
//        setSupportActionBar(toolbar);
//    }

}
