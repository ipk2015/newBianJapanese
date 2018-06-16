package com.ipk.newbianjapanese.bean;

public class SimpleClassInfo {
    public int mUnitIndex;
    public int mClassIndex;
    public int mClassTitle;

    public SimpleClassInfo(int mUnitIndex, int mClassIndex, int mClassTitle) {
        this.mUnitIndex = mUnitIndex;
        this.mClassIndex = mClassIndex;
        this.mClassTitle = mClassTitle;
    }

    public int getmUnitIndex() {
        return mUnitIndex;
    }

    public void setmUnitIndex(int mUnitIndex) {
        this.mUnitIndex = mUnitIndex;
    }

    public int getmClassIndex() {
        return mClassIndex;
    }

    public void setmClassIndex(int mClassIndex) {
        this.mClassIndex = mClassIndex;
    }

    public int getmClassTitle() {
        return mClassTitle;
    }

    public void setmClassTitle(int mClassTitle) {
        this.mClassTitle = mClassTitle;
    }
}
