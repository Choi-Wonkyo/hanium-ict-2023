package com.example.androidar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidar.R;
import com.example.androidar.models.Store;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder3> {

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView storeName;
        TextView storeDescription;
        ImageView storeImage;

        ViewHolder3(View v) {
            super(v);
            storeName = v.findViewById(R.id.storeName);
            storeDescription = v.findViewById(R.id.storeDescription);
            storeImage = v.findViewById(R.id.storeImage);
        }
    }

    private ArrayList<Store> storeArray;

    public StoreAdapter(ArrayList<Store> storeArray) {
        this.storeArray = storeArray;
    }

    @NonNull
    @Override
    public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_store, viewGroup, false);
        return new ViewHolder3(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder3 holder, int position) {
        Store store = storeArray.get(position);
        holder.storeName.setText(store.getStoreName());
        holder.storeDescription.setText(store.getStoreDescription());
        holder.storeImage.setImageResource(store.getStoreImage());
    }

    @Override
    public int getItemCount() {
        return storeArray.size();
    }
}
