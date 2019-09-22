package com.kurobarabenjamingeorge.mynavigationdrawer.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.AllJobsOverviewFragment;
import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.ExpenseOverviewFragment;

public class PagerAdapterOverview extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapterOverview(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AllJobsOverviewFragment();
            case 1:
                return new ExpenseOverviewFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
