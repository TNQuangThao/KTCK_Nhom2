package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    RecyclerView recyclerViewTacGia;
    View view;
    List<TacGia> tacGiaList;
    TacGiaAdapter adapterTG;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewTacGia = view.findViewById(R.id.recyclerViewTacGia);
        recyclerViewTacGia.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        tacGiaList = new ArrayList<>();
        adapterTG = new TacGiaAdapter(tacGiaList);
        recyclerViewTacGia.setAdapter(adapterTG);
        fetchTacGias();
        return view;
    }

    private void fetchTacGias() {
        APIService apiService = APIController.getRetrofitInstance().create(APIService.class);
        Call<List<TacGia>> call = apiService.getTacGia();
        call.enqueue(new Callback<List<TacGia>>() {
            @Override
            public void onResponse(Call<List<TacGia>> call, Response<List<TacGia>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    tacGiaList.clear();
                    tacGiaList.addAll(response.body());
                    adapterTG.notifyDataSetChanged();
                } else {
                    Log.e("API Error", "API Tác Giả trả về lỗi: " + response.code());
                    Toast.makeText(getActivity().getApplicationContext(), "API Tác Giả trả về lỗi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<TacGia>> call, Throwable t) {
                // Xử lý lỗi khi gọi API thất bại
                Toast.makeText(getActivity().getApplicationContext(), "Không thể gọi API Tác Giả", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
