package com.ipk.newbianjapanese.viewpager_lessonContent;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

public class MyPageModel {
    @LayoutRes public int layoutRes;
    @StringRes public int titleRes;
    public String fileName;
    public MyPageModel(@LayoutRes int layoutRes,@StringRes int titleRes,String fileName){
        this.layoutRes = layoutRes;
        this.titleRes = titleRes;
        this.fileName = fileName;
    }
}
