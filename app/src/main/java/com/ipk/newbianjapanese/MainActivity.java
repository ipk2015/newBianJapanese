package com.ipk.newbianjapanese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ipk.newbianjapanese.bean.SimpleClassInfo;
import com.ipk.newbianjapanese.recyclerView_unit.MyRecyclerViewAdapter;
import com.ipk.newbianjapanese.recyclerView_unit.UnitClassDecoration;

import java.lang.reflect.Type;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.OnItemClickListener{
    public static String Intent_extra_class_info = "classInfo";
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<SimpleClassInfo> mDataset;
    private TextView textView_toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = this.<Toolbar>findViewById(R.id.toolBar1);
        textView_toolbar = (TextView)toolbar.findViewById(R.id.toolbar_title);
        textView_toolbar.setText(R.string.app_name);
        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        String json = DataUtils.getJson(this, "book1.json");
        Type listType = new TypeToken<List<SimpleClassInfo>>() {}.getType();
        //这里的json是字符串类型 = jsonArray.toString();
        mDataset = new Gson().fromJson(json, listType );
//        for(int i=0;i<50;i++){
//            SimpleClassInfo simpleClassInfo = new SimpleClassInfo(i/5,i%5,5,"第"+(i/5+1)+"单元","第"+(i%5+1)+"课");
//            mDataset.add(simpleClassInfo);
//        }
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(mDataset);
        myRecyclerViewAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        UnitClassDecoration decoration = new UnitClassDecoration(this, new UnitClassDecoration.SimpleClassInfoCallback() {
            @Override
            public SimpleClassInfo getSimpleClassInfo(int position) {
                return mDataset.get(position);
            }
        });
        recyclerView.addItemDecoration(decoration);

//        Log.e("fyp-json",json);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"view"+position,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,LessonContentActivity.class);
        SimpleClassInfo simpleClassInfo = mDataset.get(position);
        intent.putExtra(Intent_extra_class_info,new Gson().toJson(simpleClassInfo));
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
    }
}
