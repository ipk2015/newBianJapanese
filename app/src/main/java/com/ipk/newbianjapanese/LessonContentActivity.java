package com.ipk.newbianjapanese;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ipk.newbianjapanese.bean.SimpleClassInfo;
import com.ipk.newbianjapanese.viewpager_lessonContent.MyFragment;
import com.ipk.newbianjapanese.viewpager_lessonContent.MyPageModel;

import java.util.ArrayList;
import java.util.List;

public class LessonContentActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<MyPageModel> layoutList = new ArrayList<>();
    private Toolbar toolBar_lesson;
    private SimpleClassInfo mSimpleClassInfo;
    private TextView textView_lessonTitle;
    private TextView textView_content_layout_passage;

    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        toolBar_lesson = this.<Toolbar>findViewById(R.id.toolBar_lesson);
        tabLayout = this.<TabLayout>findViewById(R.id.tabLayout);
        viewPager = this.<ViewPager>findViewById(R.id.viewPager);
        textView_lessonTitle = (TextView) toolBar_lesson.findViewById(R.id.textView_toolbar_title_lesson);

        String stringExtra = getIntent().getStringExtra(MainActivity.Intent_extra_class_info);
        mSimpleClassInfo = new Gson().fromJson(stringExtra, SimpleClassInfo.class);
        textView_lessonTitle.setText(mSimpleClassInfo.getClassTitle());

        Log.e("fyp-mSimpleClassInfo",mSimpleClassInfo.toString());
        int unitIndex = mSimpleClassInfo.getUnitIndex();
        int classIndex = mSimpleClassInfo.getClassIndex();

        layoutList.add(new MyPageModel(R.layout.layout_passage,R.string.tab_title_passage,DataUtils.getAssertsFileName(unitIndex,classIndex,"passage")));
        layoutList.add(new MyPageModel(R.layout.layout_passage,R.string.tab_title_passage_translate,DataUtils.getAssertsFileName(unitIndex,classIndex,"passage-translate")));
        layoutList.add(new MyPageModel(R.layout.layout_words,R.string.tab_title_words,DataUtils.getAssertsFileName(unitIndex, classIndex,"words")));
        initToolbar();
        initTabLayout();

    }
    private void initToolbar(){
        setSupportActionBar(toolBar_lesson);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.toolbar_action1:
                Toast.makeText(this,"action111",Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_action2:
                Toast.makeText(this,"action222",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_lesson,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initTabLayout(){
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                MyPageModel myPageModel = layoutList.get(position);
                Fragment fragment = MyFragment.newInstance(myPageModel.layoutRes,myPageModel.fileName);
                return fragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(layoutList.get(position).titleRes);
            }

            @Override
            public int getCount() {
                return layoutList.size();
            }
        });

        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_to_right);
    }
}
