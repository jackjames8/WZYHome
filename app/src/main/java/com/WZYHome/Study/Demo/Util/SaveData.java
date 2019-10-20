package com.WZYHome.Study.Demo.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author: Unique
 * CreatedTime 2017/11/2 on 14:11
 * function:  缓存
 */
public class SaveData {

    private static SharedPreferences mPerpetualShared = null;
    private static Editor mPerpetualEditor = null;

    private static SharedPreferences mShortTermShared = null;
    private static Editor mShortTermEditor = null;

    private static SharedPreferences mHttpShared = null;
    private static Editor mHttpEditor = null;

    private static SaveData saveData;

    private SaveData() {
    }

    public static void init(Context context) {
        if (saveData == null) {
            synchronized (SaveData.class) {
                if (saveData == null) {
                    saveData = new SaveData();
                    mShortTermShared = context.getSharedPreferences("CreatedTimeOne", Context.MODE_PRIVATE);
                    mShortTermEditor = mShortTermShared.edit();
                    mPerpetualShared = context.getSharedPreferences("CreatedTimeTwo", Context.MODE_PRIVATE);
                    mPerpetualEditor = mPerpetualShared.edit();
                    mHttpShared = context.getSharedPreferences("CreatedTimeThree", Context.MODE_PRIVATE);
                    mHttpEditor = mHttpShared.edit();
                }
            }
        }
    }

    public static SaveData getInstance() {
        if (saveData == null) {
            return null;
        }
        return saveData;
    }

    /*
     * ------------------------保存请求数据-----华丽的分割线--------------------------
     */

    public void saveHttpString(String key, String value) {
        mHttpEditor.putString(key, value).commit();
    }

    public String getHttpString(String key, String value) {
        return mHttpShared.getString(key, value);
    }

    /*
     * ------------------------保存长期数据-----华丽的分割线--------------------------
     */


    public void savePerpetualString(String key, String value) {
        mPerpetualEditor.putString(key, value).commit();
    }

    public String getPerpetualString(String key, String value) {
        return mPerpetualShared.getString(key, value);
    }

    public void savePerpetualKey(String key, String value) {
        mPerpetualEditor.putString(key, value).commit();
    }

    public String getPerpetualKey(String key) {
        return mPerpetualShared.getString(key, "");
    }


    public void savePerpetualInt(String key, int value) {
        mPerpetualEditor.putInt(key, value).commit();
    }

    public int getPerpetualInt(String key) {
        return mPerpetualShared.getInt(key, 0);
    }

    public void savePerpetualLong(String key, long value) {
        mPerpetualEditor.putLong(key, value).commit();
    }

    public long getPerpetualLong(String key) {
        return mPerpetualShared.getLong(key, 0);
    }

    public void savePerpetualBoolean(String key, boolean value) {
        mPerpetualEditor.putBoolean(key, value).commit();
    }

    public boolean getPerpetualBoolean(String key) {
        return mPerpetualShared.getBoolean(key, false);
    }

    /**
     * ak
     *
     * @return ak
     */
    public String getAccessKey() {
        return getPerpetualString("ak", "");
    }
    /*
     * ------------------------保存短期数据-----华丽的分割线--------------------------
     */

    /**
     * 保存字符串类型数据
     *
     * @param key   保存名字
     * @param value 保存内容
     */
    public void savaString(String key, String value) {
        mShortTermEditor.putString(key, value).commit();
    }

    /**
     * 获取字符串类型数据
     *
     * @param key   保存的名字
     * @param value 默认返回值
     * @return
     */
    public String getString(String key, String value) {
        return mShortTermShared.getString(key, value);
    }

    /**
     * 保存布尔类型数据
     *
     * @param key   保存名字
     * @param value 保存内容
     */
    public void saveBoolean(String key, boolean value) {
        mShortTermEditor.putBoolean(key, value).commit();
    }

    /**
     * 获取布尔类型数据
     *
     * @param key 保存名字
     */
    public boolean getBoolean(String key) {
        return mShortTermShared.getBoolean(key, false);
    }

    /**
     * 获取布尔类型数据
     *
     * @param key   保存名字
     * @param value 默认返回值
     */
    public boolean getBoolean(String key, boolean value) {
        return mShortTermShared.getBoolean(key, value);
    }

    public void saveLong(String key, long value) {
        mShortTermEditor.putLong(key, value).commit();
    }

    public long getLong(String key) {
        return mShortTermShared.getLong(key, 0);
    }

    public void saveInt(String key, int value) {
        mShortTermEditor.putInt(key, value).commit();
    }

    public int getInt(String key) {
        return mShortTermShared.getInt(key, 0);
    }

    /**
     * 清除短期保存数据
     */
    public void clearShortTermData() {
        savePerpetualString("ak", "");
        savePerpetualString("TypeItemsCarOwner", "");
        savePerpetualString("TypeItemsAgent", "");
        savePerpetualString("TypeItemsPromoter", "");
        savePerpetualString("AddOrderContactName", "");
        savePerpetualString("AddOrderMobilePhone", "");
        mShortTermEditor.clear().commit();
        mHttpEditor.clear().commit();
    }
}
