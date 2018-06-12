package com.ipk.newbianjapanese;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return view;
    }
}
