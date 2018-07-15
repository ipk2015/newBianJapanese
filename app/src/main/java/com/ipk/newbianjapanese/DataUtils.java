package com.ipk.newbianjapanese;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataUtils {
    /**
     * 得到json文件中的内容
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(Context context, String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName),"utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 将字符串转换为 对象
     * @param json
     * @param type
     * @return
     */
    public  static <T> T JsonToObject(String json, Class<T> type) {
        Gson gson =new Gson();
        return gson.fromJson(json, type);
    }

    /**
     * 拼接成指定单元指定课的资源文件名
     * @param bookIndex 第几册，0为第一册
     * @param unitIndex 第几单元，0为第一单元
     * @param classIndex 第几课，0为第一课
     * @param fileType  文件说明，要拼接在文件名最后
     * @return
     */
    public static String getAssertsFileName(int bookIndex,int unitIndex,int classIndex,String fileType){
        return "book-"+(bookIndex+1)+"-unit-"+(unitIndex+1)+"-lesson-"+(classIndex+1)+"-"+fileType+".json";
    }
}
