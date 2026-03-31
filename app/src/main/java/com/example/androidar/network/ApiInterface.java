package com.example.androidar.network;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

import com.example.androidar.models.Furniture;
import com.example.androidar.models.FurnitureListItem;
import com.example.androidar.models.Login;
import com.example.androidar.models.Place;
import com.example.androidar.models.ImageData;
import com.example.androidar.models.Store;
import com.example.androidar.models.Terms;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("/api/login")
    Call<Login> login(
            @Body LoginRequestBody requestBody
    );

    class LoginRequestBody {
        private String email;
        private String password;

        public LoginRequestBody(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }


    @Headers("Content-Type: application/json")
    @POST("/api/terms_agree")
    Call<ApiResponse<Terms>> terms_agree(
            @Body LoginRequestBody2 requestBody2

    );

    class LoginRequestBody2 {
        private String Yes;
        private String No;

        public LoginRequestBody2(String Yes, String No) {
            this.Yes = Yes;
            this.No = No;
        }
    }

    @Headers("Content-Type: application/json")
    @GET("/furniture_list")
    Call<ApiResponse<Furniture>> furniture_list();

    class FurnitureList {
        private String furnitureName;
        private Integer furniturePrice;
        private String furnitureManufacture;
        private String furnitureDescription;

        public FurnitureList(String furnitureName, Integer furniturePrice, String furnitureManufacture, String furnitureDescription) {
            this.furnitureName = furnitureName;
            this.furniturePrice = furniturePrice;
            this.furnitureManufacture = furnitureManufacture;
            this.furnitureDescription = furnitureDescription;
        }
    }

    @Headers("Content-Type: application/json")
    @GET("/store_list")
    Call<ApiResponse<Store>> store_list();

    class StoreList {
        private String storeName;
        private String storeDescription;

        public StoreList(String storeName, String storeDescription) {
            this.storeName = storeName;
            this.storeDescription = storeDescription;
        }
    }

    // 이미지 업로드 API 엔드포인트
    @Multipart
    @POST("/place") // 장소식별.
    Call<String> place(@Part MultipartBody.Part imageFile);
    
    //원래-AI와 연결_둘 다
    @GET("api/endpoint") // 실제 API 엔드포인트를 입력해주세요.
    Call<ApiResponse<Furniture>> getRecommendedFurniture(@Query("placeId") String placeId);
}

