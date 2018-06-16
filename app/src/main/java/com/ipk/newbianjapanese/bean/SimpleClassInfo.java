package com.ipk.newbianjapanese.bean;

public class SimpleClassInfo {
    public int mUnitIndex;  //第几个单元
    public int mClassIndex; //单元里第几课
    public String mClassTitle; //课的标题
    public String mUnitTitle; //单元的标题
    public int mGroupLength; //所在单元的课的个数


    public int getmGroupLength() {
        return mGroupLength;
    }

    public void setmGroupLength(int mGroupLength) {
        this.mGroupLength = mGroupLength;
    }


    public String getUnitTitle() {
        return mUnitTitle;
    }

    public void setUnitTitle(String mUnitTitle) {
        this.mUnitTitle = mUnitTitle;
    }


    public SimpleClassInfo(){

    }
    public SimpleClassInfo(int mUnitIndex, int mClassIndex,int mGroupLength, String mUnitTitle,String mClassTitle) {
        this.mUnitIndex = mUnitIndex;
        this.mClassIndex = mClassIndex;
        this.mClassTitle = mClassTitle;
        this.mUnitTitle = mUnitTitle;
        this.mGroupLength = mGroupLength;
    }

    public int getUnitIndex() {
        return mUnitIndex;
    }

    public void setUnitIndex(int mUnitIndex) {
        this.mUnitIndex = mUnitIndex;
    }

    public int getClassIndex() {
        return mClassIndex;
    }

    public void setClassIndex(int mClassIndex) {
        this.mClassIndex = mClassIndex;
    }

    public String getClassTitle() {
        return mClassTitle;
    }

    public void setClassTitle(String mClassTitle) {
        this.mClassTitle = mClassTitle;
    }

    public boolean isFirstClassInUnit(){
        return mClassIndex == 0;
    }
    public boolean isLastClassInUnit(){
        return mClassIndex == mGroupLength-1;
    }
}
