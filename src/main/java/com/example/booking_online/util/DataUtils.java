package com.example.booking_online.util;

import java.math.BigInteger;
import java.util.List;

public class DataUtils {

    public static boolean notNull(Object obj) {
        return !isNullObject(obj);
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().equals("") || value.trim().equalsIgnoreCase("null");
    }

    public static boolean isNullObject(Object obj1) {
        if (obj1 == null) {
            return true;
        }
        if (obj1 instanceof String) {
            return isNullOrEmpty(obj1.toString());
        }
        return false;
    }

    public static String safeToString(Object obj1, String defaultValue) {
        if (obj1 == null || safeEqual(obj1.toString(), "null")) {
            return defaultValue;
        }
        return obj1.toString();
    }

    /**
     * @param obj1 Object
     * @return String
     */
    public static String safeToString(Object obj1, Object defaultValue) {
        if (obj1 == null || safeEqual(obj1.toString(), "null")) {
            return safeToString(defaultValue);
        }
        return obj1.toString();
    }

    /**
     * @param obj1 Object
     * @return String
     */
    public static String safeToString(Object obj1, String... defaultValue) {
        if (obj1 == null || safeEqual(obj1.toString(), "null")) {
            for (String def : defaultValue) {
                if (notNull(def)) {
                    return def;
                }
            }
            return "";
        }
        return obj1.toString();
    }

    /**
     * @param obj1 Object
     * @return String
     */
    public static String safeToString(Object obj1) {
        return safeToString(obj1, "");
    }
    public static boolean safeEqual(Long obj1, Long obj2) {
        if (obj1 == obj2) return true;
        return ((obj1 != null) && (obj2 != null) && (obj1.compareTo(obj2) == 0));
    }

    /**
     * safe equal
     *
     * @param obj1 Long
     * @param obj2 Long
     * @return boolean
     */
    public static boolean safeEqual(BigInteger obj1, BigInteger obj2) {
        if (obj1 == obj2) return true;
        return (obj1 != null) && (obj2 != null) && obj1.equals(obj2);
    }

    /**
     * @param obj1
     * @param obj2
     * @return
     * @date 09-12-2015 17:43:20
     * @author TuyenLT18
     * @description
     */
    public static boolean safeEqual(Short obj1, Short obj2) {
        if (obj1 == obj2) return true;
        return ((obj1 != null) && (obj2 != null) && (obj1.compareTo(obj2) == 0));
    }

    /**
     * safe equal
     *
     * @param obj1 String
     * @param obj2 String
     * @return boolean
     */
    public static boolean safeEqual(String obj1, String obj2) {
        if (obj1 == null && obj2 == null) return true;
        else if (obj1 == obj2) return true;
        return ((obj1 != null) && (obj2 != null) && obj1.equals(obj2));
    }

    /**
     * safe equal
     *
     * @param baseObj String
     * @param obj2    String...
     * @return boolean
     */
    public static boolean safeEqual(String baseObj, String... obj2) {
        if (baseObj == null && obj2 == null) return true;
        else if (obj2 != null) {
            for (String s : obj2) {
                if (safeEqual(baseObj, s)) return true;
            }
        }
        return false;
    }

    /**
     * @param obj1 Object
     * @return String
     */
    public static boolean safeEqual(Object obj1, List defaultValue) {
        if (obj1 == null && defaultValue == null) return true;
        else if (obj1 != null) {
            for (Object s : defaultValue) {
                if (safeEqual(obj1, s)) return true;
            }
        }
        return false;
    }

    /**
     * safe equal
     *
     * @param baseObj String
     * @param obj2    String...
     * @return boolean
     */
    public static boolean safeEqual(Long baseObj, Long... obj2) {
        if (baseObj == null && obj2 == null) return true;
        else if (obj2 != null) {
            for (Long s : obj2) {
                if (safeEqual(baseObj, s)) return true;
            }
        }
        return false;
    }

    public static boolean safeEqual(Object obj1, Object obj2) {
        return ((obj1 != null) && (obj2 != null) && obj2.toString().equals(obj1.toString()));
    }

    public static boolean safeEqual(Object obj1, Object... lstObjs) {
        for (Object obj2 : lstObjs) {
            if (((obj1 != null) && (obj2 != null) && obj2.toString().equals(obj1.toString()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean safeEqual(Float obj1, Float obj2) {
        return ((obj1 != null) && (obj2 != null) && Float.compare(obj1, obj2) == 0);
    }

    public static boolean safeEqual(Double obj1, Double obj2) {
        return ((obj1 != null) && (obj2 != null) && Double.compare(obj1, obj2) == 0);
    }
}
