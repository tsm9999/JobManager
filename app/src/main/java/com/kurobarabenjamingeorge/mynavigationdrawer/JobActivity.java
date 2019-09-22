package com.kurobarabenjamingeorge.mynavigationdrawer;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.kurobarabenjamingeorge.mynavigationdrawer.adapters.PagerAdapterAllJobs;

public class JobActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        //Set the toolbar as the app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        //Display the menu toggle icon on the app bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        mDrawerLayout =  (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //Registers the NavigationItemSelectedListener to the navigation view
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggler = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.open_nav, R.string.close_nav);
        mDrawerLayout.addDrawerListener(toggler);
        toggler.syncState();

        //Creates the tab layout from the layout and populates it with three tabs
        tabLayout =findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("All Jobs"));
        tabLayout.addTab(tabLayout.newTab().setText("In Progress"));
        tabLayout.addTab(tabLayout.newTab().setText("Approved"));
        tabLayout.addTab(tabLayout.newTab().setText("Submitted"));
        tabLayout.addTab(tabLayout.newTab().setText("Rejected"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager =  (ViewPager) findViewById(R.id.pager);
        PagerAdapterAllJobs pagerAdapterAllJobs = new PagerAdapterAllJobs(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapterAllJobs);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        mDrawerLayout.closeDrawers();

        switch(item.getItemId()){
            case R.id.view_jobs:
                Intent  intent=new Intent(getBaseContext(),JobActivity.class);
                startActivity(intent);

                return true;
            case R.id.add_job:
                Intent  intent1=new Intent(getBaseContext(),AddJobActivity.class);
                startActivity(intent1);
                return true;

            case R.id.overview:
                Intent  intent2=new Intent(getBaseContext(),Overview.class);
                startActivity(intent2);
                return true;

            case R.id.accruals:
                Intent intent3=new Intent(getBaseContext(),AccrualsActivity.class);
                startActivity(intent3);
                return true;


        }
        return true;
    }


}

