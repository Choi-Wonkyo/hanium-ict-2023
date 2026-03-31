package com.example.androidar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidar.R;
import com.example.androidar.adapters.StoreAdapter;
import com.example.androidar.models.Store;

import java.util.ArrayList;

public class FragmentStore extends Fragment {

    RecyclerView sRecyclerView;
    RecyclerView.LayoutManager sLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        sRecyclerView = view.findViewById(R.id.recyclerViewStore);
        sRecyclerView.setHasFixedSize(true);

        sLayoutManager = new GridLayoutManager(requireContext(), 3); // 그리드 형태, 열의 수: 3
        sRecyclerView.setLayoutManager(sLayoutManager);

        ArrayList<Store> storeArray = new ArrayList<>();
        storeArray.add(new Store("이케아", "", R.drawable.ikea));
        storeArray.add(new Store("한샘", "", R.drawable.hanssem));
        storeArray.add(new Store("에이스 침대", "", R.drawable.ace_bed));
        storeArray.add(new Store("시디즈", "", R.drawable.sidiz));
        storeArray.add(new Store("지누스", "", R.drawable.zinus));

        StoreAdapter adapter = new StoreAdapter(storeArray);
        sRecyclerView.setAdapter(adapter);

        return view;
    }
}
