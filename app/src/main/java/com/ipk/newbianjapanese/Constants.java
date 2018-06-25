package com.ipk.newbianjapanese;

import android.text.TextUtils;

public class Constants {

    public Constants(){

    }

    public static String[] Tones = {"⓪","①","②","③","④","⑤","⑥","⑦","⑧","⑨","⑩"};
    public static String getToneByIndex(int index){
        if(index>=0 && index <=Tones.length-1){
            return Tones[index];
        }
        return Tones[0];
    }

    /**
     * 获得夹圈语调
     * @param param
     * @return
     */
    public static String getToneByString(String param){
        if(TextUtils.isEmpty(param)) return "";
        String[] strings = param.split("、");
        String result = "";
        for(String item:strings){
            result = result + getToneByIndex(Integer.valueOf(item));
        }
        return result;
    }

    /**
     * 加中括号
     * @param param
     * @return
     */
    public static String addBrackets(String param){
        if(TextUtils.isEmpty(param)) return "";
        return "["+param+"]";
    }
}
