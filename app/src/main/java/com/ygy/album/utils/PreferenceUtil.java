package com.ygy.album.utils;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * Created by Administrator on 2016/10/14.
 */
public class PreferenceUtil {
    private static SharedPreferences setting;
    private static SharedPreferences.Editor pen;
    /**
     * 把字符串保存到偏好设置中
     *
     * @param context
     *            上下文环境
     * @param key
     *            键
     * @param value
     *            值
     */
    public static void setStringValue(Context context, String key, String value) {
        // 只被本应用使用
        setting = context.getSharedPreferences("gdswww_user", Context.MODE_PRIVATE);
        pen = setting.edit();
        pen.putString(key, value);
        pen.commit();
    }
    public static void clearAllPrefer(){
        if(pen!=null){
            pen.clear();
        }
    }

    /**
     * 根据键获取值
     *
     * @param context
     * @param key
     * @return
     */
    public static String getStringValue(Context context, String key) {
        // 只被本应用使用
        setting = context.getSharedPreferences("gdswww_user", Context.MODE_PRIVATE);
        return setting.getString(key, "");
    }

    public static void setIntValue(Context context, String key, int value) {
        // 只被本应用使用
        setting = context.getSharedPreferences("gdswww_user", Context.MODE_PRIVATE);
        pen = setting.edit();
        pen.putInt(key, value);
        pen.commit();
    }

    /**
     * 根据键获取值
     *
     * @param context
     * @param key
     * @return
     */
    public static int getIntValue(Context context, String key) {
        // 只被本应用使用
        setting = context.getSharedPreferences("gdswww_user", Context.MODE_PRIVATE);
        return setting.getInt(key, 0);
    }

    /**
     * 把boolean保存到偏好设置中
     *
     * @param context
     *            上下文环境
     * @param key
     *            键
     * @param value
     *            值
     */
    public static void setBooleanValue(Context context, String key,
                                       boolean value) {
        // 只被本应用使用
        setting = context.getSharedPreferences("gdswww_user", Context.MODE_PRIVATE);
        pen = setting.edit();
        pen.putBoolean(key, value);
        pen.commit();
    }

    /**
     * 根据键获取值
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getBooleanValue(Context context, String key) {
        // 只被本应用使用
        setting = context.getSharedPreferences("gdswww_user", Context.MODE_PRIVATE);
        return setting.getBoolean(key, false);
    }

    /**
     * 通过偏好设置文件名获取配置信息
     * @return
     */
    public static String getPrefersetbyPreferFileName(String fileName, String key,
                                                      Context context) {
        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return  preferences.getString(key, "gdswww_no");
    }

    /**
     * 通过偏好设置文件名设置配置信息
     * @return
     */
    public static void setPrefersetbyPreferFileName(String fileName, String key,String value,
                                                    Context context) {
        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        preferences.edit().putString(key, value).commit();
    }
}
