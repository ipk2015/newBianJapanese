package com.ipk.newbianjapanese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ipk.newbianjapanese.bean.SimpleClassInfo;
import com.ipk.newbianjapanese.recyclerView_unit.MyRecyclerViewAdapter;
import com.ipk.newbianjapanese.recyclerView_unit.UnitClassDecoration;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<SimpleClassInfo> mDataset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = this.<Toolbar>findViewById(R.id.toolBar1);
        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        mDataset = new ArrayList();
        for(int i=0;i<50;i++){
            SimpleClassInfo simpleClassInfo = new SimpleClassInfo(i/5,i%5,5,"第"+(i/5+1)+"单元","第"+(i%5+1)+"课");
            mDataset.add(simpleClassInfo);
        }
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(mDataset);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        UnitClassDecoration decoration = new UnitClassDecoration(this, new UnitClassDecoration.SimpleClassInfoCallback() {
            @Override
            public SimpleClassInfo getSimpleClassInfo(int position) {
                return mDataset.get(position);
            }
        });
        recyclerView.addItemDecoration(decoration);
    }


    public void onTouchButton(View v){
        Intent intent = new Intent(this,LessonContentActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
    }
}
