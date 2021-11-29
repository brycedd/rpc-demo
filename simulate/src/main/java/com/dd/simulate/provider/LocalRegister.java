package com.dd.simulate.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bryce_dd 2021/11/29 23:00
 */
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void register(String interfacesName, Class implClass) {
        map.put(interfacesName, implClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
