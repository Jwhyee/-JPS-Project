package com.ll.jspproject.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.jspproject.article.dto.ArticleDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ut {
    public static Map<String, Object> mapOf(Object... args) {
        int dataSize = args.length / 2;

        Map<String, Object> map = new LinkedHashMap<>();

        for (int i = 0; i < dataSize; i++) {
            int keyIdx = i * 2 + 0;
            int valueIdx = i * 2 + 1;

            String key = (String) args[keyIdx];
            Object value = args[valueIdx];
            map.put(key, value);
        }
        return map;
    }
    /*public static Map<String, Object> mapOf(Object... args) {
        Map<String, Object> resultData = new LinkedHashMap<>();
        int dataSize = args.length / 2;
        for (int i = 0; i < dataSize; i++) {
            int keyIdx = i * 2;
            int valueIdx = i * 2 + 1;
            resultData.put(args[], );
            resultData.put(msg, failOrSuccess);
            resultData.put(data, articleDtos);
        }

        return resultData;
    }*/

    public static class json{
        private static final ObjectMapper om;
        static {
            om = new ObjectMapper();
        }
        public static String toStr(Object obj, String defaultValue) {
            try {
                return om.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <T> T toObj(String jsonStr, Class<T> cls, T defaultValue) {
            try {
                return om.readValue(jsonStr, cls);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <T> T toObj(String jsonStr, TypeReference<T> typeReference, T defaultValue) {
            try {
                return om.readValue(jsonStr, typeReference);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
