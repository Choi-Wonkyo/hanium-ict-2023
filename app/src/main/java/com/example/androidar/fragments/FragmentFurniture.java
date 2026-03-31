package com.example.androidar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidar.R;
import com.example.androidar.adapters.FurnitureAdapter;
import com.example.androidar.models.Furniture;

import java.util.ArrayList;

public class FragmentFurniture extends Fragment {

    RecyclerView fRecyclerView;
    RecyclerView.LayoutManager fLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_furniture, container, false);

        fRecyclerView = view.findViewById(R.id.recyclerViewFurniture);
        fRecyclerView.setHasFixedSize(true);

        fLayoutManager = new LinearLayoutManager(requireContext());
        fRecyclerView.setLayoutManager(fLayoutManager);

        ArrayList<Furniture> furnitureArray = new ArrayList<>();
        furnitureArray.add(new Furniture(R.drawable.f_normal_sofa,"소파(기본형)", "50,000","이케아","화이트", "sofa"));
        furnitureArray.add(new Furniture(R.drawable.f_normal_stand,"플로어스탠드3등", "99,900","이케아","앤트러싸이트", "table_lamp"));
        furnitureArray.add(new Furniture(R.drawable.f_ranarp_ikea,"RANARP 라나르프", "69,900","이케아","독서등, 오프화이트", "table_lamp"));
        //3D 파일 -> desk_lamp(ikea)
        furnitureArray.add(new Furniture(R.drawable.f_franklin_black,"FRANKLIN 프랑클린", "49,900","이케아","접이식바스툴+등받이, 블랙", "officechair_small1"));
        furnitureArray.add(new Furniture(R.drawable.f_franklin_white,"FRANKLIN 프랑클린", "49,900","이케아","접이식바스툴+등받이, 화이트", "table_lamp"));
        //3D 파일 -> office_chair

        furnitureArray.add(new Furniture(R.drawable.f_simplely_white,"바젤 심플리화이트" ,"759,000","일룸","침대(Q)", "bed"));
        furnitureArray.add(new Furniture(R.drawable.f_rug_ikea,"STOENSE 스토엔세" ,"149,000","이케아","단모러그, 다크그레이, 170x240)", "rug_stoense_ikea"));
        furnitureArray.add(new Furniture(R.drawable.f_mirror_ikea,"TRENSUM 트렌숨" ,"8,900","이케아","거울, 스테인리스", "mirror_ikea"));
        furnitureArray.add(new Furniture(R.drawable.f_mug_ikea,"FÄRGKLAR 페리클라르" ,"2,900","이케아","머그컵, 유광 베이지", "mug_ikea"));
        furnitureArray.add(new Furniture(R.drawable.f_glasscup_ikea,"IVRIG 이브리그" ,"2,900","이케아","유리컵", "glasscup_ikea"));
        furnitureArray.add(new Furniture(R.drawable.f_cart_ikea,"RÅSKOG 로스코그" ,"44,900","이케아","카트, 화이트, 35x45x78", "cart_ikea"));
        furnitureArray.add(new Furniture(R.drawable.f_shelf_ikea,"VITTSJÖ 빗셰" ,"129,000","이케아","선반유닛, 블랙브라운", "shelf_ikea"));
        furnitureArray.add(new Furniture(R.drawable.f_shelf_ikea2,"KALLAX 칼락스" ,"199,000","이케아","선반유닛, 화이트", "shelf_ikea2"));
        furnitureArray.add(new Furniture(R.drawable.f_clock_ikea,"KLOCKIS 클로키스" ,"4,900","이케아","시계/온도계/알람/타이머, 화이트", "clock_ikea"));
        furnitureArray.add(new Furniture(R.drawable.f_drawer_ikea,"KUGGIS 쿠기스" ,"7,500","이케아","수납함+뚜껑, 화이트", "drawer_ikea"));

        furnitureArray.add(new Furniture(R.drawable.f_chair_image,"의자" ,"8","일룸","예쁘다", "goofchair"));
        //3D 파일 -> goofchair
        furnitureArray.add(new Furniture(R.drawable.f_table_image,"책상" ,"7","삼성","비싸다", "table_lamp"));





        // FurnitureAdapter에 LAYOUT_FURNITURE를 전달하여 수정된 레이아웃을 사용
        FurnitureAdapter adapter = new FurnitureAdapter(furnitureArray, FurnitureAdapter.LAYOUT_FURNITURE);
        fRecyclerView.setAdapter(adapter);

        return view;

    }
}
