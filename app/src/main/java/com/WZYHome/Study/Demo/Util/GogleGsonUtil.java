package com.WZYHome.Study.Demo.Util;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2018/3/10.
 */

public class GogleGsonUtil {

    /**
     * 对象转JSON
     *
     * @param entity 对象
     * @return
     */
    public static String ObjectToJson(Object entity) {
        Gson gson = new Gson();
        return gson.toJson(entity);
    }
    /**
     * JSON转对象
     *
     * @param entity 对象
     * @return
     */
    public static Object JsonToObject(String json, Class entity) {
        Gson gson = new Gson();
        return gson.fromJson(json, entity);
    }


}
