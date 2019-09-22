package com.kurobarabenjamingeorge.mynavigationdrawer;

import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class SubmittedOnClick extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted_on_click);

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

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    break;
        }
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
                // Utils.makeToast(getString(R.string.movies_toast), MainActivity.this);
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

//assigned to,job name,client files,agency files, remarks.
//form comments
