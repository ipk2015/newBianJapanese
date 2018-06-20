package com.ipk.newbianjapanese.viewpager_lessonContent;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ipk.newbianjapanese.DataUtils;
import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.PassageInfo;
import com.ipk.newbianjapanese.recyclerView_passage.PassageRecyclerViewAdapter;

import java.lang.reflect.Type;
import java.util.List;

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

        RecyclerView recyclerView_passage = view.findViewById(R.id.recyclerView_passage);
        Log.e("fyp-1111","111");
        if(null != recyclerView_passage){
            Log.e("fyp-22222","2222");
            recyclerView_passage.setHasFixedSize(true);
            recyclerView_passage.setLayoutManager(new LinearLayoutManager(this.getActivity()));

            String json = DataUtils.getJson(this.getContext(), "unit-1-lesson-1-passage.json");
            Type listType = new TypeToken<List<PassageInfo>>() {}.getType();
            //这里的json是字符串类型 = jsonArray.toString();
            List<PassageInfo> dataList = new Gson().fromJson(json, listType );
            Log.e("fyp-dataList",dataList.size()+"");
            for(int i=0;i<dataList.size();i++){
                Log.e("fyp-dataList"+i,dataList.get(i).type+"");
            }
            PassageRecyclerViewAdapter passageRecyclerViewAdapter = new PassageRecyclerViewAdapter(dataList);
            recyclerView_passage.setAdapter(passageRecyclerViewAdapter);
        }

        return view;
    }
}
