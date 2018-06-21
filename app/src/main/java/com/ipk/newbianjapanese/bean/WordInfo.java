package com.ipk.newbianjapanese.bean;

public class WordInfo {
    public String writing;//写法
    public String tone;//声调
    public String pos;//词性
    public String meaning;//释义

    public WordInfo() {
    }

    public WordInfo(String writing, String tone, String pos, String meaning) {
        this.writing = writing;
        this.tone = tone;
        this.pos = pos;
        this.meaning = meaning;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
