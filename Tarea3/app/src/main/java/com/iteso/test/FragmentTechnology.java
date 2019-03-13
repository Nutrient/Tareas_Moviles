package com.iteso.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.test.beans.ItemProduct;

import java.util.ArrayList;

public class FragmentTechnology extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentTechnology() {}



    public static FragmentTechnology newInstance(int sectionNumber) {
        FragmentTechnology fragment = new FragmentTechnology();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.fragment_technology_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> dataSet = new ArrayList<ItemProduct>();

        // remove later
        ItemProduct itemProduct1 = new ItemProduct(0, "Alienware", "bestbuy", "Zapopan", "3333333333", "An Alienware");
        ItemProduct itemProduct2 = new ItemProduct(1, "Mac", "bestbuy", "Zapopan", "3333333333", "A Mac");
        // end remove

        dataSet.add(itemProduct1);
        dataSet.add(itemProduct2);

        mAdapter = new AdapterProduct(getActivity(), dataSet);
        recyclerView.setAdapter(mAdapter);


        return rootView;
    }
}
