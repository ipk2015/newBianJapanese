package com.ipk.newbianjapanese;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

public class MyPageModel {
    @LayoutRes int layoutRes;
    @StringRes int titleRes;

    MyPageModel(@LayoutRes int layoutRes,@StringRes int titleRes){
        this.layoutRes = layoutRes;
        this.titleRes = titleRes;
    }
}
