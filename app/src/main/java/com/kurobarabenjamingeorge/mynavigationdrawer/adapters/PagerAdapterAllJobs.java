package com.kurobarabenjamingeorge.mynavigationdrawer.adapters;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.AllJobsFragment;
import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.ApprovedFragment;
import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.InProgressFragment;
import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.RejectedFragment;
import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.SubmittedFragment;


public class PagerAdapterAllJobs extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapterAllJobs(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AllJobsFragment();
            case 1:
                return new InProgressFragment();
            case 2:
                return new ApprovedFragment();
            case 3:
                return new SubmittedFragment();
            case 4:
                return new RejectedFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
