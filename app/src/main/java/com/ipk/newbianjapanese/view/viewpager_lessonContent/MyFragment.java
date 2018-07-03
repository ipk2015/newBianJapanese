package com.ipk.newbianjapanese.view.viewpager_lessonContent;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ipk.newbianjapanese.DataUtils;
import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.GrammarInfo;
import com.ipk.newbianjapanese.bean.PassageInfo;
import com.ipk.newbianjapanese.bean.WordInfo;
import com.ipk.newbianjapanese.view.GrammarRecyclerViewAdapter;
import com.ipk.newbianjapanese.view.PassageRecyclerViewAdapter;
import com.ipk.newbianjapanese.view.WordsItemDecoration;
import com.ipk.newbianjapanese.view.WordsRecyclerViewAdapter;

import java.lang.reflect.Type;
import java.util.List;

public class MyFragment extends Fragment {
    @LayoutRes int mainLayoutRes;
    private String mAssertsFileName;

    public static MyFragment newInstance(@LayoutRes int layoutRes,String assertsFileName){
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("mainLayoutRes",layoutRes);
        args.putString("assertsFileName",assertsFileName);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if(null != arguments){
            mainLayoutRes = arguments.getInt("mainLayoutRes");
            mAssertsFileName = arguments.getString("assertsFileName");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(mainLayoutRes,container,false);

        RecyclerView recyclerView_passage = view.findViewById(R.id.recyclerView_passage);
        RecyclerView recyclerView_words = view.findViewById(R.id.recyclerView_words);
        RecyclerView recyclerView_grammar = view.findViewById(R.id.recyclerView_grammar);

        if(null != recyclerView_passage){
            recyclerView_passage.setHasFixedSize(true);
            recyclerView_passage.setLayoutManager(new LinearLayoutManager(this.getActivity()));
            String json = DataUtils.getJson(this.getContext(), mAssertsFileName);
            Type listType = new TypeToken<List<PassageInfo>>() {}.getType();
            List<PassageInfo> dataList = new Gson().fromJson(json, listType );
            PassageRecyclerViewAdapter passageRecyclerViewAdapter = new PassageRecyclerViewAdapter(dataList);
            recyclerView_passage.setAdapter(passageRecyclerViewAdapter);
        }else if(null != recyclerView_words){
            recyclerView_words.setHasFixedSize(true);
            recyclerView_words.setLayoutManager(new LinearLayoutManager(this.getActivity()));
            String json = DataUtils.getJson(this.getContext(), mAssertsFileName);
            Type listType = new TypeToken<List<WordInfo>>() {}.getType();
            List<WordInfo> dataList = new Gson().fromJson(json, listType );
            recyclerView_words.addItemDecoration(new WordsItemDecoration(this.getActivity()));
            WordsRecyclerViewAdapter wordsRecyclerViewAdapter = new WordsRecyclerViewAdapter(dataList);
            recyclerView_words.setAdapter(wordsRecyclerViewAdapter);
        }else if(null != recyclerView_grammar){
            recyclerView_grammar.setHasFixedSize(true);
            recyclerView_grammar.setLayoutManager(new LinearLayoutManager(this.getActivity()));
            String json = DataUtils.getJson(this.getContext(), mAssertsFileName);
            Type listType = new TypeToken<List<GrammarInfo>>() {}.getType();
            List<GrammarInfo> dataList = new Gson().fromJson(json, listType );
            recyclerView_grammar.addItemDecoration(new WordsItemDecoration(this.getActivity()));
            GrammarRecyclerViewAdapter grammarRecyclerViewAdapter = new GrammarRecyclerViewAdapter(dataList);
            recyclerView_grammar.setAdapter(grammarRecyclerViewAdapter);
//            WordsRecyclerViewAdapter wordsRecyclerViewAdapter = new WordsRecyclerViewAdapter(dataList);
//            recyclerView_grammar.setAdapter(wordsRecyclerViewAdapter);
        }

        return view;
    }
}
