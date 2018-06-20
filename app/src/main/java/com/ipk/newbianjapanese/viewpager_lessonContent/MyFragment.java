package com.ipk.newbianjapanese.viewpager_lessonContent;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.recyclerView_passage.PassageRecyclerViewAdapter;

public class MyFragment extends Fragment {
    @LayoutRes int mainLayoutRes;
    public static MyFragment newInstance(@LayoutRes int layoutRes){
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("mainLayoutRes",layoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if(null != arguments){
            mainLayoutRes = arguments.getInt("mainLayoutRes");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(mainLayoutRes,container,false);
        RecyclerView recyclerView_passage = (RecyclerView)view.findViewById(R.id.recyclerView_passage);
        recyclerView_passage.setHasFixedSize(true);
        recyclerView_passage.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        PassageRecyclerViewAdapter passageRecyclerViewAdapter = new PassageRecyclerViewAdapter();
//        recyclerView_passage.setAdapter();
        return view;
    }
}
