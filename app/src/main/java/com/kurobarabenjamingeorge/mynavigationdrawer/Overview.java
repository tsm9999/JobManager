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

import com.github.mikephil.charting.charts.PieChart;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.kurobarabenjamingeorge.mynavigationdrawer.adapters.PagerAdapterOverview;

public class Overview extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private TabLayout tabLayout;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        //Set the toolbar as the app bar
        Toolbar toolbar =findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        //Display the menu toggle icon on the app bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        mDrawerLayout =   findViewById(R.id.drawer_layout);
        NavigationView navigationView =  findViewById(R.id.nav_view);

        //Registers the NavigationItemSelectedListener to the navigation view
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggler = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.open_nav, R.string.close_nav);
        mDrawerLayout.addDrawerListener(toggler);
        toggler.syncState();

        tabLayout =findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("All Jobs"));
        tabLayout.addTab(tabLayout.newTab().setText("Expenses"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager =  (ViewPager) findViewById(R.id.pager);
        PagerAdapterOverview pagerAdapterOverview = new PagerAdapterOverview(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapterOverview);

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



//        pieChart=findViewById(R.id.piechart);
//        pieChart.setBackgroundColor(Color.WHITE);
//        moveOffScreen();

//        pieChart.setUsePercentValues(true);
//        pieChart.getDescription().setEnabled(false);
//        pieChart.setDrawHoleEnabled(true);
//        pieChart.setMaxAngle(180);
//        pieChart.setRotationAngle(180);
//        pieChart.setCenterTextOffset(0,-20);
//
//        setData(4,100);
//
//        pieChart.animateY(800, Easing.EasingOption.EaseInCubic);
//
//        Legend l=pieChart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(false);
//
//        pieChart.setEntryLabelColor(Color.WHITE);
//        pieChart.setEntryLabelTextSize(15f);

    }
//    String[] jobs=new String[]{"In Progress","Approved","Submitted","Rejected"};
//    private void setData(int count,int range)
//    {
//        ArrayList<PieEntry>values=new ArrayList<>();
////        for(int i=0;i<count;i++)
////        {
////            float val=(float)((Math.random()*range)+range/4);
////            values.add(new PieEntry(val,jobs[i]));
////        }
//        values.add(new PieEntry(23,"In Progress"));
//        values.add(new PieEntry(44,"Approved"));
//        values.add(new PieEntry(67,"Submitted"));
//        values.add(new PieEntry(56,"Rejected"));
//        PieDataSet dataSet=new PieDataSet(values,"partner");
//        dataSet.setSelectionShift(5f);
//        dataSet.setSliceSpace(3f);
//        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
//
//        PieData data=new PieData(dataSet);
//        data.setValueFormatter(new PercentFormatter());
//        data.setValueTextSize(15f);
//        data.setValueTextColor(Color.WHITE);
//
//        pieChart.setData(data);
//        pieChart.invalidate();
//    }
//
//    private void moveOffScreen(){
//
//        Display display=getWindowManager().getDefaultDisplay();
//        DisplayMetrics displayMetrics=new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height=displayMetrics.heightPixels;
//
//        int offset=(int) (height*0.5);
//
//        RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams)pieChart.getLayoutParams();
//        params.setMargins(0,0,0,-offset);
//        pieChart.setLayoutParams(params);
//    }
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
                Intent intent=new Intent(getBaseContext(),JobActivity.class);
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

