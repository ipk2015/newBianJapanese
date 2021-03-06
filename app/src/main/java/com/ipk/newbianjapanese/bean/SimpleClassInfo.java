package com.ipk.newbianjapanese.bean;

public class SimpleClassInfo {
    public int bookIndex;  //第几册
    public int unitIndex;  //第几个单元
    public int classIndex; //单元里第几课
    public String classTitle; //课的标题
    public String unitTitle; //单元的标题
    public int groupLength; //所在单元的课的个数

    public SimpleClassInfo(int bookIndex,int unitIndex, int classIndex, String classTitle, String unitTitle, int groupLength) {
        this.bookIndex = bookIndex;
        this.unitIndex = unitIndex;
        this.classIndex = classIndex;
        this.classTitle = classTitle;
        this.unitTitle = unitTitle;
        this.groupLength = groupLength;
    }

    public int getBookIndex() {
        return bookIndex;
    }

    public void setBookIndex(int bookIndex) {
        this.bookIndex = bookIndex;
    }

    public int getUnitIndex() {
        return unitIndex;
    }

    public void setUnitIndex(int unitIndex) {
        this.unitIndex = unitIndex;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public String getUnitTitle() {
        return unitTitle;
    }

    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle;
    }

    @Override
    public String toString() {
        return "SimpleClassInfo{" +
                "bookIndex=" + bookIndex +
                ", unitIndex=" + unitIndex +
                ", classIndex=" + classIndex +
                ", classTitle='" + classTitle + '\'' +
                ", unitTitle='" + unitTitle + '\'' +
                ", groupLength=" + groupLength +
                '}';
    }

    public int getGroupLength() {
        return groupLength;
    }

    public void setGroupLength(int groupLength) {
        this.groupLength = groupLength;
    }

    public boolean isFirstClassInUnit(){
        return classIndex == 0;
    }
    public boolean isLastClassInUnit(){
        return classIndex == groupLength-1;
    }


}
