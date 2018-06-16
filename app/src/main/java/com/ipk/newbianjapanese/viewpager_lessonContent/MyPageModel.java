package com.ipk.newbianjapanese.viewpager_lessonContent;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

public class MyPageModel {
    @LayoutRes public int layoutRes;
    @StringRes public int titleRes;

    public MyPageModel(@LayoutRes int layoutRes,@StringRes int titleRes){
        this.layoutRes = layoutRes;
        this.titleRes = titleRes;
    }
}
