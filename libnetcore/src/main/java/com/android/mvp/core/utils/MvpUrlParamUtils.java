package com.android.mvp.core.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * Created by meikai on 15/11/6.
 */
public class MvpUrlParamUtils {

    public static String buildUrlParams(String url, Map<String, String> extraMap, String signKey) {
        StringBuilder sb = new StringBuilder(url);

        if (sb.indexOf("?") == -1)
            sb.append("?");
        else if (sb.indexOf("?") != sb.length() - 1) {
            sb.append("&");
        }

        if(MvpUtils.isEmpty(extraMap))
            extraMap = new HashMap<>();

        addUUID(extraMap);

        extraMap.putAll(createStandardParams());


        Iterator iterator = extraMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        return MvpSignUtils.singUrl(sb.toString(), signKey) ;
    }

    private static void addUUID(Map<String, String> extraMap){
        if(MvpUtils.isEmpty(extraMap))
            return;

        extraMap.put("_r", UUID.randomUUID().toString().replaceAll("-", ""));
    }

    private static Map<String, String> createStandardParams(){
        Map<String, String> standardParamsMap = new HashMap<>();

        standardParamsMap.put("imei", "imei");
        standardParamsMap.put("standardParams1", "standardParams1");
        //TODO

        return standardParamsMap;
    }

}
