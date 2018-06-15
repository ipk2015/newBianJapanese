package com.ipk.newbianjapanese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = this.<Toolbar>findViewById(R.id.toolBar1);
        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        String[] mDataset = new String[]{"111111","22222","3333333","111111","22222","3333333","111111","22222","3333333","111111","22222","3333333","111111","22222","3333333","111111","22222","3333333","111111","22222","3333333","111111","22222","3333333"};
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(mDataset);
        recyclerView.setAdapter(myRecyclerViewAdapter);

    }


    public void onTouchButton(View v){
        Intent intent = new Intent(this,LessonContentActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
    }
}
