package com.torkuds.nest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.torkuds.nest.R;
import com.torkuds.nest.adapter.MyAdapter;
import com.torkuds.nest.widget.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * des:显示ListView的Fragment
 * Created by torkuds
 * on 2017/4/21 0021.
 */

public class ListFragment extends Fragment {

    private ListViewForScrollView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_list, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listView = (ListViewForScrollView) view.findViewById(R.id.listView);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            datas.add("List item" + i);
        }
        listView.setAdapter(new MyAdapter(getActivity(), datas));
    }
}
