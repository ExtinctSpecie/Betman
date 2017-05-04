package com.extinctspecie.betman;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;


import com.extinctspecie.betman.fragments.TabViewAdapter;
import com.extinctspecie.betman.helpers.Fonts;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class MainActivity extends AppCompatActivity {


    private TabViewAdapter tabViewAdapter;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeCustomFonts();


        tabViewAdapter = new TabViewAdapter(getSupportFragmentManager() , getApplicationContext());

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(tabViewAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPagerTab = (SmartTabLayout) findViewById(R.id.tabsLayout);
        viewPagerTab.setViewPager(viewPager);


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
