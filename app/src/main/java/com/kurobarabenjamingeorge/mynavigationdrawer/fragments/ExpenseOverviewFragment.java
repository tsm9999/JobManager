package com.kurobarabenjamingeorge.mynavigationdrawer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.kurobarabenjamingeorge.mynavigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class ExpenseOverviewFragment extends Fragment {
    PieChart pieChart;


    public ExpenseOverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_expense_overview, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        pieChart=getActivity().findViewById(R.id.piechartExpense);
        pieChart.setUsePercentValues(true);

        List<PieEntry> value=new ArrayList<>();
        value.add(new PieEntry(40f,"Job 1"));
        value.add(new PieEntry(60f,"Job 2"));
        PieDataSet pieDataSet=new PieDataSet(value,"Jobs");
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setSelectionShift(10);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
    }
}
