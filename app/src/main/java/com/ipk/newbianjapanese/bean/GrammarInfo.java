package com.ipk.newbianjapanese.bean;

public class GrammarInfo {
    public String name;
    public String explanation;
    public String example;

    public GrammarInfo(String name, String explanation, String example) {
        this.name = name;
        this.explanation = explanation;
        this.example = example;
    }

    public GrammarInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
