package com.example.androidar.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidar.R;
import com.example.androidar.activities.AR;
import com.example.androidar.activities.FurnitureDetails;
import com.example.androidar.models.Furniture;

import java.util.ArrayList;
import java.util.List;

public class FurnitureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Furniture> furnitureArray;
    private final int layoutResId;

    public static final int LAYOUT_FURNITURE = R.layout.item_furniture;
    public static final int LAYOUT_FURNITURE_DETAILS = R.layout.item_furniture_details;

    public FurnitureAdapter(ArrayList<Furniture> furnitureArray, int layoutResId) {
        this.furnitureArray = furnitureArray;
        this.layoutResId = layoutResId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layoutResId, viewGroup, false);

        if (layoutResId == LAYOUT_FURNITURE) {
            return new FurnitureViewHolder(v);
        } else if (layoutResId == LAYOUT_FURNITURE_DETAILS) {
            return new FurnitureDetailsViewHolder(v);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Furniture furniture = furnitureArray.get(position);

        if (layoutResId == LAYOUT_FURNITURE) {
            FurnitureViewHolder furnitureViewHolder = (FurnitureViewHolder) holder;
            furnitureViewHolder.furnitureImage.setImageResource(furniture.getFurnitureImage());
            furnitureViewHolder.furnitureName.setText(furniture.getFurnitureName());
            furnitureViewHolder.furniturePrice.setText(furniture.getFurniturePrice());
            furnitureViewHolder.furnitureManufacture.setText(furniture.getFurnitureManufacture());
            furnitureViewHolder.furnitureDescription.setText(furniture.getFurnitureDescription());

            furnitureViewHolder.detailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = furnitureViewHolder.itemView.getContext();
                    Intent intent = new Intent(context, FurnitureDetails.class);
                    intent.putExtra("selected_furniture", furniture);
                    context.startActivity(intent);
                }
            });

            furnitureViewHolder.tryARButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Try AR 동작 구현
                    Context context = view.getContext();
                    String arModelFileName = furniture.getItem3D(); // 리소스 이름, "R.raw."을 제외하는 게 들어가야함.
                    // getResources().getIdentifier(이름, 타입, 패키지명) 형태로 사용된다.
                    int resourceId = context.getResources().getIdentifier(arModelFileName, "raw", context.getPackageName());

                    if (resourceId != 0) {
                        Intent intent = new Intent(context, AR.class);
                        intent.putExtra("modelResourceId", resourceId); // 리소스 ID를 인텐트에 추가
                        context.startActivity(intent);
                    } else {
                        // 3D 파일명이 없을 때 처리
                        Log.e("FurnitureAdapter", "3D 모델 파일이 없습니다.");
                    }
                    /*
                    String arModelFileName = furniture.getItem3D();
                    if (arModelFileName != null && !arModelFileName.isEmpty()) {
                        // AR 활동으로 이동하고 3D 파일명 전달
                        Context context = view.getContext();
                        Intent arIntent = new Intent(context, AR.class);
                        //arIntent.putExtra("arModelFileName", arModelFileName);
                        arIntent.putExtra("modelResourceId", arModelFileName ); //# 2023.11.03 수정.
                        context.startActivity(arIntent);
                    } else {
                        // 3D 파일명이 없을 때 처리
                        Log.e("FurnitureAdapter", "3D 모델 파일이 없습니다.");
                    }*/
                }
            });

        } else if (layoutResId == LAYOUT_FURNITURE_DETAILS) {
            FurnitureDetailsViewHolder furnitureDetailsViewHolder = (FurnitureDetailsViewHolder) holder;
            furnitureDetailsViewHolder.furnitureImage.setImageResource(furniture.getFurnitureImage());
            furnitureDetailsViewHolder.furnitureName.setText(furniture.getFurnitureName());
            furnitureDetailsViewHolder.furniturePrice.setText(furniture.getFurniturePrice());
            furnitureDetailsViewHolder.furnitureManufacture.setText(furniture.getFurnitureManufacture());
            furnitureDetailsViewHolder.furnitureDescription.setText(furniture.getFurnitureDescription());
        }
    }

    @Override
    public int getItemCount() {
        return furnitureArray.size();
    }

    public static class FurnitureViewHolder extends RecyclerView.ViewHolder {
        ImageView furnitureImage;
        TextView furnitureName;
        TextView furniturePrice;
        TextView furnitureManufacture;
        TextView furnitureDescription;
        Button detailsButton;
        Button tryARButton;

        public FurnitureViewHolder(View itemView) {
            super(itemView);
            furnitureImage = itemView.findViewById(R.id.furnitureImage);
            furnitureName = itemView.findViewById(R.id.furnitureName);
            furniturePrice = itemView.findViewById(R.id.furniturePrice);
            furnitureManufacture = itemView.findViewById(R.id.furnitureManufacture);
            furnitureDescription = itemView.findViewById(R.id.furnitureDescription);
            detailsButton = itemView.findViewById(R.id.detailsButton);
            tryARButton = itemView.findViewById(R.id.tryARButton);
        }
    }

    public static class FurnitureDetailsViewHolder extends RecyclerView.ViewHolder {
        ImageView furnitureImage;
        TextView furnitureName;
        TextView furniturePrice;
        TextView furnitureManufacture;
        TextView furnitureDescription;

        public FurnitureDetailsViewHolder(View itemView) {
            super(itemView);
            furnitureImage = itemView.findViewById(R.id.furnitureImage);
            furnitureName = itemView.findViewById(R.id.furnitureName);
            furniturePrice = itemView.findViewById(R.id.furniturePrice);
            furnitureManufacture = itemView.findViewById(R.id.furnitureManufacture);
            furnitureDescription = itemView.findViewById(R.id.furnitureDescription);
        }
    }
}
