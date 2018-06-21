package com.ipk.newbianjapanese;

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

    public static String getToneByString(String param){
        String[] strings = param.split("、");
        String result = "";
        for(String item:strings){
            result = result + getToneByIndex(Integer.valueOf(item));
        }
        return result;
    }
}
