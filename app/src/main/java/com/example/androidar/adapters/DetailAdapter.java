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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidar.AR;
import com.example.androidar.R;
import com.example.androidar.activities.Wishlist;
import com.example.androidar.models.Furniture;
import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder2> {

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView furnitureImage;
        TextView furnitureName;
        TextView furniturePrice;
        TextView furnitureManufacture;
        TextView furnitureDescription;
//        Button tryArButton;
        AppCompatImageButton favoriteButton; // '찜하기' 버튼을 멤버 변수로 선언

        ViewHolder2(View v) {
            super(v);
            furnitureImage = v.findViewById(R.id.furnitureImage);
            furnitureName = v.findViewById(R.id.furnitureName);
            furniturePrice = v.findViewById(R.id.furniturePrice);
            furnitureManufacture = v.findViewById(R.id.furnitureManufacture);
            furnitureDescription = v.findViewById(R.id.furnitureDescription);
//            tryArButton = v.findViewById(R.id.Try_ar);
            favoriteButton = v.findViewById(R.id.Favorite); // '찜하기' 버튼 초기화
        }
    }

    private ArrayList<Furniture> furnitureArray;
    ArrayList<Wishlist> wishlist = new ArrayList<>();

    public DetailAdapter(ArrayList<Furniture> furnitureArray) {
        this.furnitureArray = furnitureArray;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_furniture_details, viewGroup, false);
        return new ViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        Furniture furniture = furnitureArray.get(position);

        holder.furnitureImage.setImageResource(furniture.getFurnitureImage());
        holder.furnitureName.setText(furniture.getFurnitureName());
        holder.furniturePrice.setText(furniture.getFurniturePrice());
        holder.furnitureManufacture.setText(furniture.getFurnitureManufacture());
        holder.furnitureDescription.setText(furniture.getFurnitureDescription());

        // '찜하기' 버튼 클릭 이벤트 처리
        holder.favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '찜하기' 버튼을 누를 때마다 상태를 변경
                furniture.setFavorite(!furniture.isFavorite());
                if (furniture.isFavorite()) {
                    // 찜하기
                    holder.favoriteButton.setBackgroundResource(R.drawable.heart_icon_full_red);

                    // 가구 정보를 Wishlist에 추가
                    Wishlist wishlistItem = new Wishlist(furniture.getFurnitureImage(), furniture.getFurnitureName(), furniture.getFurnitureDescription());
                    wishlist.add(wishlistItem);
                } else {
                    // 찜 취소
                    holder.favoriteButton.setBackgroundResource(R.drawable.heart_icon_empty);

                    // 위시리스트에서 해당 가구 정보를 제거
                    Wishlist wishlistItem = new Wishlist(furniture.getFurnitureImage(), furniture.getFurnitureName(), furniture.getFurnitureDescription());
                    wishlist.remove(wishlistItem);
                }
            }
        });

//        // Try AR 버튼 클릭 이벤트 처리
//        holder.tryArButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Try AR 동작 구현
//                String arModelFileName = furniture.getItem3D();
//                if (arModelFileName != null && !arModelFileName.isEmpty()) {
//                    // AR 활동으로 이동하고 3D 파일명 전달
//                    Context context = view.getContext();
//                    Intent arIntent = new Intent(context, AR.class);
//                    arIntent.putExtra("arModelFileName", arModelFileName);
//                    context.startActivity(arIntent);
//                } else {
//                    // 3D 파일명이 없을 때 처리
//                    Log.e("DetailAdapter", "3D 모델 파일이 없습니다.");
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return furnitureArray.size();
    }
}
