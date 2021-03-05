package com.example.design.compositeMethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EngineConfig {
    static Map<String, LogicalFilter> map;

    static {
        map = new ConcurrentHashMap<>();
        map.put("userAge", new UserAgeFilter());
        map.put("userGender", new UserGenderFilter());
    }

    public static Map<String, LogicalFilter> getMap() {
        return map;
    }

    public static void setMap(Map<String, LogicalFilter> map) {
        EngineConfig.map = map;
    }
}
