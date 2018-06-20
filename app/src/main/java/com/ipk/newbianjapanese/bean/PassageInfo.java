package com.ipk.newbianjapanese.bean;

public class PassageInfo {
    public String passage;
    public String talkContent;
    public String talkName;
    public int type;//0为passage,1为talk

    public PassageInfo() {
    }

    public PassageInfo(String passage, int type) {
        this.passage = passage;
        this.type = type;
    }

    public PassageInfo(String talkContent, String talkName, int type) {
        this.talkContent = talkContent;
        this.talkName = talkName;
        this.type = type;
    }

    public PassageInfo(String passage, String talkContent, String talkName, int type) {
        this.passage = passage;
        this.talkContent = talkContent;
        this.talkName = talkName;
        this.type = type;
    }


    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent;
    }

    public String getTalkName() {
        return talkName;
    }

    public void setTalkName(String talkName) {
        this.talkName = talkName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
